package jsoft.ads.user;

import jsoft.*;
import jsoft.objects.*;

import java.util.ArrayList;

import org.javatuples.*;

public class UserLibrary {
	public static String viewUsers(ArrayList<UserObject> items) {
		StringBuilder tmp = new StringBuilder();
		
		tmp.append("<div class=\"card\">");
		tmp.append("<div class=\"card-body\">");
		//tmp.append("<h5 class=\"card-title\">Table with stripped rows</h5>\n");
		tmp.append("<table class=\"table table-striped\">");
		tmp.append("<thead>");
		tmp.append("<tr>");
		tmp.append("<th scope=\"col\">STT</th>");
		tmp.append("<th scope=\"col\">Ngày tạo</th>");
		tmp.append("<th scope=\"col\">Tài khoản</th>");
		tmp.append("<th scope=\"col\">Họ tên</th>");
		tmp.append("<th scope=\"col\">Hộp thư</th>");
		tmp.append("<th scope=\"col\">Lần đăng nhập</th>");
		tmp.append("<th scope=\"col\">ID</th>");
		tmp.append("<th scope=\"col\" colspan=\"3\">Thực hiện</th>");
		tmp.append("</tr>");
		tmp.append("</thead>\n");
		
		tmp.append("<tbody>");
		items.forEach(item -> {
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\">"+(items.indexOf(item)+1)+"</th>");
			tmp.append("<td>"+item.getUser_created_date()+"</td>");
			tmp.append("<td>"+item.getUser_name()+"</td>");
			tmp.append("<td>"+item.getUser_fullname()+"</td>");
			tmp.append("<td>"+item.getUser_email()+"</td>");
			tmp.append("<td>"+item.getUser_logined()+"</td>");
			tmp.append("<th scope=\"row\">"+item.getUser_id()+"</th>");
			tmp.append("<td>Chi tiết</td>");
			tmp.append("<td>Sửa</td>");
			tmp.append("<td>Xóa</td>");
			tmp.append("</tr>\n");
		});
		
		
		tmp.append("</tbody>");
		tmp.append("</table>");
		
		
		tmp.append("</div>");
		tmp.append("</div>");
		return tmp.toString();
	}
	
	public static ArrayList<String> viewUsers(Pair<ArrayList<UserObject>,Integer> datas) {
		//bóc tách dữ liệu để xử lý
		ArrayList<UserObject> items = datas.getValue0();
		int total = datas.getValue1();
		
		//cấu trúc trình bày danh sách và phân trang
		ArrayList<String>tmp = new ArrayList<>();
		
		//Danh sách
		StringBuilder list = new StringBuilder();
		
		list.append("<div class=\"card\">");
		list.append("<div class=\"card-body\">");
		list.append("<h5 class=\"card-title\">Table with stripped rows</h5>\n");
		list.append("");
		list.append("<!-- Table with stripped rows -->");
		list.append("<table class=\"table table-striped\">");
		list.append("<thead>");
		list.append("<tr>");
		list.append("<th scope=\"col\">#</th>");
		list.append("<th scope=\"col\">Tài khoản</th>");
		list.append("<th scope=\"col\">Họ tên</th>");
		list.append("<th scope=\"col\">Hộp thư</th>");
		list.append("<th scope=\"col\">Điện thoại</th>");
		list.append("<th scope=\"col\">Ngày đăng nhập</th>");
		list.append("<th scope=\"col\" colspan=\"3\">Thực hiện</th>");
		list.append("</tr>");
		list.append("</thead>\n");
		
		list.append("<tbody>");
		
		items.forEach(item -> {
			list.append("<tr>");
			list.append("<th scope=\"row\">"+item.getUser_id()+"</th>");
			list.append("<th scope=\"row\">"+item.getUser_name()+"</th>");
			list.append("<td>"+item.getUser_fullname()+"</td>");
			list.append("<td>"+item.getUser_email()+"</td>");
			list.append("<td>"+item.getUser_homephone()+"</td>");
			list.append("<td>"+item.getUser_last_logined()+"</td>");
			list.append("<td>Chi tiết</td>");
			list.append("<td>Sửa</td>");
			list.append("<td>Xóa</td>");
			list.append("</tr>\n");
		});
		
		list.append("</tbody>");
		list.append("</table>");
		list.append("<!-- End Table with stripped rows -->");
		list.append("");
		list.append("</div>");//end card body
		list.append("</div>");//end card
			
		
		//phân trang
		
		tmp.add(list.toString());
		
		return tmp;
	}
	
	public UserLibrary() {
		// TODO Auto-generated constructor stub
	}

}
