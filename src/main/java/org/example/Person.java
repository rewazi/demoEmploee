package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    private Addres addres;

    public Person() {

    }

    public Person(String name, String surname, int birthYear, int birthMonth, int birthDay, Addres addres) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Addres getAddres() {
        return addres;
    }

    public void setAddres(Addres addres) {
        this.addres = addres;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(surname, person.surname) && birthYear == person.birthYear && birthMonth == person.birthMonth && birthDay == person.birthDay && Objects.equals(name, person.name) && Objects.equals(addres, person.addres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthYear, birthMonth, birthDay, addres);
    }
    public int getAge(){
        LocalDate birthdate = LocalDate.of(birthYear, birthMonth, birthDay);
        Period age = Period.between(birthdate, LocalDate.now());
        return age.getYears();
    }
}
