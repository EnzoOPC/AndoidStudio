package br.uniceub.ads.pdm.cadastro_de_produtos;

public class Produto {

    private String nome;
    private String descricao;
    private double valor;
    private boolean disponivel;
    private int image;

    public Produto(String nome, String descricao, double valor, boolean disponivel, int image) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
