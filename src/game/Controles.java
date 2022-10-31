package game;

import java.awt.*;
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

        switch ( e.getKeyCode() ){
            case 38://arriba
                if (jugador.y > Constantes.ALTURA_BARRA_TAREAS) {
                    if (!mapa.getMapa((int) (jugador.x / 25), (int) ((jugador.y - 1) / 25)).equals("w"))
                        jugador.y -= 25;
                }
                break;
            case 40://abajo
                if (jugador.y + jugador.largo < Constantes.LARGO_LABERINTO) {
                    if (!mapa.getMapa((int) (jugador.x / 25), (int) ((jugador.y + 25) / 25)).equals("w"))
                        jugador.y += 25;
                }
                break;
            case 37://izquierda
                if (jugador.x > Constantes.BORDE_IZQUIERDO) {
                    if (!mapa.getMapa((int) ((jugador.x - 1) / 25), (int) (jugador.y / 25)).equals("w"))
                        jugador.x -= 25;
                }
                break;
            case 39://derecha
                if (jugador.x + jugador.ancho < Constantes.ANCHO_LABERINTO){
                    if (!mapa.getMapa((int) ((jugador.x + 25) / 25), (int) (jugador.y / 25)).equals("w"))
                        jugador.x += 25;
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
