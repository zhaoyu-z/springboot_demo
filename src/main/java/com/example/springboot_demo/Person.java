package com.example.springboot_demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Integer age;

    public Person() {};

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        String nameString = "The person is named " + getFirstName() + " " + getLastName();
        String ageString = age != null ? " and the age is " + getAge() : "";

        return nameString + ageString;
    }
}
