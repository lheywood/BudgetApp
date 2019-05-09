package com.personalbudgetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalbudgetapp.domain.Budget;
import com.personalbudgetapp.domain.Group;
import com.personalbudgetapp.repositories.GroupRepository;

@Service
public class GroupService {
	
	@Autowired
	private BudgetService budgetService;
	
	@Autowired
	private GroupRepository groupRepo;
	
	public Group createNewGroup(Long budgetId) {

		Group group = new Group();
		
		Budget budget = budgetService.findOne(budgetId);
		group.setBudget(budget);
		budget.getGroups().add(group);
		
		return save(group);
	}

	private Group save(Group group) {
		
		return groupRepo.save(group);
	}

	public Group findOne(Long groupId) {
	
		return groupRepo.findById(groupId).orElse(null);
	}
}
