package com.projectfinally.ProjectoADASchool.Repository;

import com.projectfinally.ProjectoADASchool.Model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
