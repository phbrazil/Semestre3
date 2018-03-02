/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Clientes;

import DAO.BancoMySQL;
import Model.Clientes.Clientes;
import Model.Produtos.Produtos;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo.Bezerra
 */
public class AlterarCliente {
    
    private Connection conexao = null;

    Clientes clientes = new Clientes();

    public Clientes PesquisarProduto(String CPF) {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from clientes where cpf = '" + CPF+"'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                clientes.setNome(result.getString("nome"));
                clientes.setLogradouro(result.getString("logradouro"));
                clientes.setRG(result.getString("rg"));
                clientes.setCPF(result.getString("cpf"));
                clientes.setNumero(result.getString("numero"));
                clientes.setCidade(result.getString("cidade"));
                clientes.setEstado(result.getString("estado"));
                clientes.setUF(result.getString("uf"));
                clientes.setCep(result.getString("cep"));
                clientes.setTelefone(result.getString("telefone"));
                clientes.setCelular(result.getString("celular"));
                clientes.setEmail(result.getString("email"));
                clientes.setSexo(result.getString("sexo"));
                clientes.setEstadoCivil(result.getString("estadocivil"));
                clientes.setNascimento(result.getString("nascimento"));
                clientes.setStatusCliente(result.getBoolean("statuscliente"));

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        if (clientes.getNome()== null) {
           //MSG ja ta no view 
            // JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }

        return clientes;
    }
    
    public void AtualizarCliente(Clientes clientes) {


        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("update clientes set nome = '"+clientes.getNome()+"', logradouro = '"+clientes.getLogradouro()+"',"
                    + "rg = '"+clientes.getRG()+"', numero = '"+clientes.getNumero()+"',cidade = '"+clientes.getCidade()+"',"
                    + "estado = '"+clientes.getEstado()+"',uf = '"+clientes.getUF()+"', cep = '"+clientes.getCep()+"',"
                    + "telefone = '"+clientes.getTelefone()+"',celular = '"+clientes.getCelular()+"',"
                    + "email = '"+clientes.getEmail()+"',sexo = '"+clientes.getSexo()+"',estadocivil = '"+clientes.getEstadoCivil()+"',"
                            + "nascimento = '"+clientes.getNascimento()+"', statuscliente = "+clientes.getStatusCliente()+" where cpf = '"+clientes.getCPF()+"'");

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        if (clientes.getNome()== null) {
            //MSG JA TA NA VIEW 
            //JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }

    }
    
}
