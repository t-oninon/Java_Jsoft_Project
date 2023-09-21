package jsoft.ads.article;

import jsoft.*;
import jsoft.library.ORDER;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ArticleModel {
	Article a;
	
	public ArticleModel(ConnectionPool cp) {
		this.a = new ArticleImpl(cp);
	}
	
	public boolean addArticle(ArticleObject item) {
		return this.addArticle(item);
	}
	
	public boolean editArticle(ArticleObject item) {
		return this.editArticle(item);
	}
	
	public boolean delArticle(ArticleObject item) {
		return this.delArticle(item);
	}
	
	public ArticleObject getArticleObject(short id) {
		ArticleObject item = null;
		
		ResultSet rs = this.a.getArticle(id);
		if(rs!= null) {
			try {
				if(rs.next()) {
					item = new ArticleObject();
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_image(rs.getString("article_image"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
}
