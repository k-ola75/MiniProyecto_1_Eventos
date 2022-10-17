package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Mapas {
    public String[] mapArray = new String[20];
    public Scanner archivoEntrada;


    public Mapas() {

        abrirArchivo();
        leerArchivo();
        cerrarArchivo();
    }

    private void abrirArchivo() {
        try {
            archivoEntrada = new Scanner(new File("./niveles/nivel1.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void leerArchivo() {
        while (archivoEntrada.hasNext()) {
            for (int idx = 0; idx < 20; idx++) {
                mapArray[idx] = archivoEntrada.next();
            }
        }

    }

    private void cerrarArchivo() {
        archivoEntrada.close();

    }

    public String getMapa(int col, int filas) {
        String index = mapArray[filas].substring(col, col + 1);
        return index;
    }

}
