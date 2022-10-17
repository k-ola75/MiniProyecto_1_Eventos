package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener {
    public Figuras jugador;
    public Mapas mapa;

    public Controles(Figuras jugador, Mapas mapa) {

        this.jugador = jugador;
        this.mapa = mapa;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP) {
            if (jugador.y > Constantes.ALTURA_BARRA_TAREAS) {
                if (!mapa.getMapa((int) (jugador.x / 25), (int) ((jugador.y - 1) / 25)).equals("w"))
                    jugador.y -= 25;
            }
        } else if (e.getKeyCode() == e.VK_DOWN) {
            if (jugador.y + jugador.largo < Constantes.LARGO_LABERINTO) {
                if (!mapa.getMapa((int) (jugador.x / 25), (int) ((jugador.y + 25) / 25)).equals("w"))
                    jugador.y += 25;
            }
        } else if (e.getKeyCode() == e.VK_LEFT) {
            if (jugador.x > Constantes.BORDE_IZQUIERDO) {
                if (!mapa.getMapa((int) ((jugador.x - 1) / 25), (int) (jugador.y / 25)).equals("w"))
                    jugador.x -= 25;
            }
        } else if (e.getKeyCode() == e.VK_RIGHT) {
            if (jugador.x + jugador.ancho < Constantes.ANCHO_LABERINTO)
                if (!mapa.getMapa((int) ((jugador.x + 25) / 25), (int) (jugador.y / 25)).equals("w"))
                    jugador.x += 25;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
