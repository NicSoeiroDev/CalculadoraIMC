package com.example.calculadora_imc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Obesidade1 extends AppCompatActivity {

    private TextView TextoMotivacional;
    private TextView resultadoObesidade1;
    private Button Voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultadoObesidade1 = findViewById(R.id.textObesidade1);

        Intent intent = getIntent();

        if(intent.hasExtra("imc_resultado")){
            String imcResultado = intent.getStringExtra("imc_resultado");
            //Log.d("AbaixoDoPeso", "IMC Recebido: " + imcResultado);
            resultadoObesidade1.setText("Seu IMC é: " + imcResultado);
        } else {
            resultadoObesidade1.setText("Erro ao obter seu IMC");
            //Log.e("AbaixoDoPeso", "Erro: Extra 'imc_resultado' não encontrado no Intent.");
        }

        TextoMotivacional = findViewById(R.id.textMotivacionalObesidade1);
        TextoMotivacional.setText("Você está em uma jornada de transformação significativa. Reconheça sua coragem e celebre cada passo para uma saúde vibrante. Pequenas mudanças trazem grandes resultados. Nutra-se com gentileza, mova-se com alegria e acredite na sua capacidade de bem-estar. Sua força interior é maior que qualquer desafio!");

        Voltar = findViewById(R.id.btn_VoltarObesidade1);
        Voltar.setOnClickListener(View ->{
            startActivity(new Intent(Obesidade1.this, CalcularIMC.class));
        });
    }
}