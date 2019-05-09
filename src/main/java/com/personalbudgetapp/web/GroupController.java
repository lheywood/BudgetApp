package com.personalbudgetapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.personalbudgetapp.domain.Group; 
import com.personalbudgetapp.service.GroupService;

@Controller
@RequestMapping("/budgets/{budgetId}/groups")
public class GroupController {
	
	@Autowired
	private GroupService groupService;

	@PostMapping("")
	public String postGroups(@PathVariable Long budgetId, ModelMap model) {
		
		Group group = groupService.createNewGroup(budgetId);
		
		return "redirect:/budgets/" + budgetId + "/groups/" + group.getId();
	}
	
	@GetMapping("{groupId}")
	public String getGroup(@PathVariable Long groupId, ModelMap model) {
		
		Group group = groupService.findOne(groupId);
		model.put("group", group);
		
		return "group";
	}
	
	
}
