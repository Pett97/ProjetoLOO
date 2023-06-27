package model;

import util.Tamanho;

public class Roupa extends Produto{
    private Tamanho tamanho;
    
    
    public Roupa (String nome, double valorVenda, double valorCompra, Tamanho tamanho){
        super(nome, valorVenda, valorCompra);
        setTamanho(tamanho);
    }
    
    public void setTamanho(Tamanho tamanho){
         this.tamanho = tamanho;  
    }
    
    public Tamanho getTamanho(){
        return tamanho;
    }
    
    @Override
    public String getTipo() {
	return "Roupa: "+getTamanho() ;
    }
}
