package com.example.anda.colocviu.services;

import com.example.anda.colocviu.R;
import com.example.anda.colocviu.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    public List<Person> getAllPeople(){
        List<Person> people = new ArrayList<Person>();

        Person person1 = new Person(0, "Anda", "andamold", 21, R.drawable.p1);
        person1.setFav(false);
        Person person2 = new Person(1, "Daiana", "daiaz", 22, R.drawable.p2);
        person2.setFav(false);
        Person person3 = new Person(2, "Mihai", "mity", 22, R.drawable.p3);
        person3.setFav(false);

        people.add(person1);
        people.add(person2);
        people.add(person3);

        return people;
    }

    public List<Person> getFavoritePeople(){
        List<Person> list = getAllPeople();
        List<Person> result = new ArrayList<>();

        for(Person p : list){
            if(p.isFav()){
                result.add(p);
            }
        }
        return result;
    }

    public Person getDefaultPerson(int position){
        Person person = new Person(position, "Default", "default", 20, R.drawable.star);
        person.setFav(false);
        return person;
    }
}
