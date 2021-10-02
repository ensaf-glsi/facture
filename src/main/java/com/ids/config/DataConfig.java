package com.ids.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

import com.ids.entity.Article;

@Configuration
public class DataConfig {

	@Bean
	BeforeSaveCallback<Article> beforeSaveCallback() {

		return (article, mutableAggregateChange) -> {
			if (article.getId() == null) {
				article.setId(UUID.randomUUID().toString());
			}
			return article;
		};
	}
}
