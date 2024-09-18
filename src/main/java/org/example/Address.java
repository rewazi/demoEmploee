package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Objects;

public class Address {
    private String house;
    private String room;
    private String street;
    private String city;
    private String state;
    private String zip;

    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public Address() {
    }

    public Address(String house, String room, String street, String city, String state, String zip) {
        this.house = house;
        this.room = room;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(house, address.house) && Objects.equals(room, address.room) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zip, address.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(house, room, street, city, state, zip);
    }
    public int getAge() {
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

}