package com.personalbudgetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalbudgetapp.domain.Transaction;
import com.personalbudgetapp.repositories.TransactionRepository;

@Service
public class TransactionService
{
  @Autowired
  private TransactionRepository transactionRepo;
  
  public Transaction save (Transaction transaction)
  {
    return transactionRepo.save(transaction);
  }

  public Transaction findOne(Long transactionId)
  {
    return transactionRepo.findById(transactionId).orElse(null);
  }
}
