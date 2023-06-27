package model;

public class Comun extends Produto{
    
    
    
    
    public Comun (String nome, double valorVenda, double valorCompra){
        super(nome, valorVenda, valorCompra);
    }
    
    @Override
    public String getTipo() {
	return "Comun";
    }
}