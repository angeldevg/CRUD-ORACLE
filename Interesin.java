
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

public class Interesin {
    private Conexion conectar;
    PreparedStatement parametro;
    DefaultTableModel tblModelo;



public DefaultTableModel tblinversion(){
        DefaultTableModel tblModelo = new DefaultTableModel();
     try{
         conectar = new Conexion();
         conectar.abrirConexion();
          String select;
          select="select * from vista_proyeccion";
                                   
          ResultSet consulta= 
          conectar.conexionBD.
            createStatement().
                  executeQuery(select);
             String encabezado []=
             {"id_prestamo","nombre_cliente","monto","interes","abono_capital","pago_total","cuotas", "dia_pago_de_cada_mes"};
             tblModelo = new DefaultTableModel();
             tblModelo.setColumnIdentifiers
                         (encabezado);
             String datos[] = new String[8];
             while(consulta.next()){
                 datos[0] = consulta.getString("id_prestamo");
                 datos[1] = consulta.getString("nombre_cliente");
                 datos[2] = consulta.getString("monto");
                 datos[3] = consulta.getString("interes");
                 datos[4] = consulta.getString("abono_capital");
                 datos[5] = consulta.getString("pago_total");
                 datos[6] = consulta.getString("cuotas");
                 datos[7] = consulta.getString("dia_pago_de_cada_mes");
                 
                 tblModelo.addRow(datos);
             }
             conectar.cerrarConexion();
            }catch(Exception ex){
             conectar.cerrarConexion();
            System.out.println(ex.getMessage());   
            //JOptionPane.showMessageDialog(null,ex.getMessage(), "Error...",JOptionPane.ERROR_MESSAGE);
 }
     return tblModelo;
 }

    
}
