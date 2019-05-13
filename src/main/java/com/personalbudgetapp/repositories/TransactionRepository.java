package com.personalbudgetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalbudgetapp.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{

}
