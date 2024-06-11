package automoviles_parcial;

import java.io.Serializable;

public abstract class  Usuario  implements Serializable {

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    
    
    
    private String usuario;
    private String password;

  

    
    
  
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }
        
    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    void mostrarInfo() {
     
    }
public abstract boolean iniciarSesion(Sistema sis);

   


   
    
}
