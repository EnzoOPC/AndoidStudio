package br.uniceub.ads.pdm.cadastro_de_produtos;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textViewNome, textViewValor;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textViewNome = itemView.findViewById(R.id.texViewNome);
        textViewValor = itemView.findViewById(R.id.texViewProdutoValor);
    }
}
