/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Producto {
    int IdProducto, Stock;
    String  NombresP,EstadoP;
    double Precio;

    public Producto() {
    }

    public Producto(int IdProducto, int Stock, String NombresP, String EstadoP, double Precio) {
        this.IdProducto = IdProducto;
        this.Stock = Stock;
        this.NombresP = NombresP;
        this.EstadoP = EstadoP;
        this.Precio = Precio;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getNombresP() {
        return NombresP;
    }

    public void setNombresP(String NombresP) {
        this.NombresP = NombresP;
    }

    public String getEstadoP() {
        return EstadoP;
    }

    public void setEstadoP(String EstadoP) {
        this.EstadoP = EstadoP;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
}
