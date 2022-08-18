package com.socialapi.models;

import lombok.Data;

@Data
public class Post {
	   private String id;
	   private String postdate;
	   private User user;
	   private String details;

	   public Post(String _id, String _postdate, User _user, String _details) {
	   		id = _id;
	   		postdate = _postdate;
	   		user = _user;
	   		details = _details;
	   }
}
