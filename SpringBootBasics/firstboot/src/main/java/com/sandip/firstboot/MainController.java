package com.sandip.firstboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		System.out.println("inside Home");
		return "home";

	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
