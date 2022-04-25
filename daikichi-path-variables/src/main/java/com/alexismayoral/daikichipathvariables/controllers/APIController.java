package com.alexismayoral.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/daikichi")
@RestController
public class APIController {
	
	@RequestMapping("")
	public String hello() {
		return "Hello!";
	}

	@RequestMapping("/code")
	public String code() {
		return "I love to code!";
	}

	@RequestMapping("/java")
	public String java() {
		return "Java is fun!";
	}

	@RequestMapping("/travel/{city}")
	public String travel(@PathVariable("city")String city) {
		return "Congratulations! You will soon travel to " + city + "!";
	}

	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable("num") Integer num) {
		if (num % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
	}
}

