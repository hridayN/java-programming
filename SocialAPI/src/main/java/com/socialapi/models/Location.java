package com.socialapi.models;

import lombok.Data;

@Data
public class Location {
	private String id;
	private String name;
	public Location(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
