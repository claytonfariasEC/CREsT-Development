package simulation;

import datastructures.CellLibrary;
import datastructures.Circuit;
import datastructures.Gate;
import datastructures.Signal;
import jxl.write.WriteException;
import levelDatastructures.LevelCircuit;
import logicSimulator.*;
import readers.MappedVerilogReader;
import signalProbability.ProbCircuit;
import writers.WriteFile;
import writers.WriteLog;

import javax.script.ScriptException;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//import logicSimulator.main;

//public class Management extends MAIN{

public class Management extends RunSimulations {

        ArrayList<LogicSimulator> itemx_list = new ArrayList<>();
        int sampleSize;
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
        String Performance_Time;
        private int sizeExaustiveCompleteSimulation;

        private ArrayList<Float> mtf_list = new ArrayList<>();
        public Map<String, SensitiveCell> sensitive_cells;
        private float MTBF;
        private float MTBFReal;
        private float avgASFLOAT;

        private String optionMode = "";

        private long sumSet = 0;
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_RESET = "\u001B[0m";

        ArrayList<Signal> signals_to_inject_faults = new ArrayList<>();
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
        public Management(int threads, String reliabilityConst, String relativePath, String genlib, String circuitName) throws IOException {
                super(threads, reliabilityConst, relativePath, genlib);
                this.cellLibrary = new CellLibrary();
                this.circuitNameStr = circuitName;
                this.genlib = genlib;
                this.reliabilityConst = reliabilityConst;
                this.relativePath = relativePath;
                this.threads = threads;
                this.mtf_list = new ArrayList<>();
        }

        public void initProbCircuit() {
                if (this.circuit != null) {
                        this.lCircuit = this.levelCircuit; //Terminal.getInstance().getLevelCircuit();
                        this.probCircuit = new ProbCircuit(this.circuit);
                        //System.out.println("InitProbCircuit " + this.probCircuit.getName());

                } else {
                        System.out.println("Circuit is null !!!");
                }
        }

        public void initLevelCircuit() {
                if (this.circuit != null) {
                        //System.out.println("InitLevelCircuit");
                        this.levelCircuit = new LevelCircuit(this.circuit);
                } else {
                        System.out.println("Circuit is null!!");
                }
        }

        public void printSpecsSimulation() {
                System.out.println("    ... Reading Genlib " + " at -> " + this.genlib + " ... ok");
                System.out.println("    ... Avaliable logic gates in this library: " + this.cellLibrary.getCells().size());
                System.out.println("    ... Reading verilog " + " at -> " + this.circuitNameStr + " ... ok");
        }

        public Map<String, SensitiveCell> readCsvFileAndMapSensitiveCellsArea(String input, String comma){


                String line = "";

                String outputString;

                //String ArrayCsv[] = new String[4];

                Map<String, SensitiveCell> sensitive_cells = new HashMap<>();

                try (BufferedReader br = new BufferedReader(new FileReader(input))) {

                        //Para cada linea no vacia
                        for (int i = 0; (line = br.readLine()) != null ; i++) {

                                String[] table = line.split(comma);

                                String concat = table[0]+"_"+table[1];

                                outputString = "Cell " + table[0] + " Vec = " + table[1]+ " , Sensitive_Area " + table[2];

                                SensitiveCell cell = new SensitiveCell(concat, table[1], table[2]);

                                sensitive_cells.put(concat, cell);

                                //System.out.println(line + " splitted " + outputString);

                        }
                } catch (IOException e) {
                        System.out.println("Error reading .csv");
                        e.printStackTrace();
                }
                return sensitive_cells;
        }

