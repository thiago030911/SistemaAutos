package automoviles_parcial;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Vendedor extends Usuario implements Serializable {

   private ArrayList<Vendedor> vendedores;
   public Vendedor(String usuario, String password) {
        super(usuario,password);
        vendedores = new ArrayList<Vendedor>();
    }
      
    public boolean iniciarSesion(Sistema sis) {
    // Mostrar el menú y realizar las operaciones del vendedor
    int op = 0 ;
     boolean seguir = true;
    do
    {
        try {
            System.out.println("=== MENÚ VENDEDOR ===");
            System.out.println("<1>. Hacer una reserva");
            System.out.println("<2>. Modificar reserva");
            System.out.println("<3>. Nuevo cliente\n<4>. Eliminar cliente");
            System.out.println("<5>. Salir");
            System.out.println("======================");
            
            // Leer la opción seleccionada por el vendedor
            op = EntradaSalida.leerEntero("Ingresar opcion ");
            
            // Realizar acciones según la opción seleccionada
            switch (op) {
                case 1:
                    reservar(sis);
                    break;
                case 2:
                    administrarReservas(sis);
                    break;
                case 3:
                    agregarCliente(sis);
                    break;
                case 4:
                    eliminarCliente(sis);
                case 5:
                     System.out.println("Cerrando sesion..."); 
                     break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }   } catch (IOException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }while(op!=5);
       return seguir;
    }
    
    
    public void administrarReservas(Sistema sis) {
        int op=0; 
        while(op!=3){
        System.out.println("\n\t\tSUBMENU DE RESERVAS");
          System.out.println("<1> Ver reservas");
          System.out.println("<2> Eliminar una reserva\n<3> Volver al menu\n");
          
          op = EntradaSalida.leerEntero("  Ingresar opcion ");
       
          switch(op){
            case 1:
            {
                try {
                    listarReservas(sis);
                } catch (IOException ex) {
                    Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 2:
                 eliminarReserva(sis);
                    break;
            case 3:
                
                break;
            default:
                 System.out.println(" Opción no válida");
        }
        }
    }

  
 public void reservar(Sistema sis) throws IOException {
       System.out.println("\n\t ***NUEVA RESERVA***");
       int num = EntradaSalida.leerEntero("<1>Reserva telefonica\n<2> Reserva via email\n  ");
       String modelo = EntradaSalida.leer("Ingrese el modelo del auto: ");
       String color = EntradaSalida.leer("Color del auto: ");
       sis.reserva(modelo,color,num);
       
    }
   
    public void administrarClientes() {
        System.out.println("Administrando clientes...");
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
    public void listarReservas(Sistema sis) throws IOException, ClassNotFoundException{
        sis.listarReservas(); 
    }
  public void eliminarReserva(Sistema sis){
      
  }
    
  
    
}