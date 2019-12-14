package view;

import model.Population;
import model.Ville;

import javax.swing.*;
import java.awt.*;

public class FrameShowMap extends JFrame {

    private Population pop;

    public FrameShowMap(Population pop) throws HeadlessException {
        super();
        this.pop = pop;

        setTitle("SHOW MAP");
        setSize(400, 400);
        setLocation(200, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }



    public void paint(Graphics g) {

        drawMapPoint(pop.getList().get(0).getPoint(0), g);

    }


    private void drawMapPoint(Ville v, Graphics g){

        System.out.println(v.getX() + ":" + v.getY());

        int pX = 0;
        int pY = 0;

        g.fillOval(pY -5, pX -5, 10, 10);

    }







}
