package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Crud {

    public static void INSERT() {
        Connection conexion;
        PreparedStatement consulta;
        String sql = "INSERT INTO usuarios (nombre,contraseña) values (?,?)";

        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement(sql);
            consulta.setString(1, "martin");
            consulta.setString(2, "897");
            consulta.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void SELECT() {
        Connection conexion;
        PreparedStatement consulta;
        String sql = "SELECT * FROM usuarios";
        ResultSet resultado;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement(sql);
            resultado = consulta.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String usuario = resultado.getString("nombre");
                String contraseña = resultado.getString("contraseña");

                System.out.println("\nid: " + id);
                System.out.println("Usuario: " + usuario);
                System.out.println("Contraseña: " + contraseña);

            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public static void UPDATE() {
        Connection conexion;
        PreparedStatement consulta;
        String sql = "UPDATE usuarios set nombre = ?,contraseña = ? WHERE id = ?";
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement(sql);
            consulta.setString(1, "juan");
            consulta.setString(2, "abc");
            consulta.setInt(3, 2);
            int filasAfectadas = consulta.executeUpdate();
            System.out.println("Filas afectadas : " + filasAfectadas);

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public static void DELETE() {
        Connection conexion;
        PreparedStatement consulta;
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, 2);
            int filasAfectadas = consulta.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
//        INSERT();
        SELECT();
//        UPDATE();
//        DELETE();
    }

}
