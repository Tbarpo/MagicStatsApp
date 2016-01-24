package com.topdeckstudios.magicstats;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class DeckCreationActivity extends AppCompatActivity {

    ArrayList<Deck> deckArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_creation);
        Spinner spinner = (Spinner) findViewById(R.id.format);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.format, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Button btn = (Button) findViewById(R.id.save_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDeck();
            }
        });
        Button btn2 = (Button) findViewById(R.id.cancel);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bootToMenu();
            }
        });
        if(getIntent().hasExtra("decks")){
            deckArray = (ArrayList<Deck>)getIntent().getSerializableExtra("decks");
        }
        if(deckArray == null){
            deckArray = new ArrayList<Deck>();
        }

    }

    public void saveDeck(){
        EditText tempEdit = (EditText)findViewById(R.id.deck_name);
        Spinner spinner = (Spinner) findViewById(R.id.format);
        CheckBox owned = (CheckBox) findViewById(R.id.owned);
        Context context = getApplicationContext();
        boolean checked = owned.isChecked();
        String deckName = tempEdit.getText().toString();
        String format = spinner.getSelectedItem().toString();
        Deck added = new Deck(deckName, format, checked);
        boolean alreadyExists = false;
        for(int i = 0; i < deckArray.size(); i++){
            Deck temp = deckArray.get(i);
            if(temp.equals(added)){
                alreadyExists = true;
            }
        }
            if(!alreadyExists) {
            deckArray.add(added);
            /*String debug = "";
            for(int i = 0; i < deckArray.size(); i++) {
                debug += deckArray.get(i).name + "\n";
            }
            Toast.makeText(context, debug, Toast.LENGTH_LONG).show();*/
            File deckFile = new File(context.getFilesDir(), "decks");
            try {
                OutputStream file = new FileOutputStream(deckFile.getPath());
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);

                output.writeObject(deckArray);
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            String text = "Deck Added";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(context, "DeckAlreadyExists", Toast.LENGTH_SHORT).show();
        }
    }

    public void bootToMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
