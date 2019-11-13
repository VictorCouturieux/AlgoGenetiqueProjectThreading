package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Circuit {

    public static GestionAllCircuit GestionAllCircuit = new GestionAllCircuit();
    ArrayList<Point> circuit;
    double fitness = 0.0;
    double distance = 0;

    public Circuit() {
        this.circuit = new ArrayList<>();
    }

    public Circuit(ArrayList<Point> circuit) {
        this.circuit = circuit;
    }

    public double getDistance(){
        if (distance == 0){
            double circuitDist = 0;
            int i=0;
            for (Point p : circuit){
                Point arrivPoint = circuit.get(i+1);
                circuitDist += p.distance(arrivPoint);
                i++;
            }
            distance = circuitDist;
        }
        return distance;
    }

    public Point getPoint(int index){
        return circuit.get(index);
    }
    public void setPoint(int index, Point point){
        circuit.add(index, point);
    }

    public double getFitness() {
        return fitness;
    }
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public boolean contientPoint(Point point){
        return circuit.contains(point);
    }

    public ArrayList<Point> getCircuit() {
        return circuit;
    }
    public void setCircuit(ArrayList<Point> circuit) {
        this.circuit = circuit;
    }
}


