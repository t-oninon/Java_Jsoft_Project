package jsoft.ads.user;

import jsoft.objects.*;
import java.sql.*;
import java.util.ArrayList;

import org.javatuples.*;

import jsoft.ShareControl;
import jsoft.ads.basic.Basic;
import jsoft.library.*;

public interface User extends ShareControl{
	//Các chức năng cập nhật
	public boolean addUser(UserObject item);
	public boolean editUser(UserObject item);
	public boolean delUser(UserObject item);

	//Các chức năng lấy dữ liệu
	public ResultSet getUser(int id);
	
	public ResultSet getUser(String username, String userpass);
	
	//public ResultSet getUsers(UserObject similar, int at, byte total);
		
	public ArrayList<ResultSet> getUsers(Triplet<UserObject, Integer, Byte> infos, Pair<USER_SORT, ORDER> so);
	
	public ArrayList<ResultSet> getUsers(Quartet<UserObject, Integer, Byte, USER_SORT> infos);
}
