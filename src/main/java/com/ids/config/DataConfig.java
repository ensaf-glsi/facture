package com.ids.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

import com.ids.support.data.entity.UuidPersistent;

@Configuration
@EnableJdbcAuditing
public class DataConfig {

	@Bean
	BeforeSaveCallback<UuidPersistent> beforeSaveCallback() {

		return (p, mutableAggregateChange) -> {
			if (p.getId() == null) {
				p.setId(UUID.randomUUID().toString());
			}
			return p;
		};
	}
}
