package com.inventory.repository;

import com.inventory.enums.Authority;
import com.inventory.model.User;
//import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface UserRepository extends MongoRepository<User,String> {
public interface UserRepository extends JpaRepository<User,String> {
    public User findByUsernameAndStatus(String username, String status);
    List<User> findAllByStatus(String status);
    public User findByIdAndStatus(long id, String status);
    public User findByAuthorityAndStatus(Authority authority, String status);


}
