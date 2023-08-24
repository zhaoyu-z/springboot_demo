package com.example.springboot_demo.restservice;

import com.example.springboot_demo.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    private Map<String, Person> personMap = new HashMap<>();

    @PostMapping("/create")
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        if (personMap.containsKey(person.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Person with Name " + person.getName() + " Already Exists");
        }
        personMap.put(person.getName(), person);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                "Person Created Successfully, with name " + person.getName() +
                (person.getAge() != null ? " and age " + person.getAge() : "")
        );
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<String> getPersonByName(@PathVariable String name) {
        if (personMap.containsKey(name)) {
            Person person = personMap.get(name);
            return ResponseEntity.ok(person.toString());
        } else {
            return new ResponseEntity<>("Person with Name " + name + " Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<String>> getAllPerson() {
        List<String> allPerson = new ArrayList<>();
        for (Person p : personMap.values()) {
            allPerson.add(p.toString());
        }
        return ResponseEntity.ok(allPerson);
    }
}
