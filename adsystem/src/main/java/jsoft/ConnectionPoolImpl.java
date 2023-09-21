package jsoft;

import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool {
	//Trình điều khiển làm việc với MYSQL
	private String driver;
	
	//Đường dẫn thực thi
	private String url;
	
	//Tài khoản làm việc với CSDL
	private String username;
	private String userpass;
	
	//đối tượng lưu trữ kết nối 
	private Stack<Connection> pool;
	
	//Contructor
	public ConnectionPoolImpl() {
		//Xác định trình điều khiển
		this.driver = "com.mysql.cj.jdbc.Driver";
		
		//Xác định đường đẫn thực thi
		this.url = "jdbc:mysql://localhost:3306/jp225_data?allowMultiQueries=true";
		
		//Xác định tài khoản làm việc
		this.username = "jp225_tonion";
		this.userpass = "Thanhdzco102.";
		
		//Nạp trình điều khiển
		this.loadDriver();
		
		//Khởi tạo đối tượng lưu trữ kết nối 
		this.pool = new Stack<>();
	}
	
	private void loadDriver() {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Connection getConnection(String objectName) throws SQLException {
		// TODO Auto-generated method stub
		
		if(this.pool.isEmpty()) {
			//Khởi tạo kết nối mới
			System.out.println(objectName + " have created a new Connection.");
			return DriverManager.getConnection(this.url, this.username, this.userpass);
		} else {
			//Lấy kết nối đã được lưu trữ
			System.out.println(objectName + " popped the Connection.");
			return this.pool.pop();
		}
	}

	@Override
	public void releaseConnectionPool(Connection con, String objectName) throws SQLException {
		// TODO Auto-generated method stub
		//Yêu cầu đối tượng trả về kết nối
		System.out.println(objectName + " have push the Connection");
		this.pool.push(con);
	}
	
	protected void finalize() throws Throwable {
		this.pool.clear();
		this.pool = null;
		
		System.out.println("ConnectionPool is closed");
	}
}
