package simulation;

import datastructures.Circuit;
import logicSimulator.SensitiveCell;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SimulationModeAdapter extends Management{
    /**
     * @param threads
     * @param reliabilityConst
     * @param relativePath
     * @param genlib
     * @param circuitName
     * @throws IOException
     */
    public SimulationModeAdapter(int threads, String reliabilityConst, String relativePath, String genlib, String circuitName) throws IOException {
        super(threads, reliabilityConst, relativePath, genlib, circuitName);
    }
    public Circuit returnCircuit(){
        return this.circuit;
    }
    public void runExhausticSimulationAndSensitiveAreaAnalysis(String option) throws IOException, Exception { //Test All possibilities

        /* Timers */

        /* Setup Enviroment */
        /* Define Simulation Sizes Sample Size */
        //String simulationMode = "runExhausticSimulationAndSensitiveAreaAnalysis";

        this.setsimulationMode("runExhausticSimulationAndSensitiveAreaAnalysis");

        Instant start = Instant.now();
                /*
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);
                */

        LocalDateTime myDateObj = this.getTimeStampDate();
        String formattedDate = this.getTimeStampDateString(myDateObj);

        this.setupEnviroment(option, this.simulationMode);

        //System.out.println(this.sensitive_cells);

        //System.out.println("    - Simulation start in : " + formattedDate);

        this.printToolStatus();

        //System.out.println("    - Threads in execution: " + this.threads);
        this.printSpecsSimulation();

        Instant loadTimeElapsed = Instant.now();

        Instant startPreparingSimulationTimeElapsed = Instant.now();

                /*
                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());

                int N = this.sampleSize; // random_input_vectors.size();//testNumber;

                int sizeExasuticTest; //= (this.sampleSize * this.signals_to_inject_faults.size());;

                this.signals_to_inject_faults = this.signalsToInjectFault(option);

                 */

        List thread_list = this.createVectorsAndParticionate(this.sampleSize, option, "TRUE_TABLE_SINGLE");

        System.out.println("-   Sample size (N = 2^ENTRADAS): " + "2^" + this.circuit.getInputs().size() + " = " + this.sampleSize + "   Sigs: " + this.signals_to_inject_faults.size());

        int sizeExasuticTest  = (this.sampleSize * this.signals_to_inject_faults.size());

        Instant endPreparingSimulationTimeElapsed = Instant.now();

        Instant startThreadingTimeElapsed = Instant.now();

        this.executeThreadsSimulation(thread_list);  // Prepare and run the thread simulation

        Instant endThreadingTimeElapsed = Instant.now();

        this.sampleSize = sizeExasuticTest;

        //System.out.println("Sample Size: " + this.sampleSize);

        int bitfipCcounter = this.parseResultsAndCalculateER();  // ER

        Instant finish = Instant.now();

        long timeElapsed_Instant = Duration.between(start, finish).toSeconds();

                /*
                LocalDateTime myDateObj2 = LocalDateTime.now();
                DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate2 = myDateObj2.format(myFormatObj2);
                */


        LocalDateTime myDateObj2 = this.getTimeStampDate();
        String formattedDate2 = this.getTimeStampDateString(myDateObj2);

        Instant startTimelogGeneration = Instant.now();

        long timeElapsed_loadTime = Duration.between(start, loadTimeElapsed).toSeconds();
        long timeElapsed_PrepareTime = Duration.between(startPreparingSimulationTimeElapsed, endPreparingSimulationTimeElapsed).toSeconds();
        long timeElapsed_ThreadingTime = Duration.between(startThreadingTimeElapsed, endThreadingTimeElapsed).toSeconds();

        Instant endTimelogGeneration = Instant.now();

        long timeElapsed_logGeneration = Duration.between(startTimelogGeneration, endTimelogGeneration).toSeconds();

        this.definePostSimulationAnalysis();

        //System.out.println("AVGS: " + this.avgASFLOAT);

        this.writeLogs(this.relativePath + option + "_ExausticSTFSimulation_" + this.circuit.getName() + "_Threads-" + this.threads + "_sampleSize-" + this.sampleSize, formattedDate, formattedDate2, timeElapsed_Instant, itemx_list, "STF");

        System.out.println("----------------------------------------------------------------------");


        this.printResults("Exhaustive", formattedDate, formattedDate2, bitfipCcounter, timeElapsed_loadTime, timeElapsed_PrepareTime, timeElapsed_ThreadingTime, timeElapsed_logGeneration, timeElapsed_Instant);
        //String specific, String formattedDate, String formattedDate2,
        // int bitfipCcounter, long timeElapsed_loadTime, long timeElapsed_PrepareTime,
        // long timeElapsed_ThreadingTime, long timeElapsed_logGeneration, long timeElapsed_Instant){

        System.out.println("-----------------------END SIMULATION---------------------------------");

        this.Performance_Time = "Simulation started at: " + formattedDate + " and finished at: " + formattedDate2;



    }


}

