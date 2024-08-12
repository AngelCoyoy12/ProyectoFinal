package com.projectfinally.ProjectoADASchool.Repository;

// Importación de las clases necesarias para trabajar con MongoDB y repositorios
import com.projectfinally.ProjectoADASchool.Model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

// La interfaz CategoryRepository extiende MongoRepository para proporcionar acceso a operaciones CRUD para la entidad Category
public interface CategoryRepository extends MongoRepository<Category, String> {
}

