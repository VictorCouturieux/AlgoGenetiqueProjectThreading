package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class GeneticAlgo {

    GestionAllCircuit gestionCircuit;
    static double mutationRate;
    int tournoiSize;
    boolean elitisme;

    public GeneticAlgo(GestionAllCircuit gestionnaireCircuit) {
        gestionCircuit = gestionnaireCircuit;
        mutationRate = 0.15;
        tournoiSize = 50;
        elitisme = true;
    }

    public Population evoluatePopulation(Population pop) {
        Population newPop = new Population(gestionCircuit, pop.populationSize(), false);
        int elitismeOffset = 0;

        if(elitisme) {
            newPop.saveCircuit(0, pop.getFittest());
            elitismeOffset = 1;
        }

        ///////////////////

//        for(int i = elitismeOffset; i < newPop.populationSize(); i++) {
//            Circuit parent1 = selectionTournoi(pop);
//            Circuit parent2 = selectionTournoi(pop);
//
//            Circuit enfant = crossover(parent1, parent2);
//            newPop.saveCircuit(i, enfant);
//        }

////////////////////
//         reproduction
        int nbProcs = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(nbProcs);

        List<Future<Integer>> futures =
                new ArrayList<Future<Integer>>(nbProcs);

        for(int i = elitismeOffset; i < newPop.populationSize(); i++) {
            int finalI = i;
            futures.add(executorService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    Circuit parent1 = selectionTournoi(pop);
                    Circuit parent2 = selectionTournoi(pop);

                    Circuit enfant = crossover(parent1, parent2);
                    newPop.saveCircuit(finalI, enfant);
                    return null;
                }
            }));
        }
        for (Future<Integer> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

/////////////////////////
// reproduction
//        int nbProcs = Runtime.getRuntime().availableProcessors();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(nbProcs);
//
//        Set<Callable<String>> callables = new HashSet<Callable<String>>();
//
//        for(int i = elitismeOffset; i < newPop.populationSize(); i++) {
//            int finalI = i;
//            callables.add(new Callable<String>() {
//                public String call() throws Exception {
//                    Circuit parent1 = selectionTournoi(pop);
//                    Circuit parent2 = selectionTournoi(pop);
//
//                    Circuit enfant = crossover(parent1, parent2);
//                    newPop.saveCircuit(finalI, enfant);
//                    return "";
//                }
//            });
//        }
//        try {
//            executorService.invokeAll(callables);
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }
//
//        executorService.shutdown();

// ----/////----- proto
//        int index = elitismeOffset;
//        while (index < newPop.populationSize()){
//            for (int i = 0; i<nbProcs; i++){
//                Circuit parent1 = selectionTournoi(pop);
//                Circuit parent2 = selectionTournoi(pop);
//
//                Circuit enfant = crossover(parent1, parent2);
//                newPop.saveCircuit(index, enfant);
//                index++;
//            }
//        }

        ////////////////////////
        ///Executor Selection
//        int nbProcs = Runtime.getRuntime().availableProcessors();
//
//        for(int i = elitismeOffset; i < newPop.populationSize(); i++) {
//        ExecutorService esSelection = Executors.newFixedThreadPool(nbProcs);
//        Set<Callable<Circuit>> callables = new HashSet<Callable<Circuit>>();
//            callables.add(new Callable<Circuit>() {
//                public Circuit call() throws Exception {
//                    return selectionTournoi(pop);
//                }
//            });
//            callables.add(new Callable<Circuit>() {
//                public Circuit call() throws Exception {
//                    return selectionTournoi(pop);
//                }
//            });
//
//            Circuit parent1 = null;
//            Circuit parent2 = null;
//            try {
//                List<Future<Circuit>> futures = esSelection.invokeAll(callables);
//                esSelection.shutdown();
//                esSelection.awaitTermination(1, TimeUnit.HOURS);
//                parent1 = futures.get(0).get();
//                parent2 = futures.get(1).get();
//            } catch (InterruptedException ie) {
//                ie.printStackTrace();
//            } catch (ExecutionException ee) {
//                ee.printStackTrace();
//            }
//          esSelection.shutdown();
//            if (parent1 != null && parent2 != null) {
//
//                Circuit enfant = crossover(parent1, parent2);
//                newPop.saveCircuit(i, enfant);
//
//
//            }
//        }


////////////////////////
//        Thread[] tblThMating = new Thread[8];
//
//        for(int i = elitismeOffset; i < newPop.populationSize(); i++) {
//            int coef = 8;
//            int logI = i%coef;
//
//            MatingSynchro synchro = new MatingSynchro(i, pop, newPop, this);
//            tblThMating[logI] = new Thread(synchro);
//            tblThMating[logI].start();
//
//            joinThread(newPop, tblThMating, i, coef, logI);
//
//        }
//////////////
//        int nbThreadCoeur = Runtime.getRuntime().availableProcessors();
//        Thread[] tblThMating = new Thread[nbThreadCoeur];
//        int iter = 0;
//        while (iter < newPop.populationSize()){
//            for (int i=0; i<nbThreadCoeur; i++){
//                if (iter < newPop.populationSize()) {
//                    MatingSynchro synchro = new MatingSynchro(iter, pop, newPop, this);
//                    tblThMating[i] = new Thread(synchro);
//                    tblThMating[i].start();
//                }
//                iter++;
//            }
//
//            for (int i=0; i<nbThreadCoeur; i++){
//                try {
//                    if (tblThMating[i] != null)
//                        tblThMating[i].join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }

