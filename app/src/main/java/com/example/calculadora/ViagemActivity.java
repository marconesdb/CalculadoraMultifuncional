package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViagemActivity extends AppCompatActivity {

    // Declaração dos componentes da interface
    private EditText edtDistancia, edtValorLitro, edtMediaKm;
    private Button btnCalcular, btnVoltar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viagem);

        // Ajuste de padding para barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialização dos componentes
        edtDistancia = findViewById(R.id.distancia);
        edtValorLitro = findViewById(R.id.valor_litro);
        edtMediaKm = findViewById(R.id.media_km);
        btnCalcular = findViewById(R.id.btn_calcular);
        txtResultado = findViewById(R.id.txt_resultado);

        // Inicialização do botão voltar
        btnVoltar = findViewById(R.id.btnVoltar); // certifique-se de criar este botão no XML
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViagemActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // finaliza a tela atual
            }
        });

        // Lógica do botão de cálculo
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCustoViagem();
            }
        });
    }

    private void calcularCustoViagem() {
        try {
            double distancia = Double.parseDouble(edtDistancia.getText().toString());
            double valorLitro = Double.parseDouble(edtValorLitro.getText().toString());
            double mediaKm = Double.parseDouble(edtMediaKm.getText().toString());

            double litrosNecessarios = distancia / mediaKm;
            double custoTotal = litrosNecessarios * valorLitro;

            txtResultado.setText(String.format(Locale.getDefault(),
                    "Custo estimado da viagem: R$ %.2f", custoTotal));
        } catch (NumberFormatException e) {
            txtResultado.setText(getString(R.string.msg_erro_campos));
        }
    }
}
