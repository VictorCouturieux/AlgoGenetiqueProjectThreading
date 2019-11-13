package model;

public class Point {

    private double x, y;
    private String nom;

    public Point(double x, double y, String nom) {
        this.x = x;
        this.y = y;
        this.nom = nom;
    }

    public double distance(Point otherPoint){
        double distanceX = (otherPoint.getX()-x)*40000*Math.cos((y+otherPoint.getY())*Math.PI/360)/360;
        double distanceY = (y-otherPoint.getY())*40000f/360f;

        return Math.sqrt((distanceX*distanceX) + (distanceY*distanceY));
    }


    public double getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
