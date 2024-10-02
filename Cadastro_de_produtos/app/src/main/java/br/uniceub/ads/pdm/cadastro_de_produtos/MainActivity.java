package br.uniceub.ads.pdm.cadastro_de_produtos;

import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Enzo", "Um serumaninho legal", 498.3, true, R.drawable.green_v));
        produtos.add(new Produto("João", "Um serumaninho legal", 498.3, true, R.drawable.red_x));
        produtos.add(new Produto("Guilherme", "Um serumaninho legal", 498.3, true, R.drawable.green_v));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new Adapter(getApplicationContext(), produtos));
    }
}