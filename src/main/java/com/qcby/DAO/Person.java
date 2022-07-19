package com.qcby.DAO;

public class Person {
    int id;
    String name;
    t1 t;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", t=" + t +
                '}';
    }

    public Person(int id, String name, t1 t) {
        this.id = id;
        this.name = name;
        this.t = t;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public t1 getT() {
        return t;
    }

    public void setT(t1 t) {
        this.t = t;
    }
}
