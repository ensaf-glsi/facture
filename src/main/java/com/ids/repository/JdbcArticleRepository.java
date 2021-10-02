package com.ids.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ids.entity.Article;
import com.ids.utils.Database;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JdbcArticleRepository {
	
	private final Database database;

//	public JdbcArticleRepository(Database database) {
//		this.database = database;
//	}
	
	public void save(Article article) {
		String sql = "insert into article(id, designation, pu, unite) values ()";
		// database.execute(null);
		
	}

	public void update(Article article) {
		
	}
	
	public void delete(Article article) {
		
	}
	
	public Optional<Article> findById(String id) {
		return Optional.empty();
	}
	
}
