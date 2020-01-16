package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Circuit {

    public static GestionAllCircuit GestionAllCircuit = new GestionAllCircuit();
    ArrayList<Ville> circuit;
//    Ville[] tblCircuit = new Ville[GestionAllCircuit.list.size()];
    double fitness = 0.0;
    double distance = 0;

    public Circuit() {
        this.circuit = new ArrayList<>();

        for (int i = 0; i<GestionAllCircuit.list.size(); i++){
            circuit.add(null);
        }

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
            for (Ville originePoint : circuit){
                Ville arrivPoint = null;
                if (i+1<circuit.size())
                    arrivPoint = circuit.get(i+1);
                else
                    arrivPoint = circuit.get(0);
                circuitDist += originePoint.distance(arrivPoint);
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
        circuit.remove(index);
        circuit.add(index, point);
    }

    public double getFitness() {
        if(fitness == 0) {
            fitness = 1/getDistance();
        }
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


