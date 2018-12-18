package com.example.anda.colocviu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.anda.colocviu.adapter.FavoritesAdapter;
import com.example.anda.colocviu.model.Person;
import com.example.anda.colocviu.services.PersonService;
import com.example.anda.colocviu.services.Singleton;

import java.util.ArrayList;
import java.util.List;

public class FavoritesListActivity extends AppCompatActivity {

    PersonService personService;
    FavoritesAdapter adapter;
    ListView listReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_people_list);

        Intent intent = getIntent();

        personService = new PersonService();

        Singleton sing = Singleton.getInstance();
        List<Person> list = sing.getPersonList();

        adapter = new FavoritesAdapter(this, (List<Person>) list);
        //adapter = new FavoritesAdapter(this, personService.getFavoritePeople());

        listReference = (ListView) findViewById(R.id.favoritesList);
        listReference.setAdapter(adapter);

        registerForContextMenu(listReference);


    }
}
