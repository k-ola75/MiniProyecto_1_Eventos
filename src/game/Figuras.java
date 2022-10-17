package game;

import java.awt.*;

public class Figuras {
    public int x, y, ancho, largo;
    public Color color;

    public Figuras(int x, int y, int ancho, int largo, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.largo = largo;
        this.color = color;
    }

    public void dibujar(Graphics graficos) {
        graficos.setColor(color);
        graficos.fillRect(x, y, ancho, largo);
    }

    public void cambiarCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
