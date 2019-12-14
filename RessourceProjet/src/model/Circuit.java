package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Circuit {

    public static GestionAllCircuit GestionAllCircuit = new GestionAllCircuit();
    ArrayList<Ville> circuit;
    double fitness = 0.0;
    double distance = 0;

    public Circuit() {
        this.circuit = new ArrayList<>();
    }

    public Circuit(ArrayList<Ville> circuit) {
        this.circuit = circuit;
    }

    public void generatePeople() {
        for (int i = 0; i < GestionAllCircuit.list.size() ; i++) {
            setPoint(i, GestionAllCircuit.list.get(i));
        }

        Collections.shuffle(circuit);
    }

    public double getDistance(){
        if (distance == 0){
            double circuitDist = 0;
            int i=0;
            for (Ville p : circuit){
                Ville arrivPoint = circuit.get(i+1);
                circuitDist += p.distance(arrivPoint);
                i++;
            }
            distance = circuitDist;
        }
        return distance;
    }

    public Ville getPoint(int index){
        return circuit.get(index);
    }
    public void setPoint(int index, Ville point){
        circuit.add(index, point);
    }

    public double getFitness() {
        return fitness;
    }
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public boolean contientPoint(Ville point){
        return circuit.contains(point);
    }

    public ArrayList<Ville> getCircuit() {
        return circuit;
    }
    public void setCircuit(ArrayList<Ville> circuit) {
        this.circuit = circuit;
    }
}


