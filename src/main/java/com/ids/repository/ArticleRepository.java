package com.ids.repository;

import org.springframework.data.repository.CrudRepository;

import com.ids.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
