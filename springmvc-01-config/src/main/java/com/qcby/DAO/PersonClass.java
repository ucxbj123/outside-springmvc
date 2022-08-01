package com.qcby.DAO;

import java.util.List;

public class PersonClass {
    List<Person> people;

    public PersonClass(List<Person> people) {
        this.people = people;
    }

    public PersonClass() {
    }

    @Override
    public String toString() {
        return "PersonClass{" +
                "people=" + people +
                '}';
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
