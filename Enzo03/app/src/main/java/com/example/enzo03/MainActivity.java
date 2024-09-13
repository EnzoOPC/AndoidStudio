package com.example.enzo03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        EditText texto01 = findViewById(R.id.campo_de_texto_01);
        EditText texto02 = findViewById(R.id.campo_de_texto_02);

        Button botao_cadastrar = findViewById(R.id.cadastrar);
        Button botao_limpar = findViewById(R.id.limpar);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto01.setText("");
                texto02.setText("");
            }
        });









    }
}