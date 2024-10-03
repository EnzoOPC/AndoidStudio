package br.uniceub.ads.pdm.cadastro_de_produtos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Produto> produtos;

    public Adapter(Context context, List<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.produto, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewNome.setText(produtos.get(position).getNome());
        holder.textViewValor.setText("R$ " + Double.toString(produtos.get(position).getValor()));
        holder.imageView.setImageResource(produtos.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
