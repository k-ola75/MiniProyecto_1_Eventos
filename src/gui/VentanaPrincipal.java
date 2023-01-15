package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Clase encargada de crear la ventana principal en cada cliente
 * @param panel contiene todos los omponentes de la ventana
 * @param tablero canvas encargado de contener el laberinto y asus jugadores
 * @param historial area de texto donde se guarda el historico de partidas
 */

public class VentanaPrincipal extends JFrame {

    Container panel;
    private Tablero lienzo;
    private JTextArea historial;

    /**
     *constructor de la ventana principal
     */
    public VentanaPrincipal() {
        super("----MAZE----");
        setSize(1000, 570);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panel = getContentPane();
        panel.setLayout(new BorderLayout());

        JPanel titulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel txt_level = new JLabel("---------LEVEL 1---------");
        titulo.add(txt_level);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel general = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));
        lienzo = new Tablero();
        general.add(lienzo);
        historial = new JTextArea(30,20);
        historial.setEnabled(false);
        general.add(historial);
        JScrollPane scrollpane1=new JScrollPane(historial);
        scrollpane1.setBounds(10,10,100,50);
        general.add(scrollpane1);

        panel.add(general,BorderLayout.CENTER);
    }

    public JTextArea getHistorial() {

        return historial;
        /**
         * @return regresa el puntero hacia la area de texto para ingresar el historial previamente guardado
         */
    }


    public Tablero getLienzo() {

        return lienzo;

        /**
         * @return regresa el puntero hacia el lienzo para futuras manipulaciones
         */
    }
}