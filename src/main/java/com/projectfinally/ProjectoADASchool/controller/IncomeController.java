package com.projectfinally.ProjectoADASchool.controller;

// Importación de las clases y anotaciones necesarias
import com.projectfinally.ProjectoADASchool.Model.Income;
import com.projectfinally.ProjectoADASchool.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Anotación para marcar esta clase como un controlador REST de Spring
@RestController
// Mapea todas las rutas que comienzan con "/incomes" a este controlador
@RequestMapping("/incomes")
public class IncomeController {

    // Inyección de dependencia del servicio de ingresos
    @Autowired
    private IncomeService incomeService;

    // Método que maneja las solicitudes GET a "/incomes"
    // Devuelve una lista con todos los ingresos
    @GetMapping
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    // Método que maneja las solicitudes GET a "/incomes/{id}"
    // Devuelve el ingreso correspondiente al ID proporcionado
    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable String id) {
        // Busca el ingreso por ID, que podría no existir (por eso Optional)
        Optional<Income> income = incomeService.getIncomeById(id);

        // Si el ingreso existe, lo devuelve con un estado HTTP 200 (OK)
        // Si no, devuelve un estado HTTP 404 (Not Found)
        return income.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método que maneja las solicitudes POST a "/incomes"
    // Crea un nuevo ingreso con los datos proporcionados en el cuerpo de la solicitud
    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody Income income) {
        // Crea el ingreso usando el servicio y lo devuelve con un estado HTTP 201 (Created)
        Income createdIncome = incomeService.createIncome(income);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
    }

    // Método que maneja las solicitudes PUT a "/incomes/{id}"
    // Actualiza el ingreso correspondiente al ID proporcionado con los nuevos datos
    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable String id, @RequestBody Income income) {
        // Actualiza el ingreso usando el servicio
        Income updatedIncome = incomeService.updateIncome(id, income);

        // Si el ingreso fue actualizado, devuelve el objeto actualizado con un estado HTTP 200 (OK)
        // Si el ingreso no fue encontrado, devuelve un estado HTTP 404 (Not Found)
        return updatedIncome != null ? ResponseEntity.ok(updatedIncome) : ResponseEntity.notFound().build();
    }

    // Método que maneja las solicitudes DELETE a "/incomes/{id}"
    // Elimina el ingreso correspondiente al ID proporcionado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable String id) {
        // Elimina el ingreso usando el servicio
        incomeService.deleteIncome(id);

        // Devuelve un estado HTTP 204 (No Content) para indicar que la eliminación fue exitosa
        return ResponseEntity.noContent().build();
    }
}
