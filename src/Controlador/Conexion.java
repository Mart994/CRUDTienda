
package Controlador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.sql.DriverManager.*;
import static javax.swing.JOptionPane.*;

public class Conexion {
    Connection con = null;

    public Connection getConexion() {
        //Conexion a la BBDD
        String usr = "root"; //usuario
        String pass = "1234"; //constraseña
        String url = "jdbc:mysql://192.168.0.105:3306/";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= getConnection(url+"Tienda", usr, pass);
            //showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e){
            showMessageDialog(null, "Error de conexion"+ e.getMessage());
        }
        return con;
    }
    
}
