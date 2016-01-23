package com.topdeckstudios.magicstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.create_deck);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDeckCreation();
            }
        });


    }

    public void goToDeckCreation(){
        Intent intent = new Intent(this, DeckCreationActivity.class);
        startActivity(intent);
    }

}
