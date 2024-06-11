package automoviles_parcial;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public  class EntradaSalida  {

    
   private static Scanner input = new Scanner(System.in);

    

    public static boolean leerBoolean(String mensaje) {

        return EntradaSalida.leer(mensaje + "[S/N]: ").equalsIgnoreCase("S");

    }





    public static void escribir(Object x) {

        System.out.print(x);

    }





    public static void escribirLN(Object x) {

        System.out.println(x);

    }





    public static String leer() {

        return input.nextLine();

    }




    

    public static String leer(String mensaje) {

        EntradaSalida.escribir(mensaje);

        return input.nextLine();

    }




    

    public static int leerEntero() {

        return Integer.parseInt(EntradaSalida.leer());

    }




   
    public static int leerEntero(String mensaje) {

        return Integer.parseInt(EntradaSalida.leer(mensaje));

    }




    

    public static double leerDouble() {

        return Double.parseDouble(EntradaSalida.leer());

    }




   

    public static double leerDouble(String mensaje) {

        return Double.parseDouble(EntradaSalida.leer(mensaje));

    }




    

    public static char leerCaracter() {

        return EntradaSalida.leer().charAt(0);

    }




   

    public static char leerCaracter(String mensaje) {

        return EntradaSalida.leer(mensaje).charAt(0);

    }





    public static Boolean devolverBooleano() {
        System.out.println("1 para TRUE, 0 para FALSE");
        int num = -1;
        while (num != 1 && num != 0) {
            num = leerEntero();
        }

        return (num == 1);
    }

    public static Boolean devolverBooleano(String a) {
        System.out.println(a);
       
        String c = "\0";
        int num = -1;
        while (!c.equals("si") && !c.equals("no") && !c.equals("SI") && !c.equals("NO")) {
            c = leer();
            if (c.equals("si") || c.equals("SI")) {
                num = 1;
            } else {
                num = 0;
            }

        }
        return (num == 1);
    }

  
   

}
