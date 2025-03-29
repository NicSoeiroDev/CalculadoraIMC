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

public class AbaixoDoPeso extends AppCompatActivity {

    private TextView resultadoAbaixo;

    private TextView textoMotivacional;

    private Button VoltarAbaixo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
        resultadoAbaixo = findViewById(R.id.textAbaixo);

        Intent intent = getIntent();

        if(intent.hasExtra("imc_resultado")){
            String imcResultado = intent.getStringExtra("imc_resultado");
            //Log.d("AbaixoDoPeso", "IMC Recebido: " + imcResultado);
            resultadoAbaixo.setText("Seu IMC é: " + imcResultado);
        } else {
            resultadoAbaixo.setText("Erro ao obter seu IMC");
            //Log.e("AbaixoDoPeso", "Erro: Extra 'imc_resultado' não encontrado no Intent.");
        }

        textoMotivacional = findViewById(R.id.textMotivacionalSobrepeso);
        textoMotivacional.setText("Construir um corpo forte e saudável é um ato de carinho e paciência. Cada escolha nutritiva te fortalece, cada pequeno passo te aproxima do seu bem-estar. Celebre o processo, nutra sua vitalidade e lembre-se que você merece se sentir pleno e energizado. Sua jornada é única, e a saúde vibrante está ao seu alcance.");

        VoltarAbaixo = findViewById(R.id.btn_voltarAbaixo);
        VoltarAbaixo.setOnClickListener(View ->{
            startActivity(new Intent(AbaixoDoPeso.this, CalcularIMC.class));
        });

    }
}