/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paulo.Bezerra
 */
public class Exercicio6 {
    
    
    static void Taboada (){
        int hum = 1, dois = 2, tres = 3, quatro = 4, cinco = 5, seis = 6, sete = 7, oito = 8, nove = 9;
        for (int i = 1; i <= 9; i++) {
            if (i == 1) {
                System.out.println(" * |  1  2  3  4  5  6  7  8  9");
                System.out.println("-------------------------------");
            }

            System.out.println(i + "|  " + hum *i+ "  " + dois *i+ "  " + tres*i+"  "+quatro*i+"  "+cinco*i+"  "+seis*i+"  "+sete*i+"  "+oito*i+"  "+nove*i);

        }
        
        
    }

    public static void main(String[] args) {
        
        Taboada();
        

    }

}
