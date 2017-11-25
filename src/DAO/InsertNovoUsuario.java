/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

import Model.Usuarios;
import java.sql.Connection;

/**
 *
 * @author paulo.bezerra
 */
public class InsertNovoUsuario {

    private Connection conexao = null;

    public void InsertNovoUsuario(Usuarios usuarios) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO usuarios (nomeuser,username,password) VALUES ('" + usuarios.getNomeUser()+ "','" + usuarios.getUserName() + "','" + usuarios.getPassword()+ "');");
            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

}
