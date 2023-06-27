package view;

import java.util.Scanner;

import control.Caixa;
import util.MinhaExcecao;
import util.Tamanho;
import java.util.Scanner;

public class InterfaceTexto {
    private static final String SAIR = "sair";

    private Scanner entrada;
    private String opcao;

    private Caixa caixa;

    public InterfaceTexto() {
        entrada = new Scanner(System.in);
        caixa = new Caixa();
    }

    public void renderizar() throws MinhaExcecao {
        do {
            limpar();
            menuInicial();
            //leiaVerifique();
        } while(!opcao.equals(SAIR));
    }

    public void menuInicial() throws MinhaExcecao {
        limpar();
        sln("MENU INICIAL ");
        sln("1 GERENCIAR PRODUTOS");
        sln("2 GERENCIAR CLIENTES");
        sln("3 GERENCIAR PEDIDOS");
        opcaoMenuInicial();
    }

    private void opcaoMenuInicial() throws MinhaExcecao {
        opcao = leia("Digite a opção escolhida do Menu Inicial");
        switch(opcao){
            case "1":
                gerenciarProduto();
                break;
            case "2":
                gerenciarClientes();
                break;
            case "3":
                gerenciarPedidos();
                break;
        }
    }

    //Gerenciar PEDIDOS
    public void gerenciarPedidos(){
        limpar();
        sln("GERENCIADOR DE PEDIDOS");

        sln("1 Adicioanar PEDIDO CPF");
        sln("2 Adicionar PEDIDO CNPJ");
        sln("-----------------------");
        sln();
        sln("3    Editar Pedido     ");
        sln();
        sln("-----------------------");
        sln("                       ");
        sln("4 Remover Pedido CPF   ");
        sln("5 Remover Pedido CNPJ  ");
        sln("6 Mostrar Pedidos CPF + CNPJ ");
        sln("7 Voltar ");
        menuGerenciarPedido();
    }

    private void menuGerenciarPedido(){
        opcao = leia("DIGITE a opçao para Gerenciar Clientes CPJ CNPJ");
        switch(opcao){
            case "1":
                criarPedidoCPF();
                break;
            case "2":
                criarPedidoCNPJ();
                break;
            case "3":
                adicionarProdutoAoPedido();
                break;    
            case "7":
                try
                {

                    menuInicial();
                }
                catch (MinhaExcecao me)
                {
                    me.printStackTrace();
                }
                break;
        }
    }
    
    private void adicionarProdutoAoPedido(){
        limpar();
        sln("Qual Tipo de Pedido vai Editar");
        sln(" Adicionar Produtos ");
        sln("1 - para CPF");
        sln("2 - para CNPJ");
        sln("Remover Produtos ");
        sln("3 - Remover Produto de CPF");
        sln("4 - Remover Para CNPJ");
        sln("------------------------------");
        sln("6 - Lucro Pedido CPF ");
        sln("------------------------------");
        sln("7 - Voltar");
        sleep(2000);
        menuSelecaoTipoPedido();
    }
    
    
    private void menuSelecaoTipoPedido(){
        opcao = leia("Digite o TIPO ");
        switch(opcao){
            case "1":
                adicionarTipoPedidoCPF();
                break;
            case "2":
                adicionarTipoPedidoCNPJ();
                break;
            case "3":
                retiraProdutoDoPedidoCPF();
                break;
            case "6":
                relatorioPedidoCPF();
                break;    
                
            case "7":
                try
                {

                    menuInicial();
                }
                catch (MinhaExcecao me)
                {
                    me.printStackTrace();
                }
                break;
        }
    }
    
    //metodos pedido CPF
    
    private void criarPedidoCPF(){
        String nomeDoCliente = leia("Digite o nome do Cliente para esse pedido");
        sln("processando");
        sleep(2000);
        caixa.criarPedidoCPF(nomeDoCliente);
        gerenciarPedidos();
    }

