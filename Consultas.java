
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Consultas {
      private Conexion conectar;
    PreparedStatement parametro;
    DefaultTableModel tblModelo;
    
    
    public DefaultTableModel tblconsulta1(){
        DefaultTableModel tblModelo = new DefaultTableModel();
        try{
            conectar = new Conexion();
            conectar.abrirConexion();
            String select;
            select = "select * from vista_consulta1";
            ResultSet consulta = conectar.conexionBD.createStatement().executeQuery(select);
            String encabezado [] = {"ID_INVERSOR","NOMBRE_INVERSOR","ID_MONEDA","TIPO_MONEDA","INTERES_PENDIENTE","INTERES_PAGADO","CAPITAL_A_DEVOLVER"};
            tblModelo = new DefaultTableModel();
            tblModelo.setColumnIdentifiers(encabezado);
            String datos [] = new String [7];
            while(consulta.next()){
                datos[0] = consulta.getString("ID_INVERSOR");
                datos[1] = consulta.getString("NOMBRE_INVERSOR");
                datos[2] = consulta.getString("ID_MONEDA");
                datos[3] = consulta.getString("TIPO_MONEDA");
                datos[4] = consulta.getString("INTERES_PENDIENTE");
                datos[5] = consulta.getString("INTERES_PAGADO");
                datos[6] = consulta.getString("CAPITAL_A_DEVOLVER");
                tblModelo.addRow(datos);
            }
            conectar.cerrarConexion();
            
            
            
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Error...",JOptionPane.ERROR_MESSAGE); 
            conectar.cerrarConexion();
            System.err.println(ex.getMessage());
        }
        
        return tblModelo;
    }
    

    public DefaultTableModel tblconsulta3(){
        DefaultTableModel tblModelo = new DefaultTableModel();
        try{
            conectar = new Conexion();
            conectar.abrirConexion();
            String select;
            select = "select * from vista_consulta3";
            ResultSet consulta = conectar.conexionBD.createStatement().executeQuery(select);
            String encabezado [] = {"ID_CLIENTE","NOMBRE_CLIENTE","TIPO_MONEDA","INTERES_TOTAL"};
            tblModelo = new DefaultTableModel();
            tblModelo.setColumnIdentifiers(encabezado);
            String datos [] = new String [4];
            while(consulta.next()){
                datos[0] = consulta.getString("ID_CLIENTE");
                datos[1] = consulta.getString("NOMBRE_CLIENTE");
                datos[2] = consulta.getString("TIPO_MONEDA");
                datos[3] = consulta.getString("INTERES_TOTAL");
                tblModelo.addRow(datos);
            }
            conectar.cerrarConexion();
            
            
            
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Error...",JOptionPane.ERROR_MESSAGE); 
            conectar.cerrarConexion();
            System.err.println(ex.getMessage());
        }
        
        return tblModelo;
    }
    


    
    public DefaultTableModel tblconsulta4(){
        DefaultTableModel tblModelo = new DefaultTableModel();
        try{
            conectar = new Conexion();
            conectar.abrirConexion();
            String select;
            select = "select * from vista_consulta4";
            ResultSet consulta = conectar.conexionBD.createStatement().executeQuery(select);
            String encabezado [] = {"ID_PAGO","NOMBRE_CLIENTE","TIPO_MONEDA","MONTO_TOTAL_PRESTADO","INTERES_TOTAL","FECHA_PAGO"};
            tblModelo = new DefaultTableModel();
            tblModelo.setColumnIdentifiers(encabezado);
            String datos [] = new String [6];
            while(consulta.next()){
                datos[0] = consulta.getString("ID_PAGO");
                datos[1] = consulta.getString("NOMBRE_CLIENTE");
                datos[2] = consulta.getString("TIPO_MONEDA");
                datos[3] = consulta.getString("MONTO_TOTAL_PRESTADO");
                datos[4] = consulta.getString("INTERES_TOTAL");
                datos[5] = consulta.getString("FECHA_PAGO");
   
                tblModelo.addRow(datos);
            }
            conectar.cerrarConexion();
            
            
            
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Error...",JOptionPane.ERROR_MESSAGE); 
            conectar.cerrarConexion();
            System.err.println(ex.getMessage());
        }
        
        return tblModelo;
    }
    
    
    
}


