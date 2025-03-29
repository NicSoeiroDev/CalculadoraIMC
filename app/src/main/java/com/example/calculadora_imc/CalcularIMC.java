package com.example.calculadora_imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.DecimalFormat;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcularIMC extends AppCompatActivity {

    private EditText Altura;
    private EditText Peso;
    private Button Calcular;
    private Button Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcular_imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Altura = findViewById(R.id.editTextAltura);
        Peso = findViewById(R.id.editTextPeso);
        Calcular = findViewById(R.id.btn_calc);

        Voltar = findViewById(R.id.btn_voltar);

        Voltar.setOnClickListener(View->{
            startActivity(new Intent(CalcularIMC.this, MainActivity.class));
        });

        Calcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String alturaStr = Altura.getText().toString();
                String pesoStr = Peso.getText().toString();

                if(alturaStr.isEmpty() || pesoStr.isEmpty()){
                    Toast.makeText(CalcularIMC.this,"Por Favor digite uma altura ou um peso valido", Toast.LENGTH_SHORT).show();
                    return;
                }

                float altura;
                float peso;

                try{
                    altura = Float.parseFloat(alturaStr);
                    peso = Float.parseFloat(pesoStr);
                } catch (NumberFormatException e){
                    Toast.makeText(CalcularIMC.this,"Altura e peso devem ser valores validos", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Log.d("CalcularIMC", "Altura digitada: " + altura);
                //Log.d("CalcularIMC", "Peso digitado: " + peso);

                if(altura <= 0 || peso <= 0){
                    Toast.makeText(CalcularIMC.this, "Altura e peso não podem ser negativos", Toast.LENGTH_SHORT).show();
                }

                float imc = calcularIMC(peso, altura);
                DecimalFormat df = new DecimalFormat("#.##");
                String imcFormatado = df.format(imc);

                Intent intent = null;
                switch (classificarIMC(imc)){
                    case "AbaixoDoPeso":
                       intent = new Intent(CalcularIMC.this, AbaixoDoPeso.class);
                        break;
                    case "PesoNormal":
                        intent = new Intent(CalcularIMC.this, PesoNormal.class);
                        break;
                    case "Sobrepeso":
                        intent = new Intent(CalcularIMC.this, Sobrepeso.class);
                        break;
                    case "ObesidadeGrau1":
                        intent = new Intent(CalcularIMC.this, Obesidade1.class);
                        break;
                    case "ObesidadeGrau2":
                        intent = new Intent(CalcularIMC.this, Obesidade2.class);
                        break;
                    case "ObesidadeGrau3":
                        intent = new Intent(CalcularIMC.this, Obesidade3.class);
                        break;
                }
                if(intent != null){
                    intent.putExtra("imc_resultado", imcFormatado);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private float calcularIMC(float peso, float altura){
        return peso / (altura*altura);
    }

    private String classificarIMC(float imc){
        if(imc < 18.5){
            return "AbaixoDoPeso";
        } else if(imc < 24.9) {
            return "PesoNormal";
        } else if(imc < 29.9) {
            return "Sobrepeso";
        } else if(imc < 34.9){
            return "ObesidadeGrau1";
        }else if( imc < 39.9){
            return"ObesidadeGrau2";
        }else{
            return "ObesidadeGrau3";
        }
    }
}