package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JMendez
 */
public class Conexion {

    //private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String server = "jdbc:sqlserver://localhost;";
    private static final String namedb = "databaseName=PRUEBA;";
    private static final String user = "user=JMENDEZ;";
    private static final String pass = "password=M10006912$";
    private static final String url = server + namedb + user + pass;
    private Connection con = null;

    //CREAMOS METODO DE CONEXION 
    public Connection OpenConexion() {
        if (con != null) {
            return con;
        } else {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url);
                System.out.println("Conexion Exitosa");
                return con;
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error en la Conexion");
                e.printStackTrace();
                return con;
            }
        }

    }

    //CREAMOS METODO PARA CERRAR: (PreparedStatement, Connection y ResultSet)
    public void CloseConexion(ResultSet rs, PreparedStatement ps, Connection con) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("Cerre el ResultSet");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("Cerre el PrepareStatement");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("Cerre el Connection");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        rs = null;
        ps = null;
        con = null;

    }

}
