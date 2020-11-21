package com.example.parcialapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggle;
    EditText lugarFavorito;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* ToggleButton toggle = (ToggleButton) findViewById(R.id.togglebutton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                } else {

                }
            }
        });*/
        toggle = (ToggleButton) findViewById(R.id.togglebutton);
        boton = findViewById(R.id.button)
        lugarFavorito = findViewById(R.id.editText);

        List<String> listaLugares = new ArrayList<String>();
        String lugar = lugarFavorito.getText();
        listaLugares.add((String)lugarFavorito.getText());

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(this, MapaActivity.class);
                i.putExtra("lugares", listaLugares);
                startActivity(i);
            }
        });



    }
}