package automoviles_parcial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva implements Serializable {
    
 
   private ArrayList<Reserva> reservas;
    private Cliente cliente;
    private String fechaInicio;
    private String fechaFinal;
    private int dias;
    private double precioAlquiler;
    private int litrosGasolina;
    private double precioTotal;
    private  boolean entregado;

    public Reserva(Cliente cliente, String fechaInicio, String fechaFinal, int dias,
            double precioAlquiler, int litrosGasolina, double precioTotal, boolean entregado) {
      reservas = new ArrayList<Reserva>();
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.dias = dias;
        this.precioAlquiler = precioAlquiler;
        this.litrosGasolina = litrosGasolina;
        this.precioTotal = precioTotal;
        this.entregado = entregado;
    }

    // Getters y setters
    // Otros métodos y comportamientos de Reserva
public String toString() {
    return "Cliente: " + cliente +
           "\nFecha de inicio: " + fechaInicio +
           "\nFecha final: " + fechaFinal +
           "\nDías de alquiler: " + dias +
           "\nPrecio de alquiler: " + precioAlquiler +
           "\nLitros de gasolina: " + litrosGasolina +
           "\nPrecio total: " + precioTotal +
           "\nEntregado: " + entregado;
}
  
}
