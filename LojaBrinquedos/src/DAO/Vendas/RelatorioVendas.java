/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Vendas;

import DAO.BancoMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo.bezerra
 */
public class RelatorioVendas {

    private Connection conexao = null;

    private int idvenda = 0, quantidadeitens = 0, quantidadevendas = 0, quantidadeitensdetalhes = 0, quantidademaisvendido = 0, idproduto = 0;
    private String cpfcliente = "", datavenda = "", nomemaisvendido = "", nome = "", listadetalhesnome = "";
    private double valor = 0, valormaisvendido = 0;

    public void SelectVendas(int idvenda, String Inicial, String Final) {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();

            select = "select * from vendas where idvenda = " + idvenda + " and datavenda between '" + Inicial + "' and '" + Final + "'";

            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                this.idvenda = result.getInt("idvenda");
                cpfcliente = result.getString("cpfcliente");
                valor = result.getDouble("totalvalor");
                datavenda = result.getString("datavenda");
                quantidadeitens = result.getInt("quantidadeitens");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

    public int SelectQuantidadeVendas() {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();

            select = "select count(*) as quantidadevendas from vendas";

            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                quantidadevendas = result.getInt("quantidadevendas");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return quantidadevendas;
    }

    public int SelectQuantidadeVendasDetalhes(int idvenda) {

        String select = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();

            select = "select quantidadeitens from vendas where idvenda = " + idvenda;

            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                quantidadeitensdetalhes = result.getInt("quantidadeitens");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return quantidadeitensdetalhes;
    }

    public String SelectDetalhesVenda(int idvenda) {

        String detalhesvenda = "";
        String listadetalhesnome = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();

            detalhesvenda = "select p.nomeproduto,p.valor, i.idproduto, i.idvenda, i.quantidadeitens from produtos as p inner join itemvenda as i on p.idproduto = i.idproduto where i.idvenda = " + idvenda;

            ResultSet resultdados = st.executeQuery(detalhesvenda);

            while (resultdados.next()) {

                setNome(resultdados.getString("nomeproduto"));
                setValorMaisvendido(resultdados.getDouble("valor"));
                SetidMaisVendido(resultdados.getInt("idproduto"));
                setIDVenda(resultdados.getInt("idvenda"));
                setQuantidadeItens(resultdados.getInt("quantidadeitens"));
                setListaDetalhesNome(resultdados.getString("nomeproduto") + " " + GetQuantidadeItens() + "\n");
                listadetalhesnome = listadetalhesnome + getNome() + " - QTD: " + GetQuantidadeItens() + "\n";

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return listadetalhesnome;
    }

    public int SelectProdutoMaisVendido() {

        String selectquantos = "";
        String selectdados = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = BancoMySQL.getConnection();

            java.sql.Statement st = conexao.createStatement();

            selectquantos = "select count(*) as quantosvendidos from itemvenda";

            ResultSet resultquantos = st.executeQuery(selectquantos);

            while (resultquantos.next()) {

                quantidademaisvendido = resultquantos.getInt("quantosvendidos");

            }
            selectdados = "select max(i.quantidadeitens) as maisvendidos, p.nomeproduto,p.valor, i.idproduto from produtos as p inner join itemvenda as i on p.idproduto = i.idproduto";

            ResultSet resultdados = st.executeQuery(selectdados);

            while (resultdados.next()) {

                setNomeMaisVendido(resultdados.getString("nomeproduto"));
                setValorMaisvendido(resultdados.getDouble("valor"));
                SetidMaisVendido(resultdados.getInt("idproduto"));

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return quantidademaisvendido;
    }

    public void setListaDetalhesNome(String nome) {
        this.listadetalhesnome = listadetalhesnome + nome;

    }

    public String getListaDetalhesNome() {
        return listadetalhesnome;
    }

    public void setQuantidadeItens(int quantidadeitens) {
        this.quantidadeitens = quantidadeitens;

    }

    public int getQuantidadeItens() {
        return quantidadeitens;
    }

    public void setIDVenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNomeMaisVendido(String nomemaisvendido) {
        this.nomemaisvendido = nomemaisvendido;
    }

    public String GetNomeMaisVendido() {
        return nomemaisvendido;
    }

    public void setValorMaisvendido(double valormaisvendido) {
        this.valormaisvendido = valormaisvendido;
    }

    public double GetValorMaisvendido() {
        return valormaisvendido;
    }

    public void SetidMaisVendido(int idproduto) {
        this.idproduto = idproduto;
    }

    public int GetidMaisVendido() {
        return idproduto;
    }

    public int GetQuantMaisVendidos() {
        return quantidademaisvendido;
    }

    public int GetIDVenda() {
        return idvenda;
    }

    public String GetCPFCliente() {
        return cpfcliente;

    }

    public double GetValorVenda() {
        return valor;
    }

    public int GetQuantidadeItens() {
        return quantidadeitens;
    }

    public String GetDataVenda() {

        return datavenda;

    }
}
