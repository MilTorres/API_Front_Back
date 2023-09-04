package com.matr.api_front_back.CRUD;



import java.sql.*;

public class Crud {





    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=curso";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "1234";

    public static void main(String[] args) {
        CrudOperations crud = new CrudOperations();

        // Insertar un nuevo registro
    /*    crud.insert("Juan",
                "Perez",
                "juan@example.com",
                "722345673",
                "123");
*/

        // Actualizar un registro (supongamos que el registro con ID 1 existe)
     //  crud.update(3009, "Juanito"
             //  , "juanito@example.com");


        // Obtener todos los registros
        crud.printTable();

        // Eliminar un registro (supongamos que el registro con ID 2 existe)
     // crud.delete(3007);


    }
}

class DatabaseManager {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=curso";
        String user = "sa";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}

class CrudOperations {
    public void insert(String nombre, String apellido, String correo, String telefono, String contrasena) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo,telefono,contrasena) VALUES (?,?,?,?,?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            pstmt.setString(4, telefono);
            pstmt.setString(5, contrasena);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAll() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Telefono: " + rs.getString("telefono"));
                System.out.println("Contraseña: " + rs.getString("contrasena"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String newName, String newEmail) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newEmail);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printTable() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Imprimir los nombres de las columnas
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-25s", metaData.getColumnName(i));
            }
            System.out.println(); // Salto de línea después de los nombres de las columnas

            // Imprimir los datos de la tabla
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-25s", rs.getString(i));
                }
                System.out.println(); // Salto de línea después de cada fila de datos
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

