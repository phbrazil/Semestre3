/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
import java.io.*;
/**
 *
 * @author paulo henrique bezerra
 */
public class Main extends Operacao{

    static int contador = 49;


    

   public static void OperacaoValida(int operacao) {

        if (operacao == 1 || operacao == 2 || operacao == 3 || operacao == 4 || operacao == 0) {
            System.out.println("Operacao " + operacao + " Selecionada");
        } else {
            JOptionPane.showMessageDialog(null, "Operação inválida: \n 1 para novo Nome \n 2 para Apresentar os Nomes \n 3 para Pesquisar um Nome \n 4 para Remover um Nome \n 0 para Sair", "Operação inválida", 0);

//            System.out.println("Operação inválida: digite 1 para novo Nome, 2 "
            //                  + "para Apresentar os Nomes, 3 para Pesquisar um Nome, 4 para Remover um Nome ou 5 para Sair");
        }
    }

    //VALIDA SE O NOME JA TA NO VETOR
   public static boolean JaInserido(String NovoNome,String[]Nomes) {

        boolean repetido = false;
        for (int i = 0; i < Nomes.length; i++) {
            if (NovoNome.equals(Nomes[i])) {

                JOptionPane.showMessageDialog(null, "O nome " + NovoNome + " já está na posição " + i, "Nome repetido", 0);

                //System.out.printf("O nome %s já está na posição %d \n", NovoNome, i);
                repetido = true;
            }

        }
        return repetido;
    }

    //FUNCAO DE ACORDO COM O NUMERO DA OPCAO
    public static String OpcaoSelecionada(int operacao, String popup, String NovoNome, boolean removido, boolean encontrado, String[]Nomes) {

        //OPCAO 1 PARA INSERIR NOVO NOME
        switch (operacao) {
            case 1:

                NovoNome = JOptionPane.showInputDialog("Insira um novo Nome");

                if (JaInserido(NovoNome, Nomes)== false) {
                    Nomes[contador] = NovoNome;
                    popup += Nomes[contador] + "\n";

                    JOptionPane.showMessageDialog(null, "Nome " + Nomes[contador] + " inserido na posição " + contador, "Inserido", 1);

                    //System.out.printf("Nome %s inserido na posição %d \n", Nomes[contador], contador);
                    contador = contador - 1;
                    break;
                }
                break;

            //OPCAO 2 PARA LISTAR OS NOMES NO VETOR
            case 2:

                for (int i = 0; i < Nomes.length; i++) {

                    if (Nomes[i] != null) {

                        //System.out.printf("%s na posição %d \n", Nomes[i], i);
                    }

                }
                JOptionPane.showMessageDialog(null, "A lista cadastrada é: \n " + popup, "Cadastrados", 1);

                break;

            //OPCAO 3 PARA PESQUISAR UM NOME NO VETOR
            case 3:
                NovoNome = JOptionPane.showInputDialog("Insira o nome a ser pesquisado");
                for (int i = 0; i < Nomes.length; i++) {

                    if (NovoNome.equals(Nomes[i])) {
                        // System.out.printf("O nome %s está na posição %d \n", Nomes[i], i);
                        JOptionPane.showMessageDialog(null, "O Nome " + Nomes[i] + " está na posição " + i, "Pesquisa", 1);

                        encontrado = true;
                        break;
                    } else {
                        encontrado = false;
                    }
                }
                if (encontrado == false) {
                    JOptionPane.showMessageDialog(null, "O Nome " + NovoNome + " não foi encontrado", "Não encontrado", 0);
                    // System.out.printf("O nome %s nao foi encontrado \n", NovoNome);

                }

                break;

            //OPCAO 4 PARA REMOVER UM NOME DO VETOR
            case 4:

                NovoNome = JOptionPane.showInputDialog("Insira o nome a ser Removido");
                for (int i = 0; i < Nomes.length; i++) {

                    if (NovoNome.equals(Nomes[i])) {
                        Nomes[i] = null;

                        JOptionPane.showMessageDialog(null, "O Nome " + NovoNome + " foi removido da posição " + i, "Removido", 1);
                        // System.out.printf("O nome %s foi removido da posição %d \n", NovoNome, i);
                        removido = true;
                        break;

                    } else {
                        removido = false;
                    }
                }
                if (removido == false) {
                    JOptionPane.showMessageDialog(null, "O Nome " + NovoNome + " não foi encontrado", "Não encontrado", 0);
                    //System.out.printf("O nome %s não foi encontrado \n", NovoNome);
                }
                    popup = "";

                //SAPORRA AQUI LIMPA O VETOR
                for (int j = 0; j < Nomes.length; j++) {
                    if (Nomes[j] != null) {
                        

                        popup += Nomes[j] + "\n";
                        //System.out.println("aejhiiiiiiii"+Nomes[j]);
                    }
                }
                break;
            case 0:
                //System.out.println("Você saiu do programa");
                JOptionPane.showMessageDialog(null, "Você saiu do programa", "Até mais!", 0);
                break;
            default:
                break;

        }

        return popup;
    }

    public static void main(String[] args) {
        int operacao = 0;
        String popup = "";
        String NovoNome = "";
        boolean opcaovalida = false;
        boolean removido = false;
        boolean encontrado = false;
        String[]Nomes = new String[50];

        //INICIA POPULANDO TODO O VETOR COM NULL
        for (int i = 0; i < Nomes.length; i++) {
            Nomes[i] = null;
        }

        do {
            //VALIDA SE USER ENTRAR COM LETRA NA OPCAO CHAMANDO A FUNCAO
            operacao = Operacao(operacao, opcaovalida);

            //VALIDA O CODIGO DA OPERACAO CHAMANDO A FUNCAO
            OperacaoValida(operacao);

            //CHAMA A FUNCAO DE ACORDO COM A OPERACAO
            popup = OpcaoSelecionada(operacao, popup, NovoNome, removido, encontrado,Nomes);
            //contador--;
            if (contador == 0) {
                JOptionPane.showMessageDialog(null, "A lista já está cheia", "Lista cheia", 0);

                //System.out.println("A lista já está cheia");
                break;
            }

            //OPCAO 0 PARA SAIR DO PROGRAMA    
        } while (operacao != 0);

    }

}