        /**
         * This methods setup genlib and verilog to proceed any simulation
         *
         * @param simulation_type
         * @throws IOException
         * @throws Exception
         */
        public void setupEnviroment(String simulation_type) throws IOException, Exception {

                System.out.println(simulation_type);
                System.out.println("- Genlibrary: " + this.genlib);

                CellLibrary cellLib = new CellLibrary();
                this.cellLibrary = cellLib;
                this.cellLibrary.initLibrary(this.genlib);


                /*Reading verilog*/
                MappedVerilogReader verilog_circuit = new MappedVerilogReader(this.circuitNameStr, this.cellLibrary);
                this.verilog_circuit = verilog_circuit;
                /*Circuit linked to veril       og_circuit - init circuit*/
                this.circuit = verilog_circuit.getCircuit();

                System.out.println("- Circuit: " + this.circuit.getName());
                /*Circuit Probabilities */
                this.initLevelCircuit();

                /*Init ProbCircuits*/
                this.initProbCircuit();

                /*Init PTMs Const*/
                cellLib.setPTMCells2(Float.valueOf(this.reliabilityConst));
                cellLib.setPTMCells(new BigDecimal(this.reliabilityConst));

                /* Print circuit Specs */
                this.printSpecsSimulation();

                //System.out.println("\n        ------ Printing Circuit Specs: --------");
                //this.PrintSpecs();
                //System.out.println("          ---------------------------------------\n");
                /*----------------------*/

                if(this.circuit.getGates().size() > 3000){
                        System.out.println("- Gates: " + this.circuit.getGates().size());
                }

                String SA_file= "./teste/lookup_table.csv";

                File f = new File(SA_file);
                System.out.println("Reading Sensitive Area File " + f + " exist: " + f.exists());
                        if(f.exists()) {
                                System.out.println("Founded: " + SA_file);

                                Map <String, SensitiveCell> sensitive_cells = readCsvFileAndMapSensitiveCellsArea(SA_file, ",");

                                System.out.println("- Sensitive Cells: " + sensitive_cells.size());

                                this.setSensitiveCells(sensitive_cells);

                }else{
                                System.err.println("    Sensitive Area File not founded: " + SA_file);
                        }



        }

        public void setSensitiveCells(Map <String, SensitiveCell> sensitive_cells){
                this.sensitive_cells = sensitive_cells;
        }

        /**
         * Write Simple and Complete logs, showing the simulation results: ER, Failure Rate, Sensitive Nodes, ...., another informations
         *
         * @param fileName
         * @param date
         * @param dateend
         * @param propagateTimems
         * @param itemx_list
         * @throws IOException
         * @throws WriteException
         */
        public void writeLogs(String fileName, String date, String dateend, long propagateTimems, ArrayList<LogicSimulator> itemx_list, String mode) throws IOException, WriteException {

                System.out.println("- Writing logs ...");
                System.out.println("- Simple Log " + fileName + "  (.txt)");
                System.out.println("- Complete Log " + fileName + "  (.csv)");

                int min = 0;
                int max = 1000;

                //Generate random int value from 50 to 100
                System.out.println("Random value in int from "+min+" to "+max+ ":");
                int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
                System.out.println(random_int);

                switch (mode) {

                        case "STF":
                                WriteLog log_STF = new WriteLog(this.sampleSize, this.threads,
                                        this.unmasked_faults, this.ER, this.circuit,
                                        this.verilog_circuit, this.signals_to_inject_faults); //(int sampleSize, int threads, int unmasked_faults,  float ER, Circuit circuit, MappedVerilogReader verilog_circuit ,ArrayList<Signal> signals_to_inject_faults){
                                //(int sampleSize, int threads, int unmasked_faults,  float ER, Circuit circuit, MappedVerilogReader verilog_circuit ,ArrayList<Signal> signals_to_inject_faults, ArrayList <Float> mtf_sizes){
                                log_STF.WriteSimpleLog(fileName, date, dateend, propagateTimems);


                                log_STF.writeCsvFileCompleteTh(fileName, itemx_list);

                                break;

                        case "MTF":
                                WriteLog log_MTF = new WriteLog(this.sampleSize, this.threads,
                                        this.unmasked_faults, this.ER, this.circuit,
                                        this.verilog_circuit, this.signals_to_inject_faults, this.mtf_list);
                                log_MTF.setavgASFLOAT(this.avgASFLOAT);
                                log_MTF.setMTBF(this.MTBF);

                                log_MTF.writeSimpleLogMultipleTransientFaultProportion(fileName+"_"+random_int, date, dateend, propagateTimems, this.mtf_list);
                                //log_MTF.writeSimpleLogMultipleTransientFaultProportion(fileName, date, dateend, propagateTimems, this.mtf_list);
                                log_MTF.writeCsvFileCompleteThMTF(fileName, itemx_list);
                                break;


                }
        }

