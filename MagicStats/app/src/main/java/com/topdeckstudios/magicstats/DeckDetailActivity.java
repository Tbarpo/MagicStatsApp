package com.topdeckstudios.magicstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DeckDetailActivity extends AppCompatActivity {

    Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_detail);

        if(getIntent().hasExtra("deck")) {
            deck = (Deck) (getIntent().getExtras().get("deck"));
            TextView deckName = (TextView) findViewById(R.id.deck_name);
            TextView format = (TextView) findViewById(R.id.format);
            TextView owned = (TextView) findViewById(R.id.owned);

            deckName.setText(deck.getName());
            format.setText(deck.getFormat());
            owned.setText("Owned?: " + (deck.getOwned() ? "yes" : "no"));
        }
    }
}
