package com.personalbudgetapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/budgets")
public class BudgetController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getBudget(ModelMap model) {
		return "budget";
	}
	

}
