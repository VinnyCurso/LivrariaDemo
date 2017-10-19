/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public class ConexaoBD {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        } else {
            try {

                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/livrariademo";
                String user = "postgres";
                String password = "root";

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro Conexão");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro Inesperado Conexão");
            }
            return connection;

        }
    }
}
