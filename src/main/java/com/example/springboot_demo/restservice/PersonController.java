package com.example.springboot_demo.restservice;

import com.example.springboot_demo.model.Person;
import com.example.springboot_demo.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        String firstName = person.getFirstName();
        if (personRepository.findByFirstName(firstName) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        personRepository.save(person);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @GetMapping
    public ResponseEntity<Person> getPersonByFirstName(@RequestParam String firstName) {
        Person person = personRepository.findByFirstName(firstName);
        if (person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(person);
        }
    }
}
