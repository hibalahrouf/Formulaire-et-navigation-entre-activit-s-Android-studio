package com.example.formulaire;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    private TextView summary;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        summary = findViewById(R.id.summary);
        btnBack = findViewById(R.id.btnBack);


        Intent intent = getIntent();


        String fullName  = intent.getStringExtra("fullName");
        String userEmail = intent.getStringExtra("userEmail");
        String telephone = intent.getStringExtra("telephone");
        String address   = intent.getStringExtra("address");
        String city      = intent.getStringExtra("city");


        String resume = "Nom complet : " + safe(fullName) +
                "\nEmail : " + safe(userEmail) +
                "\nTéléphone : " + safe(telephone) +
                "\nAdresse : " + safe(address) +
                "\nVille : " + safe(city);


        summary.setText(resume);


        btnBack.setOnClickListener(v -> finish());
    }


    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}
