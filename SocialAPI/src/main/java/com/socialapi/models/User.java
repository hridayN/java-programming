package com.socialapi.models;

import lombok.Data;

@Data
public class User {
	private String id;
    private String firstname;
    private String lastname;
    private Location location;
    private String email;

    public User(String _id, String _firstname, String _lastname, Location _location, String _email) {
        id = _id;
        firstname = _firstname;
        lastname = _lastname;
        location = _location;
        email = _email;
    }
}
