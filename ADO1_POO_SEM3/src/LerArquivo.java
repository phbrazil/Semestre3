
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author killuminatti08
 */
public class LerArquivo {

    String nomeDoArquivo1 = "Arquivos/pib.txt";
    String nomeDoArquivo2 = "Arquivos/regioes.txt";

    // linha temporaria
    String linha = null;
    String valor = "";
    String nome = "";
    double total = 0;
    double[] valorEstado = new double[27];
    String[] nomeestado = new String[27];

    public void LerArquivo() {
        try {
            FileReader fileReader = new FileReader(nomeDoArquivo1);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // loop por cada linha do arquivo
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
                if (linha.contains(";")) {
                    for (int i = 1; i < linha.length(); i++) {
                        if (String.valueOf(linha.charAt(i)).equals(";")) {
                            int j = 0;
                            int separador = 2;
                            separador++;
                            
                            for (j = i + 1; j < linha.length(); j++) {
                                valor = valor + String.valueOf(linha.charAt(j));
                                valorEstado[i] = Double.valueOf(valor);

                            }
                            for (int k = 0; k < linha.length()-separador; k++) {
                                nome = nome + String.valueOf(linha.charAt(k));

                            }

                            System.out.println("nome: " + nome);

                            System.out.println("Valor: " + valorEstado[i]);
                            total = total + Double.parseDouble(valor);
                        }

                    }
                    valor = "";
                    nome = "";

                }

            }
            System.out.println("O total é: " + total);

            // feche o arquivo
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + nomeDoArquivo1 + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + nomeDoArquivo1 + "'");
        }
    }
}
