package jsoft.ads.basic;

import java.sql.*;
import java.util.ArrayList;

import jsoft.*;

public class BasicImpl implements Basic {
	// Bộ quản lý kết nối riêng của Basic
	private ConnectionPool cp;
	
	//Kết nối để Basic làm việc vơi CPU
	protected Connection con;
	
	// Đối tượng làm việc với Basic
	private String objectName;

	public BasicImpl(ConnectionPool cp, String objectName) {
		//Xác định đối tượng làm việc với Basic
		this.objectName = objectName;
		
		//Xác định bộ quản lý kết nối
		if(cp == null) {
			this.cp = new ConnectionPoolImpl();
		} else {
			this.cp = cp;
		}
		
		//Hỏi xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection(this.objectName);
			
			//Kiểm tra trạng thái thực thi của kết nối
			if(this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized boolean exe(PreparedStatement pre) {
		if(pre != null) {
			try {
				int results = pre.executeUpdate(); //thực thi
				if(results == 0) {
					this.con.rollback();
					return false;
				}
				
				//Xác nhận thực thi sau cùng
				this.con.commit();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//Trở lại trạng thái an toàn của kết lối
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {
				pre = null;
			}
		}
		return false;
	}

	@Override
	public synchronized boolean add(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public synchronized boolean edit(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public synchronized boolean del(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public ResultSet get(String sql, int id) {
		// Biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			if(id>0) {
				pre.setInt(1, id);
			}
			return pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//Trở lại trạng thái an toàn của kết lối
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			sql = null;
		}
		return null;
	}

	@Override
	public ResultSet get(String sql, String name, String pass) {
		// Biên dịch
			try {
				PreparedStatement pre = this.con.prepareStatement(sql);
				pre.setString(1, name);
				pre.setString(2, pass);
				
				return pre.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//Trở lại trạng thái an toàn của kết lối
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {
				sql = null;
				}
		return null;
	}

	@Override
	public ResultSet gets(String sql) {
		// TODO Auto-generated method stub
		return this.get(sql, 0);
	}

	@Override
	public ResultSet[] gets(String[] sql) {
		ResultSet[] tmp = new ResultSet[sql.length];
		for(int i = 0; i < sql.length; i++) {
			tmp[i] = this.get(sql[i], 0);
		}
		return null;
	}

	@Override
	public ConnectionPool getCP() {
		// TODO Auto-generated method stub
		return this.cp;
	}

	@Override
	public void releaseConnection() {
		try {
			this.cp.releaseConnectionPool(this.con, this.objectName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ResultSet> getMR(String multiSelect) {
		// TODO Auto-generated method stub
		ArrayList<ResultSet> res = new ArrayList<>();
		
		try {
			PreparedStatement pre = this.con.prepareStatement(multiSelect);
			
			boolean result = pre.execute();
			do {
				if(result) {
					res.add(pre.getResultSet());
				}
				
				//Di chuyển sang resultSet tiếp theo
				result = pre.getMoreResults(pre.KEEP_CURRENT_RESULT);
			} while(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
