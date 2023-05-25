package com.lazyevaluation;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(this.name);
    }
}
