package controller;

import gui.VentanaPrincipal;
import levels.Laberinto;
import net.Cliente;
import net.Despachador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


/**
 * Clase encargada de manejar las interacciones del usuario con el juego
 */
public class Controlador implements KeyListener {
    private VentanaPrincipal vista;
    public HashMap<String, Jugador> jugadores = new HashMap<>();
    public String jugadorPresente = "";
    public Despachador despachador;
    private Laberinto laberinto = new Laberinto();
    int[][] lab = laberinto.obtenerLaberinto();

    /**
     * Constructor: inicializa objeto tipo "VentanaPrincipal" y establece los jugadores a controlar
     * @param v
     */
    public Controlador(VentanaPrincipal v) {
        vista = v;
        vista.getLienzo().setJugadores(jugadores);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    /**
     * Método encargado del movimiento de los jugadores
     * @param keyEvent evento a ser procesado
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int movimiento = 30;
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (lab[(jugadores.get(jugadorPresente).getY() / movimiento) - 1][jugadores.get(jugadorPresente).getX() / movimiento] != 1) {
                    jugadores.get(jugadorPresente).moverY(-movimiento);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (lab[(jugadores.get(jugadorPresente).getY()) / movimiento][(jugadores.get(jugadorPresente).getX() / movimiento) + 1] != 1) {
                    jugadores.get(jugadorPresente).moverX(movimiento);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (lab[(jugadores.get(jugadorPresente).getY() / movimiento) + 1][(jugadores.get(jugadorPresente).getX() / movimiento)] != 1) {
                    jugadores.get(jugadorPresente).moverY(movimiento);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (lab[jugadores.get(jugadorPresente).getY() / 30][(jugadores.get(jugadorPresente).getX() / 30) - 1] != 1) {
                    jugadores.get(jugadorPresente).moverX(-movimiento);
                }
                break;
        }

        int _x = jugadores.get(jugadorPresente).getX();
        int _y = jugadores.get(jugadorPresente).getY();
        despachador.send("mover:" + jugadorPresente + "," + _x + "," + _y);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    /**
     * Método que despliega ventana de inicio del juego
     */
    private void ingresar() {
        String nickname = JOptionPane.showInputDialog(vista, "Digita el nombre de usuario: ",
                "Bienvenido al desafio de laberintos", JOptionPane.QUESTION_MESSAGE);
        despachador.send("login:" + nickname);
        jugadorPresente = nickname;

    }

    /**
     * Método encargado de conectar cada objeto jugador correspondiente a un cliente con la ventana de juego
     */
    public void conectar() {
        Cliente conexion = new Cliente("localhost", 1234);
        try {
            despachador = conexion.conectar(vista);

            if (despachador != null) {
                ingresar();
                recuperarHistorial(vista);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        }
    }

    /**
     * Método encargado de almacenar ganadores de cada partida iniciada
     * @param resumenJuego: Texto que contiene el ganador de una partida
     */
    public static void agregarJuego(String resumenJuego) {
        try {
            FileWriter escritor = new FileWriter("src/net/historial.txt", true);
            escritor.write(resumenJuego + "\n");
            escritor.close();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error historial" + e);
        }

    }

    /**
     * Método encargado de leer historial de partidas y añadirlo al área de texto de la ventana principal
     * @param vista: ventana principal del juego para cada cliente
     */
    public static void recuperarHistorial(VentanaPrincipal vista) {
        try {
            String linea;
            BufferedReader lector = new BufferedReader(new FileReader("src/net/historial.txt"));
            while ((linea = lector.readLine()) != null) {
                vista.getHistorial().append(linea + "\n");
            }


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Clase que define los atributos de un jugador
     */
    public static class Jugador {
        private Color color;
        private String nickname;
        private int x;
        private int y;

        /**
         * Constructor: Inicializa atributos de un jugador
         * @param nick
         * @param log
         * @param x
         * @param y
         */
        public Jugador(String nick, Color log, int x, int y) {
            nickname = nick;
            color = log;
            this.x = x;
            this.y = y;
        }

        /**
         * Getter: retorna cadena correspondiente al atributo "color" de cada objeto jugador
         * @return String: color de cada objeto jugador
         */
        public String getColorJugador() {
            if (color.equals(Color.RED))
                return "RED";
            else if (color.equals(Color.BLUE))
                return "BLUE";
            else if (color.equals(Color.GREEN))
                return "GREEN";
            else
                return "BLACK";
        }

        /**
         * Getter: retorna atributo "color" de cada objeto jugador
         */
        public Color getColor() {
            return color;
        }

        /**
         * Getter: retorna atributo "nickname" de cada objeto jugador
         */
        public String getNickname() {
            return nickname;
        }

        /**
         * Getter: retorna atributo "x" de cada objeto jugador
         */
        public int getX() {
            return x;
        }

        /**
         * Getter: retorna atributo "y" de cada objeto jugador
         */
        public int getY() {
            return y;
        }

        /**
         * Setter: establecer atributo "x" de cada objeto jugador
         * @param x
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * Setter: establecer atributo "y" de cada objeto jugador
         * @param y
         */
        public void setY(int y) {
            this.y = y;
        }

        /**
         * Método encargado de modificar la posición del eje horizontal de un jugador
         * @param movement: unidades en las que se modifica la posición
         */
        public void moverX(int movement) {
            x += movement;
        }

        /**
         * Método encargado de modificar la posición del eje vertical de un jugador
         * @param movement: unidades en las que se modifica la posición
         */
        public void moverY(int movement) {
            y += movement;
        }

    }

}
