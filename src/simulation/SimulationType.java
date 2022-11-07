package simulation;

import java.util.ArrayList;

public class SimulationType {

    private SimulationCircuit simulationCircuit;

    public String OUTPUT_INFO = "";

    public String output_sample = "";

    public ArrayList <String> info = new ArrayList<>();

    public SimulationType(SimulationCircuit simulationCircuit){
        this.simulationCircuit = simulationCircuit;
    }

    public String getFMR(){
        return this.OUTPUT_INFO;
    }



    public void monteCarloReliabilityAPI(String Sensitive_Library) throws Exception{

        this.printSpecSimulation();

        /* Constructor */
        Management simulacaoMultithreading = new Management(simulationCircuit.getThreads(), simulationCircuit.getReliabilityConst(), simulationCircuit.getRelativePath(),
                simulationCircuit.getRelativePath() + simulationCircuit.getGenlib(), simulationCircuit.getRelativePath() + simulationCircuit.getCircuit());

        /* Monte Carlo Simulation */
        simulacaoMultithreading.monteCarloReliability(Math.round(simulationCircuit.getMtf_sizes().get(0)), simulationCircuit.getMtf_sizes(), simulationCircuit.getSignalsToinjectFault(), Sensitive_Library);
        simulacaoMultithreading.classifyTotalSensitiveAreas();
        /* Sensitive Areas Analysis based in all vectors (20k)*/
        //info.add(simulacaoMultithreading.printGates(Math.round(simulationCircuit.getMtf_sizes().get(0)), simulationCircuit.getMtf_sizes(), simulationCircuit.getSignalsToinjectFault(), Sensitive_Library));

        //simulacaoMultithreading.printSensitiveAreasAnalysis();

        this.OUTPUT_INFO = simulacaoMultithreading.getMTBF(" MTFT Sample (Monte Carlo = N): ");
        System.out.println(this.OUTPUT_INFO);
    }

    public void faultToleranceMonteCarloMETAPI(String External_Link) throws Exception{


       // System.out.println("\n\n ------");

        /*
        Management simulacaoMultithreading = new Management(simulationCircuit.getThreads(), simulationCircuit.getReliabilityConst(), simulationCircuit.getRelativePath(),
                simulationCircuit.getRelativePath() +  simulationCircuit.getGenlib(), simulationCircuit.getRelativePath() + simulationCircuit.getCircuit());
        */

        if(External_Link.equals("CREsT")) {
            Management simulacaoMultithreading = new Management(simulationCircuit.getThreads(), simulationCircuit.getReliabilityConst(), simulationCircuit.getRelativePath(),
                    simulationCircuit.getGenlib(), simulationCircuit.getCircuit());
            simulacaoMultithreading.runMultipleFaultInjectionMultithreadingMonteCarloSimulationProportion(Math.round(simulationCircuit.getMtf_sizes().get(0)),
                    simulationCircuit.getMtf_sizes(), simulationCircuit.getSignalsToinjectFault());
            this.OUTPUT_INFO = simulacaoMultithreading.getER(" MTFT Sample (Monte Carlo = N)");
        }
        else{
            Management simulacaoMultithreading = new Management(simulationCircuit.getThreads(), simulationCircuit.getReliabilityConst(), simulationCircuit.getRelativePath(),
                    simulationCircuit.getRelativePath() + simulationCircuit.getGenlib(), simulationCircuit.getRelativePath() + simulationCircuit.getCircuit());
            simulacaoMultithreading.runMultipleFaultInjectionMultithreadingMonteCarloSimulationProportion(Math.round(simulationCircuit.getMtf_sizes().get(0)),
                    simulationCircuit.getMtf_sizes(), simulationCircuit.getSignalsToinjectFault());
            this.OUTPUT_INFO = simulacaoMultithreading.getER(" MTFT Sample (Monte Carlo = N)");
        }




    }


