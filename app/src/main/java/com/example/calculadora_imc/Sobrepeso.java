package com.example.calculadora_imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class Sobrepeso extends AppCompatActivity {

    private TextView resultadoSobrepeso;
    private TextView textoMotivacional;
    private Button Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobrepeso);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultadoSobrepeso = findViewById(R.id.textSobrepeso);

        Intent intent = getIntent();

        if(intent.hasExtra("imc_resultado")){
            String imcResultado = intent.getStringExtra("imc_resultado");
            //Log.d("AbaixoDoPeso", "IMC Recebido: " + imcResultado);
            resultadoSobrepeso.setText("Seu IMC é: " + imcResultado);
        } else {
            resultadoSobrepeso.setText("Erro ao obter seu IMC");
            //Log.e("AbaixoDoPeso", "Erro: Extra 'imc_resultado' não encontrado no Intent.");
        }

        textoMotivacional = findViewById(R.id.textMotivacionalSobrepeso);
        textoMotivacional.setText("Você está dando passos importantes para um bem-estar maior. Reconheça sua força e continue cultivando hábitos saudáveis com gentileza. Cada escolha positiva te aproxima de sentir-se melhor. Celebre o progresso, sua jornada é única e você tem a capacidade de alcançar seus objetivos!");

        Voltar = findViewById(R.id.btn_VoltarSobrepeso);
        Voltar.setOnClickListener(View ->{
            startActivity(new Intent(Sobrepeso.this, CalcularIMC.class));
        });
    }
}