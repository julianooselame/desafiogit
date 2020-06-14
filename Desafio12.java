package senai;

        import javax.swing.*;
        import java.util.ArrayList;
        import java.util.Collections;

public class Desafio12 {

    static ArrayList<String> nomesFuncionario = new ArrayList<String>();
    static ArrayList<String> emailsFuncionario = new ArrayList<String>();
    static ArrayList<String> celularesFuncionario = new ArrayList<String>();
    static ArrayList<String> enderecosFuncionario = new ArrayList<String>();

    static ArrayList<String> nomesCliente = new ArrayList<String>();
    static ArrayList<String> emailsCliente = new ArrayList<String>();
    static ArrayList<String> celularesCliente = new ArrayList<String>();
    static ArrayList<String> enderecosCliente = new ArrayList<String>();
    static ArrayList<String> servicosVendidos = new ArrayList<String>();

    static ArrayList<String> servicos = new ArrayList<String>();
    static ArrayList<String> precos = new ArrayList<String>();

    static StringBuffer listFuncionarios = new StringBuffer();
    static StringBuffer listClientes = new StringBuffer();
    static StringBuffer listServicos = new StringBuffer();

    static String servicoVendido = "";



    public static void main(String[] args) {

        String nomeFuncionario = "";
        String emailFuncionario = "";
        String celularFuncionario = "";
        String enderecoFuncionario = "";

        String nomeCliente = "";
        String emailCliente = "";
        String celularCliente = "";
        String enderecoCliente = "";

        String servico = "";
        String preco = "";

        int opcao = -1;
        int opcao2 = -1;
        int opcao3 = -1;
        int opcao4 = -1;

        int indice = 0;
        int indice2 = 0;

        String novoNomeFuncionario = "";
        String novoEmailFuncionario = "";
        String novoCelularFuncionario = "";
        String novoEnderecoFuncionario = "";

        String novoNomeCliente = "";
        String novoEmailCliente = "";
        String novoCelularCliente = "";
        String novoEnderecoCliente = "";

        String novoServico = "";
        String novoPreco = "";

        StringBuffer menu = new StringBuffer();
        menu.append("1 - Adicionar Funcionario");
        menu.append("\n");
        menu.append("2 - Alterar dados do Funcionario");
        menu.append("\n");
        menu.append("3 - Listar Funcionarios");
        menu.append("\n");
        menu.append("4 - Adicionar Cliente");
        menu.append("\n");
        menu.append("5 - Alterar dados do Cliente");
        menu.append("\n");
        menu.append("6 - Listar Clientes");
        menu.append("\n");
        menu.append("7 - Adicionar Serviço");
        menu.append("\n");
        menu.append("8 - Alterar dados do Serviço");
        menu.append("\n");
        menu.append("9 - Listar Serviços");
        menu.append("\n");
        menu.append("10 - Efetuar vendas para o cliente");
        menu.append("\n");
        menu.append("11 - Listar Vendas");
        menu.append("\n");
        menu.append("0 - Sair");

        while (opcao != 0) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));


            switch (opcao) {
                case 1: //Adicionar Funcionario
                    nomeFuncionario = jopStr("Digite o nome do Funcionário");
                    emailFuncionario = jopStr("Digite o Email de "+nomeFuncionario);
                    celularFuncionario = jopStr("Digite o celular de "+nomeFuncionario);
                    enderecoFuncionario = jopStr("Digite o endereço de "+nomeFuncionario);

                    addFuncionario(nomeFuncionario, emailFuncionario, celularFuncionario, enderecoFuncionario);

                    break;

                case 2: //Alterar Dados do Funcionario

                    StringBuffer menu2 = new StringBuffer();
                    menu2.append("Qual dado gostaria de alterar?");
                    menu2.append("\n");
                    menu2.append("1 - Alterar Nome do Funcionário");
                    menu2.append("\n");
                    menu2.append("2 - Alterar E-Mail do Funcionário");
                    menu2.append("\n");
                    menu2.append("3 - Alterar Celular do Funcionário");
                    menu2.append("\n");
                    menu2.append("4 - Alterar Endereço do Funcionário");
                    menu2.append("\n");


                    opcao2 = Integer.parseInt(JOptionPane.showInputDialog(menu2));


                    switch (opcao2) {


                        case 1: // Alterar nome Funcionario

                            indice = index("Digite o número do Funcionário que deseja alterar\n" + listFuncionariosAlterar());

                            novoNomeFuncionario = jopStr("Digite o novo nome do Funcionário:");

                            nomesFuncionario.set(indice, novoNomeFuncionario);

                            jop("Nome alterado com sucesso!!");

                            break;

                        case 2: //E-mail Funcionario

                            indice = index("Digite o número do Funcionário que deseja alterar\n" + listFuncionariosAlterar());

                            novoEmailFuncionario = jopStr("Digite o novo E-mail do Funcionário:");

                            emailsFuncionario.set(indice, novoEmailFuncionario);

                            jop("E-mail alterado com sucesso!!");

                            break;

                        case 3: //Celular Funcionario

                            indice = index("Digite o número do Funcionário que deseja alterar\n" + listFuncionariosAlterar());

                            novoCelularFuncionario = jopStr("Digite o novo E-mail do Funcionário:");

                            celularesFuncionario.set(indice, novoCelularFuncionario);

                            jop("Celular alterado com sucesso!!");

                            break;

                        case 4: //Endereço Funcionario

                            indice = index("Digite o número do Funcionário que deseja alterar\n" + listFuncionariosAlterar());


                            novoEnderecoFuncionario = jopStr("Digite o novo Endereço do Funcionário:");

                            enderecosFuncionario.set(indice, novoEnderecoFuncionario);

                            jop("Endereco alterado com sucesso!!");

                            break;

                    }

                    break;

                case 3: //Listar Funcionarios

                    jop(listarFuncionarios());

                    break;

                case 4: //Adicionar Clientes

                    nomeCliente = jopStr("Digite o nome do Cliente");
                    emailCliente = jopStr("Digite o Email de "+nomeCliente);
                    celularCliente = jopStr("Digite o celular de "+nomeCliente);
                    enderecoCliente = jopStr("Digite o endereço de "+nomeCliente);

                    addCliente(nomeCliente, emailCliente, celularCliente, enderecoCliente);

                    break;

                case 5: //Alterar dados do CLiente

                    StringBuffer menu3 = new StringBuffer();
                    menu3.append("Qual dado gostaria de alterar?");
                    menu3.append("\n");
                    menu3.append("1 - Alterar Nome do Cliente");
                    menu3.append("\n");
                    menu3.append("2 - Alterar E-Mail do Cliente");
                    menu3.append("\n");
                    menu3.append("3 - Alterar Celular do Cliente");
                    menu3.append("\n");
                    menu3.append("4 - Alterar Endereço do Cliente");
                    menu3.append("\n");


                    opcao3 = Integer.parseInt(JOptionPane.showInputDialog(menu3));


                    switch (opcao3) {


                        case 1: // Alterar nome Cliente

                            indice = index("Digite o número do Cliente que deseja alterar\n" + listClientesAlterar());

                            novoNomeCliente = jopStr("Digite o novo nome do Cliente:");

                            nomesCliente.set(indice, novoNomeCliente);

                            jop("Nome alterado com sucesso!!");

                            break;

                        case 2: //E-mail Cliente

                            indice = index("Digite o número do Cliente que deseja alterar\n" + listClientesAlterar());

                            novoEmailCliente = jopStr("Digite o novo E-mail do Cliente:");

                            emailsCliente.set(indice, novoEmailCliente);

                            jop("E-mail alterado com sucesso!!");

                            break;

                        case 3: //Celular Cliente

                            indice = index("Digite o número do Cliente que deseja alterar\n" + listClientesAlterar());

                            novoCelularCliente = jopStr("Digite o novo Celular do Cliente:");

                            celularesCliente.set(indice, novoCelularCliente);

                            jop("Celular alterado com sucesso!!");

                            break;

                        case 4: //Endereço Cliente

                            indice = index("Digite o número do Cliente que deseja alterar\n" + listClientesAlterar());

                            novoEnderecoCliente = jopStr("Digite o novo Endereço do Cliente:");

                            enderecosCliente.set(indice, novoEnderecoCliente);

                            jop("Endereco alterado com sucesso!!");

                            break;

                    }


                    break;

                case 6: //Listar Clientes

                    jop(listarClientes());

                    break;

                case 7: //Adicionar Serviço

                    servico = jopStr("Digite o novo Serviço:");
                    preco = jopStr("Digite o preço de "+servico);

                    addServico(servico, preco);

                    break;

                case 8: //Alterar dados do Serviço

                    StringBuffer menu4 = new StringBuffer();
                    menu4.append("Qual dado gostaria de alterar?");
                    menu4.append("\n");
                    menu4.append("1 - Alterar tipo de Serviço");
                    menu4.append("\n");
                    menu4.append("2 - Alterar Preço do Serviço");
                    menu4.append("\n");


                    opcao4 = Integer.parseInt(JOptionPane.showInputDialog(menu4));

                    switch (opcao4) {


                        case 1: // Alterar tipo de Serviços

                            indice = index("Digite o número do Serviço que deseja alterar:\n" + listServicosAlterar());

                            novoServico = jopStr("Digite o novo Serviço:");

                            servicos.set(indice, novoServico);

                            jop("Serviço alterado com sucesso!!");

                            break;

                        case 2: //Alterar preço do serviço

                            indice = index("Digite o número do Serviço que deseja alterar:\n" + listServicosAlterar());

                            novoPreco = jopStr("Digite o novo Serviço:");

                            precos.set(indice, novoPreco);

                            jop("Venda efetuada com Sucesso!!");

                            break;

                    }

                    break;

                case 9: //Listar Serviços

                    jop(listarServicos());

                    break;

                case 10: //Efetuar vendas para o cliente


                    indice = index("Digite o número do Cliente para o qual quer vender\n" + listClientesAlterar());

                    indice2 = index("Digite o servico que quer vender:\n" + listServicosAlterar());

                    servicoVendido = servicos.get(indice2);

                    servicosVendidos.set(indice, servicoVendido);

                    jop("Venda realizada com sucesso!!");


                    break;

                case 11: //Listar Vendas

                    jop(listarClientesVendas());

                    break;

                case 0: //Sair

                    JOptionPane.showMessageDialog(null, "Fechando o Programa...");

                    break;

            }
        }
    }



    public static String jopStr(String mensagem) {
        String retorno = "";
        retorno = JOptionPane.showInputDialog(mensagem);
        return retorno;
    }

    public static void jop(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);

    }

    public static void addFuncionario(String nomeFuncionario, String emailFuncionario, String celularFuncionario, String enderecoFuncionario) {
        nomesFuncionario.add(nomeFuncionario);
        emailsFuncionario.add(emailFuncionario);
        celularesFuncionario.add(celularFuncionario);
        enderecosFuncionario.add(enderecoFuncionario);

        jop("Contato adicionado com sucesso!");
    }

    public static String listarFuncionarios() {
        StringBuffer lista = new StringBuffer();
        lista.append("Lista de Funcionários");
        lista.append("\n");
        lista.append("========================");
        lista.append("\n");
        for (int i = 0; i < nomesFuncionario.size(); i++) {
            lista.append("Nome: "+nomesFuncionario.get(i));
            lista.append("\n");
            lista.append("Email: "+emailsFuncionario.get(i));
            lista.append("\n");
            lista.append("Celular: "+celularesFuncionario.get(i));
            lista.append("\n");
            lista.append("Endereço: "+enderecosFuncionario.get(i));
            lista.append("\n");
            lista.append("========================");
            lista.append("\n");
        }
        return lista.toString();
    }

    public static Integer index(String mensagem) {
        Integer numero = 0;
        numero = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
        return numero;
    }

    public static String listFuncionariosAlterar() {

        listFuncionarios = new StringBuffer();

        for (int i = 0; i < nomesFuncionario.size(); i++) {
            listFuncionarios.append(i + " - " + nomesFuncionario.get(i) + " - E-Mail: " + emailsFuncionario.get(i) + " - Celular: " + celularesFuncionario.get(i) + " - Endereço: " + enderecosFuncionario.get(i));
            listFuncionarios.append("\n");
        }


        return listFuncionarios.toString();
    }

    public static void addCliente(String nomeCliente, String emailCliente, String celularCliente, String enderecoCliente) {
        nomesCliente.add(nomeCliente);
        emailsCliente.add(emailCliente);
        celularesCliente.add(celularCliente);
        enderecosCliente.add(enderecoCliente);
        servicosVendidos.add("");


        jop("Contato adicionado com sucesso!");
    }

    public static String listarClientes() {
        StringBuffer lista = new StringBuffer();
        lista.append("Lista de Clientes");
        lista.append("\n");
        lista.append("========================");
        lista.append("\n");
        for (int i = 0; i < nomesCliente.size(); i++) {
            lista.append("Nome: "+nomesCliente.get(i));
            lista.append("\n");
            lista.append("Email: "+emailsCliente.get(i));
            lista.append("\n");
            lista.append("Celular: "+celularesCliente.get(i));
            lista.append("\n");
            lista.append("Endereço: "+enderecosCliente.get(i));
            lista.append("\n");
            lista.append("========================");
            lista.append("\n");
        }
        return lista.toString();
    }

    public static String listClientesAlterar() {

        listClientes = new StringBuffer();

        for (int i = 0; i < nomesCliente.size(); i++) {
            listClientes.append(i + " - " + nomesCliente.get(i) + " - E-Mail: " + emailsCliente.get(i) + " - Celular: " + celularesCliente.get(i) + " - Endereço: " + enderecosCliente.get(i));
            listClientes.append("\n");
        }


        return listClientes.toString();
    }

    public static void addServico(String servico, String preco) {
        servicos.add(servico);
        precos.add(preco);

        jop("Serviço adicionado com sucesso!");
    }

    public static String listarServicos() {
        StringBuffer lista = new StringBuffer();
        lista.append("Lista de Serviços");
        lista.append("\n");
        lista.append("========================");
        lista.append("\n");
        for (int i = 0; i < servicos.size(); i++) {
            lista.append("Serviço: "+servicos.get(i));
            lista.append("\n");
            lista.append("Preço: R$"+precos.get(i));
            lista.append("\n");
            lista.append("========================");
            lista.append("\n");
        }
        return lista.toString();
    }

    public static String listServicosAlterar() {

        listServicos = new StringBuffer();

        for (int i = 0; i < servicos.size(); i++) {
            listServicos.append(i + " - " + servicos.get(i) + " - Preço: R$" + precos.get(i));
            listServicos.append("\n");
        }

        return listServicos.toString();

    }
    public static String listarClientesVendas() {
        StringBuffer lista = new StringBuffer();
        lista.append("Lista de Vendas");
        lista.append("\n");
        lista.append("========================");
        lista.append("\n");


        for (int i = 0; i < servicosVendidos.size(); i++) {
            if (servicosVendidos.get(i) == "" || servicosVendidos.get(i).trim().isEmpty()) {
                System.out.println(nomesCliente.get(i) + " Não comprou nada!");
            }
            else {
                lista.append("Serviço contratado: " + servicosVendidos.get(i));
                lista.append("\n");
                lista.append("Cliente: " + nomesCliente.get(i));
                lista.append("\n");
                lista.append("========================");
                lista.append("\n");
            }

        }

        return lista.toString();
    }



}
