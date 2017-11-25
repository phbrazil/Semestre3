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
 * @author paulo.hbezerra
 */
public class ValidaProdutoCadastrado {
    
    

    private static Connection conexao = null;

    public boolean ValidaProduto(long codigobarras) {

        boolean produtocadastrado = false;
        String select = "";

        int quantosprod = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) produto from produtos where codigobarras = " + codigobarras;
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                quantosprod = result.getInt("produto");

            }
            if (quantosprod == 0) {
                System.out.println("Não Cadastrado");
                produtocadastrado = false;

            } else {

                produtocadastrado = true;

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return produtocadastrado;

    }

    
}
