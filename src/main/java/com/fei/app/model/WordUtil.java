package com.fei.app.model;

import java.io.Serializable;

public class WordUtil implements Serializable{

	private int id;
	private String name;
	
	public int getId() {
		
		return id;
		
	}
	public String getName() {
		
		return name;
	}
	
	public void setID(int id) {
		this.id = id;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
}
