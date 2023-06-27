package control;

import Carrinho.Pedido;
import banco.BancoClientes;
import banco.BancoProdutos;
import model.Cliente;
import model.Comun;
import model.Fruta;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;
import model.Roupa;
import util.Tamanho;




public class Caixa{
    private BancoClientes bc;
    private BancoProdutos bp;
    private Pedido p;
    private Lista lista;
    private Fruta fruta;
    private Roupa roupa;
    private Comun comun;
    private PessoaJuridica pessoaJuridica;
    private PessoaFisica pessoaFisica;
    private Cliente c;
    
    public Caixa(){
        bc = new BancoClientes();
        bp = new BancoProdutos();
        lista = new Lista(bc);
    }
    
    
    //metodoPEDIDO
    public void criarPedidoCPF(String nome){
        PessoaFisica pf = bc.retornarPessoaFisicaPeloNome(nome);
        p = new Pedido(bp,pf);
        lista.adicionarPedido(p);
    }
    
    public void listarProdutosPedido(String nomeCliente){
        Pedido pedido = lista.retornarPedidoCPF(nomeCliente);
        pedido.imprimirProdutos();
    }
    
    public void criarPedidoCNPJ(String nome){
        PessoaJuridica pj = bc.retornarCNPJPeloNomeEmpresa(nome);
        p = new Pedido(bp,pj);
        lista.adicionarPedido(p);
    }
    
    public void adicionaProdutoPedido(String nomeCliente,String nomeProduto){
        Pedido pedido = retornarOPedidoPeloNomeCPF(nomeCliente);
        pedido.adicionarProduto(nomeProduto);
    }
    
    public void adicionaProdutoPedidoCNPJ(String nomeCliente,String nomeProduto){
        Pedido pedido = retornarPedidoCNPJNomeEmpresa(nomeCliente);
        pedido.adicionarProduto(nomeProduto);
    }
    
    public Pedido retornarOPedidoPeloNomeCPF(String nome){
          return lista.retornarPedidoCPF(nome);
    }
    
    public Pedido retornarPedidoCNPJNomeEmpresa(String nome){
         return lista.retornarPedidoCNPJNomeEmpresa(nome);
    }
    
    public void removerProdutoPedido(String nomeProduto){
        p.removerProduto(nomeProduto);
    }
    
    public void imprimirTodosOsPedidosCPF(){
     lista.imprimirPedidosCPF();   
    }
    
    public void imprimirTodosOsPedidosCNPJ(){
     lista.imprimirPedidosCNPJ();   
    }
    
    
    public void relatorioPedido(String nome){
        Pedido p = retornarOPedidoPeloNomeCPF(nome);
        System.out.println("Valor Do Pedido: "+ p.getValorDoPedido()+"\t");
        System.out.println("Custo Pedido: "+ p.getValorCusto()+"\t");
        System.out.println("Lucro Pedido: "+ p.getLucro()+"\t");
    }
    
    public void relatorioPedidoCNPJ(String nome){
        Pedido p = retornarPedidoCNPJNomeEmpresa(nome);
        System.out.println("Valor Do Pedido: "+ p.getValorDoPedido()+"\t");
        System.out.println("Custo Pedido: "+ p.getValorCusto()+"\t");
        System.out.println("Lucro Pedido: "+ p.getLucro()+"\t");
    }
    
    //metodos CLINTES
    
    //metodos PF 
    public void adicionarPF(String nome){
        pessoaFisica = new PessoaFisica(nome);
        bc.adicionarClienteCPF(pessoaFisica);
        
    }
    
    public void removerCPF(String nome){
        bc.removerClienteCPF(nome);
        
    }
    
    public void recuperarCPF(String nome){
        bc.recuperarClienteCPF(nome);
        
    }
    
    public PessoaFisica retornarCPF(String nome){
        return bc.retornarPessoaFisicaPeloNome(nome);
    }
    
    public void retornarCPFS(){
        bc.getClientesCPF();
    }
    
    public void listarCPFS(){
        bc.listarClientesCPFS();
    }
    
    //metodos CNPJ
        
    public void adicionarCNPJ(String nomeContato, String NomeEmpresa){
        pessoaJuridica = new PessoaJuridica(nomeContato,NomeEmpresa);
        bc.adicionarClienteCNPJ(pessoaJuridica);
    }
    
    public void deletarCNPJPeloNomeEmpresa(String nome){
        bc.removerCNPJNomeEmpresa(nome);
    
    }
    
    public void recuperarCNPJPeloNomeEmpresa(String nome){
        bc.recuperarCNPJNomeEmpresa(nome);
    }
    
    public PessoaJuridica retornaCNPJPeloNomeEmpresa(String nome){
        return bc.retornarCNPJPeloNomeEmpresa(nome);
    }
    
    public void retornarCNPJS(){
        bc.getClientesCNPJS();
    }
    
    public void listarCNPJS(){
        bc.listarCNPJS();   
    }
    
    //metodos PRODUTOS
    
    public void adicionarFruta(String nome, double venda, double compra){
        fruta =  new Fruta(nome, venda, compra);
        adicionarProduto(fruta);
        
    }
    
    public void adicionarComun(String nome, double venda, double compra){
        comun =  new Comun(nome, venda, compra);
        adicionarProduto(comun);        
    }
    
    public void adicionarRoupa(String nome, double venda, double compra, Tamanho tamanho){
        roupa = new Roupa (nome, venda,compra,tamanho);
        adicionarProduto(roupa);
        
    }
    
    private void adicionarProduto(Produto produto){
        bp.adicionarProduto(produto);
    }
    
    public void listarProdutos(){
        bp.imprimirProdutos();
    }
    
    public void removerProduto(String nomeProduto){
        String nomeProd = nomeProduto.toLowerCase().trim();
        bp.removerProduto(nomeProd);
    }
} 