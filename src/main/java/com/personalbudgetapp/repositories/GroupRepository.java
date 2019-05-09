package com.personalbudgetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalbudgetapp.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
