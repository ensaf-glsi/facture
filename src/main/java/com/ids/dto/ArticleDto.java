package com.ids.dto;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ArticleDto extends AbstractPersistable<Long> {
	
	private String desig;
	private Double pu;
	private String unite;

}
