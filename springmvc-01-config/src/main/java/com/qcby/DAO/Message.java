package com.qcby.DAO;

public class Message {
    private int id;
    private String name;
    private String datetime;

    public Message() {
    }

    public Message(int id, String name, String datetime) {
        this.id = id;
        this.name = name;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
