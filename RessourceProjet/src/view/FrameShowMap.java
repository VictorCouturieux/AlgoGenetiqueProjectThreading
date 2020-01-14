package view;

import model.Circuit;
import model.Population;
import model.Ville;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FrameShowMap extends JFrame {

    private Population pop;

    int width = 1000, height = 1000;

    public FrameShowMap(Population pop) throws HeadlessException {
        super();
        this.pop = pop;

        setTitle("SHOW MAP");
        setSize(width, height);
        setLocation(400, 25);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public void paint(Graphics g) {

        Ville v = null;

//        ArrayList<Ville> polylineVille = new ArrayList<>();
//        for (Circuit circuit : pop.getList()) {
//            for (Ville ville : circuit.getCircuit()) {
//                drawMapPoint(ville, g);
//
//                polylineVille.add(ville);
//
////                if (v != null)
////                    drawMapLine(v, ville, g);
////
////                v = ville;
//            }
//        }
//        drawMapPolyline(polylineVille, g);

        drawMapPolyline(Circuit.GestionAllCircuit.getList(), g);

    }


    private void drawMapPoint(Ville v, Graphics g){

//        System.out.println(v.getX() + " : " + v.getY());

        int pX = (int) (400 + v.getX()*60) -5;
        int pY = (int) (-2300 + v.getY()*60) -5;

//        System.out.println(pX + " : " + pY);

        g.fillOval(pX, pY, 10, 10);

    }

    private void drawMapLine(Ville v1, Ville v2, Graphics g){

        int p1X = (int) (400 + v1.getX()*60);
        int p1Y = (int) (-2300 + v1.getY()*60);

        int p2X = (int) (400 + v2.getX()*60);
        int p2Y = (int) (-2300 + v2.getY()*60);

        g.drawLine(p1X, p1Y, p2X, p2Y);
    }

    private void drawMapPolyline(ArrayList<Ville> listV, Graphics g){

        ArrayList<Integer> aListX =  new ArrayList<>();
        ArrayList<Integer> aListY = new ArrayList<>();

        for (Ville v : listV) {
            int px = (int) (400 + v.getX()*60);
            int py = (int) (-2300 + v.getY()*60);

            aListX.add(px);
            aListY.add(py);
        }
        int[] lX = aListX.stream().mapToInt(i -> i).toArray();
        int[] lY = aListY.stream().mapToInt(i -> i).toArray();

        g.drawPolyline(lX, lY, listV.size());
    }


}
