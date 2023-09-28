package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

    public Connection conexion() {
        Connection conectar = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/miappjava", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return conectar;
    }

}
