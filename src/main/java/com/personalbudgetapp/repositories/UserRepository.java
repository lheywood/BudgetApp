package com.personalbudgetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalbudgetapp.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);
}
