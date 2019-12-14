package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Population {

    ArrayList<Circuit> list;

    public Population(GestionAllCircuit gestionnaireCircuit, int populationSize, boolean init) {

        this.list = new ArrayList<>();

        for (int i = 0 ; i < populationSize ; i++) {
            list.add(new Circuit());
        }

        if(init) {
            for (int i = 0; i< populationSize; i++) {
                Circuit newCircuit =new Circuit();
                newCircuit.generatePeople();
                saveCircuit(i, newCircuit);
            }
        }
    }

    public void addCircuit(Ville[] points){
        Circuit circuit = new Circuit();
        circuit.GestionAllCircuit.addListPoints(points);
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
        list.add(index, circuit);
    }

    public Circuit getFittest() {
        Circuit fittest = list.get(0);

        for (int i = 0; i < populationSize(); i++) {
            if(fittest.getFitness() <= getCircuit(i).getFitness()) {
                fittest = getCircuit(i);
            }
        }

        return fittest;
    }

    public int populationSize() {
        return list.size();
    }
}
