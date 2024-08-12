package com.projectfinally.ProjectoADASchool.Repository;

// Importación de la clase necesaria para trabajar con MongoDB y repositorios
import com.projectfinally.ProjectoADASchool.Model.Income;
import org.springframework.data.mongodb.repository.MongoRepository;

// La interfaz IncomeRepository extiende MongoRepository para proporcionar acceso a operaciones CRUD para la entidad Income
public interface IncomeRepository extends MongoRepository<Income, String> {
}
