package com.example.anda.colocviu;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.anda.colocviu.adapter.PersonListAdapter;
import com.example.anda.colocviu.model.Person;
import com.example.anda.colocviu.services.PersonService;
import com.example.anda.colocviu.services.Singleton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    PersonService personService;
    PersonListAdapter personListAdapter;
    ListView listViewReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        personService = new PersonService();
        personListAdapter = new PersonListAdapter(this, personService.getAllPeople());

        listViewReference = (ListView)findViewById(R.id.listViewId);
        listViewReference.setAdapter(personListAdapter);

        listViewReference.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        registerForContextMenu(listViewReference);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId() == R.id.listViewId){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle("Select");
            getMenuInflater().inflate(R.menu.contextual, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if(item.getItemId() == R.id.add_person){
            personListAdapter.personList.add(info.position, personService.getDefaultPerson(info.position));
            personListAdapter.notifyDataSetChanged();
        }else if(item.getItemId() == R.id.delete_person){
            personListAdapter.personList.remove(info.position);
            personListAdapter.notifyDataSetChanged();
        }else if(item.getItemId() == R.id.set_favorite){
            personListAdapter.personList.get(info.position).setFav(true);
            personListAdapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();

        if(id == R.id.singout){
            singOutUser();
            return true;
        }else if(id == R.id.reset_list){
            personListAdapter.personList.removeAll(personListAdapter.personList);
            personListAdapter.personList.addAll(personService.getAllPeople());
            personListAdapter.notifyDataSetChanged();
        }else if(id == R.id.goto_favotites){
            List<Person> list = new ArrayList<>();
            for(Person p: personListAdapter.personList){
                if(p.isFav() == true) list.add(p);
            }
            Singleton sing = Singleton.getInstance();
            sing.setPersonList(list);
            Intent intent = new Intent(ListActivity.this, FavoritesListActivity.class);
            ListActivity.this.startActivity(intent);
        }

        return true;
    }

    private void singOutUser() {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        ListActivity.this.startActivity(intent);
    }

}
