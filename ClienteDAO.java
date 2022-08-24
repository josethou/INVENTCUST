/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ClienteDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement pr;
    ResultSet rs;
    int r;
    
    public Cliente Buscar(String dni){
        Cliente cli =new Cliente();
        String sql="SELECT * FROM cliente WHERE Dni="+dni;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                cli.setIdClientes(rs.getInt(1));
                cli.setDniC(rs.getString(2));
                cli.setNombresC(rs.getString(3));
                cli.setDirreccionC(rs.getString(4));
                cli.setEstadoC(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return cli;
    }
    
    //Operaciones CRUD
    public List Listar(){
        String sql="SELECT * FROM cliente";
        List<Cliente>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                Cliente cli=new Cliente();
                cli.setIdClientes(rs.getInt(1));
                cli.setDniC(rs.getString(2));
                cli.setNombresC(rs.getString(3));
                cli.setDirreccionC(rs.getString(4));
                cli.setEstadoC(rs.getString(5));
                lista.add(cli);
                

            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int Actualizar(Cliente cli ){
        String sql="UPDATE cliente SET Dni=?,Nombres=?,Direccion=?,Estado=? WHERE IdCliente=?";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setString(1,cli.getDniC());
            pr.setString(2,cli.getNombresC());
            pr.setString(3,cli.getDirreccionC());
            pr.setString(4,cli.getEstadoC());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Cliente ListarId(int id){
       Cliente clii=new Cliente();
       String sql="SELECT * FROM cliente WHERE IdCliente="+id;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                clii.setDniC(rs.getString(2));
                clii.setNombresC(rs.getString(3));
                clii.setDirreccionC(rs.getString(4));
                clii.setEstadoC(rs.getString(5));
                
                
            }
        } catch (Exception e) {
        }
        return clii;
    }
    public int Agregar(Cliente cli ){
        String sql="INSERT INTO cliente(Dni,Nombres,Direccion,Estado) VALUES(?,?,?,?) ";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setString(1, cli.getDniC());
            pr.setString(2, cli.getNombresC());
            pr.setString(3, cli.getDirreccionC());
            pr.setString(4, cli.getEstadoC());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void  Eliminar(int id ){
        String sql="DELETE FROM cliente WHERE IdCliente="+id;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.executeUpdate();

            
        } catch (Exception e) {
        }
    }
}