        /**
         * Run the thread simulation in parallel
         *
         * @param thread_list
         * @throws Exception
         */
        public void executeThreadsSimulation(List thread_list) throws Exception {
                Thread thread_temp = null;
                for (int i = 0; i < thread_list.size(); i++) {
                        thread_temp = (Thread) thread_list.get(i);
                        thread_temp.start();

                }
                /*Esperando termino das threads*/
                for (int i = 0; i < thread_list.size(); i++) {
                        thread_temp = (Thread) thread_list.get(i);
                        thread_temp.join();
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

        public ArrayList<String> generateInputVector(String input_option) {


                if (input_option.equals("TRUE_TABLE")) {
                        //this.probCircuit.getInputs().size(), this.sampleSize
                        ArrayList<String> vector = new ArrayList<>();
                        int numLines = (int) Math.pow(2, this.probCircuit.getInputs().size());
                        int n_inputs = this.probCircuit.getInputs().size();

                        for (int i = 0; i < numLines; i++) {
                                if (i < (numLines / 2)) {
                                        //System.out.println(i + " - " + Integer.toBinaryString(i) +" len " +Integer.toBinaryString(i).length());

                                        int len = Integer.toBinaryString(i).length();
                                        String str = Integer.toBinaryString(i); //Transform in binary
                                        if (len < n_inputs) {
                                                while (len < n_inputs) {
                                                        str = "0" + str;
                                                        len++;
                                                }
                                        }

                                        //System.out.println("" + (i+1) + " - " + str);
                                        vector.add(str);
                                } else {
                                        //System.out.println("" + (i+1) + " - " + Integer.toBinaryString(i) );
                                        vector.add(Integer.toBinaryString(i));
                                }
                        }


                        //System.out.println("TRUE TABLE: " + vector);
                        return vector;

                }
                if (input_option.equals("RANDOM")) {

                        int inputSignaisSize = this.circuit.getInputs().size();

                        ArrayList<String> vector = new ArrayList<>();
                        Random gerador = new Random();

                        //Collections Sorted

                        for (int i = 0; i < this.sampleSize; i++) {
                                String str = "";
                                for (int j = 0; j < inputSignaisSize; j++) {
                                        //int randomLogicValue = gerador.nextInt(2);
                                        //str = str + "0";
                                        str = str + gerador.nextInt(2);
                                }
                                vector.add(str);
                                //str = "";
                        }
                        return vector;
                }

                return null;
        }

        public ArrayList<ArrayList<Integer>> splitInputPatternsInInt(ArrayList<String> vector, int n_input) {

                ArrayList<ArrayList<Integer>> v = new ArrayList<>();

                for (int i = 0; i < vector.size(); i++) {
                        ArrayList<Integer> temp = new ArrayList<>();

                        String str = vector.get(i);
                        for (int j = 0; j < n_input; j++) {
                                temp.add(Integer.parseInt(str.substring(j, j + 1)));
                        }
                        //System.out.println("TEMP: "+ temp);

                        v.add(temp);
                }

                //System.out.println(""+v);

                return v;

        }

        public List particionateVectorPerThread(ArrayList<ArrayList<Integer>> ListInputVectors) throws ScriptException, Exception {

                List thread_list = new ArrayList();

                int N = this.sampleSize;

                int partition;
                if (this.threads == 1) {
                        partition = N; //final_pos/NThreads ;
                } else {
                        double temp;
                        temp = Math.floor(N / this.threads);
                        partition = (int) temp;//(ints) Math.round(collapsed_faults/NThreads);
                }

                int start = 0;
                int end = partition;

                /* In case logic gates One and Zero
                    //ArrayList <Signal> Signals_CTE_ONE_ZERO = identificate_ONE_ZERO_CTE();  //ONLY USE WHEN ITS NOT CADENCE.GENLIB or GenIB with ZERO ONE GATES
                    //System.out.println("LOGIC GATES consider WIRES (CTE) Can't inject fault: " + Signals_CTE_ONE_ZERO);
               */


                for (int i = 0; i < this.threads; i++) { //Loop of simulations

                        ArrayList<TestVectorInformation> ItemxSimulationList = new ArrayList<>();
                        ArrayList<Integer> inputVector = new ArrayList<>();
                        //System.out.println("Start: " + start + " End: " + end);
                        if ((this.threads - 1) == (i)) {

                                start = end;
                                end = N;
                        } else {
                                if (i == 0) {
                                        start = 0;
                                        end = partition;
                                } else {
                                        start = start + partition;
                                        end = start + partition;
                                }

                        }


                        System.out.println(" - starting thread: " + i + " - simulate fault injection (number): " + partition);
                        for (int j = start; j < end; j++) {

                                inputVector = this.get_Input_Vectors(ListInputVectors, j); //input Test n
                                int SigIndex = this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);

                                TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), j + 1);
                                ItemxSimulationList.add(temp);
                        }

                        LogicSimulator threadItem = new LogicSimulator(ItemxSimulationList, this.circuit, this.cellLibrary, this.levelCircuit, start, end, this.genlib, this.circuitNameStr); // Thread contex info
                        threadItem.setMode("Single");
                        itemx_list.add(threadItem);

                        Runnable runnable = threadItem;
                        Thread thread = new Thread(runnable);
                        thread.setName(Integer.toString(threadItem.hashCode()));
                        thread_list.add(thread);

                }

