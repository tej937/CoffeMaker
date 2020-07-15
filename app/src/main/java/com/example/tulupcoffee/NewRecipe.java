package com.example.tulupcoffee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class NewRecipe extends AppCompatActivity {
    ProgressBar progressBar;
    TextView s1,s2,s3,s4,s5,s6,s7,s8,s9;
    ImageView start;
    MyCountDownTimer myCountDownTimer;
    //int total_seconds = 5000;
    long timeLeft;
    long flag = 0;
    int px = 160;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initialise();
        Intent intent =getIntent();
        String dose = intent.getStringExtra("dose");
        String water_amt = intent.getStringExtra("water_amt");
        water_amt = water_amt.substring(0,3);
        double initial = Double.parseDouble(water_amt)/8;
        double step5_water = Double.parseDouble(water_amt) - initial;
        s1.setText("Add "+dose+" of coffee into the chamber");
        s2.setText("Pour "+initial+"ml of water into the chamber");
        s5.setText("Pour "+step5_water+"ml of water");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer = new MyCountDownTimer(118000, 1000);
                myCountDownTimer.start();
               // Toast.makeText(NewRecipe.this, "Flag "+flag, Toast.LENGTH_SHORT).show();
            }
        });
      }

    private void initialise() {
        s1 = findViewById(R.id.step1);
        s2 = findViewById(R.id.step2);
        s3 = findViewById(R.id.step3);
        s4 = findViewById(R.id.step4);
        s5 = findViewById(R.id.step5);
        s6 = findViewById(R.id.step6);
        s7 = findViewById(R.id.step7);
        s8 = findViewById(R.id.step8);
        s9 = findViewById(R.id.step9);
        progressBar = findViewById(R.id.barTimer);
        start = findViewById(R.id.play);
        progressBar.setProgress(0);
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            flag = millisUntilFinished;
            timeLeft++;
//            ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", (int) timeLeft);
//            progressAnimator.setInterpolator(new DecelerateInterpolator());
//            progressAnimator.start();
            progressBar.setInterpolator(new DecelerateInterpolator());
            progressBar.setProgress((int) timeLeft);
            Toast.makeText(NewRecipe.this, "Seconds "+ timeLeft, Toast.LENGTH_SHORT).show();
            if(timeLeft == 5){
                s1.setAlpha((float) 0.3);
                s1.setTextSize(20);
                s1.setTextColor(getResources().getColor(R.color.GrayColor));
                s2.setAlpha(1);
                s2.setTextSize(30);
                s2.setTextColor(getResources().getColor(R.color.GreenColor));
                s3.setAlpha((float) 0.3);
            }
            else if(timeLeft == 10){
                s1.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s2.setLayoutParams(params);
                s2.setAlpha((float) 0.3);
                s2.setTextSize(20);
                s2.setTextColor(getResources().getColor(R.color.GrayColor));
                s3.setAlpha(1);
                s3.setTextSize(30);
                s3.setTextColor(getResources().getColor(R.color.GreenColor));
                s4.setAlpha((float) 0.3);
                s4.setTextColor(getResources().getColor(R.color.GrayColor));
            }
            else if(timeLeft == 15){
                s2.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s3.setLayoutParams(params);
                s3.setAlpha((float) 0.3);
                s3.setTextSize(20);
                s3.setTextColor(getResources().getColor(R.color.GrayColor));
                s4.setAlpha(1);
                s4.setTextSize(30);
                s4.setTextColor(getResources().getColor(R.color.GreenColor));
                s5.setAlpha((float) 0.3);
                s5.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds  = 20000;
               // time = 1000*1000/total_seconds;
            }
            else if(timeLeft == 35){
                s3.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s4.setLayoutParams(params);
                s4.setAlpha((float) 0.3);
                s4.setTextSize(20);
                s4.setTextColor(getResources().getColor(R.color.GrayColor));
                s5.setAlpha(1);
                s5.setTextSize(30);
                s5.setTextColor(getResources().getColor(R.color.GreenColor));
                s6.setAlpha((float) 0.3);
                s6.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 7000;
                //time = 1000*1000/total_seconds;
            }
            else if(timeLeft == 42){
                s4.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s5.setLayoutParams(params);
                s5.setAlpha((float) 0.3);
                s5.setTextSize(20);
                s5.setTextColor(getResources().getColor(R.color.GrayColor));
                s6.setAlpha(1);
                s6.setTextSize(30);
                s6.setTextColor(getResources().getColor(R.color.GreenColor));
                s7.setAlpha((float) 0.3);
                s7.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 4000;
               // time = 1000*1000/total_seconds;
            }
            else if(timeLeft == 46){
                s5.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(40, px, 40, 0);
                s6.setLayoutParams(params);
                s6.setAlpha((float) 0.3);
                s6.setTextSize(20);
                s6.setTextColor(getResources().getColor(R.color.GrayColor));
                s7.setAlpha(1);
                s7.setTextSize(30);
                s7.setTextColor(getResources().getColor(R.color.GreenColor));
                s8.setAlpha((float) 0.3);
                s8.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 60000;
                //time = 1000*1000/total_seconds;
            }
            else if(timeLeft == 106){
                s6.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s7.setLayoutParams(params);
                s7.setAlpha((float) 0.3);
                s7.setTextSize(20);
                s7.setTextColor(getResources().getColor(R.color.GrayColor));
                s8.setAlpha(1);
                s8.setTextSize(30);
                s8.setTextColor(getResources().getColor(R.color.GreenColor));
                s9.setAlpha((float) 0.3);
                s9.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 12000;
                //time = 1000*1000/total_seconds;
            }
            else if(timeLeft == 118){
                s7.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s8.setLayoutParams(params);
                s8.setAlpha((float) 0.3);
                s8.setTextSize(20);
                s8.setTextColor(getResources().getColor(R.color.GrayColor));
                s9.setAlpha(1);
                s9.setTextSize(30);
                s9.setTextColor(getResources().getColor(R.color.GreenColor));
                startActivity(new Intent(NewRecipe.this,CompleteCoffee.class));
                finish();
            }
        }
        @Override
        public void onFinish() {
            progressBar.setProgress(118);
            //timeLeft = 1;
            //time = 0;
            // Toast.makeText(NewRecipe.this, "Flag "+flag, Toast.LENGTH_SHORT).show();
        }
    }
}