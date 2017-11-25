/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mock.CadastrarCliente;
import Model.Clientes;
import java.sql.Connection;

/**
 *
 * @author paulo.hbezerra
 */
public class InsertNovoCliente {

    private Connection conexao = null;

    public void InsertNovoCliente(Clientes novocliente) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO Clientes (Nome,Logradouro,RG,CPF,numero,Cidade,Estado,UF,CEP,Telefone,Celular,Email,Sexo,EstadoCivil,Nascimento) \n"
                    + "VALUES ('" + novocliente.getNome() + "','" + novocliente.getLogradouro() + "','" + novocliente.getRG() + "','" + novocliente.getCPF() + "','" + novocliente.getNumero() + "','" + novocliente.getCidade() + "','" + novocliente.getEstado() + "','" + novocliente.getUF() + "','" + novocliente.getCep() + "','" + novocliente.getTelefone() + "','"
                    + novocliente.getCelular() + "','" + novocliente.getEmail() + "','" + novocliente.getSexo() + "','" + novocliente.getEstadoCivil() + "','" + novocliente.getNascimento() + "');");
            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

}
