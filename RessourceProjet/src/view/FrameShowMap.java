package view;

import model.Population;

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

        g.fillOval(100, 100, 20, 20);



    }





}
