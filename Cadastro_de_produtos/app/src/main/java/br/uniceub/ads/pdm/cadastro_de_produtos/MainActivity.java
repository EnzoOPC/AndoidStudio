package br.uniceub.ads.pdm.cadastro_de_produtos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nomeProduto.getText().toString();
                String description = descricao.getText().toString();
                String value = valor.getText().toString();

                double valorDouble = Double.parseDouble(value);

                produtos.add(new Produto(name, description, valorDouble,true, R.drawable.green_v));

                LoadMain();
            }
        });
    }
}