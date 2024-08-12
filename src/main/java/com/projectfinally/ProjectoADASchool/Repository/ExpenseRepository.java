package com.projectfinally.ProjectoADASchool.Repository;

// Importación de la clase necesaria para trabajar con MongoDB y repositorios
import com.projectfinally.ProjectoADASchool.Model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

// La interfaz ExpenseRepository extiende MongoRepository para proporcionar acceso a operaciones CRUD para la entidad Expense
public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
