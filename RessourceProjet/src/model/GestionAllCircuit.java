package model;

import java.util.ArrayList;
import java.util.Arrays;

public class GestionAllCircuit {

    ArrayList<Point> list;

    public GestionAllCircuit() {
        list = new ArrayList<>();
    }

    public int nbCircuits(){
        return list.size();
    }

    public void addPoint(int x, int y, String nom){
        list.add(new Point(x, y, nom));
    }
    public void addListPoints(Point[] points){
        list.addAll(Arrays.asList(points));
    }

    public ArrayList<Point> getList() {
        return list;
    }
    public void setList(ArrayList<Point> list) {
        this.list = list;
    }


}
