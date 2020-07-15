package com.example.tulupcoffee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tulupcoffee.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        CardView bt=(CardView) findViewById(R.id.bt);
        CardView ct=(CardView) findViewById(R.id.ct);
        CardView bg=(CardView) findViewById(R.id.bg);
        CardView cd=(CardView) findViewById(R.id.cd);
        CardView cc=(CardView) findViewById(R.id.cc);
        CardView cr=(CardView) findViewById(R.id.cr);
        CardView rc=(CardView) findViewById(R.id.rc);
        Button logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Menu.this, LoginActivity.class));
                finish();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,BrewingMethod.class));
                finish();
            }
        });
    }
}