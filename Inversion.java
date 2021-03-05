
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inversion {
    public String idinversion, idmoneda, idinversor, fecha;
    public int monto, interes,plazo;
     private Conexion conectar;
    PreparedStatement parametro;
    DefaultTableModel tblModelo;


    public String getIdinversion() {
        return idinversion;
    }

    public void setIdinversion(String idinversion) {
        this.idinversion = idinversion;
    }

    public String getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }

    public String getIdinversor() {
        return idinversor;
    }

    public void setIdinversor(String idinversor) {
        this.idinversor = idinversor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    
public int insertar(){
           int retorno = 0;    
        try{
            String sql_insert;
            conectar = new Conexion();       
            conectar.abrirConexion();
            sql_insert = "insert into captacion (monto,interes,plazo,fecha,id_moneda,id_inveror) values(?,?,?,?,?,?)";
            
            parametro = (PreparedStatement)conectar.conexionBD.prepareStatement(sql_insert);
            
            parametro.setInt(1, getMonto());
            parametro.setInt(2, getInteres());
            parametro.setInt(3, getPlazo());
            parametro.setString(4, getFecha());
            parametro.setString(5, getIdmoneda());
            parametro.setString(6, getIdinversor());
            retorno=parametro.executeUpdate();
            conectar.cerrarConexion();
        //JOptionPane.showMessageDialog(null,"Ingreso Exitoso...", "Exito",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
            retorno = 0;
        // JOptionPane.showMessageDialog(null, ex.getMessage() , "Error...",JOptionPane.ERROR_MESSAGE);

        }
        return retorno;
    }





 public DefaultTableModel tblinversor(){
        DefaultTableModel tblModelo = new DefaultTableModel();
        try{
            conectar = new Conexion();
            conectar.abrirConexion();
            String select;
            select = "select * from vista_captacion";
            ResultSet consulta = conectar.conexionBD.createStatement().executeQuery(select);
            String encabezado [] = {"ID_CAPTACION","MONTO","INTERES","PLAZO","FECHA","TIPO_MONEDA","NOMBRE_INVERSOR"};
            tblModelo = new DefaultTableModel();
            tblModelo.setColumnIdentifiers(encabezado);
            String datos [] = new String [7];
            while(consulta.next()){
                datos[0] = consulta.getString("ID_CAPTACION");
                datos[1] = consulta.getString("MONTO");
                datos[2] = consulta.getString("INTERES");
                datos[3] = consulta.getString("PLAZO");
                datos[4] = consulta.getString("FECHA");
                datos[5] = consulta.getString("TIPO_MONEDA");
                datos[6] = consulta.getString("NOMBRE_INVERSOR");
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
   




   public List<List<String>> ListaMoneda(){
        List<List<String>> lista = new ArrayList<List<String>>();
        lista.add(new ArrayList<String>());
        lista.add(new ArrayList<String>());
        try {
            conectar = new Conexion();
            conectar.abrirConexion();
            String consulta;
            consulta = "select id_moneda, tipo_moneda from monedas";
            ResultSet query = conectar.conexionBD.createStatement().executeQuery(consulta);
            lista.get(0).add("0");
            lista.get(1).add("Seleccionar");
            while(query.next()){
            lista.get(0).add(query.getString("id_moneda"));
            lista.get(1).add(query.getString("tipo_moneda"));
            }
            conectar.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error...");
        }
        return lista;
    }
    
   
  
   
   
   public List<List<String>> ListaInversor(){
        List<List<String>> lista = new ArrayList<List<String>>();
        lista.add(new ArrayList<String>());
        lista.add(new ArrayList<String>());
        try {
            conectar = new Conexion();
            conectar.abrirConexion();
            String consulta;
            consulta = "select id_inversor, nombre_inversor from inversionistas";
            ResultSet query = conectar.conexionBD.createStatement().executeQuery(consulta);
            lista.get(0).add("0");
            lista.get(1).add("Seleccionar");
            while(query.next()){
            lista.get(0).add(query.getString("id_inversor"));
            lista.get(1).add(query.getString("nombre_inversor"));
            }
            conectar.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error...");
        }
        return lista;
    }
    
    
    
    
    
}
