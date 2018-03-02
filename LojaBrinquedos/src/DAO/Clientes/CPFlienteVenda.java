/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Clientes;

import DAO.BancoMySQL;
import Model.Clientes.Clientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author paulo.hbezerra
 */
public class CPFlienteVenda {

    private Connection conexao = null;

    private String nomecliente = "";
    private Clientes clientes = new Clientes();

    public Clientes SelectCPFCliente(String CPF) {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from clientes where cpf = '" + CPF + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                clientes.setNome(result.getString("nome"));
                clientes.setStatusCliente(result.getBoolean("statuscliente"));

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return clientes;

    }

}
