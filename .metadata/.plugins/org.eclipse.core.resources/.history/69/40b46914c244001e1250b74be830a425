package jsoft.ads.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import com.mysql.cj.protocol.Resultset;

import jsoft.objects.UserObject;
import jsoft.ads.basic.*;
import jsoft.library.ORDER;
import jsoft.*;

public class UserImpl extends BasicImpl implements User {

	public UserImpl(ConnectionPool cp) {
		super(cp, "User");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addUser(UserObject item) {
		// TODO Auto-generated method stub
		if(this.isExisting(item))
			return false;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbluser (");
		sql.append("user_name, user_pass, user_fullname, user_birthday, user_mobilephone, ");
		sql.append("user_homephone, user_officephone, user_email, user_address, user_jobarea, ");
		sql.append("user_job, user_position, user_applyyear, user_permission, user_notes, ");
		sql.append("user_roles, user_logined, user_created_date, user_last_modified, user_last_logined, ");
		sql.append("user_parent_id, user_actions");
		sql.append(") ");
		sql.append("VALUES(?, md5(?) , ?, ? , ?, ? , ?, ? , ?, ? , ?, ? , ?, ? , ?, ? , ?, ? , ?, ? , ?, ?)");
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setString(4, item.getUser_birthday());
			pre.setString(5, item.getUser_mobilephone());
			pre.setString(6, item.getUser_homephone());
			pre.setString(7, item.getUser_officephone());
			pre.setString(8, item.getUser_email());
			pre.setString(9, item.getUser_address());
			pre.setString(10, item.getUser_jobarea());
			pre.setString(11, item.getUser_job());
			pre.setString(12, item.getUser_position());
			pre.setShort(13, item.getUser_applyyear());
			pre.setByte(14, item.getUser_permission());
			pre.setString(15, item.getUser_notes());
			pre.setString(16, item.getUser_roles());
			pre.setShort(17, item.getUser_logined());
			pre.setString(18, item.getUser_created_date());
			pre.setString(19, item.getUser_last_modified());
			pre.setString(20, item.getUser_last_logined());
			pre.setInt(21, item.getUser_parent_id());
			pre.setByte(22, item.getUser_actions());
			
			return this.add(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean isExisting(UserObject item) {
		boolean flag = false;
		String sql = "SELECT user_id from tbluser WHERE user_name='"+item.getUser_name()+"'";
		ResultSet rs = this.get(sql, 0);
		if(rs != null) {
			try {
				if(rs.next()) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean editUser(UserObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbluser SET ");
		sql.append("user_pass=md5(?), user_fullname=?, user_birthday=?, user_mobilephone=?, ");
		sql.append("user_homephone=?, user_officephone=?, user_email=?, user_address=?, user_jobarea=?, ");
		sql.append("user_job=?, user_position=?, user_applyyear=?, user_permission=?, user_notes=?, ");
		sql.append("user_roles=?, user_last_modified=?, user_last_logined=?, user_actions=?");
		sql.append(" WHERE user_id =? ");
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getUser_pass());
			pre.setString(2, item.getUser_fullname());
			pre.setString(3, item.getUser_birthday());
			pre.setString(4, item.getUser_mobilephone());
			pre.setString(5, item.getUser_homephone());
			pre.setString(6, item.getUser_officephone());
			pre.setString(7, item.getUser_email());
			pre.setString(8, item.getUser_address());
			pre.setString(9, item.getUser_jobarea());
			pre.setString(10, item.getUser_job());
			pre.setString(11, item.getUser_position());
			pre.setShort(12, item.getUser_applyyear());
			pre.setByte(13, item.getUser_permission());
			pre.setString(14, item.getUser_notes());
			pre.setString(15, item.getUser_roles());	
			pre.setString(16, item.getUser_last_modified());
			pre.setString(17, item.getUser_last_logined());
			pre.setByte(18, item.getUser_actions());
			pre.setInt(19, item.getUser_id());
			
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean isEmpty(UserObject item) {
		boolean flag = true;
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT article_id FROM tblarticle WHERE article_author_name='").append(item.getUser_name()).append("' ; ");
		sql.append("SELECT product_id FROM tblproduct WHERE product_manager_id="+item.getUser_id()+"; ");
		sql.append("SELECT user_id FROM tbluser WHERE user_parent_id ="+item.getUser_id()+"; ");
		
		ArrayList<ResultSet> res = this.getMR(sql.toString());
		for(ResultSet rs : res) {
			if(rs!=null) {
				try {
					if(rs.next()) {
						return false;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	@Override
	public boolean delUser(UserObject item) {
		// TODO Auto-generated method stub
		if(this.isEmpty(item)) 
			return false;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tbluser WHERE user_id =? ");
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getUser_id());
			
			return this.del(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public ResultSet getUser(int id) {
		
		String sql = "SELECT * FROM tbluser WHERE use_id=?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getUser(String username, String userpass) {
		
		String sql = "SELECT * FROM tbluser WHERE (use_name=?) AND (use_pass=?)";
		
		return this.get(sql, username, userpass);
	}

	@Override
	public ArrayList<ResultSet> getUsers(Triplet<UserObject, Integer, Byte> infos, Pair<USER_SORT, ORDER> so) {

		//Đối tượng lưu trữ thông tin bộ lọc kết quả
		UserObject similar = infos.getValue0();
		
		//Vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();		
		
		//Số bản ghi được lấy trong 1 lần
		byte total = infos.getValue2();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbluser ");
		sql.append("");
		
		switch(so.getValue0()) {
		case NAME:
			sql.append("ORDER BY user_name ").append(so.getValue1().name());
			break;
		case FULLNAME:
			sql.append("ORDER BY user_fullname ").append(so.getValue1().name());
			break;
		default:
			sql.append("ORDER BY user_id DESC ");
		}
		sql.append(" LIMIT " + at + ", " + total + "; ");
		sql.append("SELECT COUNT(user_id) AS total FROM tbluser" + "; ");
		//System.out.println(sql.toString());
		return this.getMR(sql.toString());
	}
	
	@Override
	public ArrayList<ResultSet> getUsers(Quartet<UserObject, Integer, Byte, USER_SORT> infos) {
		UserObject similar = infos.getValue0();
		int at = infos.getValue1();
		byte total = infos.getValue2();
		USER_SORT uo = infos.getValue3();

		// select tất bản ghi
		StringBuilder sql = new StringBuilder();
		sql.append("select * from tbluser ");
		switch (uo) {
		case NAME:
			sql.append("order by user_name ASC ");
			break;

		case FULLNAME:
			sql.append("order by user_fullname ASC ");
			break;
		case ADDRESS:
			sql.append("order by user_address ASC ");
			break;
		case EMAIL:
			sql.append("order by user_email ASC ");
			break;
		case PHONE:
			sql.append("order by user_email ASC ");
			break;
		default:
			sql.append("order by user_id DESC ");
			break;
		}

		sql.append("LIMIT ").append(at).append(", ").append(total).append("; ");

		// select lấy tổng số bản ghi

		sql.append("select count(user_id) AS total From tbluser;");

		return this.getMR(sql.toString());
		
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tạo đối tượng thực thi chức năng mức Interface
		User u = new UserImpl(cp);
		
		//Tạo đối tượng lưu trữ thông tin kết nối
		UserObject nUser = new UserObject();
		nUser.setUser_name("adthanh2");
		nUser.setUser_created_date("06/06/2023");
		nUser.setUser_email("thanhmeroy@gmail.com");
		nUser.setUser_parent_id(1);
		nUser.setUser_pass("1111111");		
		nUser.setUser_fullname("Nguyễn Trung Thành");
		nUser.setUser_address("Hà Nội");

		nUser.setUser_id(57);
		boolean result = u.delUser(nUser);
		if(!result) {
			System.out.println("------------KHÔNG THÀNH CÔNG------------");
		}
		
		//Lấy tập kết quả(danh sách người sử dụng)
		Triplet<UserObject, Integer, Byte> infos = new Triplet<>(null, 0, (byte)15);
		ArrayList<ResultSet> res = u.getUsers(infos, new Pair<>(USER_SORT.NAME, ORDER.DESC));
		
		ResultSet rs = res.get(0);
		
		String row;
		
		if(rs != null) {
			try {
				while (rs.next()) {
					row = "ID: " + rs.getInt("user_id");
					row += "\tNAME: " + rs.getString("user_name");
					row += "\tFULLNAME: " + rs.getString("user_fullname");
					row += "\tPARENT: " + rs.getString("user_parent_id");
					row += "\tPASS: " + rs.getString("user_pass");
					System.out.println(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = res.get(1);
		if(rs != null) {
			try {
				if(rs.next()) {
					System.out.println("Tong so tai khoan la: " + rs.getShort("total"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
