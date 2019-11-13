import model.Circuit;
import model.Point;
import model.Population;

public class Application {
    public static void main(String[] args) {
        
        //region CreaPoint
        Point p1 = new Point(3.002556, 45.846117, "Clermont-Ferrand");
        Circuit.GestionAllCircuit.getList().add(p1);

        Point p2 = new Point(-0.644905, 44.896839, "Bordeaux");
        Circuit.GestionAllCircuit.getList().add(p2);

        Point p3 = new Point(-1.380989, 43.470961, "Bayonne");
        Circuit.GestionAllCircuit.getList().add(p3);

        Point p4 = new Point(1.376579, 43.662010, "Toulouse");
        Circuit.GestionAllCircuit.getList().add(p4);

        Point p5 = new Point(5.337151, 43.327276, "Marseille");
        Circuit.GestionAllCircuit.getList().add(p5);

        Point p6 = new Point(7.265252, 43.745404, "Nice");
        Circuit.GestionAllCircuit.getList().add(p6);

        Point p7 = new Point(-1.650154, 47.385427, "Nantes");
        Circuit.GestionAllCircuit.getList().add(p7);

        Point p8 = new Point(-1.430427, 48.197310, "Rennes");
        Circuit.GestionAllCircuit.getList().add(p8);

        Point p9 = new Point(2.414787, 48.953260, "Paris");
        Circuit.GestionAllCircuit.getList().add(p9);

        Point p10 = new Point(3.090447, 50.612962, "Lille");
        Circuit.GestionAllCircuit.getList().add(p10);

        Point p11 = new Point(5.013054, 47.370547, "Dijon");
        Circuit.GestionAllCircuit.getList().add(p11);

        Point p12 = new Point(4.793327, 44.990153, "Valence");
        Circuit.GestionAllCircuit.getList().add(p12);

        Point p13 = new Point(2.447746, 44.966838, "Aurillac");
        Circuit.GestionAllCircuit.getList().add(p13);

        Point p14 = new Point(1.750115, 47.980822, "Orleans");
        Circuit.GestionAllCircuit.getList().add(p14);

        Point p15 = new Point(4.134148, 49.323421, "Reims");
        Circuit.GestionAllCircuit.getList().add(p15);

        Point p16 = new Point(7.506950, 48.580332, "Strasbourg");
        Circuit.GestionAllCircuit.getList().add(p16);

        Point p17 = new Point(1.233757, 45.865246, "Limoges");
        Circuit.GestionAllCircuit.getList().add(p17);

        Point p18 = new Point(4.047255,48.370925, "Troyes");
        Circuit.GestionAllCircuit.getList().add(p18);

        Point p19 = new Point(0.103163,49.532415, "Le Havre");
        Circuit.GestionAllCircuit.getList().add(p19);

        Point p20 = new Point(-1.495348, 49.667704, "Cherbourg");
        Circuit.GestionAllCircuit.getList().add(p20);

        Point p21 = new Point(-4.494615, 48.447500, "Brest");
        Circuit.GestionAllCircuit.getList().add(p21);

        Point p22 = new Point(-0.457140, 46.373545, "Niort");
        Circuit.GestionAllCircuit.getList().add(p22);
        //endregion CreaPoint

        //limite la pop a 50 circuits
        Population pop = new Population(Circuit.GestionAllCircuit, 50, true);
        System.out.println("Distance initiale : " + pop.getFittest().getDistance());

        //evolutionn population sur 10 generation

        //generer une carte représentant notre solution


    }
}
