package com.topdeckstudios.magicstats;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class ViewDecksActivity extends AppCompatActivity {

    ArrayList<Deck> deckArray;
    ArrayList<String> deckNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_decks);

        if(getIntent().hasExtra("decks")){
            deckArray = (ArrayList<Deck>)getIntent().getSerializableExtra("decks");
            for(int i = 0; i < deckArray.size(); i++) {
                deckNames.add(deckArray.get(i).getName());
            }

            ListView lv = (ListView) findViewById(R.id.decks);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, deckNames);
            lv.setAdapter(arrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?>adapter,View v, int position, long id){
                    getDeckDetails(position);
                }

            });
        }
    }
    
    public void getDeckDetails(int position){
        Intent intent = new Intent(this,DeckDetailActivity.class);
        Deck deck = deckArray.get(position);
        intent.putExtra("deck", deck);
        startActivity(intent);
    }
}
