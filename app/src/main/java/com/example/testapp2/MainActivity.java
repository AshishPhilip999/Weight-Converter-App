package com.example.testapp2;
import java.util.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Output;
import android.media.Image;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView Input;
    TextView Ouput;

    ImageView PoundLogoLHS;
    ImageView TonLogoLHS;
    ImageView KGLogoLHS;
    ImageView GramLogoLHS;
    ImageView MilliGramLogoLHS;


    ImageView PoundLogoRHS;
    ImageView TonLogoRHS;
    ImageView KGLogoRHS;
    ImageView GramLogoRHS;
    ImageView MilliGramRHS;


    Spinner spinner1;
    Spinner spinner2;
    String UnitsLH[]  = { "Kilograms" , "Pounds" , "Tons" , "Milligrams" , "Grams" };
    List<String> UnitsLHS = new ArrayList<>();

    String[] ExpUnitRHS = {"Kilograms" , "Milligrams"  ,"Grams"};

    TextView UnitLHS;
    TextView UnitRHS;

    int LHS ;
    int RHS ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Input = findViewById(R.id.editTextNumberDecimal);
        Ouput = findViewById(R.id.editTextNumberDecimal2);

        //Spinner Items
        UnitsLHS.add("Kilograms"); UnitsLHS.add("Pounds"); UnitsLHS.add("Tons"); UnitsLHS.add("Milligrams"); UnitsLHS.add("Grams");

        //Unit
        UnitLHS = findViewById(R.id.textView);
        UnitRHS = findViewById(R.id.textView2);

        //Invisibility LHS
        KGLogoLHS = findViewById(R.id.imageView4);
        PoundLogoLHS = findViewById(R.id.imageView8);
        TonLogoLHS = findViewById(R.id.imageView7);
        GramLogoLHS = findViewById(R.id.imageView2);
        MilliGramLogoLHS = findViewById(R.id.imageView12);

        KGLogoLHS.setVisibility(View.VISIBLE);
        PoundLogoLHS.setVisibility(View.INVISIBLE);
        TonLogoLHS.setVisibility(View.INVISIBLE);
        GramLogoLHS.setVisibility(View.INVISIBLE);
        MilliGramLogoLHS.setVisibility(View.INVISIBLE);

        // Invisibility RHS
        PoundLogoRHS = findViewById(R.id.imageView6);
        TonLogoRHS = findViewById(R.id.imageView3);
        KGLogoRHS = findViewById(R.id.imageView5);
        GramLogoRHS = findViewById(R.id.imageView10);
        MilliGramRHS = findViewById(R.id.imageView13);

        TonLogoRHS.setVisibility(View.INVISIBLE);
        KGLogoRHS.setVisibility(View.INVISIBLE);
        PoundLogoRHS.setVisibility(View.VISIBLE);
        GramLogoRHS.setVisibility(View.INVISIBLE);
        MilliGramRHS.setVisibility(View.INVISIBLE);

        // Spinner setup
        spinner1 = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item , UnitsLHS );
        adapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner2.setAdapter(adapter1);
        spinner2.setSelection(1);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();

        String ID = adapterView.getResources().getResourceName(adapterView.getId());



        //spinner 1  [LHS]
        if(ID.equals("com.example.testapp2:id/spinner"))
        {

                ArrayAdapter<String> Radapter = new ArrayAdapter<String>(MainActivity.this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item , UnitsLHS );
                Radapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                spinner2.setAdapter(Radapter);
                spinner2.setSelection(1);

            if(text.equals("Kilograms"))
            {
                UnitLHS.setText("KG");
                KGLogoLHS.setVisibility(View.VISIBLE);
                PoundLogoLHS.setVisibility(View.INVISIBLE);
                TonLogoLHS.setVisibility(View.INVISIBLE);
                GramLogoLHS.setVisibility(View.INVISIBLE);
                MilliGramLogoLHS.setVisibility(View.INVISIBLE);
                LHS = 1;
            }else if(text.equals("Pounds"))
            {
                UnitLHS.setText("lbs");
                KGLogoLHS.setVisibility(View.INVISIBLE);
                PoundLogoLHS.setVisibility(View.VISIBLE);
                TonLogoLHS.setVisibility(View.INVISIBLE);
                GramLogoLHS.setVisibility(View.INVISIBLE);
                MilliGramLogoLHS.setVisibility(View.INVISIBLE);
                LHS = 2;
            }else if(text.equals("Tons"))
            {
                UnitLHS.setText("t");
                KGLogoLHS.setVisibility(View.INVISIBLE);
                PoundLogoLHS.setVisibility(View.INVISIBLE);
                TonLogoLHS.setVisibility(View.VISIBLE);
                GramLogoLHS.setVisibility(View.INVISIBLE);
                MilliGramLogoLHS.setVisibility(View.INVISIBLE);
                LHS = 3;
            }else if(text.equals("Milligrams"))
            {
                UnitLHS.setText("mg");
                KGLogoLHS.setVisibility(View.INVISIBLE);
                PoundLogoLHS.setVisibility(View.INVISIBLE);
                TonLogoLHS.setVisibility(View.INVISIBLE);
                GramLogoLHS.setVisibility(View.INVISIBLE);
                MilliGramLogoLHS.setVisibility(View.VISIBLE);
                LHS = 4;

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item , ExpUnitRHS );
                adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter);
            }else if(text.equals("Grams"))
            {
                UnitLHS.setText("g");
                KGLogoLHS.setVisibility(View.INVISIBLE);
                PoundLogoLHS.setVisibility(View.INVISIBLE);
                TonLogoLHS.setVisibility(View.INVISIBLE);
                GramLogoLHS.setVisibility(View.VISIBLE);
                MilliGramLogoLHS.setVisibility(View.INVISIBLE);
                LHS = 5;
            }
        }


        // spinner 2 [RHS]
        if(ID.equals("com.example.testapp2:id/spinner2"))
        {
            Ouput.setText("");
            if(text.equals("Kilograms"))
            {
                UnitRHS.setText("KG");
                KGLogoRHS.setVisibility(View.VISIBLE);
                PoundLogoRHS.setVisibility(View.INVISIBLE);
                TonLogoRHS.setVisibility(View.INVISIBLE);
                GramLogoRHS.setVisibility(View.INVISIBLE);
                MilliGramRHS.setVisibility(View.INVISIBLE);
                RHS = 1;
            }else if(text.equals("Pounds"))
            {
                UnitRHS.setText("lbs");
                KGLogoRHS.setVisibility(View.INVISIBLE);
                PoundLogoRHS.setVisibility(View.VISIBLE);
                TonLogoRHS.setVisibility(View.INVISIBLE);
                GramLogoRHS.setVisibility(View.INVISIBLE);
                MilliGramRHS.setVisibility(View.INVISIBLE);
                RHS = 2;
            }else if(text.equals("Tons"))
            {
                UnitRHS.setText("t");
                KGLogoRHS.setVisibility(View.INVISIBLE);
                PoundLogoRHS.setVisibility(View.INVISIBLE);
                TonLogoRHS.setVisibility(View.VISIBLE);
                GramLogoRHS.setVisibility(View.INVISIBLE);
                MilliGramRHS.setVisibility(View.INVISIBLE);
                RHS = 3;
            }else if(text.equals("Milligrams"))
            {
                UnitRHS.setText("mg");
                KGLogoRHS.setVisibility(View.INVISIBLE);
                PoundLogoRHS.setVisibility(View.INVISIBLE);
                TonLogoRHS.setVisibility(View.INVISIBLE);
                GramLogoRHS.setVisibility(View.INVISIBLE);
                MilliGramRHS.setVisibility(View.VISIBLE);
                RHS = 4;
            }else if(text.equals("Grams"))
            {
                UnitRHS.setText("g");
                KGLogoRHS.setVisibility(View.INVISIBLE);
                PoundLogoRHS.setVisibility(View.INVISIBLE);
                TonLogoRHS.setVisibility(View.INVISIBLE);
                GramLogoRHS.setVisibility(View.VISIBLE);
                MilliGramRHS.setVisibility(View.INVISIBLE);
                RHS = 5;
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void Convert(View V)
    {
        try {
            float Inputval = Float.parseFloat(Input.getText().toString());
            float result;
            float KiloMultiplier = 1;
            float PoundMultiplier = 1;
            float TonMultiplier = 1;
            float MilliMultiplier = 1;
            float GramMultiplier = 1;

            switch(LHS){

                //Kilograms
                case 1:
                    PoundMultiplier = 2.204f;
                    TonMultiplier = 0.0011f;
                    KiloMultiplier = 1.0f;
                    MilliMultiplier = 1000000.0f;
                    GramMultiplier = 1000.0f;
                    break;

                //Pounds
                case 2:
                    PoundMultiplier = 1.0f;
                    TonMultiplier = 0.0005f;
                    KiloMultiplier = 0.453f;
                    MilliMultiplier = 453592.0f;
                    GramMultiplier = 453.592f;
                    break;

                //Tons
                case 3:
                    PoundMultiplier = 2000.0f;
                    TonMultiplier = 1.0f;
                    KiloMultiplier = 907.185f;
                    MilliMultiplier = 907184740.0f;
                    GramMultiplier = 907185.0f;
                    break;

                //Milligrams
                case  4:
                    KiloMultiplier = 0.000001f;
                    GramMultiplier = 0.001f;
                    MilliMultiplier = 1.0f;
                    break;

                //Gram
                case 5 :
                    KiloMultiplier = 0.001f;
                    GramMultiplier = 1.0f;
                    MilliMultiplier = 1000.0f;
                    PoundMultiplier = 0.00220462f;
                    TonMultiplier /= 907200.0f;
                    break;

            }


            switch (RHS) {

                //toKilograms
                case 1:
                    result = Inputval * KiloMultiplier;
                    Ouput.setText(result + "");
                    break;

                //toPounds
                case 2:
                    result = Inputval * PoundMultiplier;
                    Ouput.setText(result + "");
                    break;

                // toTons
                case 3:
                    result = Inputval * TonMultiplier;
                    Ouput.setText(result + "");
                    break;

                //Milligrams
                case 4:
                    result = Inputval * MilliMultiplier;
                    Ouput.setText(result + "");
                    break;

                //Grams
                case 5:
                    result = Inputval * GramMultiplier;
                    Ouput.setText(result + "");
                    break;
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this , "Enter a valid value" , Toast.LENGTH_SHORT).show();
        }
    }

}