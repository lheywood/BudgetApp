package com.personalbudgetapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.personalbudgetapp.domain.User;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin(ModelMap model) {
		User user = new User();
		model.put("user", user);
		
		return "login";
	}
	
	@RequestMapping(value ="/register", method=RequestMethod.GET)
	public String getRegister (ModelMap model) {
		
		User user = new User();
		model.put("user", user);
		
		return "register";
	}
	
	@RequestMapping(value ="/register", method=RequestMethod.POST)
	public String postRegister (@ModelAttribute User user, ModelMap model) {
		if (!StringUtils.isEmpty(user.getPassword()) && !StringUtils.isEmpty(user.getConfirmPassword())) {
			
			if (!user.getPassword().equals(user.getConfirmPassword())) {
				model.put("error", "Passwords don't match");
				return "register";
			}
		};
		
		if (StringUtils.isEmpty(user.getPassword())) {
			model.put("error", "You must enter a password");
			return "register";
		}
	return "redirect:/budgets";
	}
}
