package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Population {

    ArrayList<Circuit> list;

    public Population(GestionAllCircuit gestionnaireCircuit, int populationSize, boolean init) {

        this.list = new ArrayList<>();

        for (int i = 0 ; i < populationSize ; i++) {
            list.add(null);
        }

        if(init) {
            for (int i = 0; i< populationSize; i++) {
                Circuit newCircuit = new Circuit();
                newCircuit.generatePeople();
                saveCircuit(i, newCircuit);
            }
        }
    }

    public void addCircuit(Ville[] points){
        Circuit circuit = new Circuit();
        Circuit.GestionAllCircuit.addListPoints(points);
        list.add(circuit);
    }

    public void addListCircuits(Circuit[] circuits){
        list.addAll(Arrays.asList(circuits));
    }

    public ArrayList<Circuit> getList() {
        return list;
    }

    public void setList(ArrayList<Circuit> list) {
        this.list = list;
    }

    public Circuit getCircuit(int index) {
        return list.get(index);
    }

    public void saveCircuit(int index, Circuit circuit) {
        list.set(index, circuit);
    }

    public Circuit getFittest() {
        Circuit fittest = list.get(0);

        for (int i = 0; i < this.populationSize(); i++) {
            if(fittest.getFitness() <= getCircuit(i).getFitness()) {
                fittest = this.getCircuit(i);
            }
        }
        if (fittest.circuit.size() == 0)
            System.out.println();

        return fittest;
    }

    public int populationSize() {
        return list.size();
    }
}
