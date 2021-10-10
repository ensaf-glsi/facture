package com.ids.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.ids.support.data.entity.UuidPersistent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Table("mq_articles")
@Builder
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor @NoArgsConstructor
public class Article implements UuidPersistent {
	@Id
	private String id;
	private String designation;
	private Double pu;
	@Column("unite")
	private String uniteVente;
	private String uniteStock;

}
