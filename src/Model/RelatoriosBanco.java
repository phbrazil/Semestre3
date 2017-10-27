/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author paulo.bezerra
 */
public class RelatoriosBanco {

    private String usuario = "root";

    private String senha = "admin";

    private String url = "jdbc:mysql://localhost:3306/LojaBrinquedosDatabase";

    private Connection conexao = null;

    private int quantidadevendas = 0;
    private int quantidadeclientes = 0;
    private int quantidadeprodutos = 0;

    public int SelectQuantidadeVendas() {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();

            select = "select count(*) as quantidadevendas from vendas";

            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                quantidadevendas = result.getInt("quantidadevendas");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return quantidadevendas;
    }

    public int SelectQuantidadeClientes() {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();

            select = "select count(*) as quantidadeclientes from clientes";

            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                quantidadeclientes = result.getInt("quantidadeclientes");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return quantidadeclientes;
    }

    public int SelectQuantidadeProdutos() {

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
        return quantidadeprodutos;
    }

}
