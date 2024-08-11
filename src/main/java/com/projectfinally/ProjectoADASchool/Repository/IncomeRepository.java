package com.projectfinally.ProjectoADASchool.Repository;

import com.projectfinally.ProjectoADASchool.Model.Income;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeRepository extends MongoRepository<Income, String> {
}
