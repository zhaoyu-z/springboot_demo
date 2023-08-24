package com.example.springboot_demo;

public class Person {
    public String name;

    public Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        String nameString = "The person is named " + getName();
        String ageString = age != null ? " and the age is " + getAge() : "";

        return nameString + ageString;
    }
}
