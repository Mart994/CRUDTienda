
package modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.sql.DriverManager.*;
import static javax.swing.JOptionPane.*;

public class Conexion {
    Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= getConnection("jdbc:mysql://192.168.0.105/Tienda","martin","1234");
            showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e){
            showMessageDialog(null, "Error de conexion"+ e.getMessage());
        }
        return con;
    }
    
}
