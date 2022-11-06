package game;

import java.awt.*;

public class Laberinto extends Canvas {
    public Figuras jugador1;
    public Figuras bloques;
    private Controles controlJugador1;
    public Mapas nivel1;

    public Laberinto() {
        super();
        setBackground(Color.WHITE);
        setSize(Constantes.ANCHO_LABERINTO, Constantes.LARGO_LABERINTO);
        nivel1 = new Mapas();
        bloques = new Figuras(0, 0, 25, 25, Color.BLACK);

        jugador1 = new Figuras(25, 0, Constantes.ANCHO_JUGADOR1, Constantes.LARGO_JUGADOR1, Constantes.COLOR_JUGADOR1);
        controlJugador1 = new Controles(jugador1, nivel1);
        this.addKeyListener(controlJugador1);
/*este movimiento hay que moverlo al archivo de juego
para hacer el repaint cuando se presione la tecla y no con el timer para evitar las interferencias en la pantalla*/
    }
    public void paint(Graphics maze) {

        for (int filas = 0; filas < 20; filas++) {
            for (int col = 0; col < 20; col++) {
                if (nivel1.getMapa(col, filas).equals("w")) {
                    bloques.cambiarCoordenadas(col * 25, filas * 25);
                    bloques.dibujar(maze);
                }
            }
        }
    jugador1.dibujar(maze);
    }


}
