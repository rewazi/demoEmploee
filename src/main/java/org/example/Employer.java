package org.example;

import java.util.Objects;

public class Employer {
    private Person person;
    private String appointment;
    private String salary;




    public Employer(Person person, String appointment, String salary) {
        this.person = person;
        this.appointment = appointment;
        this.salary = salary;



    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Objects.equals(person, employer.person) && Objects.equals(appointment, employer.appointment) && Objects.equals(salary, employer.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, appointment, salary);
    }
}

