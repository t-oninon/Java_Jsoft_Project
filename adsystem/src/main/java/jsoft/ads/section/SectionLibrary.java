package jsoft.ads.section;

import java.util.ArrayList;

import org.javatuples.Pair;

import jsoft.objects.*;

public class SectionLibrary {
	public static String viewSections(ArrayList<SectionObject> items) {
		StringBuilder tmp = new StringBuilder();
		
		tmp.append("<div class=\"card\">");
		tmp.append("<div class=\"card-body\">");
		//tmp.append("<h5 class=\"card-title\">Table with stripped rows</h5>\n");
		tmp.append("<table class=\"table table-striped\">");
		tmp.append("<thead>");
		tmp.append("<tr>");
		tmp.append("<th scope=\"col\">STT</th>");
		tmp.append("<th scope=\"col\">Tên Section</th>");
		tmp.append("<th scope=\"col\">Ghi chú</th>");
		tmp.append("<th scope=\"col\">ID</th>");
		tmp.append("<th scope=\"col\" colspan=\"3\">Thực hiện</th>");
		tmp.append("</tr>");
		tmp.append("</thead>\n");
		
		tmp.append("<tbody>");
		items.forEach(item -> {
			tmp.append("<tr>");
			tmp.append("<th scope=\"row\">"+(items.indexOf(item)+1)+"</th>");
			tmp.append("<td>"+item.getSection_name()+"</td>");
			tmp.append("<td>"+item.getSection_notes()+"</td>");
			tmp.append("<td>"+item.getSection_id()+"</td>");
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
	
	
	public static ArrayList<String> viewSections(Pair<ArrayList<SectionObject>, Integer> datas) {
		ArrayList<SectionObject> items = datas.getValue0();
		int total = datas.getValue1();
		
		ArrayList<String>tmp = new ArrayList<>();
		
		StringBuilder list = new StringBuilder();
		
		list.append("<div class=\"card\">");
		list.append("<div class=\"card-body\">");
		//list.append("<h5 class=\"card-title\">Table with stripped rows</h5>\n");
		list.append("<table class=\"table table-striped\">");
		list.append("<thead>");
		list.append("<tr>");
		list.append("<th scope=\"col\">STT</th>");
		list.append("<th scope=\"col\">Tên Section</th>");
		list.append("<th scope=\"col\">Ghi chú</th>");
		list.append("<th scope=\"col\">ID</th>");
		list.append("<th scope=\"col\" colspan=\"3\">Thực hiện</th>");
		list.append("</tr>");
		list.append("</thead>\n");
		
		list.append("<tbody>");
		items.forEach(item -> {
			list.append("<tr>");
			list.append("<th scope=\"row\">"+(items.indexOf(item)+1)+"</th>");
			list.append("<td>"+item.getSection_name()+"</td>");
			list.append("<td>"+item.getSection_notes()+"</td>");
			list.append("<td>"+item.getSection_id()+"</td>");
			list.append("<td>Chi tiết</td>");
			list.append("<td>Sửa</td>");
			list.append("<td>Xóa</td>");
			list.append("</tr>\n");
		});
		
		
		list.append("</tbody>");
		list.append("</table>");
		
		
		list.append("</div>");
		list.append("</div>");
		tmp.add(list.toString());
		return tmp;
	}
	
	public SectionLibrary() {
		// TODO Auto-generated constructor stub
	}

}
