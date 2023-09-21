package jsoft.ads.basic;

import java.sql.*;
import java.util.ArrayList;

import jsoft.*;
//import jsoft.objects.*;

public interface Basic extends ShareControl{
	//Các chức năng cập nhật
	//PreparedStatement pre - đã được biên dịch và truyền đầy đủ giá trị
	public boolean add(PreparedStatement pre);
	public boolean edit(PreparedStatement pre);
	public boolean del(PreparedStatement pre);
	
	//Các chức năng lấy dũư liệu
	public ResultSet get(String sql, int id);
	public ResultSet get(String sql, String name, String pass);
	public ResultSet gets(String sql);
	public ResultSet[] gets(String[] sql);
	public ArrayList<ResultSet> getMR(String multiSelect);	
}
