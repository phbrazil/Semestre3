import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        double x1, x2, y, a, b, c, soma, produto;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Informe o valor de X1: ");
        x1 = scan.nextDouble();
        System.out.println("Informe o valor de X2: ");
        x2 = scan.nextDouble();
        System.out.println("Informe o eixo de Y: ");
        y = scan.nextDouble();
        
        c = y;
        
        soma = x1 + x2;
        produto = x1*x2;
        
        a = c/ produto;
        b = -(soma * a);
        
        System.out.println("A: "+a);
        System.out.println("B: "+b);
        System.out.println("C: "+c);
    }
    
}
