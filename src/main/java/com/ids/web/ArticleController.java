package com.ids.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ids.entity.Article;
import com.ids.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	@GetMapping
	public Iterable<Article> list() {
		return articleService.findAll();
	}
//	@GetMapping("/detail")
//	public String example() {
//		return "example";
//	}
	
	// bug Accept application/xml
	@GetMapping(value = "/{id}")
	public ResponseEntity<Article> findById(@PathVariable Long id) {
		Optional<Article> article = articleService.findById(id);
		if (article.isPresent()) {
//			return ResponseEntity.ok(article.get());
			return ResponseEntity.status(HttpStatus.OK).header("token", "tokjwonon oiwj ewkfjoi").body(article.get());
		}
		return ResponseEntity.notFound().header("message", "article non trouvé").build();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Article save(@RequestBody Article article) {
//		return ResponseEntity.created(article);
		return articleService.save(article);
	}

	@PutMapping
	public Article update(@RequestBody Article article) {
		return articleService.save(article);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		articleService.deleteById(id);
	}
}
