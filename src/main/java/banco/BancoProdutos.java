/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.ArrayList;

import java.util.List;
import model.Produto;



public class BancoProdutos{
    
    private ArrayList<Produto> produtos;

    
    public BancoProdutos(){
         produtos = new ArrayList<>();
    }
    
        
    public void imprimirProdutos(){

        if(produtos.size() == 0 ){
            System.out.println("Nao ha produtos no pedido");
        }
        String aux = "";
        for(Produto produto : produtos){
            aux +="PRODUTO: "+produto.getNome()+"\t";
            aux +="VALOR VENDA: "+produto.getValorVenda()+"\t";
            aux +="VALOR COMPRA: "+produto.getValorCompra()+"\t";
            aux +="Tipo: "+produto.getTipo()+"\t";
            aux +="\n";
        }
        System.out.println(aux);
    }
    
    public Produto obterProdutoPorNome(String nomeProduto){
        String nomeProd = nomeProduto.toLowerCase().trim();
        for(Produto produto :produtos){
            if(produto.getNome().trim().equals(nomeProd)){
                return produto;
            }
            return null;
        }
        return null;
    }
    
    public ArrayList<Produto> retorna(){
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(String nome) {
        nome = nome.toLowerCase();
        List<Produto> produtosARemover = new ArrayList<>();

        for (Produto produto : produtos) {
            if (nome.equals(produto.getNome())) {
                produtosARemover.add(produto);
            }
        }

        produtos.removeAll(produtosARemover);
    }
}
