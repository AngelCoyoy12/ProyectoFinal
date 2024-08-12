package com.projectfinally.ProjectoADASchool.Service;

import com.projectfinally.ProjectoADASchool.Model.Expense;
import com.projectfinally.ProjectoADASchool.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotación que indica que esta clase es un componente de servicio en Spring
@Service
public class ExpenseService {

    // Inyección de dependencia del repositorio de gastos
    @Autowired
    private ExpenseRepository expenseRepository;

    // Método para obtener todos los gastos
    public List<Expense> getAllExpenses() {
        // Llama al método findAll del repositorio para obtener todos los gastos
        return expenseRepository.findAll();
    }

    // Método para obtener un gasto por su ID
    public Optional<Expense> getExpenseById(String id) {
        // Llama al método findById del repositorio para obtener un gasto por su ID
        return expenseRepository.findById(id);
    }

    // Método para crear un nuevo gasto
    public Expense createExpense(Expense expense) {
        // Llama al método save del repositorio para guardar el nuevo gasto
        return expenseRepository.save(expense);
    }

    // Método para actualizar un gasto existente
    public Expense updateExpense(String id, Expense expense) {
        // Verifica si el gasto con el ID dado existe en el repositorio
        if (expenseRepository.existsById(id)) {
            // Establece el ID del gasto para asegurarse de que el documento actualizado tenga el ID correcto
            expense.setId(id);
            // Llama al método save del repositorio para guardar el gasto actualizado
            return expenseRepository.save(expense);
        }
        // Si el gasto no existe, devuelve null
        return null;
    }

    // Método para eliminar un gasto por su ID
    public void deleteExpense(String id) {
        // Llama al método deleteById del repositorio para eliminar el gasto con el ID dado
        expenseRepository.deleteById(id);
    }
}
