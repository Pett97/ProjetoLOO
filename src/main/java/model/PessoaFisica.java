package model;

public class PessoaFisica implements Cliente{
    private String nome;
    
    
    public PessoaFisica(String nome){
        setNome(nome);
    }
    
    public void setNome(String nome){
        this.nome = nome.toUpperCase().trim();
    }
    
    public String getNome(){
        return nome;
    }
    
    @Override
    public double desconto(){
        return 0.5;
    }
}