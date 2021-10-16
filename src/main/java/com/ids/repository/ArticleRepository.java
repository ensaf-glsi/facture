package com.ids.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ids.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

	@Query("select a from Article a where lower(designation) like %?1%")
	List<Article> findByDesignationContaining(String designation);

	//TODO a detailler la seance prochaine 
	@Query(
			value = "select id, desig, pu, unite from mql_article a where lower(desig) like %?1%", 
			nativeQuery = true)
	List<Article> findByDesignationContainingNative(String designation);
}
