package com.example.recyclerviewinfragment;

import android.app.Application;

import java.util.ArrayList;

public class myApplication extends Application {
    static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<>();
        people.add(new Person("rana waqas", "03344398837"));
    }

}
