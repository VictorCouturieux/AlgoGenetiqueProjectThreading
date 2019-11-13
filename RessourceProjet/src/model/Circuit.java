package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Circuit {

    public static GestionAllCircuit GestionAllCircuit;
    ArrayList<Point> circuit;
    double fitness = 0.0;
    double distance = 0;

    public Circuit() {
        if (GestionAllCircuit == null)
            GestionAllCircuit = new GestionAllCircuit();
        this.circuit = new ArrayList<>();
    }

    public Circuit(ArrayList<Point> circuit) {
        if (GestionAllCircuit == null)
            GestionAllCircuit = new GestionAllCircuit();
        this.circuit = circuit;
    }

    public int len(){
        return circuit.size();
    }

    public Point getPoint(int index){
        return circuit.get(index);
    }
//    public void setPoint()


    public double getFitness() {
        return fitness;
    }
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

}


class GestionAllCircuit {

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
