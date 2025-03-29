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

public class Obesidade3 extends AppCompatActivity {

    private TextView TextoMotivacional;
    private TextView resultadoObesidade3;
    private Button Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultadoObesidade3 = findViewById(R.id.textObesidade3);

        Intent intent = getIntent();

        if(intent.hasExtra("imc_resultado")){
            String imcResultado = intent.getStringExtra("imc_resultado");
            //Log.d("AbaixoDoPeso", "IMC Recebido: " + imcResultado);
            resultadoObesidade3.setText("Seu IMC é: " + imcResultado);
        } else {
            resultadoObesidade3.setText("Erro ao obter seu IMC");
            //Log.e("AbaixoDoPeso", "Erro: Extra 'imc_resultado' não encontrado no Intent.");
        }

        TextoMotivacional = findViewById(R.id.textMotivacionalObesidade3);
        TextoMotivacional.setText("Você está demonstrando uma grande coragem ao iniciar esta importante jornada em direção a uma vida mais saudável. Reconheça essa força e celebre cada passo. Lembre-se que pequenas mudanças consistentes trazem grandes resultados. Busque apoio, nutra seu corpo com cuidado e acredite na sua capacidade de transformação. Você merece sentir-se bem!");

        Voltar = findViewById(R.id.btn_VoltarObesidade3);
        Voltar.setOnClickListener(View ->{
            startActivity(new Intent(Obesidade3.this, CalcularIMC.class));
        });
    }
}