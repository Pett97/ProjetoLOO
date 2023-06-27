package control;

import java.util.ArrayList;
import java.util.Iterator;

import Carrinho.Pedido;
import banco.BancoClientes;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Cliente;




public class Lista{
    private ArrayList<Pedido> pedidos;
    private BancoClientes bc;
    public Lista(BancoClientes bc){
        pedidos = new ArrayList<>();
        this.bc = bc;
    }

    public ArrayList getPedidos(){
        return pedidos;
    }

    public Pedido retornarPedidoCPF(String nome){
        PessoaFisica pf = bc.retornarPessoaFisicaPeloNome(nome);
        if (pf != null) {
            for (Pedido pedido : pedidos) {
                if (pedido.getPessoaFisica() == pf) {
                    return pedido;
                }
            }
        }
        return null;
    }

    public Pedido retornarPedidoCNPJNomeEmpresa(String nome){
        PessoaJuridica pj = bc.retornarCNPJPeloNomeEmpresa(nome);

        for ( Pedido pedido : pedidos){
            if(pedido.getPessoaJuridica() == pj){
                return pedido;
            }
        }
        return null;
    }

    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);  
    }

    public void removerPedidoCPFPorNomeCliente(String nome){
        Cliente cliente =  bc.retornarPessoaFisicaPeloNome(nome);
        pedidos.remove(cliente);
    }

    public void removerPedidoCNPJNomeEmpresa(String nome){
        Cliente cliente = bc.retornarCNPJPeloNomeEmpresa(nome);
        pedidos.remove(cliente);
    }

    public void imprimirPedidosCPF(){
        if (pedidos.size() == 0) {
            System.out.println("Não há pedidos para listar.");
            return;
        }

        System.out.println("Pedidos:");
        for (Pedido pedido : pedidos) {
            PessoaFisica pessoaFisica = pedido.getPessoaFisica();
            String nomeCliente = pessoaFisica.getNome();
            System.out.println("Nome do cliente: " + nomeCliente);
        }
    }

    public void imprimirPedidosCNPJ(){
        if (pedidos.size() == 0) {
            System.out.println("Não há pedidos para listar.");
            return;
        }

        System.out.println("Pedidos:");
        for (Pedido pedido : pedidos) {
            PessoaJuridica pessoaJuridica = pedido.getPessoaJuridica();
            String nomeCliente = pessoaJuridica.getNomeEmpresa();
            System.out.println("Nome do cliente: " + nomeCliente);
        }
    }

}