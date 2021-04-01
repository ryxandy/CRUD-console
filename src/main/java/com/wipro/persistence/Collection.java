package com.wipro.persistence;

public class Collection {

	String name;
	String description;
	String keyword;
	String subCollection;
	

	public Collection() {
		super();
	}

	public Collection(String name, String description, String keyword) {
		super();
		this.name = name;
		this.description = description;
		this.keyword = keyword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
