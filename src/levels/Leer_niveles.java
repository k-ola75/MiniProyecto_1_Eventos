package levels;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * clase encargada exclusivamente de leer el archivo donde se contienen los niveles
 */

public class Leer_niveles {

    public static int[][] buildmaze() {
        /**
         * @param maze arreglo encargado de guardar el contenido del archivo de texto
         */

        String thisLine = "";
        int lectorlinea = 0;
        int[][] maze = new int[13][23];

        try {

            BufferedReader br = new BufferedReader(new FileReader("./src/levels/level1.txt"));

            while ((thisLine = br.readLine()) != null) {
                /**
                 * Despues de leer una linea se recorre para ir agregandolas al arreglo maze,
                 * SOLO SE LEERAN LAS CARACTERES 0 - 1 -2
                 */
                for (int idx = 0; idx < thisLine.length(); idx++) {
                    int temp = Character.getNumericValue(thisLine.charAt(idx));
                    if (temp == 1 || temp == 0 || temp == 2) {
                        maze[lectorlinea][idx] = temp;
                    }
                }
                lectorlinea++;
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo");
        }
        return maze;

        /**
         * @return retorna el arreglo extraido de la lectura previa del archivo donde se contiene
         */
    }

}
