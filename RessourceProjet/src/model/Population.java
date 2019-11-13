package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Population {

    ArrayList<Circuit> list;

    public Population() {
        this.list = new ArrayList<>();
    }

    public void addCircuit(Point[] points){
        Circuit circuit = new Circuit();
        circuit.addListPoints(points);
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
}
