package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/index")
public class HelloController {
	@GetMapping("/hello")
	public String hello(@RequestParam(name="name")String name,Model model) {
		model.addAttribute("name", model);
		return "index";
	}
}
