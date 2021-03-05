
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    public Connection conexionBD;
    private final String url="jdbc:oracle:thin:@localhost:1521:XE";
    private final String usuario="USR_PROYECTO_FINAL";
    private final String contra="1234";
    private final String jdbc="oracle.jdbc.driver.OracleDriver";
    
    public void abrirConexion(){
        try{
          Class.forName(jdbc);
          conexionBD = DriverManager.getConnection(url,usuario,contra);
          //JOptionPane.showMessageDialog(null,"Conexion Exitosa...", "Exito",JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(), "Error en conexion :(",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void cerrarConexion(){
       try{
         conexionBD.close();
        } catch(Exception ex){
        JOptionPane.showMessageDialog
        (null,ex.getMessage(), "Error en conexion :(",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}
    

