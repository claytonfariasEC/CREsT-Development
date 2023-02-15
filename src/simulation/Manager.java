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
import java.util.List;
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
    public ArrayList<Signal> assignsignalsToInjectFault(String option) {

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

    /**
     * Generate input vectors according with sampleSize and signalsOption defition
     *
     * @param sampleSize    eg: 20000 SET faults (Particle generating SET)
     * @param signalsOption
     * @return
     * @throws Exception
     */
    public List createVectorsAndParticionate(int sampleSize, String signalsOption, String option) throws Exception {

        List thread_list = new ArrayList();
        ArrayList<String> random_input_vectors;
        ArrayList<ArrayList<Integer>> ListInputVectors;

        this.sampleSize = sampleSize; //(int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());

        /* Comentario estava sobrescrevendo as opções para injeção de falhas*/
        //this.signals_to_inject_faults = this.signalsToInjectFault(signalsOption); // Consider all signals to fault inject


        switch (option) {
            case "RANDOM":
                System.out.println("STF - RANDOM");
                random_input_vectors = this.generateInputVector(option); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = this.particionateVectorPerThread(ListInputVectors); // x - vectors per thread
                break;

            case "TRUE_TABLE_SINGLE":
                System.out.println("STF - Exhaustive for STF");
                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = particionateExausticVector(ListInputVectors); // x - vectors per thread
                break;


            case "TRUE_TABLE_SINGLE_FAULT":
                System.out.println("STF - Exhaustive for STF - Logical Masking ");
                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = particionateExausticVector(ListInputVectors); // x - vectors per thread
                break;

            case "TRUE_TABLE_SINGLE_SA":
                System.out.println("STF - Exhaustive for STF and Sensitive Area ANALYSIS SINGLE Thread");
                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());
                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = particionateExausticVectorSA(ListInputVectors); // x - vectors per thread
                break;

            case "TRUE_TABLE_SINGLE_SA_NEW":
                System.out.println("STF - Exhaustive for STF and Sensitive Area ANALYSIS SINGLE Thread - New aprouch");
                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());
                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = particionateExausticVectorSASingleThread(ListInputVectors); // x - vectors per thread
                break;
            case "TRUE_TABLE_SINGLE_SA_ADAPTIVE":
                System.out.println("STF - Exhaustive for STF and Sensitive Area ANALYSIS - ADAPTIVE");
                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());
                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = particionateExausticVectorSAADAPTIVE(ListInputVectors); // x - vectors per thread
                break;
            //"TRUE_TABLE_SINGLE_SA"
            case "TRUE_TABLE_SINGLE_SA_FREE":
                System.out.println("STF - Exhaustive for STF and Sensitive Area ANALYSIS");
                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());
                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = particionateExausticVectorSAFREE(ListInputVectors); // x - vectors per thread
                break;

            case "TRUE_TABLE_COMPLETE":
                //this.signals_to_inject_faults = this.signalsToInjectFault(option);
                System.out.println("STF - Exhaustive for STF");
                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                System.out.println(" total vectors: "  +random_input_vectors.size());
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                System.out.println(" ListInputVectors: "  +ListInputVectors.size());
                thread_list = particionateExausticVectorComplete(ListInputVectors);  // TESTE ALL GATES ///particionateVectorPerThread(ListInputVectors); // x - vectors per thread
                System.out.println(" thread_list: "  +thread_list.size());
                break;

            case "TRUE_TABLE_COMPLETE_SIMULATION":
                System.out.println("Estimate Simulation MTF sample ....");
                //random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                //ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                EstimateMTFSimulationSample();  // TESTE ALL GATES ///particionateVectorPerThread(ListInputVectors); // x - vectors per thread

                break;

            case "MTF-RANDOM":
                System.out.println("MTF - RANDOM");
                random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = this.particionateMultipletransientFaultInjectionVectorPerThreadProportion(ListInputVectors, this.mtf_list); // x - vectors per thread
                break;

            case "MTF-Generate_Netlist":
                System.out.println("MTF - RANDOM");
                System.out.println("MTF - RANDOM");
                random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = this.particionateMultipletransientFaultInjectionVectorPerThreadProportion(ListInputVectors, this.mtf_list); // x - vectors per thread
                break;


            case "STF-Generate_Netlist":
                System.out.println("STF-Generate_Netlist");
                random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable
                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                thread_list = this.particionateVectorPerThread(ListInputVectors); // x - vectors per thread
                break;


        }

        return (thread_list);
    }

    public ProbCircuit getProbCircuitManager() {
        return this.probCircuit;
    }
    public int getSampleSize() {
        return this.sampleSize;
    }
}
