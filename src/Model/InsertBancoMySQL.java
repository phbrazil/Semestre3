package Model;


import com.sun.corba.se.spi.orbutil.fsm.FSMTest;
import com.sun.prism.j2d.J2DPipeline;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeString;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulo.bezerra
 */
public class InsertBancoMySQL {

    private String usuario = "root";

    private String senha = "adminadmin";

    private String url = "jdbc:mysql://localhost:3306/LojaBrinquedosDatabase";

    private Connection conexao = null;

    public void InsertNovoUser(String NomeUser, String Username, String Password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO usuarios (NomeUser, Username, Password) VALUES ('" + NomeUser + "','" + Username + "','" + Password + "');");

            JOptionPane.showMessageDialog(null, Username + " foi cadastrado");

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

    public void InsertNovaVenda(long CPFCliente, double TotalValor, Date DataCompra, int QuantidadeItens) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO vendas (CPFCliente, TotalValor, DataCompra, QuantidadeItens) VALUES ('" + CPFCliente + "'," + TotalValor + ",'" + DataCompra + "'," + QuantidadeItens + ");");

            //JOptionPane.showMessageDialog(null, "Produto foi cadastrado");
            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

    public void InsertNovoCliente(String nome, String logradouro, String RG, String CPF, String numero, String cidade,
            String estado, String UF,String CEP, String telefone, String celular, String email, String sexo, String estadocivil, String nascimento) {

        if (nome.equals("") || nome.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Nome inválido");

        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conexao = DriverManager.getConnection(url, usuario, senha);

                java.sql.Statement st = conexao.createStatement();
                st.executeUpdate("INSERT INTO Clientes (Nome,Logradouro,RG,CPF,Numero,Cidade,Estado,UF,CEP,Telefone,Celular,Email,Sexo,EstadoCivil,Nascimento) \n"
                        + "VALUES ('" + nome + "','" + logradouro + "','" + RG + "','" + CPF + "','" + numero + "','" + cidade + "','" + estado + "','" + UF + "','"+CEP+"','" + telefone + "','"
                        + celular + "','" + email + "','" + sexo + "','" + estadocivil + "','" + nascimento + "');");

                JOptionPane.showMessageDialog(null, nome + " foi cadastrado como cliente");
                conexao.close();

            } catch (Exception e) {

                System.out.println("erro" + e.getMessage());

            }
        }
    }

    public void InsertNovoProduto(long codigobarras, String nomeproduto, double valor, String faixaetaria, String fabricante, String prazogarantia, int quantidade) {

        if (nomeproduto.equals("") || nomeproduto.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Produto inválido");

        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conexao = DriverManager.getConnection(url, usuario, senha);

                java.sql.Statement st = conexao.createStatement();
                st.executeUpdate("INSERT INTO produtos (codigobarras, nomeproduto,valor,faixaetaria,fabricante,prazogarantia, quantidade)"
                        + " VALUES ("+codigobarras+",'" + nomeproduto + "'," + valor + ",'" + faixaetaria + "','" + fabricante + "','" + prazogarantia + "'," + quantidade + ");");

                JOptionPane.showMessageDialog(null, "Produto " + nomeproduto + " foi cadastrado");
                conexao.close();

            } catch (Exception e) {

                System.out.println("erro" + e.getMessage());

            }
        }
    }

}
