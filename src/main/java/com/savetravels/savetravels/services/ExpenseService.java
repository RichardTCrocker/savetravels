package com.savetravels.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savetravels.savetravels.models.Expense;
import com.savetravels.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService{
    @Autowired ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByID(Long id) {
        Optional <Expense> expense = expenseRepository.findById(id);
        return expense.orElse(null);
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void editExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

}