package com.personalbudgetapp.repositories;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalbudgetapp.domain.Budget;
import com.personalbudgetapp.domain.User;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

	
TreeSet<Budget> findByUsers(Set<User> users); 
	
int countByUsers(Set<User> users);

}
