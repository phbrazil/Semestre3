/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Vendas;

import Controller.Produtos.AtualizarListaCarrinho;
import DAO.BancoMySQL;
import Model.Clientes.Clientes;
import Model.Vendas.Vendas;
import java.sql.Connection;

/**
 *
 * @author Paulo.Bezerra
 */
public class ItemVenda {

    private Connection conexao = null;

    public void InsertItemTemp(AtualizarListaCarrinho carrinho, Vendas vendas) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            for (int i = 0; i < carrinho.TamanhoListaCarrinho(); i++) {

                java.sql.Statement st = conexao.createStatement();
                st.executeUpdate("INSERT INTO itemvenda (idvenda, idproduto,quantidadeitens) VALUES (" + vendas.getVendaID() + "," + carrinho.pesquisarProduto(i).getCodigobarras() + "," + carrinho.pesquisarProduto(i).getQuantidade()+ ");");

            }
            conexao.close();
        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

}
