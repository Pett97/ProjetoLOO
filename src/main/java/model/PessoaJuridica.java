package model;


public class PessoaJuridica implements Cliente{
     
    private String nome;
    private String nomeEmpresa;
    
    
    public PessoaJuridica(String nome, String nomeEmpresa){
        setNome(nome);
        setNomeEmpresa(nomeEmpresa);
    }
    
    public void setNomeEmpresa(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa.toUpperCase().trim();
    }
    
    public String getNomeEmpresa(){
        return nomeEmpresa;
    }
    
    public void setNome(String nome){
        this.nome = nome.toUpperCase().trim();
    }
    
    public String getNome(){
        return nome;
    }
    
    @Override
    public double desconto(){
        return 0.10;
    }
}