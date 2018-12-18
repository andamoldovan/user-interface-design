package com.example.anda.colocviu.services;

import com.example.anda.colocviu.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static final Singleton ourInstance = new Singleton();

    private List<Person> personList;

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        personList = new ArrayList<>();
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
