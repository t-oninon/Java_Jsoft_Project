package jsoft.ads.category;

import jsoft.ads.user.USER_SORT;
import jsoft.library.ORDER;
import jsoft.objects.*;
import java.sql.*;
import java.util.ArrayList;

import org.javatuples.*;

public interface Category {
	//Các chức năng cập nhật
	public boolean addCategory(CategoryObject item);
	public boolean editCategory(CategoryObject item);
	public boolean delCategory(CategoryObject item);
	
	//Các chức năng lấy dũư liệu
	public ResultSet getCategory(short id, UserObject userLogin);
	
	//public ResultSet getCategorys(CategoryObject similar, int at, byte total);
	
	public ArrayList<ResultSet> getCategorys(Triplet<CategoryObject, Integer, Byte> infos, Pair<CATEGORY_SORT, ORDER> so);
}
