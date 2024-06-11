package com.codingdojo.saveTravels.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.saveTravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

}
