package com.inventory.repository;

import com.inventory.model.Category;
//import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface CategoryRepository extends MongoRepository<Category, String>
public interface CategoryRepository extends JpaRepository<Category, String>
{
public Category findByNameAndStatus(String name, String status);
List<Category> findAllByStatus(String status);
public Category findByIdAndStatus(long id, String status);

}
