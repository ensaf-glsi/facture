package com.ids.support.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class CustomAbstractPersistable<ID extends Serializable> extends AbstractPersistable<ID> {
	
//	public CustomAbstractPersistable(ID id) {
//		setId(id);
//	}
	
	public <T> T id(ID id) {
		setId(id);
		return (T) this;
	}

}
