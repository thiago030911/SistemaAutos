package automoviles_parcial;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehiculo implements Serializable {

    private ArrayList<Vehiculo> vehiculos;

    private String patente;
    private String modelo;
    private String color;
    private String marca;
    boolean reservado;
    String getColor;

    public Vehiculo(String patente, String modelo, String color, String marca, boolean reservado) {
        vehiculos = new ArrayList<Vehiculo>();
        this.patente = patente;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.reservado = reservado;
    }

    
    
   

    void listar() {

    }

    public String getPatente() {
       return patente;
    }
    public String getColor(){
        return color;
    }
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
            return modelo; 
    }
    public boolean getReserva(){
        return reservado;
    }
    public void setReserva(boolean reservado){
        this.reservado= reservado;
    }
    public String toString() {
    return "Vehiculo [patente=" + patente + ", modelo=" + modelo + ", color=" + color + ", marca=" + marca + ", reservado=" + reservado + "]";
}

   

}
