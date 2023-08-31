package com.example.springboot_demo.repository;

import com.example.springboot_demo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
    Person findByFirstName(String firstName);
}
