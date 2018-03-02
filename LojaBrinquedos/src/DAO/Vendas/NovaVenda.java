/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Vendas;

import DAO.BancoMySQL;
import Model.Clientes.Clientes;
import Model.Vendas.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Paulo.Bezerra
 */
public class NovaVenda {

    /**
     *
     * @author paulo.hbezerra
     */
    private Connection conexao = null;

    public void InsertNovaVenda(Vendas vendas) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            java.sql.Statement id = conexao.createStatement();

            st.executeUpdate("INSERT INTO vendas (cpfcliente, totalvalor,datavenda,quantidadeitens, vendastatus, username) VALUES ('" + vendas.getCPFCliente() + "'," + vendas.getTotalValor() + ",NOW()," + vendas.getQuantidadeItensVenda()+ ",true,'"+vendas.getVendedor()+"');");
            String idvenda = "SELECT LAST_INSERT_ID() as idvenda";

            ResultSet result = st.executeQuery(idvenda);

            while (result.next()) {

                int resultadovendaid = result.getInt("idvenda");
                vendas.setVendaID(resultadovendaid);

                System.out.println(resultadovendaid + " heuahueahehau");

            }
            

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

}
