/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class EmpleadoDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement pr;
    ResultSet rs;
    int r;
    
    public Empleado validar(String user, String dni){
        Empleado em=new Empleado();
        String  sql ="SELECT * FROM empleado WHERE User=? AND Dni=?";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, dni);
            rs=pr.executeQuery();
            while (rs.next()) {     
                em.setId(rs.getInt("IdEmpleado"));
                em.setUsuario(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNombres(rs.getString("Nombres"));
                
            }
        } catch (Exception e) {
        }
        return em;
    }
    //Operaciones CRUD
    public List Listar(){
        String sql="SELECT * FROM empleado";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNombres(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUsuario(rs.getString(6));
                lista.add(em);
                

            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int Actualizar(Empleado em ){
        String sql="UPDATE empleado SET Dni=?, Nombres=?,Telefono=?,Estado=?,User=? WHERE idEmpleado=?";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setString(1, em.getDni());
            pr.setString(2, em.getNombres());
            pr.setString(3, em.getTelefono());
            pr.setString(4, em.getEstado());
            pr.setString(5, em.getUsuario());
            pr.setInt(6, em.getId());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Empleado ListarId(int id){
       Empleado emp=new Empleado();
       String sql="SELECT * FROM empleado WHERE IdEmpleado="+id;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                emp.setDni(rs.getString(2));
                emp.setNombres(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUsuario(rs.getString(6));
                
            }
        } catch (Exception e) {
        }
        return emp;
    }
    public int Agregar(Empleado em ){
        String sql="INSERT INTO empleado(Dni,Nombres,Telefono,Estado,User) VALUES(?,?,?,?,?) ";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setString(1, em.getDni());
            pr.setString(2, em.getNombres());
            pr.setString(3, em.getTelefono());
            pr.setString(4, em.getEstado());
            pr.setString(5, em.getUsuario());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void  Eliminar(int id ){
        String sql="DELETE FROM empleado WHERE IdEmpleado="+id;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.executeUpdate();

            
        } catch (Exception e) {
        }
    }
}
