package com.example.tulupcoffee;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.shawnlin.numberpicker.NumberPicker;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class AeroPress extends AppCompatActivity {

    Button dose,ratio,water_amt;
    RelativeLayout start_recipe;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aero_press);
        initialise();
        //calculate();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        dose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker;
                TextView unit;
                Button submit;
                myDialog.setContentView(R.layout.ingredient_picker);
                myDialog.getWindow().setGravity(Gravity.BOTTOM);
                numberPicker = myDialog.findViewById(R.id.number_unit);
                unit = myDialog.findViewById(R.id.unit);
                submit = myDialog.findViewById(R.id.submit);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
                final String[] numbers = {"05","10","15","20","25","30","35","40","45","50"};
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue(numbers.length-1);
                numberPicker.setDisplayedValues(numbers);
                numberPicker.setValue(15);
                unit.setText("gms");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dose.setText((numbers[numberPicker.getValue()]+" gms"));
                        calculate();
                        myDialog.dismiss();
                    }
                });
            }
        });
        ratio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker;
                Button submit;
                myDialog.setContentView(R.layout.ingredient_picker);
                myDialog.getWindow().setGravity(Gravity.BOTTOM);
                numberPicker = myDialog.findViewById(R.id.number_unit);
                submit = myDialog.findViewById(R.id.submit);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
                final String[] numbers = {"1:1","1:2","1:3","1:4","1:5","1:6","1:7","1:8","1:9","1:10",
                        "1:11","1:12","1:13","1:14","1:15","1:16","1:17","1:18","1:19","1:20"};
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue(numbers.length-1);
                numberPicker.setDisplayedValues(numbers);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ratio.setText((numbers[numberPicker.getValue()]+""));
                        int rat = Integer.parseInt(ratio.getText().toString().substring(2));
                        int dos = Integer.parseInt(dose.getText().toString().substring(0,2));
                        int new_wat = rat*dos;
                        water_amt.setText(new_wat+"ml");
                        myDialog.dismiss();
                    }
                });
            }
        });
        water_amt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker numberPicker;
                TextView unit;
                Button submit;
                myDialog.getWindow().setGravity(Gravity.BOTTOM);
                myDialog.setContentView(R.layout.ingredient_picker);
                numberPicker = myDialog.findViewById(R.id.number_unit);
                unit = myDialog.findViewById(R.id.unit);
                submit = myDialog.findViewById(R.id.submit);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
                final String[] numbers = {"030","040","050","060","070","080","090","100","110","120","130",
                                    "140","150","160","170","180","190","200","210","220","230",
                                    "240","250"};
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue(numbers.length-1);
                numberPicker.setDisplayedValues(numbers);
                numberPicker.setValue(200);
                unit.setText("ml");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        water_amt.setText((numbers[numberPicker.getValue()]+"ml"));
                        calculate();
                        myDialog.dismiss();
                    }
                });
            }
        });
        start_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AeroPress.this,NewRecipe.class);
                intent.putExtra("dose",dose.getText());
                intent.putExtra("water_amt",water_amt.getText());
                startActivity(intent);
                finish();
            }
        });
    }

    private void calculate() {
        float dos = Integer.parseInt(dose.getText().toString().substring(0,2));
        float wat = Integer.parseInt(water_amt.getText().toString().substring(0,3));
        float fraction_answer = dos/wat;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        int[] result = convertToFraction(""+fraction_answer);
        result[0] = 1;
        if(result[1]>20){
            Random random = new Random();
            result[1] = random.nextInt(10 - 1) +1;
        }
        ratio.setText(result[0]+":"+result[1]);
    }

    int[] convertToFraction(String numberStr) {
        String[] parts;
        try {
            BigDecimal number = new BigDecimal(numberStr);
            parts = number.toString().split("\\.");
            if (parts.length < 2)
                Log.d("Error","Error: Please ensure that"+" the entered value has a decimal.");
        } catch (NumberFormatException e) {
            Log.d("Error","Number Format Exception");
        } catch (ArrayIndexOutOfBoundsException ae){
            Log.d("Error","ArrayIndexOutOfBoundsException");
        }
        BigDecimal number = new BigDecimal(numberStr);
        parts = number.toString().split("\\.");
        BigDecimal den = BigDecimal.TEN.pow(parts[1].length());
        BigDecimal num = (new BigDecimal(parts[0]).multiply(den)).add(new BigDecimal(parts[1]));
        return reduceFraction(num.intValue(), den.intValue());
    }
    static int[] reduceFraction(int num, int den) {
        int gcd = BigInteger.valueOf(num).gcd(BigInteger.valueOf(den)).intValue();
        int[] fractionElements = { num / gcd, den / gcd };
        return fractionElements;
    }
    private void initialise() {
        dose = findViewById(R.id.coffee_dose);
        ratio = findViewById(R.id.ratio);
        water_amt = findViewById(R.id.water_amt);
        start_recipe = findViewById(R.id.start);
        myDialog = new Dialog(this);

    }
}