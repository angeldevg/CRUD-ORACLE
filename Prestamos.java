
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Prestamos {
    public String idinversion, idmoneda, idcliente, fecha;
    public int monto,plazo;
    public float interes;
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

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdicliente(String idinversor) {
        this.idcliente = idinversor;
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

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }
    
    
    public int insertar(){
           int retorno = 0;    
        try{
            String sql_insert;
            conectar = new Conexion();       
            conectar.abrirConexion();
            sql_insert = "insert into prestamos (monto, inters, plazo, id_moneda, id_cliente, fecha) values (?,?,?,?,?,?);";
            
            parametro = (PreparedStatement)conectar.conexionBD.prepareStatement(sql_insert);
            
            parametro.setInt(1, getMonto());
            parametro.setFloat(2, getInteres());
            parametro.setInt(3, getPlazo());
            parametro.setString(4, getIdmoneda());
            parametro.setString(5, getIdcliente());
            parametro.setString(6, getFecha());
            retorno=parametro.executeUpdate();
            conectar.cerrarConexion();
        //JOptionPane.showMessageDialog(null,"Ingreso Exitoso...", "Exito",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
            retorno = 0;
         //JOptionPane.showMessageDialog(null, ex.getMessage() , "Error...",JOptionPane.ERROR_MESSAGE);

        }
        return retorno;
    }

    
    
    
    
    public DefaultTableModel tblprestamos(){
        DefaultTableModel tblModelo = new DefaultTableModel();
        try{
            conectar = new Conexion();
            conectar.abrirConexion();
            String select;
            select = "select * from vista_prestamos";
            ResultSet consulta = conectar.conexionBD.createStatement().executeQuery(select);
            String encabezado [] = {"ID_PRESTAMO","MONTO","INTERES","PLAZO","TIPO_MONEDA","NOMBRE_CLIENTE","FECHA"};
            tblModelo = new DefaultTableModel();
            tblModelo.setColumnIdentifiers(encabezado);
            String datos [] = new String [7];
            while(consulta.next()){
                datos[0] = consulta.getString("ID_PRESTAMO");
                datos[1] = consulta.getString("MONTO");
                datos[2] = consulta.getString("INTERES");
                datos[3] = consulta.getString("PLAZO");
                datos[4] = consulta.getString("TIPO_MONEDA");
                datos[5] = consulta.getString("NOMBRE_CLIENTE");
                datos[6] = consulta.getString("FECHA");
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
    
    
    
    
    
    
    public List<List<String>> Listacliente(){
        List<List<String>> lista = new ArrayList<List<String>>();
        lista.add(new ArrayList<String>());
        lista.add(new ArrayList<String>());
        try {
            conectar = new Conexion();
            conectar.abrirConexion();
            String consulta;
            consulta = "select id_cliente, nombre_cliente from clientes";
            ResultSet query = conectar.conexionBD.createStatement().executeQuery(consulta);
            lista.get(0).add("0");
            lista.get(1).add("Seleccionar");
            while(query.next()){
            lista.get(0).add(query.getString("id_cliente"));
            lista.get(1).add(query.getString("nombre_cliente"));
            }
            conectar.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error...");
        }
        return lista;
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
    
    
    
    
}