    //adiciona Produto ao  pedido tipo CPF
    private void adicionarTipoPedidoCPF(){
        limpar();
        sln("LISTANDO PEDIDO CPF");
        sleep(2000);
        caixa.imprimirTodosOsPedidosCPF();
        String nome = leia("Digite o nome Do Cliente que deseja editar");
        limpar();
        sln("LISTANDO PRODUTOS NO ESTOQUE");
        sleep(1000);
        caixa.listarProdutos();
        sleep(1000);
        String nomeProduto = leia("Digite o nome do Produto que deseja adicionar");
        caixa.adicionaProdutoPedido(nome, nomeProduto);
        sleep(1000);
        gerenciarPedidos();
    }
    
    
    private void retiraProdutoDoPedidoCPF(){
        limpar();
        sln("LISTANDO PEDIDO CPF");
        sleep(2000);
        caixa.imprimirTodosOsPedidosCPF();
        String nome = leia("Digite o nome Do Cliente que deseja editar");
        limpar();
        sln("LISTANDO PRODUTOS Desse Pedido ");
        sleep(1000);
        caixa.listarProdutosPedido(nome);
        sleep(1000);
        String nomeProduto = leia("Digite o nome do Produto que deseja remover");
        caixa.removerProdutoPedido(nomeProduto);
        sleep(1000);
        gerenciarPedidos();
    }
    
    private void relatorioPedidoCPF(){
        limpar();
        sln("LISTANDO PEDIDO CPF");
        sleep(2000);
        caixa.imprimirTodosOsPedidosCPF();
        String nome = leia("Digite o nome Do Cliente que deseja editar");
        limpar();
        caixa.relatorioPedido(nome);
        pause();
        gerenciarPedidos();
    }
    
    //metodo PedidoCNPj
    
     private void criarPedidoCNPJ(){
        String nomeEmpressa = leia("Digite Nome Da Empressa");
        sleep(2000);
        caixa.criarPedidoCNPJ(nomeEmpressa);
        gerenciarPedidos();
    }
    
    private void adicionarTipoPedidoCNPJ(){
        limpar();
        sln("LISTANDO PEDIDO CNPJ");
        sleep(2000);
        caixa.imprimirTodosOsPedidosCNPJ();
        String nome = leia("Digite o nome Da Empressa que deseja editar");
        sleep(1000);
        String nomeProduto = leia("Digite o nome do Produto que deseja adicionar");
        caixa.adicionaProdutoPedidoCNPJ(nome, nomeProduto);
        gerenciarPedidos();
    }
    
    private void retiraProdutoDoPedidoCNPJ(){
        limpar();
        sln("LISTANDO PEDIDO CNPJ");
        sleep(2000);
        caixa.imprimirTodosOsPedidosCNPJ();
        String nome = leia("Digite o nome Da Empressa que deseja editar");
        limpar();
        sln("LISTANDO PRODUTOS Desse Pedido ");
        sleep(1000);
        caixa.listarProdutosPedido(nome);
        sleep(1000);
        String nomeProduto = leia("Digite o nome do Produto que deseja remover");
        caixa.removerProdutoPedido(nomeProduto);
        sleep(1000);
        gerenciarPedidos();
    }
    
    private void relatorioPedidoCNPJ(){
        limpar();
        sln("LISTANDO PEDIDO CNPJ");
        sleep(2000);
        caixa.imprimirTodosOsPedidosCNPJ();
        String nome = leia("Digite o nome Da Empressa que deseja editar");
        limpar();
        caixa.relatorioPedidoCNPJ(nome);
        pause();
        gerenciarPedidos();
    }
    

    // gerenciar Clientes
    private  void gerenciarClientes(){
        limpar();
        sln("GERENCIADOR DE CLIENTES");
        sln("1 GERENCIAR CPF");
        sln("2 GERENCIAR CNPJ");
        sln("3 LISTAR TODOS CPF e CNPJ ");
        sln("4 Voltar");
        menuGerenciarClientes();
    }

    private void menuGerenciarClientes(){
        opcao = leia("DIGITE a opçao para Gerenciar Clientes CPJ CNPJ");
        switch(opcao){
            case "1":
                gerenciadorCPF();
                break;
            case "2":
                gerenciadorCNPJ();
            case "3":
                listarTodos();
            case "4":
                try
                {
                    menuInicial();
                }
                catch (MinhaExcecao me)
                {
                    me.printStackTrace();
                }
                break;    
        }
    }

    public void listarTodos(){}

