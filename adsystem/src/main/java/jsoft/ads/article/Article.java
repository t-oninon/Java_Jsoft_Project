package jsoft.ads.article;

import java.sql.*;
import java.util.ArrayList;

import org.javatuples.Triplet;

import org.javatuples.Pair;

import jsoft.library.ORDER;
import jsoft.objects.*;

public interface Article {
	//Các chức năng cập nhật
	public boolean addArticle(ArticleObject item);
	public boolean editArticle(ArticleObject item);
	public boolean delArticle(ArticleObject item);
	
	//Các chức năng lấy dũư liệu
	public ResultSet getArticle(short id);
	
	//public ResultSet getArticles(ArticleObject similar, int at, byte total);
	
	public ArrayList<ResultSet> getArticles(Triplet<ArticleObject, Integer, Byte> infos, Pair<ARTICLE_SORT, ORDER> so);
}
