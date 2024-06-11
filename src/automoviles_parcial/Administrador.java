package automoviles_parcial;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administrador extends Usuario implements Serializable {

    private ArrayList<Administrador> administradores;

    public Administrador(String usuario, String password) {
        super(usuario, password);
        administradores = new ArrayList<Administrador>();
    }

    Sistema sis = new Sistema();

    public boolean iniciarSesion(Sistema sis) {
        int op = 0;
        boolean seguir = true;

        while (op != 8 && op != 9) {
            try {
                System.out.println("=== MENÚ ADMINISTRADOR ===");

                System.out.println("<1> Agregar auto");
                System.out.println("<2> Listar autos");
                System.out.println("<3> Agregar vendedor\n<4> Eliminar vendedor");
                System.out.println("<5> Agregar Cliente\n<6> Eliminar cliente");
                System.out.println("<7> Mostrar Datos de todos los usuarios");
                System.out.println("<8> Cerrar sesion");
                System.out.println("<9> Salir del sistema");
                System.out.println("======================\n");
                op = EntradaSalida.leerEntero("Ingrese una opcion ");
                switch (op) {
                    case 1 ->
                        agregarVehiculo(sis);

                    case 2 ->
                        listarAutos(sis);

                    case 3 ->
                        agregarVendedor(sis);
                    case 4 ->
                        eliminarVendedor(sis);
                    case 5 ->
                        agregarCliente(sis);
                    case 6 ->
                        eliminarCliente(sis);
                    case 7 ->
                         mostrarUsuarios(sis);
                    case 8 ->
                        System.out.println("Cerrando sesion...");
                    case 9 ->
                        seguir = false; // Finalizar el bucle y salir del sistema
                    default ->
                        System.out.println("Opción no válida , intetelo de nuevo");
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return seguir;
    }

    public void agregarVehiculo(Sistema sis) throws IOException {
        System.out.println("\t***AGREGAR VEHICULO***");
        String patente = EntradaSalida.leer("Ingrese patente del vehiculo: ");
        String modelo = EntradaSalida.leer("Ingrese modelo del vehiculo:");
        String color = EntradaSalida.leer("Ingrese color del vehiculo:");
        String marca = EntradaSalida.leer("Ingrese marca del vehiculo:");
        boolean reservado = EntradaSalida.devolverBooleano("¿Esta reservado?  [SI/NO]");
        sis.agregarVehiculo(patente, modelo, color, marca, reservado);

    }

    public void listarAutos(Sistema sis) throws IOException, ClassNotFoundException {
        System.out.println("\t***LISTAR AUTOS***");
        sis.deSerializar("autos.txt");
        sis.listarAutos();
    }

    public void agregarVendedor(Sistema sis) throws IOException {
        System.out.println("\t***AGREGAR UN VENDEDOR***");
        String usuario = EntradaSalida.leer("Ingrese nombre de usuario: ");
        String password = EntradaSalida.leer("Ingrese una contraseña: ");
        sis.agregarVendedor(usuario, password);

    }

    public void eliminarvehiculo(Sistema sis) {

    }

    public void administrarVehiculos() {
        System.out.println("Administrando vehiculos...");
    }

   
    public void eliminarVendedor(Sistema sis) {
  System.out.println("\t***ELIMINAR UN VENDEDOR***");
        String usuario = EntradaSalida.leer("Ingrese nombre de usuario: ");
        String password = EntradaSalida.leer("Ingrese una contraseña: ");
        sis.eliminarVendedor(usuario,password);
    }
 public void agregarCliente(Sistema sis) throws IOException {
         System.out.println("\t***NUEVO CLIENTE***\n\tIngrese sus datos personales ");
                 
         String nombre= EntradaSalida.leer("Nombre: ");
          int dni= EntradaSalida.leerEntero("DNI: ");
           String direccion= EntradaSalida.leer("Direccion: ");
            String mail= EntradaSalida.leer("Mail: ");
             int telefono= EntradaSalida.leerEntero("Telefono: ");
             String id= EntradaSalida.leer("ID: ");
             System.out.println("DATOS PERSONALES INTRODUCIDOS CORRECAMENTE");
            String usuario = EntradaSalida.leer("Ingrese un nombre de usuario(recomendado -"+nombre+"123-): ");
             String password =EntradaSalida.leer("Ingrese una contraseña: ");
            sis.agregarCliente(nombre,dni,direccion,mail,telefono,id,usuario, password);
    }

    public void eliminarCliente(Sistema sis) {
        System.out.println("\t***ELIMINAR UN CLIENTE***");
        String usuario = EntradaSalida.leer("Ingrese nombre de usuario: ");
        String paswword =EntradaSalida.leer("Ingrese la contraseña");
        sis.eliminarCliente(usuario, paswword);
    }
public void mostrarUsuarios(Sistema sis)
{
        try {
            sis.mostrarUsuarios();
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
