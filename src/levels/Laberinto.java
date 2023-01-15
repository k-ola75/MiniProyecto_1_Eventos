package levels;

import java.awt.*;

/**
 * clase encargada de representar graficamente el laberinto.
 * @param levels instancia de la clase Leer_niveles utilizada para leer el archivo del nivel
 */
public class Laberinto {
    private int fila = 0, columna = 0;
    private final int numfilas = 13, numcolumnas = 23, altobloque = 30, anchobloque = 30;
    private Leer_niveles levels;

    /**
     * metodo encargado de graficar el laberinto
     * @param g instancia de la clase Graphics encargado de graficar el laboratorio
     * @param laberinto arreglo encragado de recuperar lo enviado por la clase Leer_niveles
     */
    public void paintfield(Graphics g) {
        int[][] laberinto = obtenerLaberinto();
        /**
         * ciclos encargado de recorrer el arreglo y graficarlo.
         * en caso de recibir un 1 grafica una pared
         * en caso de recibir un 2 graficaun triangulo que representa el fin del juego
         */
        for (fila = 0; fila < numfilas; fila++) {
            for (columna = 0; columna < numcolumnas; columna++) {
                if (laberinto[fila][columna] == 1) {
                    g.setColor(Color.gray);
                    g.fillRect(columna * 30, fila * 30, anchobloque, altobloque);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(columna * 30, fila * 30, anchobloque, altobloque);
                } else if (laberinto[fila][columna] == 2) {
                    g.setColor(Color.PINK);
                    int xpoints[] = {345, 330, 360};
                    int ypoints[] = {180, 210, 210};
                    int npoints = 3;
                    g.fillPolygon(xpoints, ypoints, npoints);
                }
            }
        }


    }

    /**
     * metodo encargado de recuperar la lectura hecha por el metodo Leer_niveles
     * @return recupera el laberinto y retorna un arreglo que lo representa
     */
    public int[][] obtenerLaberinto() {
        int nivel1[][] = levels.buildmaze();
        return nivel1;
    }
}
