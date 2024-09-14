package com.example.prueba2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.prueba2.R;

public class MainActivity extends AppCompatActivity {
    EditText txt_edad;
    EditText txt_peso;
    EditText txt_height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt_edad = findViewById(R.id.txt_edad);
        txt_peso = findViewById(R.id.txt_peso);
        txt_height = findViewById(R.id.txt_height);

        Button btn_randomNumber = findViewById(R.id.btn_randomNumber);

        btn_randomNumber.setOnClickListener(view -> {
            Intent intent = new Intent(this, RandomNumber.class);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void imc(View Vista){
        String laedad = txt_edad.getText().toString();
        String elpeso = txt_peso.getText().toString();
        String altura = txt_height.getText().toString();
        if (laedad.equals("") || elpeso.equals("") || altura.equals("")){
            Toast.makeText(getApplicationContext(), "Por favor complete los siguientes campos", Toast.LENGTH_LONG).show();
        }else{
            int txt_edad = Integer.parseInt(laedad);
            float txt_peso = Integer.parseInt(elpeso);
            float txt_height = Integer.parseInt(altura);
            txt_height= txt_height/100;
            //se calcula el indice de masa corporal
            float imc=txt_peso/(float)Math.pow(txt_height, 2);
            //se convierte el resultado a texto
            String imcTexto = String.format("%.1f", imc);
            if (imc < 18.5f)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + txt_edad + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Desnutricion", Toast.LENGTH_LONG).show(); // Desnutrición
            if (imc >= 18.5f && imc < 25)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + txt_edad + " y su indice de masa coporal es de: " + imcTexto+" usted esta Normal", Toast.LENGTH_LONG).show(); // Normal
            if (imc >= 25 && imc < 30)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + txt_edad + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Sobrepeso", Toast.LENGTH_LONG).show(); //Sobrepeso
            if (imc >= 30 && imc < 35)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + txt_edad + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Obesidad Grado 1", Toast.LENGTH_LONG).show(); // Obestdad Grado1
            if (imc >= 35 && imc < 40)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + txt_edad + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Obesidad Grado 2", Toast.LENGTH_LONG).show(); // Obesidod Grado2
            if (imc >= 40)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + txt_edad + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Obesidad Grado 3", Toast.LENGTH_LONG).show(); // Obesidod Grado3

        }

    }
}