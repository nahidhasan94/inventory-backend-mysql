package com.inventory.repository;

import com.inventory.model.Product;
//import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface ProductRepository extends MongoRepository<Product, String>
public interface ProductRepository extends JpaRepository<Product, String>
{

public Product findByIdAndStatus(long id, String status);
List <Product> findAllByStatus(String status);
List <Product> findAllByCategoryAndStatus(String category, String status);
public Product findByNameAndStatus(String name, String status);
List <Product> findAllByNameAndStatus (String search, String status);


}
