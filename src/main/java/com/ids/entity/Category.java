package com.ids.entity;

import javax.persistence.Entity;

import com.ids.support.jpa.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Category extends AbstractEntity<String> {
	
	private String nom;

}
