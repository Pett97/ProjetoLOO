package model;


public  abstract class Produto {

    private String nome;

    private double valorVenda;
   
    private double valorCompra;
    
    public Produto(String nome, double valorVenda, double valorCompra){
        setNome(nome);
        setValorVenda(valorVenda);
        setValorCompra(valorCompra);
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }
    
    
    public abstract String getTipo();
}

