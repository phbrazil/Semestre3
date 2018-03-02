/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatorial;

import javax.swing.JOptionPane;

/**
 *
 * @author killuminatti08
 */
public class Fatorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //int numero = Integer.parseInt(JOptionPane.showInputDialog("Insira o número"));

        int x = 5;
        int y = 3;
        int fatorial = fatorial(x, y);

        System.out.println("Fatorial: " + y);
        // TODO code application logic here
    }

    static int fatorial(int x, int y) {
        if (x == 0) {
            return 1;
        }
        System.out.println("yeagyea");

        return (fatorial(x - 1,y+1));
    }

}
