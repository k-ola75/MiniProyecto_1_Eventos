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

    public MenuPpal() {
        super("Maze Runner");
        setSize(Constantes.ANCHO_VENTANA_PPAL, Constantes.LARGO_VENTANA_PPAL);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        try {
            File path = new File("./imagenes");
            imagen = ImageIO.read(new File(path, "maze2.jpg"));
            File pathLogo = new File("./imagenes");
            imagen2 = ImageIO.read(new File(path, "logo.jpg"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ImageIcon fondo = new ImageIcon(imagen);
        ImageIcon logo = new ImageIcon(imagen2);
        this.setIconImage(logo.getImage());//cambia ícono del frame

        //Image img = fondo.getImage();
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
        //restricciones.fill = GridBagConstraints.BASELINE;
        //jugar.setAlignmentX(Component.CENTER_ALIGNMENT);
        //jugar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        panel.add(jugar, restricciones);

        //JButton boton2 = new JButton ("Salir");
        /*restricciones.gridx = 0;
        restricciones.gridy = 1;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        panel.add (boton2, restricciones);*/
        /*boton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton2.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.add (boton2);*/


        //JButton boton4 = new JButton ("Boton 4");
        /*restricciones.gridx = 0;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        panel.add (boton4, restricciones);*/

        jugar.addActionListener(ActionEvent -> {
            juego = new Juego();
            /*restricciones.gridx = 0;
            restricciones.gridy = 0;
            restricciones.gridwidth = 1;
            restricciones.gridheight = 1;
            restricciones.weightx = 0.5;
            restricciones.weighty = 0.5;
            restricciones.fill = GridBagConstraints.NORTHWEST;*/
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.removeAll();
            juego.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(juego);
            juego.setVisible(true);
            this.revalidate();
            this.repaint();
        });
    }
}
