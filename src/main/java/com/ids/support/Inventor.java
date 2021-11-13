package com.ids.support;

import java.util.Date;

public class Inventor {
	
	String name;
	Date birthday;
	String nationality;

	public Inventor(String name, Date birthday, String nationality) {
		this.name = name;
		this.birthday = birthday;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}
}
