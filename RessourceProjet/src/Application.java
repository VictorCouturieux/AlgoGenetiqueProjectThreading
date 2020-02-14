import model.*;
import view.FrameShowMap;

import java.util.ArrayList;

public class Application {

    private static int NBPOP_VALID = 200;

    public static void main(String[] args) {

        long debut = System.currentTimeMillis();


        //region CreaPoint
        Ville p1 = new Ville(3.002556, 45.846117, "Clermont-Ferrand");
        Circuit.GestionAllCircuit.getList().add(p1);

        Ville p2 = new Ville(-0.644905, 44.896839, "Bordeaux");
        Circuit.GestionAllCircuit.getList().add(p2);

        Ville p3 = new Ville(-1.380989, 43.470961, "Bayonne");
        Circuit.GestionAllCircuit.getList().add(p3);

        Ville p4 = new Ville(1.376579, 43.662010, "Toulouse");
        Circuit.GestionAllCircuit.getList().add(p4);

        Ville p5 = new Ville(5.337151, 43.327276, "Marseille");
        Circuit.GestionAllCircuit.getList().add(p5);

        Ville p6 = new Ville(7.265252, 43.745404, "Nice");
        Circuit.GestionAllCircuit.getList().add(p6);

        Ville p7 = new Ville(-1.650154, 47.385427, "Nantes");
        Circuit.GestionAllCircuit.getList().add(p7);

        Ville p8 = new Ville(-1.430427, 48.197310, "Rennes");
        Circuit.GestionAllCircuit.getList().add(p8);

        Ville p9 = new Ville(2.414787, 48.953260, "Paris");
        Circuit.GestionAllCircuit.getList().add(p9);

        Ville p10 = new Ville(3.090447, 50.612962, "Lille");
        Circuit.GestionAllCircuit.getList().add(p10);

        Ville p11 = new Ville(5.013054, 47.370547, "Dijon");
        Circuit.GestionAllCircuit.getList().add(p11);

        Ville p12 = new Ville(4.793327, 44.990153, "Valence");
        Circuit.GestionAllCircuit.getList().add(p12);

        Ville p13 = new Ville(2.447746, 44.966838, "Aurillac");
        Circuit.GestionAllCircuit.getList().add(p13);

        Ville p14 = new Ville(1.750115, 47.980822, "Orleans");
        Circuit.GestionAllCircuit.getList().add(p14);

        Ville p15 = new Ville(4.134148, 49.323421, "Reims");
        Circuit.GestionAllCircuit.getList().add(p15);

        Ville p16 = new Ville(7.506950, 48.580332, "Strasbourg");
        Circuit.GestionAllCircuit.getList().add(p16);

        Ville p17 = new Ville(1.233757, 45.865246, "Limoges");
        Circuit.GestionAllCircuit.getList().add(p17);

        Ville p18 = new Ville(4.047255,48.370925, "Troyes");
        Circuit.GestionAllCircuit.getList().add(p18);

        Ville p19 = new Ville(0.103163,49.532415, "Le Havre");
        Circuit.GestionAllCircuit.getList().add(p19);

        Ville p20 = new Ville(-1.495348, 49.667704, "Cherbourg");
        Circuit.GestionAllCircuit.getList().add(p20);

        Ville p21 = new Ville(-4.494615, 48.447500, "Brest");
        Circuit.GestionAllCircuit.getList().add(p21);

        Ville p22 = new Ville(-0.457140, 46.373545, "Niort");
        Circuit.GestionAllCircuit.getList().add(p22);
        //endregion CreaPoint

        //limite la pop a 50 circuits
        Population pop = new Population(Circuit.GestionAllCircuit, 1000, true);

        GeneticAlgo ga = new GeneticAlgo(Circuit.GestionAllCircuit);

        ArrayList<Population> popValide = new ArrayList<>();

        //iterat number
//        pop = ga.evoluatePopulation(pop);
//        for (int i =0; i<1000 ; i++)
//            pop = ga.evoluatePopulation(pop);

        pop = ga.evoluatePopulation(pop);
        int itera = 0;
        while (!compareGeneration(popValide)){
            popValide.add(pop);
            if (popValide.size()>NBPOP_VALID)
                popValide.remove(0);
            pop = ga.evoluatePopulation(pop);
            itera++;
        }
        System.out.println("nb iteration : " + itera);


        Circuit bestPop = pop.getFittest();
        //generer une carte représentant notre solution
        new FrameShowMap(bestPop);

        //Affiche la durée d'exécution en millisecondes
        System.out.println("RunTimeMilis : " + (System.currentTimeMillis() - debut));

        //nb Processeur
        System.out.println("Nb Coeur PC : " + Runtime.getRuntime().availableProcessors());

    }

    private static boolean compareGeneration(ArrayList<Population> list){
        if (list.size()<NBPOP_VALID)
            return false;
//        int valide=0, diff=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                // compare list.get(i) and list.get(j)
//                if (list.get(i).getFittest().getDistance() != list.get(j).getFittest().getDistance())
//                    diff++;
//                else
//                    valide++;
                ///////
                if (list.get(i).getFittest().getDistance() != list.get(j).getFittest().getDistance())
                    return false;
            }
        }
//        System.out.println("valide : " + valide + " //diff : " + diff);
//        if (diff != 0)
//            return false;
//        else
            return true;

    }

    private static Population getBestPopFromGenerationList(ArrayList<Population> list){
        Population pop = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFittest().getDistance() > pop.getFittest().getDistance())
                pop = list.get(i);
        }
        return pop;
    }

//    private static Population comparePopWithBestGenerationList(Population pop, ArrayList<Population> list){
//
//        Population BestPopList = getBestPopFromGenerationList(list);
////
////        if ()
////        return list.
//    }
}