    /**
     * Method to link the Logic Simulator and run method Exhaustive Simulation for SET evaluation (Extracts the Fault Masking Rate - FMR)
     * @throws Exception e e
     */
    public void exhaustiveSensitiveAreaAnalysisAPI() throws Exception { //ou Signals =  "ALL_SIGNALS" for exaustive consider all_signals

        /*
        Management simulationManagement = new Management(simulationCircuit.getThreads(), simulationCircuit.getReliabilityConst(), simulationCircuit.getRelativePath(),
                simulationCircuit.getRelativePath() + simulationCircuit.getGenlib(), simulationCircuit.getRelativePath() + simulationCircuit.getCircuit());

         */
        System.out.println("Simulation Exaustive SET and Sensitive Area without faults");
        Management simulationManagement = new Management(simulationCircuit.getThreads(), simulationCircuit.getReliabilityConst(), simulationCircuit.getRelativePath(),
                simulationCircuit.getRelativePath()+ simulationCircuit.getGenlib(), simulationCircuit.getRelativePath()+ simulationCircuit.getCircuit());

        simulationManagement.runExhausticSimulationAndSensitiveAreaAnalysis(simulationCircuit.getSignalsToinjectFault());


        //simulationManagement.printSensitiveAreasAnalysis();
        this.OUTPUT_INFO = simulationManagement.getER("Sample (N = "
                + "2^Signals * Gates)");
    }
    public void faultToleranceMonteCarloAPI() throws Exception{
        this.printSpecSimulation();
        //System.out.println(" >>>> PATH AND FILE: " + simulationCircuit.getRelativePath() + simulationCircuit.getCircuit());
        Management simulacaoMultithreading = new Management(simulationCircuit.getThreads(), simulationCircuit.getReliabilityConst(), simulationCircuit.getRelativePath(),
                simulationCircuit.getRelativePath()+ simulationCircuit.getGenlib(), simulationCircuit.getRelativePath()+  simulationCircuit.getCircuit());

        simulacaoMultithreading.runMultithreadingMonteCarlo(simulationCircuit.getSample(), simulationCircuit.getSignalsToinjectFault()); //ou Signals =  "ALL_SIGNALS" ou "INTERMEDIATE" ou "INTERMEDIATE_AND_OUTPUTS" ou "INPUTS" ou "INPUTS_OUTPUTS"

        this.OUTPUT_INFO = simulacaoMultithreading.getER(" Sample(Monte Carlo = N)");
    }

    public void printSpecSimulation(){

        if(this.simulationCircuit.getMode().equals("STF")){
            System.out.println();
            System.out.println("------------SimulationMode------------------");
            System.out.println("- STF's Simulation -");
            System.out.println("- Circuit: " + this.simulationCircuit.getCircuit());
            System.out.println("- MC Single Fault Injection: " + this.simulationCircuit.getMode());
            System.out.println("- Path: " + this.simulationCircuit.getRelativePath());
            System.out.println("- Genlib: " + this.simulationCircuit.getGenlib());
            System.out.println("----------------");
        }

        if(this.simulationCircuit.getMode().equals("MTF")){
            System.out.println();
            System.out.println("------------SimulationMode------------------");
            System.out.println("- MTF's Simulation Proportion ");
            System.out.println("- Circuit: " + this.simulationCircuit.getCircuit());
            System.out.println("- MC Multiple Fault Injection : " + this.simulationCircuit.getMtf_sizes());
            System.out.println("- Path: " + this.simulationCircuit.getRelativePath());
            System.out.println("- Genlib: " + this.simulationCircuit.getGenlib());
            System.out.println("----------------");

        }
    }
    public void faultToleranceExhaustiveCompleteMETAPI() throws Exception{ //ou Signals =  "ALL_SIGNALS" for exhaustive consider all_signals
        Management simulacaoMultithreading = new Management(simulationCircuit.getThreads(), simulationCircuit.getReliabilityConst(), simulationCircuit.getRelativePath(),
                simulationCircuit.getRelativePath() +   simulationCircuit.getGenlib(), simulationCircuit.getRelativePath() + simulationCircuit.getCircuit());

        // this.output_sample = simulacaoMultithreading.SampleSizeExhaustiveCompleteMET(simulationCircuit.getSignalsToinjectFault());
        simulacaoMultithreading.faultToleranceExhaustiveCompleteMET(simulationCircuit.getSignalsToinjectFault());
        this.OUTPUT_INFO = simulacaoMultithreading.getER("Sample (N = "
                + "2^Signals * Gates)");
    }
}
