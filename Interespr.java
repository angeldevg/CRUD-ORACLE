
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Interespr {
    private Conexion conectar;
    PreparedStatement parametro;
    DefaultTableModel tblModelo;
    
    
  public DefaultTableModel tblinversionpr(){
        DefaultTableModel tblModelo = new DefaultTableModel();
     try{
         conectar = new Conexion();
         conectar.abrirConexion();
          String select;
          select="select * from vista_pagoinversiones";
                                   
          ResultSet consulta= 
          conectar.conexionBD.
            createStatement().
                  executeQuery(select);
             String encabezado []=
             {"ID_CAPTACION","NOMBRE_INVERSOR","MONTO","CUOTAS","INTERES_MENSUAL","ULITMO_PAGO", "DIA_PAGO_DE_CADA_MES"};
             tblModelo = new DefaultTableModel();
             tblModelo.setColumnIdentifiers
                         (encabezado);
             String datos[] = new String[7];
             while(consulta.next()){
                 datos[0] = consulta.getString("ID_CAPTACION");
                 datos[1] = consulta.getString("NOMBRE_INVERSOR");
                 datos[2] = consulta.getString("MONTO");
                 datos[3] = consulta.getString("CUOTAS");
                 datos[4] = consulta.getString("INTERES_MENSUAL");
                 datos[5] = consulta.getString("ULITMO_PAGO");
                 datos[6] = consulta.getString("DIA_PAGO_DE_CADA_MES");

                 
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
