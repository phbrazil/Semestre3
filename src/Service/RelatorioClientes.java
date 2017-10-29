/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo.hbezerra
 */
public class RelatorioClientes {

    private String usuario = "root";

    private String senha = "admin";

    private String url = "jdbc:mysql://localhost:3306/LojaBrinquedosDatabase";

    private Connection conexao = null;

    private String nomeproduto = "", faixaetaria = "", fabricante = "", prazogarantia = "";
    private int quantidade = 0;
    private int codigobarras = 0;
    private double valor = 0, valordesconto = 0;

    private int linha = 0;
    private int coluna = 0;

    private int quantidadeprodutos = 0;

    public void SelectProduto() {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();
            select = "select * from produtos limit 1";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                codigobarras = result.getInt("codigobarras");
                // coluna++;
                nomeproduto = result.getString("nomeproduto");
                //  coluna++;
                valor = result.getInt("valor");
                //  coluna++;
                valordesconto = result.getInt("valordesconto");
                //  coluna++;
                faixaetaria = result.getString("faixaetaria");
                //coluna++;
                fabricante = result.getString("fabricante");
                // coluna++;
                prazogarantia = result.getString("prazogarantia");
                //  coluna++;
                quantidade = result.getInt("quantidade");
                //  coluna++;
                //   linha++;

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        if (nomeproduto.equals("")) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }

    }

    public int SelectQuantosProdutos() {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) as quantidadeprodutos from produtos";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                quantidadeprodutos = result.getInt("quantidadeprodutos");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        if (nomeproduto.equals("")) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
        return quantidadeprodutos;

    }

    public int Getlinha() {

        return linha;

    }

    public int Getcoluna() {

        return coluna;

    }

    public long GetcodigoBarras() {

        return codigobarras;
    }

    public String GetNomeProduto() {

        return nomeproduto;
    }

    public double GetValor() {

        return valor;
    }

    public double GetValorDesconto() {

        return valordesconto;
    }

    public String GetFaixaEtaria() {

        return faixaetaria;
    }

    public String GetFabricante() {

        return fabricante;
    }

    public String GetPrazoGarantia() {

        return prazogarantia;
    }

    public int Getquantidade() {

        return quantidade;
    }
}
