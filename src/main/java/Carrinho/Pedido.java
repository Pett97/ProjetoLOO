package Carrinho;

 
import java.util.ArrayList;
import java.util.List;

import banco.BancoProdutos;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class Pedido {
   private BancoProdutos bancoProdutos;
   private Cliente cliente;
   private ArrayList<Produto> produtosPedido;
   private PessoaFisica pessoaFisica;
   private PessoaJuridica pessoaJuridica;
  
   public Pedido(BancoProdutos bancoProdutos,PessoaFisica pessoaFisica) {
       this.bancoProdutos = bancoProdutos;
       this.pessoaFisica = pessoaFisica;
       this.produtosPedido = new ArrayList<>();
   }
   
   public Pedido(BancoProdutos bancoProdutos,PessoaJuridica pessoaJuridica) {
       this.bancoProdutos = bancoProdutos;
       this.pessoaJuridica = pessoaJuridica;
       this.produtosPedido = new ArrayList<>();
   }
   
   public PessoaJuridica getPessoaJuridica(){
       return pessoaJuridica;
   }
   
   public PessoaFisica getPessoaFisica(){
       return pessoaFisica;
   }
   
   public String getNomeCliente(){
       return pessoaFisica.getNome();
   }

   public void adicionarProduto(String nomeProduto) {
       Produto produto = bancoProdutos.obterProdutoPorNome(nomeProduto);
       if (produto != null) {
           produtosPedido.add(produto);
           System.out.println("PRODUTO adicionado: "+produto.getNome());
       } else {
           System.out.println("Produto não encontrado no banco de produtos.");
       }
   }

   public void removerProduto(String nomeProduto) {
       for (Produto produto : produtosPedido) {
           if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
               produtosPedido.remove(produto);
               System.out.println("Produto removido do pedido: " + produto.getNome());
               return;
           }
       }
       System.out.println("Produto não encontrado no pedido.");
   }

   public void imprimirProdutos() {
       if (produtosPedido.isEmpty()) {
           System.out.println("O pedido está vazio.");
       } else {
           System.out.println("Produtos do pedido:");
           for (Produto produto : produtosPedido) {
               System.out.println(produto.getNome());
           }
       }
   }

   public double getValorDoPedido() {
       double total = 0;
       for (Produto produto : produtosPedido) {
           total += produto.getValorVenda();
       }
       return total;
   }

   public double getValorCusto() {
       double total = 0;
       for (Produto produto : produtosPedido) {
           total += produto.getValorCompra();
       }
       return total;
   }

   public double getLucro() {
       return getValorDoPedido() - getValorCusto();
   }

   public void processarPedido() {
       Thread thread = new Thread(new Runnable() {
           public void run() {
               enviarEmailConfirmacao();
           }
       });

       thread.start();

       System.out.println("Pedido em processamento. Aguarde o e-mail de confirmação.");
   }

   private void enviarEmailConfirmacao() {
       try {
           Thread.sleep(2000);
           System.out.println("E-mail de confirmação enviado.");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}

