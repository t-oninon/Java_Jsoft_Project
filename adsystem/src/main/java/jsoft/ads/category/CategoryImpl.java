package jsoft.ads.category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.ads.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.CategoryObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

public class CategoryImpl extends BasicImpl implements Category {

	public CategoryImpl(ConnectionPool cp) {
		super(cp, "Category");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCategory(CategoryObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();// dữ nguyên tham chiếu không cần phải làm chiếu nhiều lần
		sql.append("INSERT INTO tblcategory (");
		sql.append("category_name, category_section_id, category_notes, category_created_date, category_created_author_id, ");
		sql.append("category_last_modified, category_manager_id, category_enable, category_delete, ");
		sql.append("category_image, category_name_en, category_language ");
		sql.append(") ");
		sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ");
		
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getCategory_name());
			pre.setShort(2, item.getCategory_section_id());
			pre.setString(3, item.getCategory_notes());
			pre.setString(4, item.getCategory_created_date());
			pre.setInt(5, item.getCategory_created_author_id());
			pre.setString(6, item.getCategory_last_modified());
			pre.setInt(7, item.getCategory_manager_id());
			pre.setBoolean(8, item.isCategory_enable());
			pre.setBoolean(9, item.isCategory_delete());
			pre.setString(10, item.getCategory_image());
			pre.setString(11, item.getCategory_name_en());
			pre.setByte(12, item.getCategory_language());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//trả về trạng thái an toàn
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean editCategory(CategoryObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();// dữ nguyên tham chiếu không cần phải làm chiếu nhiều lần
		sql.append("UPDATE tblcategory SET (");
		sql.append("category_name=?, category_section_id=?, category_notes=?, ");
		sql.append("category_last_modified=?, category_manager_id=?, category_enable=?, category_delete=?, ");
		sql.append("category_image=?, category_name_en=?, category_language=? ");
		sql.append(") WHERE category_id=?");
		
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getCategory_name());
			pre.setShort(2, item.getCategory_section_id());
			pre.setString(3, item.getCategory_notes());
			pre.setString(4, item.getCategory_last_modified());
			pre.setInt(5, item.getCategory_manager_id());
			pre.setBoolean(6, item.isCategory_enable());
			pre.setBoolean(7, item.isCategory_delete());
			pre.setString(8, item.getCategory_image());
			pre.setString(9, item.getCategory_name_en());
			pre.setByte(10, item.getCategory_language());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//trả về trạng thái an toàn
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	private boolean isEmpty(CategoryObject item) {
		boolean flag = true; 
		StringBuilder sql = new StringBuilder(); 
		sql.append("SELECT article_id FROM tblarticle WHERE article_category_id=?");
	
		ResultSet rs = this.get(sql.toString(), item.getCategory_id());
		if(rs != null) {
			try {
				if(rs.next()) {
					flag = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	@Override
	public boolean delCategory(CategoryObject item) {
		// TODO Auto-generated method stub
		if(!this.isEmpty(item)) {
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tblcategory WHERE category_id=?");
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getCategory_id());
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
	public ResultSet getCategory(short id, UserObject userLogin) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder(); 
		sql.append("SELECT * FROM tblcategory");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id=s.section_id ");
		sql.append("LEFT JOIN tbluser AS u ON s.category_manager_id = u.user_id");
		sql.append("WHERE c.category_id=? AND ((s.category_manager_id="+userLogin.getUser_id()+
				") OR (s.category_created_author_id="+userLogin.getUser_id()+")");
		return this.get(sql.toString(), id);
	}

	@Override
	public ArrayList<ResultSet> getCategorys(Triplet<CategoryObject, Integer, Byte> infos, Pair<CATEGORY_SORT, ORDER> so) {
		// TODO Auto-generated method stub
		// đối tượng lưu trữ thông tin lọc kết quả 
		CategoryObject similer = infos.getValue0(); 
		
		// vị trí bắt đầu lấy bản ghi 
		int at = infos.getValue1();
		
		//số bản ghi được lấy trong một lần 
		byte totalperpage = infos.getValue2();
		
		StringBuilder sql= new StringBuilder();
		sql.append("SELECT * FROM tblcategory AS c ");
		sql.append("LEFT JOIN tbluser AS u ON c.category_manager_id = u.user_id ");
		sql.append("LEFT JOIN tblsection AS s ON c.category_section_id = s.section_id ");
		sql.append("");
		switch(so.getValue0()) {
		case NAME:
			sql.append("ORDER BY c.category_name ").append(so.getValue1().name());
			break;
		case MANAGER:
			sql.append("ORDER BY c.category_manager_id ").append(so.getValue1().name());
			break;
		default:
			sql.append("ORDER BY c.category_id DESC ");
		}
		sql.append(" LIMIT "+at+ ", "+ totalperpage +"; ");
		
		// tổng số bản ghi 
		sql.append("SELECT COUNT(category_id) AS total FROM tblcategory;");
		return this.getMR(sql.toString());
	}

}
