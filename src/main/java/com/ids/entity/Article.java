package com.ids.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mql_article")

@Builder
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor @NoArgsConstructor
public class Article {
	
	@Id @GeneratedValue
	private Long id;
	@Column(name = "desig")
	private String designation;
	private Double pu;
	private String unite;

}
