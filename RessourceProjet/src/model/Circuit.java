package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Circuit {

    ArrayList<Point> list;

    public Circuit() {
        list = new ArrayList<>();
    }

    public void addPoint(int x, int y){
        list.add(new Point(x, y));
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
