/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Cliente {
    int idClientes;
    String DniC,NombresC,DirreccionC,EstadoC;

    public Cliente() {
    }

    public Cliente(int idClientes, String DniC, String NombresC, String DirreccionC, String EstadoC) {
        this.idClientes = idClientes;
        this.DniC = DniC;
        this.NombresC = NombresC;
        this.DirreccionC = DirreccionC;
        this.EstadoC = EstadoC;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public String getDniC() {
        return DniC;
    }

    public void setDniC(String DniC) {
        this.DniC = DniC;
    }

    public String getNombresC() {
        return NombresC;
    }

    public void setNombresC(String NombresC) {
        this.NombresC = NombresC;
    }

    public String getDirreccionC() {
        return DirreccionC;
    }

    public void setDirreccionC(String DirreccionC) {
        this.DirreccionC = DirreccionC;
    }

    public String getEstadoC() {
        return EstadoC;
    }

    public void setEstadoC(String EstadoC) {
        this.EstadoC = EstadoC;
    }
    
}
