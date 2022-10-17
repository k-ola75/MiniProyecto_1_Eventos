package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;


public class Laberinto extends Canvas {
    //private int anchoBloque = 10;
    public Figuras jugador1;
    public Figuras bloques;
    private Controles controlJugador1;
    public Mapas nivel1;
    Timer reloj;


    public Laberinto(Timer reloj) {
        super();
        setBackground(Color.WHITE);
        setSize(Constantes.ANCHO_LABERINTO, Constantes.LARGO_LABERINTO);
        this.reloj = reloj;
        nivel1 = new Mapas();
        bloques = new Figuras(0, 0, 25, 25, Color.BLACK);

        jugador1 = new Figuras(25, 0, Constantes.ANCHO_JUGADOR1, Constantes.LARGO_JUGADOR1, Constantes.COLOR_JUGADOR1);
        controlJugador1 = new Controles(jugador1, nivel1);
        this.addKeyListener(controlJugador1);

    }

    public void paint(Graphics maze) {
        jugador1.dibujar(maze);

        for (int filas = 0; filas < 20; filas++) {
            for (int col = 0; col < 20; col++) {
                if (nivel1.getMapa(col, filas).equals("w")) {
                    bloques.cambiarCoordenadas(col * 25, filas * 25);
                    bloques.dibujar(maze);
                }
            }
        }
    }
}
