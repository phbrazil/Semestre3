/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author paulo.hbezerra
 */
public class SelectCPFlienteVenda {

    private Connection conexao = null;
    
    private String nomecliente = "";

    public String SelectCPFCliente(String CPF) {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from clientes where cpf = '" + CPF + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                nomecliente = result.getString("nome");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return nomecliente;

    }

}
