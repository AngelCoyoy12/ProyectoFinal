package com.projectfinally.ProjectoADASchool.controller;

// Importación de las clases y anotaciones necesarias
import com.projectfinally.ProjectoADASchool.Model.Category;
import com.projectfinally.ProjectoADASchool.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Anotación para marcar esta clase como un controlador REST de Spring
@RestController
// Mapea todas las rutas que comienzan con "/categories" a este controlador
@RequestMapping("/categories")
public class CategoryController {

    // Inyección de dependencia del servicio de categoría
    @Autowired
    private CategoryService categoryService;

    // Método que maneja las solicitudes GET a "/categories"
    // Devuelve una lista con todas las categorías
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Método que maneja las solicitudes GET a "/categories/{id}"
    // Devuelve la categoría correspondiente al ID proporcionado
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        // Busca la categoría por ID, que podría no existir (por eso Optional)
        Optional<Category> category = categoryService.getCategoryById(id);

        // Si la categoría existe, la devuelve con un estado HTTP 200 (OK)
        // Si no, devuelve un estado HTTP 404 (Not Found)
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método que maneja las solicitudes POST a "/categories"
    // Crea una nueva categoría con los datos proporcionados en el cuerpo de la solicitud
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        // Crea la categoría usando el servicio y la devuelve con un estado HTTP 201 (Created)
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    // Método que maneja las solicitudes PUT a "/categories/{id}"
    // Actualiza la categoría correspondiente al ID proporcionado con los nuevos datos
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String id, @RequestBody Category category) {
        // Actualiza la categoría usando el servicio
        Category updatedCategory = categoryService.updateCategory(id, category);

        // Si la categoría fue actualizada, devuelve el objeto actualizado con un estado HTTP 200 (OK)
        // Si la categoría no fue encontrada, devuelve un estado HTTP 404 (Not Found)
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.notFound().build();
    }

    // Método que maneja las solicitudes DELETE a "/categories/{id}"
    // Elimina la categoría correspondiente al ID proporcionado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        // Elimina la categoría usando el servicio
        categoryService.deleteCategory(id);

        // Devuelve un estado HTTP 204 (No Content) para indicar que la eliminación fue exitosa
        return ResponseEntity.noContent().build();
    }
}

