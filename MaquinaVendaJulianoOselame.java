package senai;

import javax.swing.*;
import java.util.ArrayList;

public class MaquinaVendaJulianoOselame {

    //CADASTRO DO PRODUTO - INICIO
    static ArrayList<String> nomeProduto = new ArrayList<String>();
    static ArrayList<String> categoriaProduto = new ArrayList<String>();
    static ArrayList<String> descricaoProduto = new ArrayList<String>();
    static ArrayList<Double> valorVenda = new ArrayList<Double>();
    static ArrayList<Double> valorCusto = new ArrayList<Double>();
    //CADASTRO DO PRODUTO - FIM

    static StringBuffer listvalorvenda = new StringBuffer();
    static StringBuffer listarProdutos = new StringBuffer();

    static StringBuffer produtosVenda = new StringBuffer();

    //VENDAS - INICIO
    static ArrayList<String> nomeProdutoVendido = new ArrayList<String>();
    static ArrayList<String> categoriaProdutoVendido = new ArrayList<String>();
    static ArrayList<String> descricaoProdutoVendido = new ArrayList<String>();
    static ArrayList<Double> valorVendaVendido = new ArrayList<Double>();
    static ArrayList<Double> valorCustoVendido = new ArrayList<Double>();

    static String produtoVendido = "";
    static String categoriaVendido = "";
    static String descricaoVendido = "";
    static double vendaVendido = 0.0;
    static double custoVendido = 0.0;
    //VENDAS - FIM


