package fr.grabarski.firstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends ActionBarActivity {

    private EditText mEditText;
    private Button mButton;
    private ListView listView;
    private List<Person> personList = new ArrayList<>();
    private PersonListAdapter adapter;
    private Button addItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

//        this.mEditText = (EditText) findViewById(R.id.editTextActivity2);
//        this.mButton = (Button) findViewById(R.id.buttonActivity2);
//
//        this.mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                backToMainActivity();
//            }
//        });

        this.listView = (ListView) findViewById(R.id.listView);
        this.addItemButton = (Button) findViewById(R.id.additemlist);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = personList.get(position);
                String text = person.getFirstName() + " est à la position " + position;
                Toast.makeText(MainActivity2.this, text, Toast.LENGTH_SHORT).show();
            }
        });

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personList.add(new Person("Nom", "Prénom", Color.BLACK));
                adapter.notifyDataSetChanged();
            }
        });

//        List<String> stringList = new ArrayList<>();
//        for (int i=0; i<50; i++) {
//            stringList.add("Mon item " + i);
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                R.layout.list_item, R.id.item_textview, stringList);
//        listView.setAdapter(adapter);

        buildPersonList();

        adapter = new PersonListAdapter(this, personList);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void backToMainActivity() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("myName", mEditText.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void buildPersonList() {
        personList.add(new Person("Apeuprès", "Jean-Michel", Color.GREEN));
        personList.add(new Person("Amoitié", "Jean-Michel", Color.BLACK));
        personList.add(new Person("Aimelesavions", "Jean-Michel", Color.BLUE));
        personList.add(new Person("Nulengéo", "Jean-Michel", Color.RED));
        personList.add(new Person("Avous", "Jean-Michel", Color.YELLOW));
        personList.add(new Person("Voiedechiotte", "Jean-Michel", Color.CYAN));
        personList.add(new Person("Chantepa", "Jean-Michel", Color.BLUE));
        personList.add(new Person("Torché", "Jean-Michel", Color.YELLOW));
        personList.add(new Person("Sature", "Jean-Michel", Color.RED));
    }
}
