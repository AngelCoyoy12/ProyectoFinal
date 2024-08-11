package com.projectfinally.ProjectoADASchool.Service;


import com.projectfinally.ProjectoADASchool.Model.Expense;
import com.projectfinally.ProjectoADASchool.Repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExpenseServiceTest {

    @InjectMocks
    private ExpenseService expenseService;

    @Mock
    private ExpenseRepository expenseRepository;

    public ExpenseServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateExpense() {
        Expense expense = new Expense();
        expense.setDescription("Test Expense");
        expense.setAmount(100.0);

        Mockito.when(expenseRepository.save(Mockito.any(Expense.class))).thenReturn(expense);

        Expense createdExpense = expenseService.createExpense(expense);
        assertEquals("Test Expense", createdExpense.getDescription());
    }
}