    public static void main(String[] args) {

        int opcao = -1;

        String produto = "";
        String categoria = "";
        String descricao = "";

        double novoValorVenda = 0.0;

        double valor = 0.0;
        double custo = 0.0;

        int indice = 0;

        StringBuffer menu = new StringBuffer();
        menu.append("1 para Cadastrar Produto");
        menu.append("\n");
        menu.append("2 para Listar Produtos");
        menu.append("\n");
        menu.append("3 para Alterar Valor do Produto");
        menu.append("\n");
        menu.append("4 para Remover Produto");
        menu.append("\n");
        menu.append("5 para Efetuar Venda de Produto");
        menu.append("\n");
        menu.append("6 para Listar Total de Vendas");
        menu.append("\n");
        menu.append("7 para Listar Total de Lucro");
        menu.append("\n");
        menu.append("0 para Sair");
        menu.append("\n");

        while (opcao != 0) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {

                case 1: //CADASTRAR PRODUTO

                    produto = inputDialog("Digite o nome do novo Produto:");
                    categoria = inputDialog("Digite a Categoria de " + produto);
                    descricao = inputDialog("Digite a Descrição de " + produto);
                    valor = parseDouble("Digite o valor de Venda de " + produto);
                    custo = parseDouble("Digite o Custo de " + produto);

                    cadastrarProduto(produto, categoria, descricao);
                    cadastrarValoresProduto(valor, custo);

                    mensagem("Produto Incluído com Sucesso!!");

                    break;

                case 2: //LISTAR PRODUTOS

                    mensagem(listarProdutos());

                    break;

                case 3: //ALTERAR VALOR DO PRODUTO

                    indice = index("Gostaria de alterar o valor de qual Produto?\n" + listValorVendaAlterar());

                    novoValorVenda = parseDouble("Digite o novo valor de " + nomeProduto.get(indice));

                    valorVenda.set(indice, novoValorVenda);

                    break;

                case 4: //REMOVER PRODUTO

                    indice = jopInt("Escolha o Produto a ser removido \n" + listaProdutosRemover());

                    remProduto(indice);

                    break;

                case 5: //EFETUAR VENDA DE PRODUTO

                    indice = jopInt("Digite o número do Produto que gostaria de Vender:\n" + listProdutosVenda());

                    produtoVendido = nomeProduto.get(indice);
                    categoriaVendido = categoriaProduto.get(indice);
                    descricaoVendido = descricaoProduto.get(indice);
                    vendaVendido = valorVenda.get(indice);
                    custoVendido = valorCusto.get(indice);


                    nomeProdutoVendido.add(produtoVendido);
                    categoriaProdutoVendido.add(categoriaVendido);
                    descricaoProdutoVendido.add(descricaoVendido);
                    valorVendaVendido.add(vendaVendido);
                    valorCustoVendido.add(custoVendido);

                    System.out.println(nomeProdutoVendido);


                    break;

                case 6: //LISTAR TOTAL DE VENDAS

                    double soma = 0.0;

                    for (int i = 0; i < valorVendaVendido.size();i++){
                        soma = soma + valorVendaVendido.get(i); }

                    JOptionPane.showMessageDialog(null, listarVendas() + "\nTOTAL DE VENDAS: R$ " + soma + "\n");

                    break;

                case 7: //LISTAR TOTAL DE LUCRO

                    double lucro = 0.0;
                    double somavenda = 0.0;
                    double somacusto = 0.0;

                    for (int i = 0; i < valorVendaVendido.size();i++){
                        somavenda = somavenda + valorVendaVendido.get(i); }

                    for (int i = 0; i < valorCustoVendido.size();i++){
                        somacusto = somacusto + valorCustoVendido.get(i); }

                        lucro = somavenda - somacusto;

                    JOptionPane.showMessageDialog(null, listarLucro() + "\nTotal de Vendas: R$ " + somavenda +
                            "\nTotal de Custos: " + somacusto + "\n" + "\nTOTAL DE LUCRO: R$ " + lucro + "\n");

                    break;

                case 0: //SAIR

                    JOptionPane.showMessageDialog(null, "Fechando o Programa...");

                    break;

            }
        }

    }


    public static String inputDialog(String mensagem) {
        String retorno = "";
        retorno = JOptionPane.showInputDialog(mensagem);
        return retorno;
    }

    public static void mensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static void cadastrarProduto(String produto, String categoria, String descricao) {
        nomeProduto.add(produto);
        categoriaProduto.add(categoria);
        descricaoProduto.add(descricao);
    }

    public static Double parseDouble(String mensagem) {
        Double numero = 0.0;
        numero = Double.parseDouble(JOptionPane.showInputDialog(mensagem));
        return numero;
    }

    private static void cadastrarValoresProduto(Double valor, Double custo) {
        valorVenda.add(valor);
        valorCusto.add(custo);
    }

    public static String listarProdutos() {
        StringBuffer lista = new StringBuffer();
        lista.append("Lista de Produtos");
        lista.append("\n");
        lista.append("========================");
        lista.append("\n");
        for (int i = 0; i < nomeProduto.size(); i++) {
            lista.append("Nome do Produto: " + nomeProduto.get(i));
            lista.append("\n");
            lista.append("Categoria: " + categoriaProduto.get(i));
            lista.append("\n");
            lista.append("Descrição: " + descricaoProduto.get(i));
            lista.append("\n");
            lista.append("Valor de Venda: " + valorVenda.get(i));
            lista.append("\n");
            lista.append("Custo: " + valorCusto.get(i));
            lista.append("\n");
            lista.append("========================");
            lista.append("\n");
        }
        return lista.toString();
    }

    public static String listarSoNomeProdutos() {
        StringBuffer listaprodutos = new StringBuffer();
        listaprodutos.append("Lista de Produtos");
        listaprodutos.append("\n");
        listaprodutos.append("========================");
        listaprodutos.append("\n");
        for (int i = 0; i < nomeProduto.size(); i++) {
            listaprodutos.append("Nome do Produto: " + nomeProduto.get(i));
            listaprodutos.append("\n");
        }

        return listaprodutos.toString();
    }

    public static String listValorVendaAlterar() {

            listvalorvenda = new StringBuffer();

            for (int i = 0; i < nomeProduto.size(); i++) {
                listvalorvenda.append(i + " - " + nomeProduto.get(i) + " - Valor: R$ " + valorVenda.get(i) + "\n");
            }
            return listvalorvenda.toString();
        }

    public static Integer index(String retorno) {
            Integer numero = 0;
            numero = Integer.parseInt(JOptionPane.showInputDialog(retorno));

            return numero;
            }

         public static void remProduto(Integer indice) {
            nomeProduto.remove(nomeProduto.get(indice));
            categoriaProduto.remove(categoriaProduto.get(indice));
            descricaoProduto.remove(descricaoProduto.get(indice));
            valorVenda.remove(valorVenda.get(indice));
            valorCusto.remove(valorCusto.get(indice));

            jop("Produto excluído com sucesso!");
    }
    public static void jop(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static String listaProdutosRemover() {

        listarProdutos = new StringBuffer();

        for (int i = 0; i < nomeProduto.size(); i++) {
            listarProdutos.append(i + " - " + nomeProduto.get(i));
            listarProdutos.append("\n");
        }


        return listarProdutos.toString();
    }

    public static Integer jopInt(String mensagem) {
            Integer numero = 0;
            numero = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
            return numero;
    }

    public static String listProdutosVenda() {

        produtosVenda = new StringBuffer();

        for (int i = 0; i < nomeProduto.size(); i++) {
            produtosVenda.append("\nProduto Nº: " + i + "\nProduto: " + nomeProduto.get(i) + "\nCategoria:" + categoriaProduto.get(i) +
                    "\nDescrição: " + descricaoProduto.get(i) + "\nValor: R$" + valorVenda.get(i));
            produtosVenda.append("\n");
        }

        return produtosVenda.toString();

    }

    public static String listarVendas() {
        StringBuffer lista = new StringBuffer();
        lista.append("Lista de Vendas");
        lista.append("\n");
        lista.append("========================");
        lista.append("\n");


        for (int i = 0; i < nomeProdutoVendido.size(); i++) {

                lista.append("Produto Vendido: " + nomeProdutoVendido.get(i));
                lista.append("\n");
                lista.append("Valor: R$" + valorVendaVendido.get(i));
                lista.append("\n");
                lista.append("========================");
                lista.append("\n");
            }



        return lista.toString();
    }

    public static String listarLucro() {
        StringBuffer listalucro = new StringBuffer();
        listalucro.append("Lista de Vendas");
        listalucro.append("\n");
        listalucro.append("========================");
        listalucro.append("\n");


        for (int i = 0; i < nomeProdutoVendido.size(); i++) {

            listalucro.append("Produto Vendido: " + nomeProdutoVendido.get(i));
            listalucro.append("\n");
            listalucro.append("Valor de Venda: R$" + valorVendaVendido.get(i));
            listalucro.append("\n");
            listalucro.append("Valor de Custo:  R$" + valorCustoVendido.get(i));
            listalucro.append("\n");
            listalucro.append("========================");
            listalucro.append("\n");
        }
        return listalucro.toString();
    }


        }


