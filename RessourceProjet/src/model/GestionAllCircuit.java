package model;

import java.util.ArrayList;
import java.util.Arrays;

public class GestionAllCircuit {

    ArrayList<Ville> list;

    public GestionAllCircuit() {
        list = new ArrayList<>();
    }

    public int nbCircuits(){
        return list.size();
    }

    public void addPoint(int x, int y, String nom){
        list.add(new Ville(x, y, nom));
    }
    public void addListPoints(Ville[] points){
        list.addAll(Arrays.asList(points));
    }

    public ArrayList<Ville> getList() {
        return list;
    }
    public void setList(ArrayList<Ville> list) {
        this.list = list;
    }


}
