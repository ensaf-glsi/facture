package com.ids.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ids.entity.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, String> {

}
