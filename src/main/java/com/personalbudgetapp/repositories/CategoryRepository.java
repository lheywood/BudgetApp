package com.personalbudgetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalbudgetapp.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>
{

}
