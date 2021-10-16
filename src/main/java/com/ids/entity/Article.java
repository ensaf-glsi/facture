package com.ids.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ids.support.jpa.CustomAbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "mql_article")

@Getter @Setter @ToString
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Article extends CustomAbstractPersistable<Long> {
	
	@Column(name = "desig")
	private String designation;
	private Double pu;
	private String unite;

}