                return thread_list;

        }

        public int sortRandomFaultInjection() {
                //vetor de entrada aleatório

                Random gerador = new Random();
                int randomSignalIndex = gerador.nextInt(this.signals_to_inject_faults.size());
                boolean f = true;
                //System.out.printf("Gates: " + this.circuit.getGates());

                for (int i = 0; i < this.circuit.getGates().size(); i ++){
                        Gate temp = this.circuit.getGates().get(i);
                        ArrayList<Signal> inputs =  temp.getInputs();
                        ArrayList<Signal> outputs =  temp.getOutputs();

/*
                        if(inputs.contains(this.circuit.getSignals().get(randomSignalIndex)) && temp.getType().toString().equals("VOTADOR")){
                                f = false;
                                System.out.printf("-OPS VOTADOR input ");
                                i = this.circuit.getGates().size();
                                //return sortRandomFaultInjection();
                        } // comentado.......

 */
                        if(outputs.contains(this.circuit.getSignals().get(randomSignalIndex)) && temp.getType().toString().equals("VOTADOR")){
                                f = false;
                                System.out.printf("-OPS VOTADOR output ");
                                i = this.circuit.getGates().size();
                        }
                }

                //System.out.println("Signal sorted: "+ this.circuit.getSignals().get(randomSignalIndex));

               /// if(this.circuit.getSignals().get(randomSignalIndex).toString().equals("VOTADOR")){
               ///         System.out.printf("------> Ops Votador");
               //                 return sortRandomFaultInjection();
               // }else{
                if(f){
                        return randomSignalIndex;
                }
                else{
                        System.out.println(" VOTADOR SORTEADO REFAZER A SORTEIO DO SINAL");
                        return sortRandomFaultInjection();
                }


        }

        public String getER(String identification) {

                //float ER, int sample, int unmasked_faults, long propagatedTime
                String result;


                result = "\n";
                result = result + "         " + this.Performance_Time + "\n";
                result = result + "         Circuit: " + this.circuit.getName() + " \n";  //+ " P(I): " + this.circuit.getInputs().size() + " Gates: " + this.circuit.getGates().size() +
                result = result + "         Signals: " + this.circuit.getSignals().size() + " - Gates: " + this.circuit.getGates().size() + " \n";
                result = result + "         Simulation " + identification + " : " + this.sampleSize + "\n";
                result = result + "         Detected Faults (Ne): " + this.unmasked_faults + "\n";
                result = result + "         Error Rate (ER): " + this.ER + "\n";
                return result;
        }

        public int parseResultsAndCalculateER() {

                int bitfipCcounter = 0;

                for (int i = 0; i < this.itemx_list.size(); i++) {
                        this.unmasked_faults = this.unmasked_faults + itemx_list.get(i).getPropagatedFaults();
                        bitfipCcounter = bitfipCcounter + itemx_list.get(i).bitflipcounter;
                }
                float one = 1.0F;
                float unmasked = this.unmasked_faults;
                float sample = this.sampleSize;

                float div = unmasked/sample;
                float sub =  (div);
                        // this.ER = (float) (1.0 - ((float) this.unmasked_faults / (float) this.sampleSize));
                this.ER = sub;//one - div;

                System.out.println("One: " + one + "  -  Div: " + div + "  Sub: " + sub + "\n" + "sample: " + this.sampleSize);

                return bitfipCcounter;
        }

        public long combination(int n, int p) {
               // if(n > 0 &&  p > 0) {
                        int combination = (int) (factorialUsingRecursion(n) / ((factorialUsingRecursion(p) * (factorialUsingRecursion(n - p)))));
                        return combination;
                //}
                //return -1;
        }

        public long factorialUsingRecursion(int n) {
                if (n <= 2) {
                        return n;
                }
                return n * factorialUsingRecursion(n - 1);
        }

        private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
                if (index == data.length) {
                        int[] combination = data.clone();
                        combinations.add(combination);
                } else if (start <= end) {
                        data[index] = start;
                        helper(combinations, data, start + 1, end, index + 1);
                        helper(combinations, data, start + 1, end, index);
                }
        }

        public static List<int[]> generate(int n, int r) {
                List<int[]> combinations = new ArrayList<>();
                helper(combinations, new int[r], 0, n - 1, 0);
                return combinations;
        }

        public ArrayList<Integer> get_Input_Vectors(ArrayList<ArrayList<Integer>> ListInputVectors, int i) {


                ArrayList<Integer> inputVectorTemp = ListInputVectors.get(i);

                ArrayList<Integer> inputVector = new ArrayList<>();

                //  System.out.println(">>: "+ ListInputVectors.get(i) + " SIZE: "+ ListInputVectors.size());

                for (int j = 0; j < inputVectorTemp.size(); j++) {  // 0 - 0000 ; 1 - 0001; 2 - 0010; .... (n) inputs
                        inputVector.add(ListInputVectors.get(i).get(j));
                }

                return inputVector;

        }

        public void setupSimulationEnviroment(String option){ //Test All possibilities

        }


        /* Method 2 - Run Simulation */

        /* Method 3 - Run definitions Methods - Switch-Case included*/

        /* Method 4 - Generate Result Logs */

        /* Method 5 - Print Results */

        /* Method 6 - Logging */

        /* Method 7 - Start Timer - Global */

        /* method 8 - End Timer - Global */

        /* Usar variavel to control the dataPath*/

        public long measureTimeStamp(Instant startTimer, Instant stopTimer){
                return (Duration.between(startTimer, stopTimer).toSeconds());
        }

        public void

        public void runExhausticSimulationAndSensitiveAreaAnalysis(String option) throws IOException, Exception { //Test All possibilities

                /* Timers */

                /* Setup Enviroment */
                /* Define Simulation Sizes Sample Size */


                Instant start = Instant.now();

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                this.setupEnviroment("\n ----- Exaustive Simulation Version For SET (SF's) ------");

                System.out.println(this.sensitive_cells);

                System.out.println("    - Simulation start in : " + formattedDate);

                System.out.println("    - Threads in execution: " + this.threads);

                Instant loadTimeElapsed = Instant.now();

                Instant startPreparingSimulationTimeElapsed = Instant.now();

                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());

                int N = this.sampleSize; // random_input_vectors.size();//testNumber;

                int sizeExasuticTest; //= (this.sampleSize * this.signals_to_inject_faults.size());;

                this.signals_to_inject_faults = this.signalsToInjectFault(option);

                List thread_list = this.createVectorsAndParticionate(sampleSize, option, "TRUE_TABLE_SINGLE");

                System.out.println("-   Sample size (N = 2^ENTRADAS): " + "2^" + this.circuit.getInputs().size() + " = " + this.sampleSize + "   Sigs: " + this.signals_to_inject_faults.size());

                sizeExasuticTest = (this.sampleSize * this.signals_to_inject_faults.size());

                Instant endPreparingSimulationTimeElapsed = Instant.now();

                Instant startThreadingTimeElapsed = Instant.now();

                this.executeThreadsSimulation(thread_list);  // Prepare and run the thread simulation

                Instant endThreadingTimeElapsed = Instant.now();

                this.sampleSize = sizeExasuticTest;

                System.out.println("Sample Size: " + this.sampleSize);

                int bitfipCcounter = this.parseResultsAndCalculateER();  // ER

                Instant finish = Instant.now();

                long timeElapsed_Instant = Duration.between(start, finish).toSeconds();

                LocalDateTime myDateObj2 = LocalDateTime.now();
                DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate2 = myDateObj2.format(myFormatObj2);

                Instant startTimelogGeneration = Instant.now();

                long timeElapsed_loadTime = Duration.between(start, loadTimeElapsed).toSeconds();
                long timeElapsed_PrepareTime = Duration.between(startPreparingSimulationTimeElapsed, endPreparingSimulationTimeElapsed).toSeconds();
                long timeElapsed_ThreadingTime = Duration.between(startThreadingTimeElapsed, endThreadingTimeElapsed).toSeconds();

                Instant endTimelogGeneration = Instant.now();

                long timeElapsed_logGeneration = Duration.between(startTimelogGeneration, endTimelogGeneration).toSeconds();

                this.defineAvgSensitiveArea();

                this.printSensitiveAreasAnalysis();

                this.defineMTBFBasedInAvgSensitiveAreaAvg();

                this.defineMTBF();

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
                                this.optionMode = "Single_Fault";
                                thread_list = particionateExausticVector(ListInputVectors); // x - vectors per thread
                                break;

                        case "TRUE_TABLE_SINGLE_SA":
                                System.out.println("STF - Exhaustive for STF and Sensitive Area ANALYSIS");
                                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());
                                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                thread_list = particionateExausticVectorSA(ListInputVectors); // x - vectors per thread
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

                        case "MTF-Sensitive_Area-Generate_Netlist":
                                System.out.println("MTF - RANDOM");
                                random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                // System.out.println(ListInputVectors.size());
                                thread_list = this.particionateMultipletransientFaultInjectionVectorPerThreadProportionForElectricalSimulation(ListInputVectors, mtf_list); // x - vectors per thread

                                System.out.println(">>>>>> Input Vec: " + random_input_vectors.size() + " L: " + ListInputVectors.size() + " THD:  " + thread_list.size());
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


}
