
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author killuminatti08
 */
public class Operacao {
    
    public static int Operacao(int operacao, boolean opcaovalida) {

        do {
            try {
                operacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da operação: \n 1 para novo Nome \n 2 para Apresentar os Nomes \n 3 para Pesquisar um Nome \n 4 para Remover um Nome \n 0 para Sair"));
                opcaovalida = true;

            } catch (NumberFormatException erro) {
                System.out.println("Operação inválida: digite 1 para novo Nome, 2 "
                        + "para Apresentar os Nomes, 3 para Pesquisar um Nome, 4 para Remover um Nome ou 5 para Sair");

            }
        } while (!opcaovalida);
        opcaovalida = false;
        return operacao;
    }
    
}
