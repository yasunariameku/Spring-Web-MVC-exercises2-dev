package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.entity.User;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index(@ModelAttribute("login") User form, Model model) {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("login") User from, Model model) {
		return "login";
	}
	
	
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String menu(@ModelAttribute("login") User form, Model model) {
		
		String userId = form.getUser_id();
		String password = form.getPassword();
		
		if (("").equals(userId)) {
			model.addAttribute("idMsg","userIdを入力してください");
			return "login";
		}
		
		if (("").equals(password)) {
			model.addAttribute("passMsg", "passwordを入力してください");
			return "login";
		}
		
		if (("axiz").equals(userId) && ("axizuser").equals(password)) {
			return "menu";
		}else {
			return "login";
		}
		
		
		
	}
}
