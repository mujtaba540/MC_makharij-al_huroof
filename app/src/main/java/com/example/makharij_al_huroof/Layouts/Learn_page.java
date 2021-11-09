package com.example.makharij_al_huroof.Layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.makharij_al_huroof.Models.Category;

import com.example.makharij_al_huroof.R;

public class Learn_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spin ;
    String[] Name = {"Halqiyah","Lahatiyah","Shajariyah-Haafiyah","Tarfiyah","Nit-eeyah","Lisaveyah","Ghunna"};
    Category[] data=new Category[Name.length];
    String[] Details={"أ ة  –  Sound produced from the End of Throat\n" +
            "\n" +
            "ع ح –  Sound produced from the Middle of Throat\n" +
            "\n" +
            "غ خ – Sound produced from the Start of Throat",

    "ق –  Base of Tongue which is near Uvula touching the mouth roof\n" +
            "\n" +
            "ك –  Portion of Tongue near its base touching the roof of mouth",

    "ج ش ى – Tongue touching the center of the mouth roof\n" +
            "\n" +
             "ض   – One side of the tongue touching the molar teeth",

            "ل  – Rounded tip of the tongue touching the base of the frontal 8 teeth\n" +
                    "\n" +
                    "ن  – Rounded tip of the tongue touching the base of the frontal 6 teeth\n" +
                    "\n" +
                     "ر  – Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth",

    "ط د ت – Tip of the tongue touching the base of the front 2 teeth",

    "ص ز س – Tip of the tongue comes between the front top and bottom teeth\n ظ  ذ  ث – Tip of the tongue touching the tip of the frontal 2 teeth",

    "ف – Tip of the two upper jaw teeth touches the inner part of the lower lip\n" +
            "\n" +
            "ب – Inner part of the both lips touch each other,  \n" +
            "\n" +
            "م –  Outer part of both lips touch each other,  \n" +
            "\n" +
            "و –  Rounding both lips and not closing the mouth\nMouth empty space while speaking words like  باَ بوُ بىِ\nم ن – While pronouncing the ending sound of  م  or ن , bring the vibration to the nose"};

    TextView text_area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_page);
        spin= findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        for(int i=0;i<Name.length;i++){
            data[i]=new Category(Name[i],Details[i]);
        }

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Name);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    text_area=findViewById(R.id.text_area);
    text_area.setText((CharSequence) data[position].get_Details());
//        Toast.makeText(getApplicationContext(),Name[position] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}