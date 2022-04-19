package com.pmart5a.myclass;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = null;
        if (validatePerson()) {
            person = new Person(this);
        }
        return person;
    }

    private boolean validatePerson() throws IllegalStateException, IllegalArgumentException {
        boolean validPerson;
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Неуказано обязательное поле 'Имя' или оно пусто.");
        }
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalStateException("Неуказано обязательное поле 'Фамилия' или оно пусто.");
        }
        if (age < -1) {
            throw new IllegalArgumentException("Указанное значение поля 'Возраст' некорректно.");
        } else {
            validPerson = true;
        }
        return validPerson;
    }
}