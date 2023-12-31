package com.saumya.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // dont follow singletone design pattern give multiple bean
public class Alien {

	private int id;

	private String name;

	private String technology;

	public Alien() {
		super();
		System.out.println("Object created....");
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

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public void show() {
		System.out.println("Hey ## I am Alien");
	}
}
