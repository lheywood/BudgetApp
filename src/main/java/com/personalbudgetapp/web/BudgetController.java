package com.personalbudgetapp.web;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personalbudgetapp.domain.Budget;
import com.personalbudgetapp.domain.User;
import com.personalbudgetapp.service.BudgetService;

@Controller
@RequestMapping("/budgets")
public class BudgetController {
	
	@Autowired
	private BudgetService budgetService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getBudgets(@AuthenticationPrincipal User user, ModelMap model) {
		
		populateUserBudgetsOnModel(user, model);
		return "budgets";
	}
	
	@GetMapping("{budgetId}")
	public String getBudget(@PathVariable Long budgetId, ModelMap model) {
		
		Budget budget = budgetService.findOne(budgetId);
		
		model.put("budget", budget);
		
		return "budget";
	}

	private String populateUserBudgetsOnModel(User user, ModelMap model) {
		
		TreeSet<Budget> budgets = budgetService.getBudgets(user);
		model.put("budgets", budgets);
		
		return "budgets";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public @ResponseBody Budget postBudget(@AuthenticationPrincipal User user, ModelMap model) {
		
		Budget budget = new Budget();
		budget = budgetService.saveBudget(user, budget);
		
		getBudgets(user, model);
		
		return budget;
		
	}

}
