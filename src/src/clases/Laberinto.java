package clases;
import java.awt.*;

public class Laberinto extends Canvas{
    private int anchoBloque = 10;
    public Laberinto(){
        super();
        setBackground(Color.lightGray);
        setSize(340,310);
    }

    public void paint(Graphics maze) {
        //genera los bordes del laberinto
        maze.fillRect(0,0, 340,anchoBloque);
        maze.fillRect(0,30, anchoBloque,380);
        maze.fillRect(0,300, 340,anchoBloque);
        maze.fillRect(330,0, anchoBloque,280);
        //********

        //paredes dentro del laberinto -> el tamaño del camino es de pixeles
        maze.fillRect(10,30, 30,anchoBloque);
        maze.fillRect(40,60, 40,anchoBloque);
        maze.fillRect(70,30, anchoBloque,100);
        maze.fillRect(40,120, 30,anchoBloque);
        maze.fillRect(40,130, anchoBloque,60);
        maze.fillRect(40,150, 110,anchoBloque);
        maze.fillRect(40,210, 60,anchoBloque);
        maze.fillRect(40,220, anchoBloque,30);
        maze.fillRect(10,270, 60,anchoBloque);
        maze.fillRect(70,240, anchoBloque,40);
        maze.fillRect(100,180, anchoBloque,120);
        maze.fillRect(70,180, 30,anchoBloque);
        maze.fillRect(140,10, anchoBloque,120);
        maze.fillRect(140,160, anchoBloque,60);
        maze.fillRect(140,240, anchoBloque,60);
        maze.fillRect(150,210, 30,anchoBloque);
        maze.fillRect(150,120, 30,anchoBloque);
        maze.fillRect(210,120, 30,anchoBloque);
        maze.fillRect(170,30, anchoBloque,60);
        maze.fillRect(170,90, 30,anchoBloque);
        maze.fillRect(170,150, 30,anchoBloque);
        maze.fillRect(230,150, 30,anchoBloque);
        maze.fillRect(170,160, anchoBloque,120);
        maze.fillRect(230,90, 70,anchoBloque);
        maze.fillRect(260,100, anchoBloque,90);
        maze.fillRect(200,70, anchoBloque,90);
        maze.fillRect(200,10, anchoBloque,30);
        maze.fillRect(200,180, anchoBloque,100);
        maze.fillRect(210,180, 50,anchoBloque);
        maze.fillRect(210,270, 90,anchoBloque);
        maze.fillRect(290,280, anchoBloque,20);
        maze.fillRect(290,100, anchoBloque,60);
        maze.fillRect(290,180, anchoBloque,40);
        maze.fillRect(260,210, 30,anchoBloque);
        maze.fillRect(300,180, 30,anchoBloque);
        maze.fillRect(230,190, anchoBloque,60);
        maze.fillRect(240,240, 60,anchoBloque);
        maze.fillRect(210,30, 50,anchoBloque);//p
        maze.fillRect(290,30, anchoBloque,40);//p
        maze.fillRect(200,60, 210,anchoBloque);
        maze.fillRect(10,90, 30,anchoBloque);
        maze.fillRect(70,30, 40,anchoBloque);
        maze.fillRect(110,30, anchoBloque,100);

    }

}