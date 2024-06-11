package automoviles_parcial;

public class Main {

    public static void main(String[] args) {

        Control c = new Control();
        try {
            c.ejecutar();
        } catch (NullPointerException e) {
            EntradaSalida.escribirLN(e.getMessage());
        }
    }
}
       

    


