
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Paulo.Bezerra
 */
public class Exercicio9 {

    static String Aula;
    static String Aulas[] = new String[10];

    static void InserirAulas() {

        String diasemana = "";
        int contador = 0;
        int[] dianumero = new int[6];

        for (int i = 1; i <= 5; i++) {
            switch (i) {
                case 1:
                    diasemana = "Segunda-feira";
                    Aula = JOptionPane.showInputDialog("Digite a Aula 1 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    Aula = JOptionPane.showInputDialog("Digite a Aula 2 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    dianumero[1] = 1;
                    break;
                case 2:
                    diasemana = "Terca-Feira";
                    Aula = JOptionPane.showInputDialog("Digite a Aula 1 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    Aula = JOptionPane.showInputDialog("Digite a Aula 2 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    dianumero[2] = 2;
                    break;
                case 3:
                    diasemana = "Quarta-Feira";
                    Aula = JOptionPane.showInputDialog("Digite a Aula 1 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    Aula = JOptionPane.showInputDialog("Digite a Aula 2 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    dianumero[3] = 3;
                    break;
                case 4:
                    diasemana = "Quinta-Feira";
                    Aula = JOptionPane.showInputDialog("Digite a Aula 1 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    Aula = JOptionPane.showInputDialog("Digite a Aula 2 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    dianumero[4] = 4;
                    break;
                case 5:
                    diasemana = "Sexta-Feira";
                    Aula = JOptionPane.showInputDialog("Digite a Aula 1 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    Aula = JOptionPane.showInputDialog("Digite a Aula 2 da " + diasemana);
                    Aulas[contador] = Aula;
                    contador++;
                    dianumero[5] = 5;
                    break;

            }

        }

    }

    static void Opcoes() {
        boolean sair = false;
        String opcaoselecionada;
        int diasemanaselecionado = 0;
        do {

            opcaoselecionada = JOptionPane.showInputDialog("digite 1 para consultar, 2 para mostrar todas aulas ou escreva sair");
            switch (opcaoselecionada) {
                case "sair":
                    sair = true;
                    System.out.println("Voce saiu do programa");
                    break;
                case "1":
                    boolean opcaovalida = false;
                    do {
                        try {
                            diasemanaselecionado = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do dia da semana, 1 para Seg e 5 Sexta"));
                            opcaovalida = true;
                        } catch (NumberFormatException erro) {
                            System.out.println("Dia da semana inválido");
                        }
                    } while (opcaovalida = false);

                    if (diasemanaselecionado == 1) {
                        System.out.println("Na Segunda voce tem aula de:");
                        System.out.println(Aulas[0]);
                        System.out.println(Aulas[1]);

                    } else if (diasemanaselecionado == 2) {
                        System.out.println("Na Terca voce tem aula de:");
                        System.out.println(Aulas[2]);
                        System.out.println(Aulas[3]);
                    } else if (diasemanaselecionado == 3) {
                        System.out.println("Na Quarta voce tem aula de:");
                        System.out.println(Aulas[4]);
                        System.out.println(Aulas[5]);
                    } else if (diasemanaselecionado == 4) {
                        System.out.println("Na Quinta voce tem aula de:");
                        System.out.println(Aulas[6]);
                        System.out.println(Aulas[7]);
                    } else if (diasemanaselecionado == 5) {
                        System.out.println("Na Sexta voce tem aula de:");
                        System.out.println(Aulas[8]);
                        System.out.println(Aulas[9]);
                    }
                    break;
                case "2":
                    System.out.println("Essas são suas aulas:");
                    for (int i = 0; i <= 9; i++) {
                        System.out.println(Aulas[i]);

                    }
                    break;
                default:
                    break;
            }

        } while (sair == false);

    }

    public static void main(String[] args) {

        InserirAulas();
        Opcoes();

    }

}
