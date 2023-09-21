package jsoft.ads.section;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.*;
import java.sql.*;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

public interface Section extends ShareControl{
	//Các chức năng cập nhật
	public boolean addSection(SectionObject item);
	public boolean editSection(SectionObject item);
	public boolean delSection(SectionObject item);

	//Các chức năng lấy dũư liệu
	public ResultSet getSection(short id, UserObject userLogin);
	
	//public ResultSet getSections(SectionObject similar, int at, byte total);
	
	public ArrayList<ResultSet> getSections(Triplet<SectionObject, Integer, Byte> infos, Pair<SECTION_SORT, ORDER> so);
	
	public ArrayList<ResultSet> getSections(Quartet<SectionObject, Integer, Byte, SECTION_SORT> infos);

}
