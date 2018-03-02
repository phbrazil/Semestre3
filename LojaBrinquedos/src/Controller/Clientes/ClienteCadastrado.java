/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Clientes;

import DAO.BancoMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author paulo.hbezerra
 */
public class ClienteCadastrado {

    private static Connection conexao = null;

    public boolean ClienteJaCadastrado(String CPF) {

        boolean clientecadastrado = false;
        String select = "";

        long cpfselect = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) cpf from clientes where cpf = '" + String.valueOf(CPF) + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                cpfselect = result.getInt("CPF");

            }
            if (cpfselect == 0) {
                clientecadastrado = false;

            } else {

                clientecadastrado = true;

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return clientecadastrado;

    }

}
