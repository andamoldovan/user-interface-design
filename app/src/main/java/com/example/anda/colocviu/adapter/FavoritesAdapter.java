package com.example.anda.colocviu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anda.colocviu.R;
import com.example.anda.colocviu.model.Person;

import java.util.List;


public class FavoritesAdapter extends ArrayAdapter<Person> {

    public List<Person> personList;

    public FavoritesAdapter(Context context, List<Person> objects) {
        super(context, 0, objects);
        this.personList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View myRow = (convertView == null) ? LayoutInflater.from(getContext()).inflate(R.layout.favorite_person_layout, parent, false) : convertView;

        Person person = getItem(position);

        TextView name = myRow.findViewById(R.id.FavPersonName);
        TextView email = myRow.findViewById(R.id.FavPersonEmail);
        TextView age = myRow.findViewById(R.id.FavPersonAge);
        ImageView img = myRow.findViewById(R.id.personImageView);

        name.setText(person.getName());
        email.setText(person.getEmail());
        age.setText(Integer.toString(person.getAge()));
        img.setImageResource(person.getImage());

        return myRow;
    }
}
