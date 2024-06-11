package automoviles_parcial;

import static automoviles_parcial.EntradaSalida.*;
import java.io.IOException;
import java.io.Serializable;

public class Control implements Serializable {

    public void ejecutar() {
        Sistema sistema = new Sistema();

        boolean seguir = true;
        try {
            sistema = sistema.deSerializar("autos.txt");
          
           EntradaSalida.escribirLN("------------Bienvenido a automoviles SIXT---------------");
        } catch (Exception e) {
            String usuario = EntradaSalida.leer("Arranque del sistema \n" + "Sr(a) Administrador(a),ingrese su usuario: ");
            if (usuario.equals("")) {
                throw new NullPointerException("ERROR: El usuario no puede ser nulo.");
            }
            String password = EntradaSalida.leer("Ingrese su contraseña: ");
            if (password.equals("")) {
                throw new NullPointerException("ERROR: La password no puede ser nula.");
            }
            sistema.getAdministradores().add(new Administrador(usuario, password));
           
            sistema.agregarUsuario(new Administrador(usuario, password));
            for (Usuario user : sistema.getUsuarios()) {
                user.mostrarInfo();
            }
            try {
                sistema.serializar("autos.txt");               
                EntradaSalida.escribirLN("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            } catch (IOException ex) {
                EntradaSalida.escribirLN("Error");
            }
            seguir = false;

        }
 
        while (seguir) {

            String usuario = EntradaSalida.leer("Ingrese el usuario: ");
            
            String password = EntradaSalida.leer("Ingrese su contraseña: ");
            System.out.println();
            Usuario u = sistema.buscarUsuario(usuario + ":" + password);

            EntradaSalida.escribirLN("\n");

            if (u == null) {

                escribirLN("Error, Usuario o contraseña no válido.\n");
            } else {
             
               seguir = u.iniciarSesion(sistema);

            }
        }

        EntradaSalida.escribirLN("-------Saliste del sistema ----------");
    }

}
