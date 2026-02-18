package com.example.formulaire;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText fullName, userEmail, telephone, address, city;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullName   = findViewById(R.id.fullName);
        userEmail  = findViewById(R.id.userEmail);
        telephone  = findViewById(R.id.telephone);
        address    = findViewById(R.id.address);
        city       = findViewById(R.id.city);
        btnSubmit  = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            // 6.1) Lire le texte des champs
            String sFullName = fullName.getText().toString().trim();
            String sUserEmail = userEmail.getText().toString().trim();
            String sTelephone = telephone.getText().toString().trim();
            String sAddress = address.getText().toString().trim();
            String sCity = city.getText().toString().trim();

            if (sFullName.isEmpty() || sUserEmail.isEmpty()) {
                Toast.makeText(this, "Le nom complet et l'email sont obligatoires.", Toast.LENGTH_SHORT).show();
                return; 
            }

            Intent i = new Intent(MainActivity.this, Screen2Activity.class);

            i.putExtra("fullName", sFullName);
            i.putExtra("userEmail", sUserEmail);
            i.putExtra("telephone", sTelephone);
            i.putExtra("address", sAddress);
            i.putExtra("city", sCity);

            startActivity(i);
        });
    }
}
