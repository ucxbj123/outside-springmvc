package com.qcby.DAO;

public class t1 {
    int age;
    double heigh;

    public t1() {
    }

    public t1(int age, double heigh) {
        this.age = age;
        this.heigh = heigh;
    }

    @Override
    public String toString() {
        return "t1{" +
                "age=" + age +
                ", heigh=" + heigh +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeigh() {
        return heigh;
    }

    public void setHeigh(double heigh) {
        this.heigh = heigh;
    }
}
