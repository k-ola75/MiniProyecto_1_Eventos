package clases;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame{
    Container panel;
    Laberinto laberinto;
    public VentanaPrincipal(){//constructor
        super("Min.Proyecto -> LABERINTO");//creacion del objeto mediante super que es la clase padre
        setSize(490,470);//manipulacion del tamaño de la ventana
        setLocation(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = getContentPane();//espacio que contiene los objetos que agreguemos a la ventana
        panel.setLayout(new FlowLayout());

        JLabel inicio = new JLabel("INTENTA CRUZAR EL LABERINTO");
        panel.add(inicio);

        Laberinto laberinto = new Laberinto();
        panel.add(laberinto);//se añade el objeto al panel

    }

}
