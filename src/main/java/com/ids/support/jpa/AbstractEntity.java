package com.ids.support.jpa;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public abstract class AbstractEntity<ID> 
		implements Persistable<ID> {
	
	@Id
	@Getter @Setter
	private ID id;

	@Transient
	private boolean isNew = true;

	@Override
	public boolean isNew() {
		return isNew;
	}

	@PrePersist // après insertion
	@PostLoad // apres récuperation de la base de données
	void markNotNew() {
		this.isNew = false;
	}

}