/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automoviles_parcial;

import static automoviles_parcial.EntradaSalida.leer;
import static automoviles_parcial.EntradaSalida.leerDouble;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Usuario implements Serializable {

    private ArrayList<Cliente> clientes;
    private int  dni;
    private String nombre;
    private String direccion;
    private String mail;
    private int  telefono;
    private String id;

    /* public Cliente(String usuario, String password) {
        super(usuario, password);
        clientes = new ArrayList<Cliente>();
    }*/
    public Cliente(String nombre, int dni, String direccion, String mail, int telefono, String id, String usuario, String password) {
        super(usuario, password);
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
        this.id = id;

    }
  public String getNombre()
  {
      return nombre;
      
  }
    public int getDni() {
        return dni;
    }

    public String getMail() {
        return mail;
    }

    public int getTelefono() {
        return telefono;
    }
     public String getId() {
        return id;
    }
        public String getDireccion() {
        return mail;
    }
    public boolean iniciarSesion(Sistema sis) {
        int op = 0;
        boolean seguir = true;
        while (op != 2) {
            System.out.println(
                    "=== MENÚ CLIENTE ===");
            System.out.println(
                    "<1> Consultar autos disponibles");
            System.out.println(
                    "<2>. Cerrar sesion ");
            System.out.println(
                    "======================");
           
            op = EntradaSalida.leerEntero(); // Leer la opción seleccionada por el vendedor
            // Realizar acciones según la opción seleccionada
            switch (op) {
                case 1: {
                    try {
                        listarAutos(sis);
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case 2:
                    System.out.println("Cerrando sesion...");
                    break;
          
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }
        return seguir;
    }

    public void listarAutos(Sistema sis) throws IOException, ClassNotFoundException {
        System.out.println("\t***LISTAR AUTOS***");
        sis.deSerializar("autos.txt");
        sis.listarAutos();
    }
     public String toString() {
        return "Nombre: " + nombre; 
    }

}
