package org.example;

import java.util.Objects;

public class Addres {
    private String house;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Addres() {
    }

    public Addres(String house, String street, String city, String state, String zip) {
        this.house = house;
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
        Addres addres = (Addres) o;
        return Objects.equals(house, addres.house) && Objects.equals(street, addres.street) && Objects.equals(city, addres.city) && Objects.equals(state, addres.state) && Objects.equals(zip, addres.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(house, street, city, state, zip);
    }

}
