
import com.mysql.jdbc.Util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author killuminatti08
 */
public class Agenda {

    public void listar() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/agendabd", "root", "admin");
                PreparedStatement stmt = con.prepareStatement(
                        "select id, nome, dtnascimento FROM PESSOA");
                ResultSet resultados = stmt.executeQuery()) {
            while (resultados.next()) {

                long id = resultados.getLong("id");
                String nome = resultados.getString("nome");
                Date dtnascimento = resultados.getDate("dtnascimento");

                System.out.println(id + ", " + nome + ", " + dtnascimento);

            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        try {
            agenda.listar();

            // TODO code application logic here
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