    //Metodos CPF
    
    private void gerenciadorCPF(){
        limpar();
        sln("   GERENCIADOR CPF");
        sln("   1 Para Adicionar ");
        sln("   2 Para Remover   ");
        sln("   3 Para Listar    ");
        sln("   4 voltar         ");
        menuGerenciadorCPF();
    }

    private void menuGerenciadorCPF(){
        opcao = leia("DIGITE a opçao para Gerenciar Clientes CPF");
        switch(opcao){
            case "1":
                adicionarCPF();
                break;
            case "2":
                removerCPF();
                break;
            case "3":
                listarCPF();
                break;
            case "4":
                gerenciarClientes();
                break;    
            default:
                sln("opcao inválida!");
                gerenciarClientes();
                break;    
        }
    }

    private void adicionarCPF(){
        String nome = leia("Digite o NOME para o CPF");
        caixa.adicionarPF(nome);
        sln("CPF ADICIONADO COM SUCESSO");
        gerenciadorCPF();
    }

    private void removerCPF(){
        String nome = leia("Digite o NOME para remover CPF");
        caixa.removerCPF(nome);
        sln("Cliente REMOVIDO");
        gerenciadorCPF();
    }

    private void listarCPF(){
        caixa.listarCPFS();
        pause();
        gerenciarClientes();
    }

    //gerenciador de CNPJ
    private void gerenciadorCNPJ(){
        limpar();
        sln("GERENCIADOR CNPJ");
        sln("1 Adicionar");
        sln("2 Remover Pelo Nome Empressa");
        sln("3 Listar Empressa");
        sln("4 Voltar");
        menuGerenciadorCNPJ();
    }

    private void menuGerenciadorCNPJ(){
        opcao = leia("DIGITE a opçao para Gerenciar Clientes CNPJ ");
        switch(opcao){
            case "1":
                adicionarCNPJ();
                break;
            case "2":
                removerCNPJ();
                break;
            case "3":
                listarCNPJ();
                break;
                case"4":
                gerenciarClientes();
                break; 
            default:
                sln("opcao inválida!");
                gerenciarClientes();;
                break;    
        }
    }

    private void adicionarCNPJ(){
        String nomeContato = leia("Digite nome do contato CNPJ");
        String nomeEmpresa = leia("Digite nome da Empressa CNPJ");
        caixa.adicionarCNPJ(nomeContato,nomeEmpresa);
        sln("Empressa Adicionada");
        gerenciadorCNPJ();
    }

    private void removerCNPJ(){
        String nomeEmpresa = leia("Digite nome da Empressa CNPJ");
        caixa.deletarCNPJPeloNomeEmpresa(nomeEmpresa);
        sln("Empressa Removida");
    }

    private void listarCNPJ(){
        caixa.listarCNPJS();
        pause();
        gerenciadorCNPJ();
    }


    // gerenciar produtos 

    private void gerenciarProduto() throws MinhaExcecao {
        limpar();
        sln("GERNECIAR PRODUTOS");
        sln("1 ADICIONAR FRUTA ");
        sln("2 ADICIONAR COMUN ");
        sln("3 ADICIONAR ROUPA ");
        sln("4 LISTAR PRODUTOS DO BANCO");
        sln("5 REMOVER PRODUTO ");
        opcaoMenuProduto();
    }

    private void opcaoMenuProduto() throws MinhaExcecao {
        opcao = leia("Digite o numero do produto que deseja Adicionar");
        switch(opcao){
            case "1":
                try {
                    adicionarFruta();
                } catch (MinhaExcecao e) {
                    sln("Erro: " + e.getMessage());
                }
                break;
            case "2":
                try {
                    adicionarComun();
                } catch (MinhaExcecao e) {
                    sln("Erro: " + e.getMessage());
                }
                break;
            case "3":
                try {
                    adicionarRoupa();
                } catch (MinhaExcecao e) {
                    sln("Erro: " + e.getMessage());
                }
                break;
            case "4":
                listarProdutos();
                break;
            case "5":
                removerProduto();
                break;
            default:
                sln("opcao inválida!");
                gerenciarProduto();
                break;
        }
    }

