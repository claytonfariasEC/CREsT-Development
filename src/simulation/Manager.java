package simulation;

public class Manager {

    public Manager(int sampleSize, String flagSimulationType){

    }
    public void computeSimulationSize(String simulationType){

        switch (simulationType) {
            /// Exhaustive
            case "Exhaustive":
                System.out.println("Exhaustive Simulation ");

                /// Do something
                break;

            case "MonteCarlo":
                System.out.println("Monte Carlo Simulation ");
                
                /// Do something
                break;


        }

        /// Monte Carlo

    }

    public void assignSignalsToInjectFaults(){

    }

    public void createAndParticionateVectors(){


    }

}
