package com.topdeckstudios.magicstats;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ArrayList<Deck> deckArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();


        String filename = "decks";
        File deckFile = new File(context.getFilesDir(), filename);
        if(!deckFile.exists()){
            try{
                deckFile.createNewFile();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            InputStream file = new FileInputStream(deckFile.getPath());
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            deckArray = (ArrayList<Deck>) input.readObject();
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Button makeDeckButton = (Button) findViewById(R.id.create_deck);
        makeDeckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDeckCreation();
            }
        });

        Button viewDecksButton = (Button) findViewById(R.id.view_decks);
        viewDecksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToViewDecks();
            }
        });


    }

    public void goToDeckCreation(){
        Intent intent = new Intent(this, DeckCreationActivity.class);
        intent.putExtra("decks", deckArray);
        startActivity(intent);
    }
    public void goToViewDecks(){
        Intent intent = new Intent(this, ViewDecksActivity.class);
        intent.putExtra("decks", deckArray);
        startActivity(intent);
    }

}
