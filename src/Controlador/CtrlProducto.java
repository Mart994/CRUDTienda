
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

    private Producto mod;
    private ConsultasProducto modC;
    private formProducto frm;

    public CtrlProducto(Producto mod, ConsultasProducto modC, formProducto frm) {
        this.mod = mod;
        this.modC = modC;
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
            mod.setCodigo(frm.tCodigo.getText());
            mod.setNombre(frm.tNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.tPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.tCantidad.getText()));
            
            try {
                if(modC.registrar(mod))
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
            mod.setId(Integer.parseInt(frm.tId.getText()));
            mod.setCodigo(frm.tCodigo.getText());
            mod.setNombre(frm.tNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.tPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.tCantidad.getText()));
            
            try {
                if(modC.modificar(mod))
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
            mod.setId(Integer.parseInt(frm.tId.getText()));
            
            try {
                if(modC.eliminar(mod))
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
            mod.setCodigo(frm.tCodigo.getText());
            
            try {
                if(modC.buscar(mod))
                {
                    frm.tId.setText(String.valueOf(mod.getId()));
                    frm.tCodigo.setText(mod.getCodigo());
                    frm.tNombre.setText(mod.getNombre());
                    frm.tPrecio.setText(String.valueOf(mod.getPrecio()));
                    frm.tCantidad.setText(String.valueOf(mod.getCantidad()));
                    
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