package com.example.demojava.model;

public class Member {

    private int age;
    private String name;
    private boolean available = false;


    public Member(int age, String name, boolean available){
        this.age = age;
        this.name = name;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
