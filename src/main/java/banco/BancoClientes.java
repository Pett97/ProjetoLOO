package banco;

import java.util.List;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class BancoClientes{

    //arrayComuns
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesDeletados;

    //arrayCPF
    private ArrayList<PessoaFisica> clientesCPF;
    private ArrayList<PessoaFisica> clientesDeletadosCPF;

    //ArrayCNPj
    private ArrayList<PessoaJuridica> clientesCNPJ;
    private ArrayList<PessoaJuridica> clientesDeletadosCNPJ;

    public BancoClientes(){
        clientes = new ArrayList<>();
        clientesDeletados = new ArrayList<>();
        //CPF
        clientesCPF = new ArrayList<>();
        clientesDeletadosCPF = new ArrayList<>();
        //CNPJ
        clientesCNPJ = new ArrayList<>();
        clientesDeletadosCNPJ = new ArrayList<>();

    }
    
    
    
    
    //metodos CNPJ

    public void adicionarClienteCNPJ(PessoaJuridica pessoaJuridica) {
        clientesCNPJ.add(pessoaJuridica);
        
        clientes.add(pessoaJuridica);
    }

    public ArrayList<PessoaJuridica> getClientesCNPJ() {
        return clientesCNPJ;
    }
    
    public ArrayList<PessoaJuridica> getClientesDeletadosCNPJ() {
        return clientesDeletadosCNPJ;
    }

    public void removerCNPJNomeEmpresa(String nome){
        String nomeCNPJ = nome.toUpperCase().trim();

        Iterator<PessoaJuridica> it = clientesCNPJ.iterator();
        while(it.hasNext()){
            PessoaJuridica pessoaJuridica = it.next();
            if(nomeCNPJ.equals(pessoaJuridica.getNomeEmpresa())){
                it.remove();
                clientesDeletadosCNPJ.add(pessoaJuridica);
                clientesDeletados.add(pessoaJuridica);
                clientesCNPJ.remove(pessoaJuridica);
                clientes.remove(pessoaJuridica);
            }
        }
    }

    public void recuperarCNPJNomeEmpresa(String nome){
        String nomeCNPJ = nome.toUpperCase().trim();

        Iterator<PessoaJuridica> it = clientesDeletadosCNPJ.iterator();
        while(it.hasNext()){
            PessoaJuridica pessoaJuridica = it.next();
            if(nomeCNPJ.equals(pessoaJuridica.getNomeEmpresa())){
                clientesCNPJ.add(pessoaJuridica);
                clientes.add(pessoaJuridica);
                clientesDeletadosCNPJ.remove(pessoaJuridica);
                clientesDeletadosCNPJ.remove(pessoaJuridica);
            }
        }
    }

    public PessoaJuridica retornarCNPJPeloNomeEmpresa(String nome) {
        String nomeCNPJ = nome.toUpperCase().trim();

        for (PessoaJuridica pessoaJuridica : clientesCNPJ) {
            if (nomeCNPJ.equals(pessoaJuridica.getNomeEmpresa())) {
                return pessoaJuridica;
            }
        }
        
        return null;
    }

    
    
    public ArrayList getClientesCNPJS(){
        return clientesCNPJ;
    }
    
    public void listarCNPJS(){
        if(clientesCNPJ.size() == 0 ){
            System.out.println("Nao ha CLIENTES CNPJ PARA LISTAR");
        }
        String aux = "";
        for(PessoaJuridica pessoaJuridica: clientesCNPJ){
            aux+="NOME Contato: "+pessoaJuridica.getNome()+"\t";
            aux+="NOME Empressa: "+pessoaJuridica.getNomeEmpresa()+"\t";
            aux +="\n";
        }
        System.out.println(aux);
    
    }
    
    //metodos CPF

    public void adicionarClienteCPF(PessoaFisica pessoaFisica){
        clientesCPF.add(pessoaFisica);
        clientes.add(pessoaFisica);
    }

    public void removerClienteCPF(String nome){
        String nomeAjustado = nome.toUpperCase().trim();
        Iterator<PessoaFisica>it  = clientesCPF.iterator();
        while(it.hasNext()){
            PessoaFisica pessoaFisica = it.next();
            if(nomeAjustado.equals(pessoaFisica.getNome())){
                it.remove();
                clientesDeletados.add(pessoaFisica);
                clientesDeletadosCPF.add(pessoaFisica);
                clientesCPF.remove(pessoaFisica);
                clientes.remove(pessoaFisica);
            }
        }
    }

    public void recuperarClienteCPF(String nome){
        String nomeAjustado = nome.toUpperCase().trim();
        Iterator<PessoaFisica>it  = clientesDeletadosCPF.iterator();
        while(it.hasNext()){
            PessoaFisica pessoaFisica = it.next();
            if(nomeAjustado.equals(pessoaFisica.getNome())){
                it.remove();
                clientes.add(pessoaFisica);
                clientesCPF.add(pessoaFisica);
                clientesDeletadosCPF.remove(pessoaFisica);
                clientesDeletados.remove(pessoaFisica);
            }
        }
    }

    public PessoaFisica retornarPessoaFisicaPeloNome(String nome){
        String nomeAjustado = nome.toUpperCase().trim();
        Iterator<PessoaFisica>it  = clientesCPF.iterator();
        while(it.hasNext()){
            PessoaFisica pessoaFisica = it.next();
            if(nomeAjustado.equals(pessoaFisica.getNome())){
                return pessoaFisica;
            }
        }
        return null;
    }
    
    public void listarClientesCPFS(){
        if(clientesCPF.size() == 0 ){
            System.out.println("Nao ha CLIENTES CPF PARA LISTAR");
            
        }
        String aux = "";
        for(PessoaFisica pessoaFisica: clientesCPF){
            aux+="NOME: "+pessoaFisica.getNome()+"\t";
            aux +="\n";
        }
        System.out.println(aux);
    }
    
    public ArrayList getClientesCPF(){
        return clientesCPF;   
    }
    
    //ambos 
    public ArrayList getClientesDeletados(){
        return clientesDeletados;   
    }
    
    public ArrayList getClientes(){
        return clientes;   
    }


}