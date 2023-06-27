package model;

public class Fruta extends Produto{
   
    
    
    
    public Fruta (String nome, double valorVenda, double valorCompra){
        super(nome, valorVenda, valorCompra);
    }
    
    @Override
    public String getTipo() {
	return "Fruta";
    }
}
