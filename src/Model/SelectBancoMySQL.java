package Model;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulo.bezerra
 */
public class SelectBancoMySQL {

    private String usuario = "root";

    private String senha = "adminadmin";

    private String url = "jdbc:mysql://localhost:3306/LojaBrinquedosDatabase";

    private String nomeproduto = "", faixaetaria = "", fabricante = "", prazogarantia = "", nomeCliente = "";

    private double valor = 0, valordesconto = 0;

    private Connection conexao = null;

    private String logradouro, cidade, UF, numero, estado;

    public void SelectCPFCliente(String CPF) {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();
            select = "select * from clientes where cpf = '" + CPF + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                nomeCliente = result.getString("nome");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public boolean ValidaAcesso(String Username, String Password) {

        boolean validado = false;
        String select = "";
        String usuariobanco = "";
        String senhabanco = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();
            select = "select * from usuarios where username = '" + Username + "' and password = '" + Password + "';";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                usuariobanco = result.getString("username");
                senhabanco = result.getString("Password");

            }
            if (usuariobanco.equals(Username) && senhabanco.equals(Password) && !Username.equals("") && !Password.equals("")) {
                validado = true;
            } else {
                validado = false;
                JOptionPane.showMessageDialog(null, "User ou Senha inválido");
            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return validado;

    }

    public boolean CPFCadastradoSelect(String CPF) {

        boolean clientecadastrado = false;
        String select = "";

        long cpfselect = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) cpf from clientes where cpf = '" + String.valueOf(CPF) + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                cpfselect = result.getInt("CPF");

            }
            if (cpfselect == 0) {
                System.out.println("Não Cadastrado");
                clientecadastrado = false;

            } else {
                System.out.println("aeeee" + cpfselect);

                clientecadastrado = true;

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return clientecadastrado;

    }

    public void SelectProduto(int idproduto) {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();
            select = "select * from produtos where idproduto = " + idproduto;
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                nomeproduto = result.getString("nomeproduto");
                faixaetaria = result.getString("faixaetaria");
                fabricante = result.getString("fabricante");
                prazogarantia = result.getString("prazogarantia");
                valor = result.getDouble("valor");
                valordesconto = result.getDouble("valordesconto");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        if (nomeproduto.equals("")) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }

    }

    public String GetnomeProduto() {

        return nomeproduto;
    }

    public double GetValorProduto() {

        return valor;
    }

    public String GetFaixaEtaria() {

        return faixaetaria;
    }

    public String GetGarantia() {

        return prazogarantia;
    }

    public String GetNomeCliente() {

        return nomeCliente;
    }

    public String GetFabricante() {

        return fabricante;
    }

    public double GetValorDesconto() {

        return valordesconto;
    }

}
