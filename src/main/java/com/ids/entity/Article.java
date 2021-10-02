package com.ids.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*

	create table article (
		id varchar(100) PRIMARY key,
		designation varchar(255),
		pu DECIMAL,
		unite varchar(60)
	);
 */
@Builder
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor @NoArgsConstructor
public class Article {
	
	private String id;
	private String designation;
	private Double pu;
	private String unite;

}
