package com.example.tulupcoffee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class CompleteCoffee extends AppCompatActivity {

    GifImageView gifImageView;
    TextView method_name;
    ImageView method_photo,back;
    String flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_coffee);
        initialise();
        if(flag.equals("1")){
            method_photo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.aeropress));
            method_name.setText("AeroPress");
        }else if(flag.equals("2")){
            method_photo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.frenchpress));
            method_name.setText("FrenchPress");
        }else if(flag.equals("3")){
            method_photo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.v60));
            method_name.setText("v60 PourOver");
        }else if(flag.equals("4")){
            method_photo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.mokapot));
            method_name.setText("Moka Pot");
        }
       // gifImageView.setVisibility(View.VISIBLE);
        GifDrawable gifDrawable = null;
        try {
            gifDrawable = new GifDrawable(getResources(), R.drawable.correct1);
            gifDrawable.setLoopCount(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        gifImageView.setImageDrawable(gifDrawable);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompleteCoffee.this,Ingrediant_Selection.class);
                intent.putExtra("Flag",flag);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initialise() {
        ActionBar actioBar = getSupportActionBar();
        actioBar.hide();
        Intent intent = getIntent();
        flag = intent.getStringExtra("Flag");
        gifImageView = findViewById(R.id.completed);
        method_name = findViewById(R.id.method_name);
        method_photo = findViewById(R.id.method_photo);
        back = findViewById(R.id.back);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CompleteCoffee.this,Ingrediant_Selection.class);
        intent.putExtra("Flag",flag);
        startActivity(intent);
        finish();
    }
}