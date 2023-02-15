package simulation;

import datastructures.CellLibrary;
import datastructures.Circuit;
import datastructures.Signal;
import levelDatastructures.LevelCircuit;
import logicSimulator.LogicSimulator;
import logicSimulator.SensitiveCell;
import readers.MappedVerilogReader;
import signalProbability.ProbCircuit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Manager extends ManagementUpdated {
        private int sampleSize;

    private ArrayList<LogicSimulator> itemx_list = new ArrayList<>();
    private CellLibrary cellLibrary;
    Circuit circuit;
    private final String circuitNameStr;
    private LevelCircuit levelCircuit;
    ProbCircuit probCircuit;
    private LevelCircuit lCircuit;
    private int unmasked_faults;
    private float ER;

    private float ASReal;
    private MappedVerilogReader verilog_circuit;
    private String Performance_Time;
    private int sizeExaustiveCompleteSimulation;

    private ArrayList<Float> mtf_list = new ArrayList<>();
    private Map<String, SensitiveCell> sensitive_cells;
    private float MTBF;
    private float MTBFReal;
    private float avgASFLOAT;

    private long sumSet = 0;
    private String SAMode="";
    //abc test

    private String ThreadSimulationFlag = "";

    private ArrayList<Signal> signals_to_inject_faults = new ArrayList<>();
    private final ArrayList<String> inputListValues = new ArrayList<>();
    private final ArrayList<ArrayList<String>> inputListValuesStr = new ArrayList<>();
    private final ArrayList<ArrayList<String>> outputFreeFaultListValueStr = new ArrayList<>();
    private final ArrayList<ArrayList<String>> outputListValueStr = new ArrayList<>();
    private final ArrayList<ArrayList<String>> SignalFault = new ArrayList<>();
    private final ArrayList<ArrayList<String>> SignalFaultBitFlip = new ArrayList<>();




    /**
     * @param threads
     * @param reliabilityConst
     * @param relativePath
     * @param genlib
     * @param circuitName
     * @throws IOException
     */
    public Manager(int threads, String reliabilityConst, String relativePath, String genlib, String circuitName, ProbCircuit probCircuit, Circuit circuit) throws IOException {
        super(threads, reliabilityConst, relativePath, genlib, circuitName);
        this.cellLibrary = new CellLibrary();
        this.circuitNameStr = circuitName;
        this.genlib = genlib;
        this.reliabilityConst = reliabilityConst;
        this.relativePath = relativePath;
        this.threads = threads;
        this.mtf_list = new ArrayList<>();
        this.probCircuit = probCircuit;
        this.circuit = circuit;
    }

    public void setupManager(String flagSimulationType){
        //this.sampleSize = 0;
        computeSimulationSize(flagSimulationType);
    }

    public void computeSimulationSize(String simulationType){
        System.out.println(this.circuitNameStr);
        switch (simulationType) {
            /// Exhaustive
            case "Exhaustive":
                System.out.println("Exhaustive Simulation ");
                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());
                break;

            case "MonteCarlo":
                System.out.println("Monte Carlo Simulation ");
                
                /// Do something
                break;

        }



    }

    /**
     * @param option
     * @return
     */
    public ArrayList<Signal> signalsToInjectFault(String option) {

        ArrayList<Signal> signalList = new ArrayList<>();
        signalList = this.circuit.getSignals();
        ArrayList<Signal> r = new ArrayList<>();

        switch (option) {

            case "INPUTS":

                for (int i = 0; i < signalList.size(); i++) {
                    if (((this.circuit.getInputs().contains(signalList.get(i))))) {

                        r.add(signalList.get(i));
                    }

                }
                System.out.println("  --- Input Signals (total): " + r.size());
                return r;
            //break;


            case "INTERMEDIATE_AND_OUTPUTS":

                for (int i = 0; i < signalList.size(); i++) {
                    if (!((this.circuit.getInputs().contains(signalList.get(i))))) {
                        r.add(signalList.get(i));
                    }

                }
                System.out.println("  --- Intermediate and output Signals (total): " + r.size());
                System.out.println(r);
                return r;


            case "INTERMEDIATE":

                for (int i = 0; i < signalList.size(); i++) {
                    if (!((this.circuit.getInputs().contains(signalList.get(i))) || (this.circuit.getOutputs().contains(signalList.get(i))))) {

                        r.add(signalList.get(i));
                    }

                }
                System.out.println("  --- Intermediate Signals (total): " + r.size());
                return r;

            case "INPUTS_OUTPUTS":

                for (int i = 0; i < signalList.size(); i++) {
                    if (((this.circuit.getInputs().contains(signalList.get(i))) || (this.circuit.getOutputs().contains(signalList.get(i))))) {

                        r.add(signalList.get(i));
                    }

                }
                System.out.println("  --- Intermediate Signals (total): " + r.size());
                return r;


            case "ALL_SIGNALS":

                for (int i = 0; i < signalList.size(); i++) {
                    r.add(signalList.get(i));
                }
                System.out.println("     --> Considering all signals (input, intermediate, output): " + r.size());
                return r;

            case "SENSITIVE_AREA":

                //for (int i = 0; i < signalList.size(); i++) {
                r.add(signalList.get(0));
                //}
                System.out.println("     --> Considering all signals (input, intermediate, output): " + r.size());
                return r;

            case "":
                System.out.println("Error !!! Please insert the correct Fault Signals String");
                break;
        }
        return null;

    }

    public void createAndParticionateVectors(){


    }
    public ProbCircuit getProbCircuitManager() {
        return this.probCircuit;
    }
    public int getSampleSize() {
        return this.sampleSize;
    }
}
