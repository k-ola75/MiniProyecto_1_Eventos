package net;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Clase encargada de realizar la conexión al juego para el servidor
 */
public class Servidor {
    private int portNumber;
    private ArrayList<Despachador> jugadoresenlinea = new ArrayList<>();

    /**
     * Constructor: Inicializa número de puerto
     * @param portNumber
     */
    public Servidor(int portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * Método que establece conexión entre servidor y clientes
     * @throws Exception
     */
    public void conectar() throws Exception {
        int portNumber = 1234;
        int numeroJugadores = 0;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true) {
            System.out.println("ESPERANDO JUGADORES...");
            Socket clientSocket = serverSocket.accept();
            numeroJugadores++;
            Despachador servidor = new Despachador(clientSocket);
            servidor.asignarposicioninicial(numeroJugadores);
            jugadoresenlinea.add(servidor);
            servidor.setJugadoresenlinea(jugadoresenlinea);

            if (numeroJugadores == 2) {
                for (Despachador e : jugadoresenlinea) {
                    e.start();
                }
                serverSocket.close();
                System.out.println("MAXIMO DE JUGADORES ALCANZADO");
            }
        }

    }
}
