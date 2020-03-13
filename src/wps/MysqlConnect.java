/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rabdos7
 */
public class MysqlConnect {

    Connection conexion;
    PreparedStatement consulta;
    ResultSet datos;

    public Connection getConnection() {
        String servidor = "jdbc:mysql://localhost/wps";
        String usuario = "root";
        String pass = "kamigawa";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(servidor, usuario, pass);
        } catch (ClassNotFoundException e) {
            System.err.println("driver not found");
            conexion = null;
        } catch (SQLException e) {
            System.err.println("no se pudo conectar a la base de datos");
            conexion = null;
        }

        return conexion;
    }

    public String consulta(String dir) {

        try {
            conexion = (Connection) this.getConnection();
            String query = "select dir from aps where mac like '" + dir + "'";
            consulta = (PreparedStatement) conexion.prepareStatement(query);
            datos = consulta.executeQuery();
            String area = null;
            if (datos.next()) {
                area = datos.getString("dir");
            }
            return area;
        } catch (SQLException e) {
            System.err.println("error en la consulta");
        } finally {
            this.desconectar();
        }
        return null;
    }

    public void desconectar() {
        try {
            conexion.close();
            consulta.close();
            datos = null;
        } catch (SQLException e) {
        }
    }
}
