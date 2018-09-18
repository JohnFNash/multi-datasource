package com.johnfnash.learn.pro.dashboardserver.domain;

public class Company {

	private int id;
	
	private String name;
	
	private int level;
	
	private int parent_id;
	
	public Company() {
	}
	
	public Company(int id, String name, int level, int parentId) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.parent_id = parentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", level=" + level + ", parent_id=" + parent_id + "]";
	}

}
