package com.projectfinally.ProjectoADASchool.controller;

// Importación de las clases y anotaciones necesarias
import com.projectfinally.ProjectoADASchool.Model.Expense;
import com.projectfinally.ProjectoADASchool.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Anotación para marcar esta clase como un controlador REST de Spring
@RestController
// Mapea todas las rutas que comienzan con "/expenses" a este controlador
@RequestMapping("/expenses")
public class ExpenseController {

    // Inyección de dependencia del servicio de gastos
    @Autowired
    private ExpenseService expenseService;

    // Método que maneja las solicitudes GET a "/expenses"
    // Devuelve una lista con todos los gastos
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // Método que maneja las solicitudes GET a "/expenses/{id}"
    // Devuelve el gasto correspondiente al ID proporcionado
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable String id) {
        // Busca el gasto por ID, que podría no existir (por eso Optional)
        Optional<Expense> expense = expenseService.getExpenseById(id);

        // Si el gasto existe, lo devuelve con un estado HTTP 200 (OK)
        // Si no, devuelve un estado HTTP 404 (Not Found)
        return expense.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método que maneja las solicitudes POST a "/expenses"
    // Crea un nuevo gasto con los datos proporcionados en el cuerpo de la solicitud
    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        // Crea el gasto usando el servicio y lo devuelve con un estado HTTP 201 (Created)
        Expense createdExpense = expenseService.createExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
    }

    // Método que maneja las solicitudes PUT a "/expenses/{id}"
    // Actualiza el gasto correspondiente al ID proporcionado con los nuevos datos
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable String id, @RequestBody Expense expense) {
        // Actualiza el gasto usando el servicio
        Expense updatedExpense = expenseService.updateExpense(id, expense);

        // Si el gasto fue actualizado, devuelve el objeto actualizado con un estado HTTP 200 (OK)
        // Si el gasto no fue encontrado, devuelve un estado HTTP 404 (Not Found)
        return updatedExpense != null ? ResponseEntity.ok(updatedExpense) : ResponseEntity.notFound().build();
    }

    // Método que maneja las solicitudes DELETE a "/expenses/{id}"
    // Elimina el gasto correspondiente al ID proporcionado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable String id) {
        // Elimina el gasto usando el servicio
        expenseService.deleteExpense(id);

        // Devuelve un estado HTTP 204 (No Content) para indicar que la eliminación fue exitosa
        return ResponseEntity.noContent().build();
    }
}

