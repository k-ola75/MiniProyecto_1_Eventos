package net;

import controller.Controlador;
import gui.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Despachador extends Thread {
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;
    private VentanaPrincipal gui = null;
    private ArrayList<Despachador> jugadoresenlinea = new ArrayList<>();
    private HashMap<String, Controlador.Jugador> jugadores = new HashMap<>(2);
    private int Xnicial = 0, Yinicial = 0;
    private String mensaje = "";

    /**
     * Constructor: Inicializa socket
     * @param socket
     */
    public Despachador(Socket socket) {
        try {
            this.in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.socket = socket;
        } catch (Exception e) {
            System.out.println("Error Despachador: " + e.getMessage());
        }
    }

    /**
     * Método encargado de ejectuar el juego
     */
    public void run() {
        try {
            iniciarJuego();
        } catch (Exception e) {
            System.out.println("Error Run: " + e.getMessage());
        }
    }

    /**
     * Método encargado de
     * @throws IOException
     */
    private void iniciarJuego() throws IOException {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (gui != null) {  // Cliente
                despachadorCliente(inputLine);
            }
            if (gui == null) {  // Servidor
                despachadorServidor(inputLine);
            }
        }
    }

    /**
     * Método encargado de recibir información manejada por cada cliente
     * @param inputLine
     */
    public void despachadorCliente(String inputLine) {
        String[] datosJugadores = inputLine.split("#");
        for (String jugador : datosJugadores) {
            String[] login = jugador.split(",");
            gui.getLienzo().getJugadores().put(login[0], new Controlador.Jugador(login[0], asignarColor(login[3]),
                    Integer.parseInt(login[1]), Integer.parseInt(login[2])));

            confirmarGanador(Integer.parseInt(login[1]), Integer.parseInt(login[2]), login[0]);
        }
        gui.getLienzo().repaint();
    }

    /**
     * Método encargado de recibir información manejada por el servidor
     * @param inputLine
     */
    public void despachadorServidor(String inputLine) {
        String[] datos = inputLine.split(":");

        if (datos[0].equals("login")) {
            jugadores.put(datos[1], new Controlador.Jugador(datos[1], seleccionarcolor(), Xnicial, Yinicial));
        } else if (datos[0].equals("mover")) {
            String[] datosJugador = datos[1].split(",");
            jugadores.get(datosJugador[0]).setX(Integer.parseInt(datosJugador[1]));
            jugadores.get(datosJugador[0]).setY(Integer.parseInt(datosJugador[2]));
        } else if (datos[0].equals("ganador")) {
            Controlador.agregarJuego("ganador: " + datos[1]);
        }

        String[] lista = new String[jugadores.size()];
        int index = 0;
        for (Controlador.Jugador e : jugadores.values()) {
            lista[index++] = e.getNickname() + "," + e.getX() + "," + e.getY() + "," + e.getColorJugador();
        }

        for (Despachador e : jugadoresenlinea) {
            e.send(String.join("#", lista));
        }
    }

    /**
     * Método encargado de enviar datos segpun el protocolo establecido
     * @param inputLine
     */
    public void send(String inputLine) {
        try {
            out.println(inputLine);
        } catch (Exception e) {
            System.out.println("Error Send: " + e.getMessage());
        }
    }

    /**
     * Método que determina si un jugador culminó con éxito el juego
     * @param posicionX
     * @param posicionY
     * @param jugador
     */
    public void confirmarGanador(int posicionX, int posicionY, String jugador) {
        if (posicionX == 330 && posicionY == 180) {
            setMensaje("Ganador: " + jugador);
            JOptionPane.showMessageDialog(null, mensaje);
            this.send("ganador:" + jugador);
            System.exit(0);
        }
    }

    /**
     * Método encargado de seleccionar un color aleatorio para cada jugador
     * @return Color: color seleccionado
     */
    public Color seleccionarcolor() {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        switch (randomNum) {
            case 1:
                return Color.RED;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.BLUE;
            default:
                return Color.black;
        }
    }

    /**
     * Método encargado de retornar un objeto color dada una cadena correspondiente a dicho color
     * @param String: color
     * @return Color:
     */
    public Color asignarColor(String color) {
        switch (color) {
            case "RED":
                return Color.RED;
            case "GREEN":
                return Color.GREEN;
            case "BLUE":
                return Color.BLUE;
            default:
                return Color.black;
        }
    }

    /**
     * Método que asigna la posición inicial de cada jugador
     * @param numerojugadores
     */
    public void asignarposicioninicial(int numerojugadores) {
        switch (numerojugadores) {
            case 1:
                Xnicial = 30;
                Yinicial = 30;
                break;
            case 2:
                Xnicial = 630;
                Yinicial = 330;
                break;
        }
    }

    /**
     * Setter: inicializa interfaz gráfica del cliente
     * @param gui
     */
    public void setGui(VentanaPrincipal gui) {
        this.gui = gui;
    }

    /**
     * Setter: Inicializa lista de jugadores en línea
     * @param jugadoresenlinea
     */
    public void setJugadoresenlinea(ArrayList<Despachador> jugadoresenlinea) {
        this.jugadoresenlinea = jugadoresenlinea;
    }

    /**
     * Getter: retorna atributo mensaje
     * @return mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Setter: inicializa atributo mensaje
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}