//package com.ids.repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Repository;
//
//import com.ids.entity.Article;
//import com.ids.utils.Database;
//
//import lombok.Cleanup;
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Repository
//public class JdbcArticleRepository {
//
//	private final Database database;
//
////	public JdbcArticleRepository(Database database) {
////		this.database = database;
////	}
//
//	public void save(Article article) {
//		String sql = "insert into article(id, designation, pu, unite) values (?, ?, ?, ?)";
//		database.execute(sql,
//				new Object[] { article.getId(), article.getDesignation(), article.getPu(), article.getUnite() });
//	}
//
//	public void update(Article article) {
//		String sql = "update article set designation = ?, pu = ?, unite = ? where id = ?";
//		database.execute(sql,
//				new Object[] { article.getDesignation(), article.getPu(), article.getUnite(), article.getId() });
//
//	}
//
//	public void delete(Article article) {
//
//	}
//
//	public Optional<Article> findById(String id) {
//		String sql = "select * from article where id = ?";
//		try {
//			@Cleanup Connection connection = database.getConnection();
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(1, id);
//			ResultSet rs = statement.executeQuery();
//			if (rs.next()) {
//				Article a = new Article(rs.getString("id"), rs.getString("designation"), rs.getDouble("pu"), rs.getString("unite"));
//				return Optional.of(a);
//			}
//			
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return Optional.empty();
//	}
//
////	public List<Article> findAll() {
////		List<Article> list = new ArrayList<>();
////		String sql = "select * from article";
////		try {
////			@Cleanup Connection connection = database.getConnection();
////			PreparedStatement statement = connection.prepareStatement(sql);
////			ResultSet rs = statement.executeQuery();
////			while (rs.next()) {
////				Article a = new Article(rs.getString("id"), rs.getString("designation"), rs.getDouble("pu"), rs.getString("unite"));
////				list.add(a);
////			}
////			
////		} catch (SQLException e) {
////			throw new RuntimeException(e);
////		}
////		return list;
////	}
//
//	public List<Article> findAll() {
//		return database.query("select * from article", null, 
//			rs -> {
//				try {
//					return new Article(rs.getString("id"), rs.getString("designation"), rs.getDouble("pu"), rs.getString("unite"));
//				} catch (SQLException e) {
//					throw new RuntimeException(e);
//				}
//			});
//	}
//	
//}
