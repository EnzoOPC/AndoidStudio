package br.uniceub.ads.pdm.fitcalcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

    public EditText tela_calculadora_imc_txt_peso;

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

        CarregarTelaPrincipal();


    }



    public void CarregarTelaPrincipal() {
        setContentView(R.layout.tela_principal);


        tela_principal_btn_calculadora_imc = findViewById(R.id.buttonTelaCalcImc);

        tela_principal_btn_calculadora_imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CarregarTelaCalculadoraImc();
            }
        });

        tela_principal_btn_calculadora_peso = findViewById(R.id.buttonTelaCalcPeso);

        tela_principal_btn_calculadora_peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaCalculadoraPeso();
            }
        });

        tela_principal_btn_calculadora_altura = findViewById(R.id.buttonTelaCalcAltura);

        tela_principal_btn_calculadora_altura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaCalculadoraAltura();
            }
        });


    }

    

    public void CarregarTelaCalculadoraImc() {
       setContentView(R.layout.calculadora_imc);




        tela_calculadora_imc_txt_altura = (EditText) findViewById(R.id.TelaCalcImcEditTextAltura);

        tela_calculadora_imc_txt_peso = (EditText) findViewById(R.id.TelaCalcImcEditTextPeso);

        tela_calculadora_imc_btn_calcular = findViewById(R.id.buttonTelaCalcImcCalcular);

        final TextView tela_calculadora_imc_resultado = findViewById(R.id.textViewImcDisplay);

        final TextView GrauDePeso = findViewById(R.id.textViewImcGrauDePeso);

        RadioGroup tela_calculadora_imc_radio_group = findViewById(R.id.radioGroupTelaImc);

        // Método para mostrar um texto na tela quando um certo botão é clicado

        tela_calculadora_imc_btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float altura = Float.parseFloat(tela_calculadora_imc_txt_altura.getText().toString());

                float peso = Float.parseFloat(tela_calculadora_imc_txt_peso.getText().toString());

                float ImcCalculado = peso / (altura*altura);

                String resposta = String.format("%.2f", ImcCalculado);

                String grauDePeso = "";


                int selectedId = tela_calculadora_imc_radio_group.getCheckedRadioButtonId();

                if (selectedId != -1) {

                    RadioButton selectedRadioButton = findViewById(selectedId);

                    String selectedText = selectedRadioButton.getText().toString();

                    if (selectedText.equals("Homem")) {
                       if (ImcCalculado < 18.5) {
                           grauDePeso = "Você está abaixo do peso.";
                       }

                       else if (ImcCalculado >= 18.5 && ImcCalculado <= 24.9) {
                           grauDePeso = "Você está no seu peso ideal.";
                       }

                       else if (ImcCalculado >= 25 && ImcCalculado <= 29.9) {
                           grauDePeso = "Você está em estado de pré-obesidade.";
                       }

                       else  if (ImcCalculado >= 30 && ImcCalculado <= 34.9) {
                           grauDePeso = "Você está com Obesidade Grau 1.";
                       }

                       else if (ImcCalculado >= 35 && ImcCalculado <= 39.9) {
                           grauDePeso = "Você está com Obesidade Grau 2.";
                       }

                       else {
                           grauDePeso = "Você está com Obesidade Grau 3";
                       }


                    } else {
                        if (ImcCalculado < 18.5) {
                            grauDePeso = "Você está abaixo do peso.";
                        }

                        else if (ImcCalculado >= 18.5 && ImcCalculado <= 26.9) {
                            grauDePeso = "Você está no seu peso ideal.";
                        }

                        else if (ImcCalculado >= 27 && ImcCalculado <= 32.9) {
                            grauDePeso = "Você está em estado de pré-obesidade.";
                        }

                        else  if (ImcCalculado >= 33 && ImcCalculado <= 37.9) {
                            grauDePeso = "Você está com Obesidade Grau 1.";
                        }

                        else if (ImcCalculado >= 38 && ImcCalculado <= 44.9) {
                            grauDePeso = "Você está com Obesidade Grau 2.";
                        }

                        else {
                            grauDePeso = "Você está com Obesidade Grau 3";
                        }
                    }

                }

                tela_calculadora_imc_resultado.setText("Seu IMC é: " + resposta);

                GrauDePeso.setText(grauDePeso);


            }
        });




        tela_calculadora_imc_btn_voltar = findViewById(R.id.buttontelaCalcImcVoltar);

        tela_calculadora_imc_btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }

        });


    }
    public void CarregarTelaCalculadoraPeso() {
        setContentView(R.layout.calculadora_peso);

        tela_calculadora_peso_btn_voltar = findViewById(R.id.buttonTelaCalcPesoVoltar);

        tela_calculadora_peso_btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }
        });
    }
    public void CarregarTelaCalculadoraAltura() {
        setContentView(R.layout.calculadora_altura);

        tela_calculadora_altura_btn_voltar = findViewById(R.id.buttonTelaCalcAlturaVoltar);

        tela_calculadora_altura_btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }
        });
    }
}
