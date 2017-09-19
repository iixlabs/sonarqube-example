package com.consoleconnect.mw.sonarqube.sample.entity;

public class Role {

	private final Long id;

	private String name;

	public Role(Long id) {
		super();
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
}
