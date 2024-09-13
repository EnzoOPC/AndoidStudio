package br.uniceub.ads.pdm.fitcalcapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Views da tela principal

    public Button tela_principal_btn_calculadora_imc;

    public Button tela_principal_btn_calculadora_peso;

    public Button tela_principal_btn_calculadora_altura;

    // Views da tela para calcular o IMC

    public Button tela_calculadora_imc_btn_calcular;

    public Button tela_calculadora_imc_btn_voltar;

    public RadioGroup tela_calculadora_imc_radio_group;

    public RadioButton tela_calculadora_imc_radio_masculino;

    public RadioButton tela_calculadora_imc_radio_feminino;

    public EditText tela_calculadora_imc_txt_altura;

    public TextView tela_calculadora_imc_resultado;


    // Views da tela para calcular o peso ideal

    public Button tela_calculadora_peso_btn_calcular;

    public Button tela_calculadora_peso_btn_voltar;

    public RadioGroup tela_calculadora_peso_radio_group;

    public RadioButton tela_calculadora_peso_radio_masculino;

    public RadioButton tela_calculadora_peso_radio_feminino;

    public EditText tela_calculadora_peso_txt_peso;

    public EditText tela_calculadora_peso_txt_altura;

    public TextView tela_calculadora_peso_resultado;


    // Views da tela para calcular a altura ideal

    public Button tela_calculadora_altura_btn_calcular;

    public Button tela_calculadora_altura_btn_voltar;

    public RadioGroup tela_calculadora_altura_radio_group;

    public RadioButton tela_calculadora_altura_radio_masculino;

    public RadioButton tela_calculadora_altura_radio_feminino;

    public EditText tela_calculadora_altura_txt_altura;

    public TextView tela_calculadora_altura_resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_principal);

        

            // Just testing smth
        });
    }
}