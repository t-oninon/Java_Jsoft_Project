package jsoft.ads.category;

import jsoft.*;
import jsoft.library.ORDER;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

import org.javatuples.Pair;
import org.javatuples.Triplet;

public class CategoryModel {

	private Category c;

	public CategoryModel(ConnectionPool cp) {
		this.c = new CategoryImpl(cp);
	}

	// -----------------------------------------
	public boolean addCategory(CategoryObject item) {
		return this.c.addCategory(item);
	}

	// -----------------------------------------
	public boolean editCategory(CategoryObject item) {
		return this.c.addCategory(item);
	}

	// -----------------------------------------
	public boolean delCategory(CategoryObject item) {
		return this.c.addCategory(item);
	}
	
	public CategoryObject getCategoryOject(short id, UserObject userLogin) {
		CategoryObject item = null; 
		
		ResultSet rs = this.c.getCategory(id, userLogin); 
		if(rs != null) {
			try {
				if(rs.next()) {
					item = new CategoryObject(); 
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_section_id(rs.getShort("category_section_id"));
					item.setCategory_notes(rs.getString("category_notes"));
					item.setCategory_last_modified(rs.getString("category_last_modified"));
					item.setCategory_manager_id(rs.getInt("category_manager_id"));
					item.setCategory_enable(rs.getBoolean("category_enable"));
					item.setCategory_image(rs.getString("category_image"));
					item.setCategory_name_en(rs.getString("Category_name_en"));
					item.setCategory_language(rs.getByte("category_language"));
					
					item.setCategory_id(rs.getShort("category_id"));
				}
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public Pair<ArrayList<CategoryObject>, Short> getCategoryObject(Triplet<CategoryObject, Integer, Byte> infos,
			Pair<CATEGORY_SORT, ORDER> so){
		CategoryObject item = null; 
		ArrayList<CategoryObject> items = new ArrayList<>(); 
		ArrayList<ResultSet> res = this.c.getCategorys(infos, so);
		ResultSet rs = res.get(1);
		if(rs != null) {
			try {
				if(rs.next()) {
					item = new CategoryObject(); 
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_section_id(rs.getShort("category_section_id"));
					item.setCategory_notes(rs.getString("category_notes"));
					item.setCategory_last_modified(rs.getString("category_last_modified"));
					item.setCategory_manager_id(rs.getInt("category_manager_id"));
					item.setCategory_enable(rs.getBoolean("category_enable"));
					item.setCategory_image(rs.getString("category_image"));
					item.setCategory_name_en(rs.getString("Category_name_en"));
					item.setCategory_language(rs.getByte("category_language"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// lấy tổng số bản gghi 
		rs = res.get(0); 
		short totalperpage = 0 ; 
		if(rs != null) {
			try {
				if(rs.next()) {
					totalperpage = rs.getShort("totalperpage"); 
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Pair<>(items, (short) 10);
	}

}
