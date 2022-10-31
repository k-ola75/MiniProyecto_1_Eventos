package game;
import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel {
    private Laberinto laberinto;
    private Timer reloj;
    private static int puntos;


    public Juego() {
        super();
        setSize(Constantes.ANCHO_VENTANA_PPAL, Constantes.LARGO_VENTANA_PPAL);
        puntos = 0;

        Constantes.ALTURA_BARRA_TAREAS = this.getInsets().top;
        Constantes.BORDE_INFERIOR = this.getInsets().bottom;
        Constantes.BORDE_IZQUIERDO = this.getInsets().left;
        Constantes.BORDE_DERECHO = this.getInsets().right;

        this.setLayout(new FlowLayout());

        JLabel pointsLabel = new JLabel("Puntos:");
        this.add(pointsLabel);

        JTextField pointsTextField = new JTextField("0", 2);
        pointsTextField.setEditable(false);
        this.add(pointsTextField);

        Laberinto laberinto = new Laberinto();
        this.add(laberinto);

        reloj = new Timer(40, actionEvent -> {

            if(cambiarNivel(laberinto)){
                puntos++;
                pointsTextField.setText(""+puntos);
                JOptionPane.showMessageDialog(null,"Felicidades, Superaste la prueba");
                System.exit(0);
            }
        laberinto.repaint();
        });

        reloj.start();

    }

    public boolean cambiarNivel(Laberinto laberinto){
        if(laberinto.nivel1.getMapa(laberinto.jugador1.x/25,laberinto.jugador1.y/25).equals("f")){
            return true;
        }
        else return false;
    }

}
