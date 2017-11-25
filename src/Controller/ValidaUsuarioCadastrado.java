/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BancoMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author paulo.hbezerra
 */
public class ValidaUsuarioCadastrado {

    private static Connection conexao = null;

    public boolean UsuarioJaCadastrado(String nomeuser, String username) {

        boolean usuariocadastrado = false;
        String select = "";

        int quantosusuarios = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) usuarios from usuarios where nomeuser = '" + nomeuser + "' or username = '" + username + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                quantosusuarios = result.getInt("usuarios");

            }
            if (quantosusuarios == 0) {
                System.out.println("Não Cadastrado");
                usuariocadastrado = false;

            } else {

                usuariocadastrado = true;

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return usuariocadastrado;

    }

}
