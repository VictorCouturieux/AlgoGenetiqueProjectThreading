package view;

import model.Circuit;
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
        setSize(1000, 1000);
        setLocation(400, 25);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public void paint(Graphics g) {

        for (Circuit circuit : pop.getList()) {
            for (Ville ville : circuit.getCircuit()) {
                drawMapPoint(ville, g);
            }
        }

    }


    private void drawMapPoint(Ville v, Graphics g){

        System.out.println(v.getX() + " : " + v.getY());

        int pX = (int) (400 + v.getX()*60);
        int pY = (int) (-2300 + v.getY()*60);

        System.out.println(pX + " : " + pY);

        g.fillOval(pY, pX, 10, 10);

    }







}
