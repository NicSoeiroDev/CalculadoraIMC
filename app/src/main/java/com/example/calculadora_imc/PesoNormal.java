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

public class PesoNormal extends AppCompatActivity {

    private TextView resultadoNormal;

    private TextView textoMotivacional;

    private Button Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peso_normal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultadoNormal = findViewById(R.id.textMotivacionalNormal);

        Intent intent = getIntent();

        if(intent.hasExtra("imc_resultado")){
            String imcResultado = intent.getStringExtra("imc_resultado");
            //Log.d("AbaixoDoPeso", "IMC Recebido: " + imcResultado);
            resultadoNormal.setText("Seu IMC é: " + imcResultado);
        } else {
            resultadoNormal.setText("Erro ao obter seu IMC");
            //Log.e("AbaixoDoPeso", "Erro: Extra 'imc_resultado' não encontrado no Intent.");
        }

        textoMotivacional = findViewById(R.id.textMotivacionalNormal);
        textoMotivacional.setText("Seu corpo é um reflexo de equilíbrio e saúde. Continue nutrindo essa harmonia com escolhas que te fazem bem, tanto física quanto mentalmente. Celebre a energia e a vitalidade que você conquista, e lembre-se que o bem-estar é uma jornada contínua e prazerosa. Mantenha o ritmo, você está no caminho certo!");

        Voltar = findViewById(R.id.btn_VoltarNormal);
        Voltar.setOnClickListener(View ->{
            startActivity(new Intent(PesoNormal.this, CalcularIMC.class));
        });
    }
}