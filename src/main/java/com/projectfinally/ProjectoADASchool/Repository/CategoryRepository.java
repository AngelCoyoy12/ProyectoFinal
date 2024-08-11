package com.projectfinally.ProjectoADASchool.Repository;

import com.projectfinally.ProjectoADASchool.Model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
