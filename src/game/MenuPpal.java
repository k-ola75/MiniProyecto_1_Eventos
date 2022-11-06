package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MenuPpal extends JFrame {
    public Container panel;
    public Juego juego;
    private BufferedImage imagen = null;
    private BufferedImage imagen2 = null;
    private ImageIcon fondo, logo;

    public MenuPpal() {
        super("Maze Runner");
        setSize(Constantes.ANCHO_VENTANA_PPAL, Constantes.LARGO_VENTANA_PPAL);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        charge_img();
        this.setIconImage(logo.getImage());//cambia ícono del frame

        JLabel labelFondo = new JLabel(fondo);
        setContentPane(labelFondo);

        Constantes.ALTURA_BARRA_TAREAS = this.getInsets().top;
        Constantes.BORDE_INFERIOR = this.getInsets().bottom;
        Constantes.BORDE_IZQUIERDO = this.getInsets().left;
        Constantes.BORDE_DERECHO = this.getInsets().right;

        panel = getContentPane();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints restricciones = new GridBagConstraints();

        JButton jugar = new JButton("Jugar");
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        panel.add(jugar, restricciones);

        jugar.addActionListener(ActionEvent -> {
            juego = new Juego();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.removeAll();
            juego.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(juego);
            juego.setVisible(true);
            this.revalidate();
            this.repaint();
        });
    }

    private void charge_img(){
        try {
            File path = new File("./src/imagenes");
            imagen = ImageIO.read(new File(path, "maze2.jpg"));
            File pathLogo = new File("./src/imagenes");
            imagen2 = ImageIO.read(new File(pathLogo, "logo.jpg"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fondo = new ImageIcon(imagen);
        logo = new ImageIcon(imagen2);
    }
}
