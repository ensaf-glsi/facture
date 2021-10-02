package com.ids.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Article {
	
	private String id;
	private String designation;
	private Double pu;
	private String unite;

}
