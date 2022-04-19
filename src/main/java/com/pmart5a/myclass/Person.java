package com.pmart5a.myclass;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address = "";

    public Person(PersonBuilder personBuilder) throws IllegalStateException {
        if (personBuilder == null) {
            throw new IllegalStateException("Объект класса PersonBuilder не существует. Предоставьте валидный" +
                    " объект класса PersonBuilder.");
        }
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public Person(String name, String surname) throws IllegalStateException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Неуказано обязательное поле 'Имя' или оно пусто.");
        }
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalStateException("Неуказано обязательное поле 'Фамилия' или оно пусто.");
        }
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) throws IllegalStateException, IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Неуказано обязательное поле 'Имя' или оно пусто.");
        }
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalStateException("Неуказано обязательное поле 'Фамилия' или оно пусто.");
        }
        if (age < -1) {
            throw new IllegalArgumentException("Указанное значение поля 'Возраст' некорректно.");
        }
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public boolean hasAddress() {
        return address != null && !address.trim().isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age > -1) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "Имя = '" + name + '\'' +
                ", Фамилия = '" + surname + '\'' +
                ", возраст = " + age +
                ", адрес = '" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}