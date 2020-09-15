
package Controlador;

import modelo.ConsultasProducto;
import modelo.Producto;
import Vista.formProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrlProducto implements ActionListener {

    private Producto prod;
    private ConsultasProducto prodC;
    private formProducto frm;

    public CtrlProducto(Producto prod, ConsultasProducto prodC, formProducto frm) {
        this.prod = prod;
        this.prodC = prodC;
        this.frm = frm;
        //escuchar acciones de los botones
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        //Levanta la interfaz gráfica
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.tId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Acciones para Boton Guardar
        if (e.getSource() == frm.btnGuardar) {
            prod.setCodigo(frm.tCodigo.getText());
            prod.setNombre(frm.tNombre.getText());
            prod.setPrecio(Double.parseDouble(frm.tPrecio.getText()));
            prod.setCantidad(Integer.parseInt(frm.tCantidad.getText()));
            
            try {
                if(prodC.registrar(prod))
                {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Acciones para Boton Modificar
        if (e.getSource() == frm.btnModificar) {
            prod.setId(Integer.parseInt(frm.tId.getText()));
            prod.setCodigo(frm.tCodigo.getText());
            prod.setNombre(frm.tNombre.getText());
            prod.setPrecio(Double.parseDouble(frm.tPrecio.getText()));
            prod.setCantidad(Integer.parseInt(frm.tCantidad.getText()));
            
            try {
                if(prodC.modificar(prod))
                {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Acciones para Boton Eliminar
        if (e.getSource() == frm.btnEliminar) {
            prod.setId(Integer.parseInt(frm.tId.getText()));
            
            try {
                if(prodC.eliminar(prod))
                {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Acciones para Boton Buscar
        if (e.getSource() == frm.btnBuscar) {
            prod.setCodigo(frm.tCodigo.getText());
            
            try {
                if(prodC.buscar(prod))
                {
                    frm.tId.setText(String.valueOf(prod.getId()));
                    frm.tCodigo.setText(prod.getCodigo());
                    frm.tNombre.setText(prod.getNombre());
                    frm.tPrecio.setText(String.valueOf(prod.getPrecio()));
                    frm.tCantidad.setText(String.valueOf(prod.getCantidad()));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro registro");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Acciones para Boton Limpiar
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }

    }
    //Funcion para limpiar los cuadros de texto
    public void limpiar(){
        frm.tId.setText(null);
        frm.tCodigo.setText(null);
        frm.tNombre.setText(null);
        frm.tPrecio.setText(null);
        frm.tCantidad.setText(null);
    }

}