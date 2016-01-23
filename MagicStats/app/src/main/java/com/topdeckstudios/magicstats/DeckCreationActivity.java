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

public class DeckCreationActivity extends AppCompatActivity {

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
    }

    public void saveDeck(){
        EditText tempEdit = (EditText)findViewById(R.id.deck_name);
        Spinner spinner = (Spinner) findViewById(R.id.format);
        CheckBox owned = (CheckBox) findViewById(R.id.owned);
        boolean checked = owned.isChecked();
        String deckName = tempEdit.getText().toString();
        String format = spinner.getSelectedItem().toString();
        Deck added = new Deck(deckName, format, checked);
        Context context = getApplicationContext();
        String text = "Deck Added";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void bootToMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
