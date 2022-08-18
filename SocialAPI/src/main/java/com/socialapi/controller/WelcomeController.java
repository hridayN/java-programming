package com.socialapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@RequestMapping(value = "/")
	public static String Welcome() {
		return "Congrats, controllers work";
	}
}
