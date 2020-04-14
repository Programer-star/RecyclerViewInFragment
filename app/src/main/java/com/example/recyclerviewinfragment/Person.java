package com.example.recyclerviewinfragment;

public class Person {
    String name;
    String telnumber;

    public Person(String name, String telnumber) {
        this.name = name;
        this.telnumber = telnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }
}
