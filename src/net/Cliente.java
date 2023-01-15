package net;

import gui.VentanaPrincipal;

import java.net.Socket;

/**
 *Clase encargada de realizar la conexión al juego para el cliente
 */
public class Cliente {

    private String hostName;
    private int portNumber;

    /**
     * Constructor: Inicializa el nombre y número de puerto al cual se conecta el cliente
     * @param hostName
     * @param portNumber
     */
    public Cliente(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    /**
     * Método encargado de crear un socket para un cliente y establecer su interfaz gráfica
     * @param gui
     * @return cliente:
     * @throws Exception
     */
    public Despachador conectar(VentanaPrincipal gui) throws Exception {
        Socket kkSocket = new Socket(hostName, portNumber);

        Despachador cliente = new Despachador(kkSocket);
        cliente.setGui(gui);
        cliente.start();
        return cliente;
    }
}