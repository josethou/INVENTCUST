        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.*;
/**
 *
 * @author USUARIO
 */
public class Conexion {
    
    public Connection Conexion(){
        Connection con=null;
        try{
            com.mysql.cj.jdbc.Driver drv=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(drv);
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ventas?user=root&password=joseth&useSSL=false");
        
        }catch(SQLException e){
                    System.out.println("Error en conexión");

        }
        return con;
    }
}
