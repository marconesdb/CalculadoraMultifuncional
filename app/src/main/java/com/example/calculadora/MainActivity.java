package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btEntrar = findViewById(R.id.btEntrar);
        btEntrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Abrir a tela Home

                Intent telaHome = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(telaHome);
                finish();

            }

        });


        Button btnViagem = findViewById(R.id.btnViagem);
        btnViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViagemActivity.class);
                startActivity(intent);
            }
        });


    }
}