//////////////

//        for(int i = elitismeOffset; i < newPop.populationSize(); i++) {
//            MatingSynchro synchro = new MatingSynchro(i, pop, newPop, this);
//            Thread temp = new Thread(synchro);
//            temp.start();
//
//            try {
//                temp.join(50);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }

//        System.out.println(newPop.list.toString());

        //////////////////
        //////Mutation
        //////////////////

        for(int i = elitismeOffset; i < newPop.populationSize(); i++) {
            muter(newPop.getCircuit(i));
        }

        return newPop;
    }

    public Circuit crossover(Circuit parent1, Circuit parent2) {
        Circuit enfant = new Circuit();

       int startpos = (int)(Math.random() * parent1.getCircuit().size());
       int endPos = (int) (Math.random() * parent1.getCircuit().size());

       for(int i = 0; i < Circuit.GestionAllCircuit.list.size(); i++) {
           if(startpos < endPos && i > startpos && i < endPos) {
               enfant.setPoint(i, parent1.getPoint(i));
           }
           else if (startpos > endPos) {
               if ( !(i < startpos && i > endPos) ) {
                   enfant.setPoint(i, parent1.getPoint(i));
               }
           }
       }

       for (int i = 0; i < Circuit.GestionAllCircuit.list.size(); i++) {
           if(!(enfant.contientPoint(parent2.getPoint(i)))) {
               for (int j = 0 ; j < enfant.getCircuit().size(); j++) {
                   if(enfant.getPoint(j) == null) {
                       enfant.setPoint(j, parent2.getPoint(i));
                       break;
                   }
               }
           }
       }

        return enfant;
    }

    public void muter(Circuit circuit) {
        for (int circuitPos1 = 0; circuitPos1 < circuit.getCircuit().size(); circuitPos1 ++) {
            if(Math.random() < mutationRate) {
                muterAlgo(circuit, circuitPos1);
            }
        }
    }

    public static void muterAlgo(Circuit circuit, int circuitPos1) {
        int circuitPos2 = (int) (circuit.getCircuit().size() * Math.random());

        Ville point1 = circuit.getPoint(circuitPos1);
        Ville point2 = circuit.getPoint(circuitPos2);

        circuit.setPoint(circuitPos2, point1);
        circuit.setPoint(circuitPos1, point2);
    }

    public Circuit selectionTournoi(Population pop) {
        Population population = new Population(gestionCircuit, tournoiSize, false);

        for(int i =0; i < tournoiSize ; i++) {
            int randomId = (int)(Math.random() * pop.populationSize());
            population.saveCircuit(i, pop.getCircuit(randomId));
        }

        Circuit fittest = population.getFittest();

        return  fittest;
    }
//    public Circuit selectionTournoiThread(Population pop) {
//        Population population = new Population(gestionCircuit, tournoiSize, false);
//
//        for(int i =0; i < tournoiSize ; i++) {
//            int randomId = (int)(Math.random() * pop.populationSize());
//            population.saveCircuit(i, pop.getCircuit(randomId));
//        }
//
//        Circuit fittest = population.getFittest();
//
//        return  fittest;
//    }
}

class Reproduction implements Callable<Object>{
    @Override
    public Object call() throws Exception {
        return null;
    }
}
class Mutation implements Callable<Object>{
    @Override
    public Object call() throws Exception {
        return null;
    }
}
class Selection implements Callable<Circuit>{

    Population p;

    public Selection(Population p) {
        this.p = p;
    }

    @Override
    public Circuit call() throws Exception {



        return null;
    }
}


//class MatingSynchro implements Runnable {
//
//    int index;
//    Population pop;
//    Population newPop;
//    GeneticAlgo ga;
//
//    public MatingSynchro(int index, Population pop, Population newPop, GeneticAlgo ga) {
//        this.index = index;
//        this.pop = pop;
//        this.newPop = newPop;
//        this.ga = ga;
//    }
//
//    @Override
//    synchronized public void run() {
//        Circuit parent1 = ga.selectionTournoi(pop);
//        Circuit parent2 = ga.selectionTournoi(pop);
//
//        Circuit enfant = ga.crossover(parent1, parent2);
//        newPop.saveCircuit(index, enfant);
//    }
//}
//
//class MutaSynchro implements Runnable {
//
//    Circuit circuit;
//
//    public MutaSynchro(Circuit circuit) {
//        this.circuit = circuit;
//    }
//
//    @Override
//    public void run() {
//        for (int circuitPos1 = 0; circuitPos1 < circuit.getCircuit().size(); circuitPos1 ++) {
//            if(Math.random() < GeneticAlgo.mutationRate) {
//                GeneticAlgo.muterAlgo(circuit, circuitPos1);
//            }
//        }
//    }
//}
//
//class SelectSynchro implements Runnable {
//
//    int index;
//    Population pop;
//    Population population;
//    GeneticAlgo ga;
//
//    public SelectSynchro(int index, Population pop, Population population, GeneticAlgo ga) {
//        this.index = index;
//        this.pop = pop;
//        this.population = population;
//        this.ga = ga;
//    }
//
//    @Override
//    public void run() {
//        int randomId = (int)(Math.random() * pop.populationSize());
//        population.saveCircuit(index, pop.getCircuit(randomId));
//    }
//}

