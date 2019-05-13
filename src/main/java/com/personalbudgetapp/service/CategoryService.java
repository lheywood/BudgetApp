package com.personalbudgetapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalbudgetapp.domain.Category;
import com.personalbudgetapp.repositories.CategoryRepository;

@Service
public class CategoryService
{
  @Autowired
  private CategoryRepository categoryRepo;
  
  public Category saveCategory (Category category)
  {
    return categoryRepo.save(category);
  }

  public Category findOne(Long categoryId)
  {
    return categoryRepo.findById(categoryId).orElse(null);
  }
}