    private void adicionarFruta() throws MinhaExcecao{
        String nomeFruta = leia("Digite o nome da Fruta");
        String vVenda = leia ("Digite o valor da Venda");
        String vCompra = leia("Digite o valor da Compra");

        double valorVenda;
        double valorCompra;
        try {
            valorVenda = Double.parseDouble(vVenda);
            valorCompra = Double.parseDouble(vCompra);
            caixa.adicionarFruta(nomeFruta,valorVenda,valorCompra);
            sln("Produto Cadastrado com Sucesso aguarde a tela");
            Thread.sleep(2000);
        } catch (NumberFormatException e) {
            throw new MinhaExcecao("PRODUTO NAO FOI SALVO, NAO USAR  \",\" nos valores  RECADASTRE!!!");
        }
        catch(InterruptedException e ){

        }
        menuInicial();
    }

    private void adicionarComun() throws MinhaExcecao{
        String nome = leia("Digite o nome do Produto");
        String vVenda = leia ("Digite o valor da Venda");
        String vCompra = leia("Digite o valor da Compra");
        double valorVenda;
        double valorCompra;
        try {
            valorVenda = Double.parseDouble(vVenda);
            valorCompra = Double.parseDouble(vCompra);
            caixa.adicionarComun(nome,valorVenda,valorCompra);
            sln("Produto Cadastrado com Sucesso aguarde a tela");
            Thread.sleep(2000);
        } catch (NumberFormatException e) {
            throw new MinhaExcecao("PRODUTO NAO FOI SALVO, NAO USAR  \",\" nos valores  RECADASTRE!!!");
        }catch(InterruptedException e ){

        }
        menuInicial();
    }

    private void adicionarRoupa() throws MinhaExcecao {
        String nome = leia("Digite o nome da Roupa");
        String vVenda = leia("Digite o valor de venda");
        String vCompra = leia("Digite o valor de compra");
        double valorVenda;
        double valorCompra;

        try {
            Tamanho tamanho = solicitarTamanho();
            valorVenda = Double.parseDouble(vVenda);
            valorCompra = Double.parseDouble(vCompra);
            caixa.adicionarRoupa(nome, valorVenda,valorCompra,tamanho);
            sln("Produto Cadastrado com Sucesso aguarde a tela");
            Thread.sleep(2000);
        } catch (NumberFormatException e) {
            throw new MinhaExcecao("PRODUTO NAO FOI SALVO, NAO USAR  \",\" nos valores  RECADASTRE!!!");
        } catch(InterruptedException e ){

        }
        menuInicial();
    }

    private Tamanho solicitarTamanho() {
        String tamanhoStr = leia("Digite o tamanho (P, M, G):");
        Tamanho tamanho;

        switch (tamanhoStr.toUpperCase()) {
            case "P":
                tamanho = Tamanho.P;
                break;
            case "M":
                tamanho = Tamanho.M;
                break;
            case "G":
                tamanho = Tamanho.G;
                break;
            default:
                sln("Tamanho inválido! Tamanho definido como P.");
                tamanho = Tamanho.P;
                break;
        }

        return tamanho;
    } 

    private void listarProdutos(){
        caixa.listarProdutos();
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        pause();
        try
        {
            menuInicial();
        }
        catch (MinhaExcecao me)
        {
            me.printStackTrace();
        }
    }

    private void removerProduto(){
        String nomeProduto = leia("Digite o nome Produto para remover").toLowerCase().trim();
        caixa.removerProduto(nomeProduto);
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        pause();
        try
        {
            menuInicial();
        }
        catch (MinhaExcecao me)
        {
            me.printStackTrace();
        }
    }

    //metodos da interface 
    private void pause() {
        sln();
        sln("Pressione a tecla enter para continuar..");
        entrada.nextLine();
    }

    private String leia(String s) {
        sln(s);
        s("> ");
        return entrada.nextLine().trim();
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void limpar() {
        s("\f");               // Limpa terminal do Bluej
        //s("\033[H\033[2J");  // Limpa terminal do Linux
        //System.out.flush();  // Limpa terminal linux
    }

    private void sln() {
        System.out.println();
    }

    private void sln(String s) {
        System.out.println(s);
    }

    private void s(String s) {
        System.out.print(s);
    }
}