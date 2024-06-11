package automoviles_parcial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Sistema implements Serializable {

    private ArrayList<Cliente> clientes;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Administrador> administradores;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Reserva> reservas;

    public Sistema() {
        clientes = new ArrayList<Cliente>();
        vendedores = new ArrayList<Vendedor>();
        administradores = new ArrayList<Administrador>();
        usuarios = new ArrayList<Usuario>();
        vehiculos = new ArrayList<Vehiculo>();
        reservas = new ArrayList<Reserva>();
    }

    public Sistema deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();
        o.close();
        f.close();
        return s;
    }

    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public Usuario buscarUsuario(String datos) {
        int i = 0;
        boolean encontrado = false;
        Usuario u = null;

        while (i < usuarios.size() && !encontrado) {

            u = usuarios.get(i);
            if (datos.equals(u.getUsuario() + ":" + u.getPassword())) {
                encontrado = true;
            } else {
                i++;
            }
        }

        if (!encontrado) {
            return null;
        } else {
            return u;
        }
    }

    public Cliente buscarCliente(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getId().equals(id)) {
                    return cliente;
                }
            }
        }
        return null;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> Clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(ArrayList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    void agregarVehiculo(String patente, String modelo, String color, String marca, boolean reservado) throws IOException {
        vehiculos.add(new Vehiculo(patente, modelo, color, marca, reservado));
        serializar("autos.txt");
        System.out.println("Se agrego un auto a la lista");

    }

    public void listarAutos() {
        int contador = 1;
        if (vehiculos != null && !vehiculos.isEmpty()) {
            System.out.println("Vehículos registrados:");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println("Auto" + contador + ":" + vehiculo);
                contador++;
            }
        } else {
            System.out.println("No hay vehículos registrados.");
        }
    }

    public void agregarVendedor(String usuario, String password) throws IOException {
        usuarios.add(new Vendedor(usuario, password));
        serializar("autos.txt");
        System.out.println("Se ha contratado un nuevo vendedor!");
    }

    public void eliminarVendedor(String usuario, String password) {
        Usuario vendedor = buscarUsuario(usuario + ":" + password);
        if (vendedor != null) {
            // Verificar si el usuario es un vendedor antes de eliminarlo
            if (vendedor instanceof Vendedor) {
                eliminarUsuario(vendedor);
                System.out.println("Vendedor eliminado exitosamente.");
            } else {
                System.out.println("El usuario no es un vendedor.");
            }
        } else {
            System.out.println("Vendedor no encontrado.");
        }
    }

    public void eliminarCliente(String usuario, String password) {
        Usuario cliente = buscarUsuario(usuario + ":" + password);
        if (cliente != null) {
            // Verificar si el usuario es un vendedor antes de eliminarlo
            if (cliente instanceof Cliente) {
                eliminarUsuario(cliente);
                System.out.println("Cliente eliminado exitosamente.");
            } else {
                System.out.println("El usuario no es un cliente.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);

    }

    /*public void agregarCliente(String nombre,double dni, String direccion, String mail, double telefono,double id,String usuario, String password) throws IOException
  {
      
      usuarios.add(new Cliente(nombre,dni,direccion,mail,telefono,id,usuario,password));
      serializar("autos.txt");
       System.out.println("NUEVO CLIENTE REGISTRADO");
  }*/
    public void agregarCliente(String nombre, int dni, String direccion, String mail, int telefono, String id, String usuario, String password) throws IOException {
        boolean clienteExistente = false;

        // Verificar si ya existe un cliente con el mismo DNI o nombre
        for (Usuario usuarioExistente : usuarios) {
            if (usuarioExistente instanceof Cliente) {
                Cliente cliente = (Cliente) usuarioExistente; // Cambio de nombre de la variable
                if (cliente.getDni() == dni || cliente.getNombre().equals(nombre) || cliente.getId().equals(id)) {
                    clienteExistente = true;
                    break;
                }
            }
        }

        if (clienteExistente) {
            System.out.println("Ya existe un cliente con el mismo DNI o nombre.");
        } else {
            usuarios.add(new Cliente(nombre, dni, direccion, mail, telefono, id, usuario, password));
            serializar("autos.txt");
            System.out.println("NUEVO CLIENTE REGISTRADO");
        }
    }

    public void reserva(String modelo, String color, int num) throws IOException {
        boolean encontrado = false;
        if (num == 1) {
            System.out.println("Reserva vía Telefónica");
        } else {
            System.out.println("Reserva via Email");
        }

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getModelo().equals(modelo) && vehiculo.getColor().equals(color) && vehiculo.getReserva() == false) {
                System.out.println("Vehículo encontrado: " + vehiculo);
                encontrado = true;

                boolean realizarReserva = EntradaSalida.devolverBooleano("Desea realizar la reserva?");
                if (realizarReserva) {
                    datosReserva();
                   vehiculo.setReserva(true);
                   serializar("autos.txt");
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron vehículos con el modelo y color especificados.");
        }

    }

    public void mostrarUsuarios() throws IOException, ClassNotFoundException {
        deSerializar("autos.txt");
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Administrador) {
                System.out.println("\t\t***USUARIOS DEL SISTEMA***\n");
                System.out.println(usuario.getUsuario() + "\t\t   es un Administrador\n-------------------");
            } else if (usuario instanceof Vendedor) {
                System.out.println(usuario.getUsuario() + "\t\t   es un Vendedor\n");
                System.out.println("--------------------------");
            } else if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(usuario.getUsuario() + "\t\t   es un Cliente");
                System.out.println("ID UNICO: " + cliente.getId());
                System.out.println("DNI: " + cliente.getDni());
                System.out.println("Correo electrónico: " + cliente.getMail());
                System.out.println("Teléfono: " + cliente.getTelefono());
                System.out.println("Direccion: " + cliente.getDireccion());
                System.out.println("--------------------------\n");
            }
        }

    }

    public void listarReservas() throws IOException, ClassNotFoundException {
        System.out.println("\t  LISTADO DE RESERVAS\n");
        deSerializar("autos.txt");
        for (Reserva reserva : reservas) {
            System.out.println(reserva.toString() + "\n");
        }

    }

    public void datosReserva() throws IOException {

        System.out.println("\t***Datos para realizar la reserva***");
        String id = EntradaSalida.leer("ID del cliente: ");
        String fechaInicio = EntradaSalida.leer("Ingrese la fecha en formato dd/MM/yyyy\nFecha de inicio de la reserva: ");
        String fechaFinal = EntradaSalida.leer("Fecha final de la reserva: ");
        int dias = EntradaSalida.leerEntero("Dias de alquiler: ");
        int precioAlquiler = 20000;
        int litrosGasolina = 100;

        boolean entregado = true;
        int precioTotal = precioAlquiler * dias;
        Cliente cliente = buscarCliente(id);
        if (cliente != null) {

            Reserva reserva = new Reserva(cliente, fechaInicio, fechaFinal, dias, precioAlquiler, litrosGasolina, precioTotal, entregado);
            reservas.add(reserva);
             
           
            serializar("autos.txt");
            System.out.println("\nRESERVA REALIZADA CON EXITO!!!\n");
        }
    }

}
