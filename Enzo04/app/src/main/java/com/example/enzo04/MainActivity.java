package com.example.enzo04;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    // DECLARAÇÃO DE OBJETOS

    // View da tela de login
    public Button btn_login;


    // Views da Tela Principal

    public Button tela_main_btn_sobre;
    public Button tela_main_btn_config;
    public Button tela_main_btn_sair;

    // Views da Tela Sobre O App

    public Button tela_sobre_btn_voltar;

    public LinearLayout layout_sobre_app;

    // View tela Configurações

    public Button btn_sair;

    public float startX;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.tela_login); /* Essa linha mostra qual tela será iniciada primeiro ao executar o aplicativo */

        CarregarTelaLogin();

    }

    public void CarregarTelaPrincipal() {
        setContentView(R.layout.activity_main);

        tela_main_btn_sobre = findViewById(R.id.main_btn_sobre);

        tela_main_btn_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaSobreApp();
            }
        });

        tela_main_btn_config = findViewById(R.id.main_btn_config);

        tela_main_btn_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaConfig();
            }
        });
        tela_main_btn_sair = findViewById(R.id.main_btn_sair);

        tela_main_btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaLogin();
            }
        });
    }

    public void CarregarTelaConfig() {
        setContentView(R.layout.tela_configuracoes);

        btn_sair = findViewById(R.id.tela_config_btn_sair);

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }
        });

    }


    public void CarregarTelaLogin() {
        setContentView(R.layout.tela_login);

        btn_login = findViewById(R.id.button_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }
        });
    }

    public void CarregarTelaSobreApp() {
        setContentView(R.layout.tela_o_app);

        tela_sobre_btn_voltar = findViewById(R.id.tela_sobre_app_btn_sair);

        tela_sobre_btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }
        });
        layout_sobre_app = findViewById(R.id.layout_tela_sobre_app);

        layout_sobre_app.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:              // ACTION_DOWN é o ato de pressionar a tela, e o ACTION_UP é o ato de deixar de pressionar
                        startX = event.getX();
                        return true;

                    case MotionEvent.ACTION_UP:
                        if (event.getX() - startX > 100)
                            CarregarTelaPrincipal();
                        return false;

                    default: return false;
                }
            }
        });
    }
}