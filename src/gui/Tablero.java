package gui;

import controller.Controlador;
import levels.Laberinto;
import net.Despachador;
import java.awt.*;
import java.util.HashMap;

/**
 * clase encargada de pintar a los jugadores y al laberinto.
 * Ademas de pintar las actualizaciones que se realicen
 */
public class Tablero extends Canvas {
    private Laberinto laberinto = new Laberinto();
    int[][] lab = laberinto.obtenerLaberinto();
    private HashMap<String, Controlador.Jugador> jugadores = new HashMap<>(2);
    private String jugadorPresente = "";
    private Despachador despachador;
    private final int ancho = 30;
    private final int alto = 30;

    /**
     * constructor encargado de asignar tamaño y color de fondo
     */
    public Tablero() {
        super();
        setBackground(Color.white);
        setSize(690, 390);
        setFocusable(true);
    }

    /**
     * metodo encargado de pintar cada jugador conectado junto a su respectivo laberinto
     * @param g   the specified Graphics context
     */
    public void paint(Graphics g) {

        for (Controlador.Jugador j : jugadores.values()) {
            laberinto.paintfield(g);
            g.setColor(j.getColor());
            g.fillOval(j.getX(), j.getY(), ancho, alto);
        }

    }

    /**
     *
     * @param jugadorPresente metodo encargado de asignar el nickname al jugador que este activo
     */
    public void setJugadorPresente(String jugadorPresente){
        this.jugadorPresente = jugadorPresente;
    }

    /**
     *
     * @param jugadores encargado de modificar el listado de jugadores
     */
    public void setJugadores(HashMap<String, Controlador.Jugador> jugadores){
        this.jugadores = jugadores;
    }

    /**
     *
     * @return regresa el listado de jugadores activos en ese instante
     */
    public HashMap<String, Controlador.Jugador> getJugadores() {
        return jugadores;
    }

}
