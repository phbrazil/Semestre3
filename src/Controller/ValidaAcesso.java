/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BancoMySQL;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author paulo.bezerra
 */
public class ValidaAcesso {
    
        private static Connection conexao = null;
        
        public boolean ValidaAcesso(String username, String password) {

        boolean usuarionabase = false;
        String select = "";

        long validado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) validado from usuarios where username = '" + username + "' and password = '"+password+"'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                validado = result.getInt("validado");

            }
            if (validado == 0) {
                System.out.println("Não Cadastrado");
                usuarionabase = false;

            } else {

                usuarionabase = true;

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return usuarionabase;

    }


    
}
