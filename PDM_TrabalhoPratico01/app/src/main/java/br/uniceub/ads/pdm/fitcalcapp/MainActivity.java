package br.uniceub.ads.pdm.fitcalcapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.squareup.picasso.Picasso;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    public LinearLayout layout_tela_calc_imc;


    // Views da tela para calcular o peso ideal

    public Button tela_calculadora_peso_btn_calcular;

    public Button tela_calculadora_peso_btn_voltar;

    public RadioGroup tela_calculadora_peso_radio_group;

    public RadioButton tela_calculadora_peso_radio_masculino;

    public RadioButton tela_calculadora_peso_radio_feminino;

    public EditText tela_calculadora_peso_txt_peso;

    public EditText tela_calculadora_peso_txt_altura;

    public TextView tela_calculadora_peso_resultado;

    public LinearLayout layout_tela_calc_peso;


    // Views da tela para calcular a altura ideal

    public Button tela_calculadora_altura_btn_calcular;

    public Button tela_calculadora_altura_btn_voltar;

    public RadioGroup tela_calculadora_altura_radio_group;

    public RadioButton tela_calculadora_altura_radio_masculino;

    public RadioButton tela_calculadora_altura_radio_feminino;

    public EditText tela_calculadora_altura_txt_peso;

    public TextView tela_calculadora_altura_resultado;

    public LinearLayout layout_tela_calc_altura;

    public ImageView imageView;

    public float startX;



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

        tela_calculadora_imc_radio_group = findViewById(R.id.radioGroupTelaImc);

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

        layout_tela_calc_imc = findViewById(R.id.calculadora_imc);

        layout_tela_calc_imc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:              // ACTION_DOWN é o ato de pressionar a tela, e o ACTION_UP é o ato de deixar de pressionar
                    startX = event.getX();
                    return true;

                case MotionEvent.ACTION_UP:
                    if (event.getX() - startX > 100)
                        CarregarTelaPrincipal();
                    return false;

                default:
                    return false;
                }
            }
        });
    }




    public void CarregarTelaCalculadoraPeso() {
        setContentView(R.layout.calculadora_peso);

        tela_calculadora_peso_txt_altura = (EditText) findViewById(R.id.TelaCalcPesoEditTextAltura);

        tela_calculadora_peso_btn_calcular = findViewById(R.id.buttonTelaCalcPesoCalcular);

        final TextView tela_calculadora_peso_resultado = findViewById(R.id.textViewPesoDisplay);


        tela_calculadora_peso_radio_group = findViewById(R.id.radioGroupTelaPeso);

        // Método para mostrar um texto na tela quando um certo botão é clicado

        tela_calculadora_peso_btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float IMC = 0;

                int selectedId = tela_calculadora_peso_radio_group.getCheckedRadioButtonId();

                if (selectedId != -1) {

                    RadioButton selectedRadioButton = findViewById(selectedId);

                    String selectedText = selectedRadioButton.getText().toString();

                    if (selectedText.equals("Homem")) {
                        IMC = 21.7F;
                    } else {
                        IMC = 22.7F;
                    }

                }
                float altura = Float.parseFloat(tela_calculadora_peso_txt_altura.getText().toString());

                float PesoClculado = IMC * (altura*altura);

                String resposta = String.format("%.2f", PesoClculado);

                tela_calculadora_peso_resultado.setText("Seu peso ideal é: " + resposta + "Kg");



            }
        });

        tela_calculadora_peso_btn_voltar = findViewById(R.id.buttonTelaCalcPesoVoltar);

        tela_calculadora_peso_btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }
        });

        layout_tela_calc_peso = findViewById(R.id.calculadora_peso);

        layout_tela_calc_peso.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:              // ACTION_DOWN é o ato de pressionar a tela, e o ACTION_UP é o ato de deixar de pressionar
                    startX = event.getX();
                    return true;

                case MotionEvent.ACTION_UP:
                    if (event.getX() - startX > 100)
                        CarregarTelaPrincipal();
                    return false;

                default:
                    return false;
            }
            }
        });
    }


    public void CarregarTelaCalculadoraAltura() {
        setContentView(R.layout.calculadora_altura);

        tela_calculadora_altura_txt_peso = (EditText) findViewById(R.id.TelaCalcAlturaEditTextPeso);

        tela_calculadora_altura_btn_calcular = findViewById(R.id.buttonTelaCalcAlturaCalcular);

        final TextView tela_calculadora_altura_resultado = findViewById(R.id.textViewAlturaDisplay);

        imageView = findViewById(R.id.image_view);


        tela_calculadora_altura_radio_group = findViewById(R.id.radioGroupTelaAltura);

        // Método para mostrar um texto na tela quando um certo botão é clicado

        tela_calculadora_altura_btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float IMC = 0;

                int selectedId = tela_calculadora_altura_radio_group.getCheckedRadioButtonId();

                if (selectedId != -1) {

                    RadioButton selectedRadioButton = findViewById(selectedId);

                    String selectedText = selectedRadioButton.getText().toString();

                    if (selectedText.equals("Homem")) {
                        IMC = 21.7F;
                    } else {
                        IMC = 22.7F;
                    }

                }
                float peso = Float.parseFloat(tela_calculadora_altura_txt_peso.getText().toString());

                float altura= peso/IMC;

                float alturaCalculada = (float) Math.pow(altura, 0.5);

                String resposta = String.format("%.2f", alturaCalculada);

                tela_calculadora_altura_resultado.setText("Sua altura ideal é: " + resposta + " Metros");

                if (alturaCalculada>=1.6 && alturaCalculada<=1.86) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/1/17/Image_phase_1_mr_incredible_becoming_uncanny_by_abbysek_dex8liy-fullview.jpg/revision/latest/scale-to-width-down/1000?cb=20240707182214";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=1.47 && alturaCalculada<=1.99) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/b/ba/Image-2022-01-10-at-2.12.20-AM-4-1014x1024.jpg/revision/latest/scale-to-width-down/1000?cb=20240714013123";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=1.34 && alturaCalculada<=2.12) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/a/ab/Image_phase_3_mr_incredible_becoming_uncanny_by_abbysek_dex8lji-fullview.jpg/revision/latest?cb=20240731035318";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=1.21 && alturaCalculada<=2.25) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/d/db/Default_phase_4_image..jpg/revision/latest/scale-to-width-down/1000?cb=20240630025841";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=1.08 && alturaCalculada<=2.38) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/0/07/Phase_5_OG_Version_Fixed.png/revision/latest/scale-to-width-down/1000?cb=20240630030111";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=0.95 && alturaCalculada<=2.51) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/5/59/Phase_6.png/revision/latest?cb=20240912034305";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=0.82 && alturaCalculada<=2.64) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/e/eb/Phase7.jpg/revision/latest?cb=20221112132911";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=0.69 && alturaCalculada<=2.77) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/e/e7/C620E1A5-37B2-4347-A846-9E4D80B15750.jpg/revision/latest/scale-to-width-down/1000?cb=20240815022721";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=0.56 && alturaCalculada<=2.90) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/3/39/Phase_9_OG_Version_Fixed.png/revision/latest/scale-to-width-down/1000?cb=20240702204047";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else if (alturaCalculada>=0.43 && alturaCalculada<=3.03) {
                    String imgUrl = "https://static.wikia.nocookie.net/the-uncanny-incredible/images/a/ad/Phase_9.05.png/revision/latest?cb=20220515180023";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }
                else {
                    String imgUrl = "https://m.media-amazon.com/images/I/61FaI1m4GmL._AC_UF894,1000_QL80_.jpg";

                    Picasso.get()
                            .load(imgUrl)
                            .into(imageView);

                    imageView.setVisibility(View.VISIBLE);
                }





            }
        });

        tela_calculadora_altura_btn_voltar = findViewById(R.id.buttonTelaCalcAlturaVoltar);

        tela_calculadora_altura_btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }
        });

        layout_tela_calc_altura = findViewById(R.id.calculadora_altura);

        layout_tela_calc_altura.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:              // ACTION_DOWN é o ato de pressionar a tela, e o ACTION_UP é o ato de deixar de pressionar
                    startX = event.getX();
                    return true;

                case MotionEvent.ACTION_UP:
                    if (event.getX() - startX > 100)
                        CarregarTelaPrincipal();
                    return false;

                default:
                    return false;
            }
            }
        });
    }
}