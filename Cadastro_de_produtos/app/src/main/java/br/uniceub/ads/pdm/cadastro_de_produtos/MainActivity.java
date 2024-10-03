package br.uniceub.ads.pdm.cadastro_de_produtos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Views tela principal

    public Button btn_Cadastrar;

    // Views tela cadastro

    public EditText nomeProduto;

    public EditText descricao;

    public EditText valor;

    public Button cadastrar;

    public Button voltar;

    public CheckBox checkBox;

    //

    List<Produto> produtos = new ArrayList<Produto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        LoadMain();

    }

    public void LoadMain() {
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new Adapter(getApplicationContext(), produtos));

        btn_Cadastrar = findViewById(R.id.btnCadastrar);

        btn_Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadTelaCadastro();
            }
        });
    }

    public void LoadTelaCadastro() {
        setContentView(R.layout.tela_cadastro);

        cadastrar = findViewById(R.id.buttonSalvar);

        voltar = findViewById(R.id.buttonVoltar);

        nomeProduto = findViewById(R.id.editTextNome);
        descricao = findViewById(R.id.editTextDescricao);
        valor = findViewById(R.id.editTextValor);
        checkBox = findViewById(R.id.checkBox);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nomeProduto.getText().toString().trim();
                String description = descricao.getText().toString().trim();
                String value = valor.getText().toString();

                double valorDouble = Double.parseDouble(value);

                if (checkBox.isChecked()) {
                    produtos.add(new Produto(name, description, valorDouble,true, R.drawable.green_v));
                }
                else {
                    produtos.add(new Produto(name, description, valorDouble,true, R.drawable.red_x));
                }


                nomeProduto.setText("");
                descricao.setText("");
                valor.setText("");

                Toast.makeText(MainActivity.this, "Produto Cadastrado", Toast.LENGTH_SHORT).show();

            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadMain();
            }
        });
    }
}