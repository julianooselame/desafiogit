package senai;

import javax.swing.*;

public class Desafio05 {

    public static void main(String[] args) {

        int digito01 = 0;
        int digito02 = 0;
        int resultado = 0;
        int opcao = 0;

        digito01 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número!"));
        digito02 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número!"));

        String menu = "Escolha uma operação:\n";
        menu += "Digite 1 para adição\n";
        menu += "Digite 2 para subtração\n";
        menu += "Digite 3 para multiplicação\n";
        menu += "Digite 4 para divisão\n";

        opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (opcao) {
            case 1:
               resultado = digito01 + digito02;
               JOptionPane.showMessageDialog(null,"O resultado da operação "+digito01+"+"+digito02+" é: "+resultado);

                break;
            case 2:
                resultado = digito01 - digito02;
                JOptionPane.showMessageDialog(null,"O resultado da operação "+digito01+"-"+digito02+" é: "+resultado);

                break;
            case 3:


                break;
            case 4:


                break;

        }
    }
}
