/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author USUARIO
 */
public class GenerarSerie {
    
    int Dato;
    String Numero;
    
    public String NumeroSerie(int Dato){
        this.Dato=Dato+1;
        if ((this.Dato>=10000000)&&(this.Dato<=100000000)) {
            Numero=""+this.Dato;
        }
        if ((this.Dato>=1000000)&&(this.Dato<=10000000)) {
            Numero="0"+this.Dato;
        }
        if ((this.Dato>=100000)&&(this.Dato<=1000000)) {
            Numero="00"+this.Dato;
        }
        if ((this.Dato>=10000)&&(this.Dato<=100000)) {
            Numero="000"+this.Dato;
        }
        if ((this.Dato>=1000)&&(this.Dato<=10000)) {
            Numero="0000"+this.Dato;
        }
        if ((this.Dato>=100)&&(this.Dato<=1000)) {
            Numero="00000"+this.Dato;
        }
        if ((this.Dato>=100)&&(this.Dato<=1000)) {
            Numero="000000"+this.Dato;
        }
        if ((this.Dato>=10)&&(this.Dato<=100)) {
            Numero="0000000"+this.Dato;
        }
        if (this.Dato<10) {
            Numero="00000000"+this.Dato;
        }
        return this.Numero;
    }
   
}
