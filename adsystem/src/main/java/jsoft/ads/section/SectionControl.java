package jsoft.ads.section;


import jsoft.*;
import jsoft.ads.user.USER_SORT;
import jsoft.ads.user.UserControl;
import jsoft.library.ORDER;
import jsoft.objects.*;
import java.util.*;
import org.javatuples.*;

public class SectionControl {

	SectionModel sm;
	public SectionControl(ConnectionPool cp) {
		this.sm = new SectionModel(cp);
	}
	
	public ConnectionPool getCP() {
		return this.sm.getCP();
	}
	
	public void releaseConnection() {
		this.sm.releaseConnection();
	}

	public boolean addSetion(SectionObject item) {
		return this.sm.addSection(item);
	}

	public boolean editSetion(SectionObject item) {
		return this.sm.editSection(item);
	}
	
	public boolean delSetion(SectionObject item) {
		return this.sm.delSection(item);
	}
	
	public SectionObject getSectionObject(short id, UserObject userLogin) {
		return this.sm.getSectionObject(id, userLogin);
	}
	
	public ArrayList<String> viewSections(Triplet<SectionObject, Integer, Byte> infos, Pair<SECTION_SORT, ORDER> so) {
		Pair<ArrayList<SectionObject>, Short> datas = this.sm.getSectionObjects(infos, so);
		ArrayList<String> views = new ArrayList<>();
		views.add(SectionLibrary.viewSections(datas.getValue0()));
		return views;
	}
	
	public ArrayList<String> viewSections(Quartet<SectionObject, Short, Byte, SECTION_SORT> infos) {
		Pair<ArrayList<SectionObject>, Integer> datas = this.sm.getSectionObjects(infos);

		return SectionLibrary.viewSections(datas);
	}
	
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		SectionControl sc = new SectionControl(cp);
		
		Triplet<SectionObject, Integer, Byte> infos = new Triplet<>(null, 0, (byte)15);
		ArrayList<String> view = sc.viewSections(infos, new Pair<>(SECTION_SORT.NAME, ORDER.DESC));
		
		//System.out.println(view);
		
		Quartet<SectionObject, Short, Byte, SECTION_SORT> infos2 = new Quartet<>(null, (short)1, (byte)15, SECTION_SORT.NAME);
		ArrayList<String> view2 = sc.viewSections(infos2);
		sc.releaseConnection();  //Yêu cầu trả lại kết nối
		
		System.out.println(view2.get(0));
	}
}
