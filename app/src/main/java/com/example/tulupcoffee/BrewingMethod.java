package com.example.tulupcoffee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.text.BreakIterator;

public class BrewingMethod extends AppCompatActivity {

    LinearLayout aeropress,french,v60,moka_pota;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brewing_method);
        initialise();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        aeropress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrewingMethod.this,AeroPress.class));
                finish();
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrewingMethod.this,FrenchPress.class));
                finish();
            }
        });
        v60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrewingMethod.this,PourOver.class));
                finish();
            }
        });
        moka_pota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrewingMethod.this,MokaPota.class));
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrewingMethod.this,Menu.class));
                finish();
            }
        });
    }
    private void initialise() {
        aeropress = findViewById(R.id.aerospace);
        french = findViewById(R.id.french_press);
        v60 = findViewById(R.id.pourover);
        moka_pota = findViewById(R.id.moka_pot);
        back = findViewById(R.id.back);
    }
}