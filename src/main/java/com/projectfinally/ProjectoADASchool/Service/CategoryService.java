package com.projectfinally.ProjectoADASchool.Service;

import com.projectfinally.ProjectoADASchool.Model.Category;
import com.projectfinally.ProjectoADASchool.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotación que indica que esta clase es un componente de servicio en Spring
@Service
public class CategoryService {

    // Inyección de dependencia del repositorio de categorías
    @Autowired
    private CategoryRepository categoryRepository;

    // Método para obtener todas las categorías
    public List<Category> getAllCategories() {
        // Llama al método findAll del repositorio para obtener todas las categorías
        return categoryRepository.findAll();
    }

    // Método para obtener una categoría por su ID
    public Optional<Category> getCategoryById(String id) {
        // Llama al método findById del repositorio para obtener una categoría por su ID
        return categoryRepository.findById(id);
    }

    // Método para crear una nueva categoría
    public Category createCategory(Category category) {
        // Llama al método save del repositorio para guardar la nueva categoría
        return categoryRepository.save(category);
    }

    // Método para actualizar una categoría existente
    public Category updateCategory(String id, Category category) {
        // Verifica si la categoría con el ID dado existe en el repositorio
        if (categoryRepository.existsById(id)) {
            // Establece el ID de la categoría para asegurarse de que el documento actualizado tenga el ID correcto
            category.setId(id);
            // Llama al método save del repositorio para guardar la categoría actualizada
            return categoryRepository.save(category);
        }
        // Si la categoría no existe, devuelve null
        return null;
    }

    // Método para eliminar una categoría por su ID
    public void deleteCategory(String id) {
        // Llama al método deleteById del repositorio para eliminar la categoría con el ID dado
        categoryRepository.deleteById(id);
    }
}
