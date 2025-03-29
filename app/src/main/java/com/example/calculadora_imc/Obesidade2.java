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

public class Obesidade2 extends AppCompatActivity {

    private TextView TextoMotivacional;
    private TextView resultadoObesidade2;
    private Button Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultadoObesidade2 = findViewById(R.id.textObesidade2);

        Intent intent = getIntent();

        if(intent.hasExtra("imc_resultado")){
            String imcResultado = intent.getStringExtra("imc_resultado");
            //Log.d("AbaixoDoPeso", "IMC Recebido: " + imcResultado);
            resultadoObesidade2.setText("Seu IMC é: " + imcResultado);
        } else {
            resultadoObesidade2.setText("Erro ao obter seu IMC");
            //Log.e("AbaixoDoPeso", "Erro: Extra 'imc_resultado' não encontrado no Intent.");
        }

        TextoMotivacional = findViewById(R.id.textMotivacionalObesidade2);
        TextoMotivacional.setText("Você está demonstrando grande força ao buscar mais saúde. Reconheça sua determinação e celebre cada conquista. Lembre-se que o caminho tem desafios, mas sua capacidade de superá-los é imensa. Nutra-se com cuidado, mova-se no seu ritmo e acredite no poder das suas escolhas. Você merece sentir-se bem!");

        Voltar = findViewById(R.id.btn_VoltarObesidade2);
        Voltar.setOnClickListener(View ->{
            startActivity(new Intent(Obesidade2.this, CalcularIMC.class));
        });
    }
}