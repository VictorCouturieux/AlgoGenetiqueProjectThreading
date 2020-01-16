package model;

public class GeneticAlgo {

    GestionAllCircuit gestionCircuit;
    double mutationRate;
    int tournoiSize;
    boolean elitisme;

    public GeneticAlgo(GestionAllCircuit gestionnaireCircuit) {
        gestionCircuit = gestionnaireCircuit;
        mutationRate = 0.015;
        tournoiSize = 5;
        elitisme = true;
    }

    public Population evoluatePopulation(Population pop) {
        Population newPop = new Population(gestionCircuit, pop.populationSize(), false);
        int elitismeOffset = 0;

        if(elitisme) {
            newPop.saveCircuit(0, pop.getFittest());
            elitismeOffset = 1;
        }

        for(int i = elitismeOffset; i < newPop.populationSize(); i++) {
            Circuit parent1 = selectionTournoi(pop);
            Circuit parent2 = selectionTournoi(pop);

            Circuit enfant = crossover(parent1, parent2);
            newPop.saveCircuit(i, enfant);
        }

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
                int circuitPos2 = (int) (circuit.getCircuit().size() * Math.random());

                Ville point1 = circuit.getPoint(circuitPos1);
                Ville point2 = circuit.getPoint(circuitPos2);

                circuit.setPoint(circuitPos2, point1);
                circuit.setPoint(circuitPos1, point2);
            }
        }
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
}
