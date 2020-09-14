
package crudtienda;

import Controlador.CtrlProducto;
import Vista.formProducto;
import modelo.ConsultasProducto;
import modelo.Producto;

/**
 *
 * @author Martin
 */
public class CRUDTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Producto pro = new Producto();
       ConsultasProducto cpro = new ConsultasProducto();
       formProducto frm = new formProducto();
       
       CtrlProducto ctrl = new CtrlProducto(pro, cpro, frm);
       ctrl.iniciar();
       frm.setVisible(true);
       
    }
    
}
