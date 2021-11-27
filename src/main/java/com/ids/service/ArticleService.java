package com.ids.service;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ids.entity.Article;
import com.ids.repository.ArticleRepository;

@Transactional(readOnly = true)
@Service
public class ArticleService {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ArticleRepository articleRepository;

	public <T> Collection<T> findAllProjectedBy(Class<T> projection) {
		return articleRepository.findAllProjectedBy(projection);
	}

	@Transactional(readOnly = false)
	public Article save(Article article) {
		return articleRepository.save(article);
	}

	public Optional<Article> findById(Long id) {
		return articleRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return articleRepository.existsById(id);
	}

	public Iterable<Article> findAll() {
		return articleRepository.findAll();
	}

	public long count() {
		return articleRepository.count();
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}

}
