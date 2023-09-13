package com.savetravels.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.savetravels.savetravels.models.Expense;
import com.savetravels.savetravels.services.ExpenseService;


@Controller
public class ExpenseController {
    
    @Autowired ExpenseService expenseService;

    @GetMapping("/expenses")
    public String expenses(@ModelAttribute Expense expense, Model model) {
		List<Expense> expenses = expenseService.getAllExpenses();
	    model.addAttribute("expenses", expenses);
        return "index.jsp";
    }
    
    @PostMapping("/expenses")
    public String createExpense(@ModelAttribute Expense expense){
        expenseService.addExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/{id}")
    public String show(@PathVariable Long id, Model model){
        Expense expense = expenseService.getExpenseByID(id);
        model.addAttribute("expense", expense);
        return "show.jsp";
    }

    @GetMapping("/expenses/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Expense expense = expenseService.getExpenseByID(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }

    @PutMapping("/expenses/{id}")
    public String update(@ModelAttribute Expense expense){
        expenseService.editExpense(expense);
        return "redirect:/expenses";
    }

    @DeleteMapping("/expenses/{id}/delete")
    public String destroy(@PathVariable Long id){
        expenseService.deleteExpenseById(id);
        return"redirect:/expenses";
    }
}