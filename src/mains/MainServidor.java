package mains;

import net.Servidor;

public class MainServidor{
    public static void main(String[] args) {
        /**
         * clase principal encargada de ejecutar el servidor con el metodo conectar
         */
        try {
            Servidor servidor = new Servidor(1234);
            servidor.conectar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
