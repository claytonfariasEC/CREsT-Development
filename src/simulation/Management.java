package simulation;

import datastructures.CellLibrary;
import datastructures.Circuit;
import datastructures.Signal;
import jxl.StringFormulaCell;
import jxl.write.WriteException;
import levelDatastructures.LevelCircuit;
import logicSimulator.LogicSimulator;
import logicSimulator.SensitiveCell;
//import logicSimulator.main;
import logicSimulator.TestVectorInformation;
import readers.MappedVerilogReader;
import signalProbability.ProbCircuit;
import writers.WriteLog;

import javax.script.ScriptException;
import javax.sound.midi.Soundbank;
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
import java.util.concurrent.TimeUnit;

//public class Management extends MAIN{

public class Management extends MAIN {

        private ArrayList<LogicSimulator> itemx_list = new ArrayList<>();
        private int sampleSize;
        private CellLibrary cellLibrary;
        private Circuit circuit;
        private final String circuitNameStr;
        private LevelCircuit levelCircuit;
        private ProbCircuit probCircuit;
        private LevelCircuit lCircuit;
        private int unmasked_faults;
        private double MTBF;
        private long time_seconds;
        private float circuitReliaibility;
        private MappedVerilogReader verilog_circuit;
        private String Performance_Time;
        private int sizeExaustiveCompleteSimulation;

        private ArrayList<Float> mtf_list = new ArrayList<>();
        private Map<String, SensitiveCell> sensitive_cells;

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
                if(this.circuit != null) {

                        this.lCircuit = this.levelCircuit; //Terminal.getInstance().getLevelCircuit();
                        this.probCircuit = new ProbCircuit(this.circuit);
                        //System.out.println("InitProbCircuit " + this.probCircuit.getName());

                } else {
                        System.out.println("Circuit is null !!!");
                }
        }

        public void initLevelCircuit(){
                if(this.circuit != null) {
                        //System.out.println("InitLevelCircuit");
                        this.levelCircuit = new LevelCircuit(this.circuit);
                }
                else
                {
                        System.out.println("Circuit is null!!");
                }
        }

        public void printSpecsSimulation(){
                System.out.println("    ... Reading Genlib " + " at -> " + this.genlib  + " ... ok");
                System.out.println("    ... Avaliable logic gates in this library: "+ this.cellLibrary.getCells().size());
                System.out.println("    ... Reading verilog "+ " at -> " + this.circuitNameStr  + " ... ok");
        }

        /**
         * This methods setup genlib and verilog to proceed any simulation
         * @param simulation_type
         * @throws IOException
         * @throws Exception
         */
        public void setupEnviroment(String simulation_type) throws IOException, Exception{

                System.out.println(simulation_type);
                System.out.println("GENLIB: " + this.genlib);
                CellLibrary cellLib = new CellLibrary();
                this.cellLibrary = cellLib;
                this.cellLibrary.initLibrary(this.genlib);


                /*Reading verilog*/
                MappedVerilogReader verilog_circuit = new MappedVerilogReader(this.circuitNameStr, this.cellLibrary);
                this.verilog_circuit = verilog_circuit;
                /*Circuit linked to verilog_circuit - init circuit*/
                this.circuit = verilog_circuit.getCircuit();


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
        }

        /**
         * Write Simple and Complete logs, showing the simulation results: FMR, Failure Rate, Sensitive Nodes, ...., another informations
         * @param fileName
         * @param date
         * @param dateend
         * @param propagateTimems
         * @param itemx_list
         * @throws IOException
         * @throws WriteException
         */
        public void writeLogs(String fileName, String date, String dateend, long propagateTimems,  ArrayList<LogicSimulator> itemx_list, String mode) throws IOException, WriteException {

                System.out.println("- Writing logs ...");
                System.out.println("- Simple Log " + fileName + "  (.txt)");
                System.out.println("- Complete Log " + fileName + "  (.csv)");



                switch (mode) {

                        case "STF":
                                WriteLog log_STF = new WriteLog(this.sampleSize, this.threads,
                                        this.unmasked_faults, this.circuitReliaibility, this.circuit,
                                        this.verilog_circuit, this.signals_to_inject_faults); //(int sampleSize, int threads, int unmasked_faults,  float circuitReliaibility, Circuit circuit, MappedVerilogReader verilog_circuit ,ArrayList<Signal> signals_to_inject_faults){
                                                                                                        //(int sampleSize, int threads, int unmasked_faults,  float circuitReliaibility, Circuit circuit, MappedVerilogReader verilog_circuit ,ArrayList<Signal> signals_to_inject_faults, ArrayList <Float> mtf_sizes){
                                log_STF.WriteSimpleLog(fileName, date, dateend, propagateTimems);
                                        //this.writeSimpleLog(fileName, date, dateend, propagateTimems);
                                log_STF.writeCsvFileCompleteTh(fileName, itemx_list);
                                        //this.writeCsvFileCompleteTh(fileName, itemx_list);
                                break;

                        case "MTF":
                                WriteLog log_MTF = new WriteLog(this.sampleSize, this.threads,
                                        this.unmasked_faults, this.circuitReliaibility, this.circuit,
                                        this.verilog_circuit, this.signals_to_inject_faults, this.mtf_list);
                                log_MTF.writeSimpleLogMultipleTransientFaultProportion(fileName, date, dateend, propagateTimems, this.mtf_list);
                                log_MTF.writeCsvFileCompleteThMTF(fileName, itemx_list);
                                break;


                }
        }

        /**
         * Run the thread simulation in parallel
         * @param thread_list
         * @throws Exception
         */
        public void executeThreadsSimulation(List thread_list) throws Exception {
                Thread thread_temp = null;
                for (int i=0; i < thread_list.size() ; i++) {
                        thread_temp = (Thread) thread_list.get(i);
                        thread_temp.start();

                }
                /*Esperando termino das threads*/
                for (int i=0; i < thread_list.size() ; i++) {
                        thread_temp = (Thread) thread_list.get(i);
                        thread_temp.join();
                }

        }

        /**
         *
         * @param option
         * @return
         */
        public ArrayList <Signal> signalsToInjectFault(String option){

                ArrayList <Signal> signalList = new ArrayList<>();
                signalList = this.circuit.getSignals();
                ArrayList <Signal> r = new ArrayList<>();

                switch (option){

                        case "INPUTS":

                                for (int i = 0; i < signalList.size(); i++) {
                                        if(((this.circuit.getInputs().contains(signalList.get(i))))){

                                                r.add(signalList.get(i));
                                        }

                                }
                                System.out.println("  --- Input Signals (total): " + r.size() );
                                return r;
                        //break;


                        case "INTERMEDIATE_AND_OUTPUTS":

                                for (int i = 0; i < signalList.size(); i++) {
                                        if(!((this.circuit.getInputs().contains(signalList.get(i))))){
                                                r.add(signalList.get(i));
                                        }

                                }
                                System.out.println("  --- Intermediate and output Signals (total): " + r.size() );
                                return r;



                        case "INTERMEDIATE":

                                for (int i = 0; i < signalList.size(); i++) {
                                        if(!((this.circuit.getInputs().contains(signalList.get(i))) || (this.circuit.getOutputs().contains(signalList.get(i))))){

                                                r.add(signalList.get(i));
                                        }

                                }
                                System.out.println("  --- Intermediate Signals (total): " + r.size() );
                                return r;

                        case "INPUTS_OUTPUTS":

                                for (int i = 0; i < signalList.size(); i++) {
                                        if(((this.circuit.getInputs().contains(signalList.get(i))) || (this.circuit.getOutputs().contains(signalList.get(i))))){

                                                r.add(signalList.get(i));
                                        }

                                }
                                System.out.println("  --- Intermediate Signals (total): " + r.size() );
                                return r;


                        case "ALL_SIGNALS":

                                for (int i = 0; i < signalList.size(); i++) {
                                        r.add(signalList.get(i));
                                }
                                System.out.println("     --> Considering all signals (input, intermediate, output): "+r.size());
                                return r;


                        case "":
                                System.out.println("Error !!! Please insert the correct Fault Signals String");
                                break;
                }
                return null;

        }

        public ArrayList<String> generateInputVector(String input_option){


                if(input_option.equals("TRUE_TABLE")){
                        //this.probCircuit.getInputs().size(), this.sampleSize
                        ArrayList <String> vector = new ArrayList<>();
                        int numLines = (int) Math.pow(2 ,this.probCircuit.getInputs().size());
                        int n_inputs  = this.probCircuit.getInputs().size();

                        for (int i = 0; i < numLines; i++){
                                if(i < (numLines/2)){
                                        //System.out.println(i + " - " + Integer.toBinaryString(i) +" len " +Integer.toBinaryString(i).length());

                                        int len = Integer.toBinaryString(i).length();
                                        String str = Integer.toBinaryString(i); //Transform in binary
                                        if(len < n_inputs){
                                                while(len < n_inputs){
                                                        str = "0" + str;
                                                        len++;
                                                }
                                        }

                                        //System.out.println("" + (i+1) + " - " + str);
                                        vector.add(str);
                                }
                                else{
                                        //System.out.println("" + (i+1) + " - " + Integer.toBinaryString(i) );
                                        vector.add(Integer.toBinaryString(i));
                                }
                        }


                        //System.out.println("TRUE TABLE: " + vector);
                        return vector;

                }
                if(input_option.equals("RANDOM")){

                        int inputSignaisSize = this.circuit.getInputs().size();

                        ArrayList <String> vector = new ArrayList<>();
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

        public ArrayList <ArrayList<Integer>> splitInputPatternsInInt(ArrayList <String> vector, int n_input){

                ArrayList <ArrayList<Integer>> v = new ArrayList<>();

                for (int i = 0; i < vector.size(); i++) {
                        ArrayList <Integer>  temp =  new ArrayList<>();

                        String str = vector.get(i);
                        for (int j = 0; j < n_input ; j++) {
                                temp.add(Integer.parseInt(str.substring(j, j+1)));
                        }
                        //System.out.println("TEMP: "+ temp);

                        v.add(temp);
                }

                //System.out.println(""+v);

                return v;

        }

        public List particionateVectorPerThread(ArrayList <ArrayList<Integer>> ListInputVectors) throws ScriptException, Exception{

                List thread_list = new ArrayList();

                int N = this.sampleSize;

                int partition;
                if(this.threads == 1){
                        partition = N; //final_pos/NThreads ;
                }
                else{
                        double temp;
                        temp = Math.floor(N/this.threads);
                        partition =  (int) temp ;//(ints) Math.round(collapsed_faults/NThreads);
                }

                int start = 0;
                int end = partition;

                /* In case logic gates One and Zero
                    //ArrayList <Signal> Signals_CTE_ONE_ZERO = identificate_ONE_ZERO_CTE();  //ONLY USE WHEN ITS NOT CADENCE.GENLIB or GenIB with ZERO ONE GATES
                    //System.out.println("LOGIC GATES consider WIRES (CTE) Can't inject fault: " + Signals_CTE_ONE_ZERO);
               */


                for (int i = 0; i < this.threads; i++) { //Loop of simulations

                        ArrayList <TestVectorInformation> ItemxSimulationList = new ArrayList<>();
                        ArrayList <Integer> inputVector = new ArrayList<>();
                        //System.out.println("Start: " + start + " End: " + end);
                        if((this.threads-1) == (i)){

                                start = end;
                                end = N;
                        }
                        else{
                                if(i == 0){
                                        start = 0;
                                        end = partition;
                                }else{
                                        start = start + partition;
                                        end = start + partition;
                                }

                        }


                        System.out.println(" - starting thread: "+i  + " - simulate fault injection (number): " + partition);
                        for (int j = start; j < end ; j++) {

                                inputVector = this.get_Input_Vectors(ListInputVectors, j); //input Test n
                                int SigIndex = this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);

                                TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), j+1);
                                ItemxSimulationList.add(temp);
                        }

                        LogicSimulator threadItem = new LogicSimulator(ItemxSimulationList, this.circuit, this.cellLibrary, this.levelCircuit, start, end, this.genlib , this.circuitNameStr); // Thread contex info
                        threadItem.setMode("Single");
                        itemx_list.add(threadItem);

                        Runnable runnable = threadItem;
                        Thread thread = new Thread(runnable);
                        thread.setName(Integer.toString(threadItem.hashCode()));
                        thread_list.add(thread);

                }

                return thread_list;

        }

        public int sortRandomFaultInjection(){
                //vetor de entrada aleatório

                Random gerador = new Random();
                int randomSignalIndex = gerador.nextInt(this.signals_to_inject_faults.size());

                //System.out.println("Signal sorted: "+ this.internSignals.get(randomSignalIndex));

                return randomSignalIndex;
        }

        public String getFRM(String identification){

                //float FMR, int sample, int unmasked_faults, long propagatedTime
                String result;


                result = "\n";
                result = result + "         " + this.Performance_Time + "\n";
                result = result + "         Circuit: " + this.circuit.getName() + " \n";  //+ " P(I): " + this.circuit.getInputs().size() + " Gates: " + this.circuit.getGates().size() +
                result = result + "         Signals: " + this.circuit.getSignals().size() + " - Gates: " + this.circuit.getGates().size() + " \n";
                result = result + "         Simulation " + identification + " : " + this.sampleSize + "\n";
                result = result + "         Detected Faults (Ne): " + this.unmasked_faults + "\n";
                result = result + "         Fault Mask Rate (FMR): " + this.circuitReliaibility + "\n";
                return result;
        }

        public int parseResultsAndCalculateFMR(){

                int bitfipCcounter = 0;

                for (int i=0; i < this.itemx_list.size() ; i++) {
                        this.unmasked_faults = this.unmasked_faults +  itemx_list.get(i).getPropagatedFaults();
                        bitfipCcounter = bitfipCcounter + itemx_list.get(i).bitflipcounter;
                }

                this.circuitReliaibility = (float) (1.0 - ((float) this.unmasked_faults / (float) this.sampleSize));

                return bitfipCcounter;
        }

        public long combination(int n, int p){
                int combination = (int) (factorialUsingRecursion(n)/ ((factorialUsingRecursion(p) * (factorialUsingRecursion(n-p)))));
                return combination;
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
                helper(combinations, new int[r], 0, n-1, 0);
                return combinations;
        }

        public ArrayList <Integer> get_Input_Vectors(ArrayList <ArrayList<Integer>> ListInputVectors, int i){


                ArrayList <Integer> inputVectorTemp = ListInputVectors.get(i);

                ArrayList <Integer> inputVector = new ArrayList<>();

                //  System.out.println(">>: "+ ListInputVectors.get(i) + " SIZE: "+ ListInputVectors.size());

                for (int j = 0; j < inputVectorTemp.size(); j++) {  // 0 - 0000 ; 1 - 0001; 2 - 0010; .... (n) inputs
                        inputVector.add(ListInputVectors.get(i).get(j));
                }

                return inputVector;

        }

        public int sortExclusiveFaultIndex(ArrayList <Integer> SigIndexList, TestVectorInformation temp ){

                boolean flag = true;

                while(flag){

                        int new_pos = this.sortRandomFaultInjection();

                        if(!SigIndexList.contains(new_pos)){
                                //
                                // System.out.println(" New position Founded : " +  this.signals_to_inject_faults.get(new_pos) + "   faultList:" + temp.get_MTF_FaultSignal_List() + "     complete signalslist: " + this.signals_to_inject_faults );
                                flag = false;
                                return new_pos;
                        }
                        else{
                                //System.out.println(" Alread exist in faultlist : " + this.signals_to_inject_faults.get(new_pos) +  "     list: " + temp.get_MTF_FaultSignal_List());
                        }

            /*
            if(new_pos != used){
                flag = false;
                return new_pos;
            }
            */



                }

                return  -1;
        }

        public List particionateMultipletransientFaultInjectionVectorPerThreadProportion(ArrayList <ArrayList<Integer>> ListInputVectors, ArrayList <Float> mtf_list) throws ScriptException, Exception{

                //System.out.println("\n\n         +++++++    Dev mode Percentage (Proportion mode)  ++++++");
                System.out.println("-   MTF LIST = " + mtf_list);

                List thread_list = new ArrayList();
                int count = 0;
                float sum_proportion;
                int N = this.sampleSize;

                int partition;
                if(this.threads == 1){
                        partition = N; //final_pos/NThreads ;
                }
                else{
                        double temp;
                        temp = Math.floor(N/this.threads);
                        partition =  (int) temp ;//(ints) Math.round(collapsed_faults/NThreads);
                }



                //HashMap  <Integer, multiple_faults_object> arraylist_mtf = new HashMap<>();
                sum_proportion = sumProportionPercentage(mtf_list);
                int sample_base = Math.round(mtf_list.get(0));
                ArrayList <Integer> new_MTF = passProportionPercentage(mtf_list, sample_base);
                System.out.println("- new MTF LIST " + new_MTF + "  size: " + new_MTF.size());

                final ArrayList<Float> arrayList_mtf_original = new ArrayList<>(mtf_list); // Original ArrayList

                ArrayList <TestVectorInformation> listOflist = new ArrayList<>();

                ArrayList <Integer> combined_MTF = new ArrayList<>();
                combined_MTF.add(new_MTF.get(0));
                int base_sum = new_MTF.get(0);

                //Loop for Single, Double or tripple
                int start = 0;
                int end = partition;

                //System.out.println("");
                ArrayList<TestVectorInformation> ItemxSimulationList = new ArrayList<>();

                for (int prop_index = 0; prop_index < new_MTF.size(); prop_index++) {
                        System.out.println(new_MTF.get(prop_index));

                        if(prop_index >0){
                                base_sum = base_sum + new_MTF.get(prop_index);
                                combined_MTF.add(base_sum);
                        }

                        for (int index = 0; index < new_MTF.get(prop_index); index++){
                                // For prop_index

                                ArrayList<Integer> inputVector = new ArrayList<>();

                                inputVector = this.get_Input_Vectors(ListInputVectors, count); //input Test n

                                if (prop_index == 0){ // Single Transient Fault
                                        int SigIndex = this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);
                                        TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), count );
                                        ArrayList <Integer> SigIndexList = new ArrayList<Integer>();
                                        SigIndexList.add(SigIndex);
                                        ItemxSimulationList.add(temp);
                                        /// System.out.println("~ Injection Single TF number : " + count + " - Sig Index" + SigIndexList + "  temp: "+ temp.getMTFPERSONAL_LIST_Identities() + "  " +  temp.getSimulationIndex());
                                }
                                else{ // Double , Tripple
                                        int SigIndex = this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);
                                        TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), count );
                                        ArrayList <Integer> SigIndexList = new ArrayList<Integer>();
                                        SigIndexList.add(SigIndex);
                                        for (int k = 1; k <= prop_index; k ++){
                                                int new_pos = sortExclusiveFaultIndex(SigIndexList, temp);
                                                temp.setMultipleTransientFaultInjection( this.signals_to_inject_faults.get(new_pos));
                                                SigIndexList.add(new_pos); // Do no reapet signals
                                        }
                                        //System.out.println("~ Injection MTF number : " + count + " - Sig Index" + SigIndexList + "  temp: "+ temp.getMTFPERSONAL_LIST_Identities()  + "  " +  temp.getSimulationIndex());
                                        ItemxSimulationList.add(temp);
                                }
                                count++;
                        }
                        System.out.println(prop_index + " Count: " + count + " ItemxSimulation: " + ItemxSimulationList.size() + "  order: ");
                }

                System.out.println("- End Count: " + count);
                System.out.println("- Combined: " + combined_MTF);
                System.out.println("- Itemx Size: " + ItemxSimulationList.size());
                System.out.println("- ThreadList: " + thread_list.size());

                start = 0;
                end = partition;
                for (int i = 0; i < this.threads; i++) { //Loop of simulations

                        System.out.println("Start: " + start + " End: " + end);
                        if ((this.threads - 1) == (i)) {
                                start = end;
                                end = N;
                        } else {
                                if (i == 0) {
                                        //start = 1;
                                        start = 0;
                                        end = partition;
                                } else {
                                        start = start + partition;
                                        end = start + partition;
                                }
                        }

                        ArrayList<TestVectorInformation> temp = new ArrayList<TestVectorInformation>(ItemxSimulationList.subList(start, end));
                        LogicSimulator threadItem = new LogicSimulator(temp, this.circuit, this.cellLibrary, this.levelCircuit, start, end, this.genlib , this.circuitNameStr); // Thread contex info

                        threadItem.setMode("Multiple");
                        itemx_list.add(threadItem);

                        Runnable runnable = threadItem;
                        Thread thread = new Thread(runnable);
                        thread.setName(Integer.toString(threadItem.hashCode()));
                        thread_list.add(thread);
                        System.out.println("\n ->>>>>> " + i + " Start: " + start + " End: " + end + "  ThreadItem: " + threadItem.getStartendPos() + " size inputss: " + threadItem.getThreadSimulatinArray().size() + " real: " + temp.size());

                }
                //System.out.println("Signal to inject fault: " + this.signals_to_inject_faults);
                return thread_list;
        }

        public List particionateMultipletransientFaultInjectionVectorPerThreadProportionForElectricalSimulation(ArrayList <ArrayList<Integer>> ListInputVectors, ArrayList <Float> mtf_list) throws ScriptException, Exception{

                //System.out.println("\n\n         +++++++    Dev mode Percentage (Proportion mode)  ++++++");
                System.out.println("-   MTF LIST = " + mtf_list);

                List thread_list = new ArrayList();
                int count = 0;
                float sum_proportion;
                int N = this.sampleSize;

                int partition;
                if(this.threads == 1){
                        partition = N; //final_pos/NThreads ;
                }
                else{
                        double temp;
                        temp = Math.floor(N/this.threads);
                        partition =  (int) temp ;//(ints) Math.round(collapsed_faults/NThreads);
                }



                //HashMap  <Integer, multiple_faults_object> arraylist_mtf = new HashMap<>();
                sum_proportion = sumProportionPercentage(mtf_list);
                int sample_base = Math.round(mtf_list.get(0));
                ArrayList <Integer> new_MTF = passProportionPercentage(mtf_list, sample_base);
                System.out.println("- new MTF LIST " + new_MTF + "  size: " + new_MTF.size());

                final ArrayList<Float> arrayList_mtf_original = new ArrayList<>(mtf_list); // Original ArrayList

                ArrayList <TestVectorInformation> listOflist = new ArrayList<>();

                ArrayList <Integer> combined_MTF = new ArrayList<>();
                combined_MTF.add(new_MTF.get(0));
                int base_sum = new_MTF.get(0);

                //Loop for Single, Double or tripple
                int start = 0;
                int end = partition;

                //System.out.println("");
                ArrayList<TestVectorInformation> ItemxSimulationList = new ArrayList<>();

                for (int prop_index = 0; prop_index < new_MTF.size(); prop_index++) {
                        System.out.println(new_MTF.get(prop_index));

                        if(prop_index >0){
                                base_sum = base_sum + new_MTF.get(prop_index);
                                combined_MTF.add(base_sum);
                        }

                        for (int index = 0; index < new_MTF.get(prop_index); index++){
                                // For prop_index

                                ArrayList<Integer> inputVector = new ArrayList<>();

                                inputVector = this.get_Input_Vectors(ListInputVectors, count); //input Test n

                                if (prop_index == 0){ // Single Transient Fault
                                        int SigIndex = this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);
                                        TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), count );
                                        ArrayList <Integer> SigIndexList = new ArrayList<Integer>();
                                        SigIndexList.add(SigIndex);
                                        ItemxSimulationList.add(temp);
                                        /// System.out.println("~ Injection Single TF number : " + count + " - Sig Index" + SigIndexList + "  temp: "+ temp.getMTFPERSONAL_LIST_Identities() + "  " +  temp.getSimulationIndex());
                                }
                                else{ // Double , Tripple
                                        int SigIndex = this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);
                                        TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), count );
                                        ArrayList <Integer> SigIndexList = new ArrayList<Integer>();
                                        SigIndexList.add(SigIndex);
                                        for (int k = 1; k <= prop_index; k ++){
                                                int new_pos = sortExclusiveFaultIndex(SigIndexList, temp);
                                                temp.setMultipleTransientFaultInjection( this.signals_to_inject_faults.get(new_pos));
                                                SigIndexList.add(new_pos); // Do no reapet signals
                                        }
                                        //System.out.println("~ Injection MTF number : " + count + " - Sig Index" + SigIndexList + "  temp: "+ temp.getMTFPERSONAL_LIST_Identities()  + "  " +  temp.getSimulationIndex());
                                        ItemxSimulationList.add(temp);
                                }
                                count++;
                        }
                        System.out.println(prop_index + " Count: " + count + " ItemxSimulation: " + ItemxSimulationList.size() + "  order: ");
                }

                System.out.println("- End Count: " + count);
                System.out.println("- Combined: " + combined_MTF);
                System.out.println("- Itemx Size: " + ItemxSimulationList.size());
                System.out.println("- ThreadList: " + thread_list.size());

                start = 0;
                end = partition;
                for (int i = 0; i < this.threads; i++) { //Loop of simulations

                        System.out.println("Start: " + start + " End: " + end);
                        if ((this.threads - 1) == (i)) {
                                start = end;
                                end = N;
                        } else {
                                if (i == 0) {
                                        //start = 1;
                                        start = 0;
                                        end = partition;
                                } else {
                                        start = start + partition;
                                        end = start + partition;
                                }
                        }

                        ArrayList<TestVectorInformation> temp = new ArrayList<TestVectorInformation>(ItemxSimulationList.subList(start, end));
                        LogicSimulator threadItem = new LogicSimulator(temp, this.circuit, this.cellLibrary, this.levelCircuit, start, end, this.genlib , this.circuitNameStr); // Thread contex info

                        threadItem.setMode("MTF-Generate_Netlist");
                        itemx_list.add(threadItem);

                        Runnable runnable = threadItem;
                        Thread thread = new Thread(runnable);
                        thread.setName(Integer.toString(threadItem.hashCode()));
                        thread_list.add(thread);
                        System.out.println("\n ->>>>>> " + i + " Start: " + start + " End: " + end + "  ThreadItem: " + threadItem.getStartendPos() + " size inputss: " + threadItem.getThreadSimulatinArray().size() + " real: " + temp.size());

                }
                //System.out.println("Signal to inject fault: " + this.signals_to_inject_faults);
                return thread_list;
        }

        public List particionateExausticVectorForSensitiveAreas(ArrayList <ArrayList<Integer>> ListInputVectors,  Map <String, SensitiveCell> sensitive_cells, String mode) throws ScriptException, Exception{

                //System.out.println("- Sensitive Area inputs ...");

                List thread_list = new ArrayList();

                int N = this.sampleSize;

                int partition;
                if(this.threads == 1){
                        partition = N; //final_pos/NThreads ;
                }
                else{
                        double temp;
                        temp = Math.floor(N/this.threads);
                        partition =  (int) temp ;//(int) Math.round(collapsed_faults/NThreads);
                }

                int start = 0;
                int end = partition;

                /* In case logic gates One and Zero
                    //ArrayList <Signal> Signals_CTE_ONE_ZERO = identificate_ONE_ZERO_CTE();  //ONLY USE WHEN ITS NOT CADENCE.GENLIB
                    //System.out.println("LOGIC GATES consider WIRES (CTE) Can't inject fault: " + Signals_CTE_ONE_ZERO);
               */

                for (int i = 0; i < this.threads; i++) { //Loop of simulations

                        ArrayList <TestVectorInformation> ItemxSimulationList = new ArrayList<>();
                        ArrayList <Integer> inputVector = new ArrayList<>();

                        if((this.threads-1) == (i)){

                                start = end;
                                end = N;
                        }
                        else{
                                if(i == 0){
                                        start = 0;
                                        end = partition;
                                }else{
                                        start = start + partition;
                                        end = start + partition;
                                }

                        }


                        System.out.println(" - starting thread: "+i  + " - simulate fault injection (number): " + partition);

                        for (int j = start; j < end ; j++){

                                for (int aux = 0; aux < 1; aux++) {

                                        inputVector = this.get_Input_Vectors(ListInputVectors, j); //input Test n

                                        int SigIndex = aux;//this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);

                                        TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), j+1);
                                        ItemxSimulationList.add(temp);

                                        //System.out.println(j + " Vec: " + inputVector + " Fault Signal: " +  this.signals_to_inject_faults.get(SigIndex));
                                }

                        }

                        LogicSimulator threadItem = new LogicSimulator(ItemxSimulationList, this.circuit, this.cellLibrary, this.levelCircuit, start, end, this.genlib , this.circuitNameStr); // Thread contex info
                        threadItem.setMode(mode);
                        threadItem.setSensitiveCellsMap(sensitive_cells);
                        itemx_list.add(threadItem);

                        Runnable runnable = threadItem;
                        Thread thread = new Thread(runnable);
                        thread.setName(Integer.toString(threadItem.hashCode()));
                        thread_list.add(thread);

                }

                return thread_list;

        }

        public List particionateExausticVector(ArrayList <ArrayList<Integer>> ListInputVectors) throws ScriptException, Exception{

                List thread_list = new ArrayList();

                int N = this.sampleSize;

                int partition;
                if(this.threads == 1){
                        partition = N; //final_pos/NThreads ;
                }
                else{
                        double temp;
                        temp = Math.floor(N/this.threads);
                        partition =  (int) temp ;//(int) Math.round(collapsed_faults/NThreads);
                }

                int start = 0;
                int end = partition;

                /* In case logic gates One and Zero
                    //ArrayList <Signal> Signals_CTE_ONE_ZERO = identificate_ONE_ZERO_CTE();  //ONLY USE WHEN ITS NOT CADENCE.GENLIB
                    //System.out.println("LOGIC GATES consider WIRES (CTE) Can't inject fault: " + Signals_CTE_ONE_ZERO);
               */

                for (int i = 0; i < this.threads; i++) { //Loop of simulations

                        ArrayList <TestVectorInformation> ItemxSimulationList = new ArrayList<>();
                        ArrayList <Integer> inputVector = new ArrayList<>();

                        if((this.threads-1) == (i)){

                                start = end;
                                end = N;
                        }
                        else{
                                if(i == 0){
                                        start = 0;
                                        end = partition;
                                }else{
                                        start = start + partition;
                                        end = start + partition;
                                }

                        }


                        System.out.println(" - starting thread: "+i  + " - simulate fault injection (number): " + partition);

                        for (int j = start; j < end ; j++){

                                for (int aux = 0; aux < this.signals_to_inject_faults.size(); aux++) {

                                        inputVector = this.get_Input_Vectors(ListInputVectors, j); //input Test n

                                        int SigIndex = aux;//this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);

                                        TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), j+1);
                                        ItemxSimulationList.add(temp);

                                        System.out.println("Vec: " + inputVector + " Fault Signal: " +  this.signals_to_inject_faults.get(SigIndex));
                                }

                        }

                        LogicSimulator threadItem = new LogicSimulator(ItemxSimulationList, this.circuit, this.cellLibrary, this.levelCircuit, start, end, this.genlib , this.circuitNameStr); // Thread contex info
                        threadItem.setMode("Single");
                        itemx_list.add(threadItem);

                        Runnable runnable = threadItem;
                        Thread thread = new Thread(runnable);
                        thread.setName(Integer.toString(threadItem.hashCode()));
                        thread_list.add(thread);

                }

                return thread_list;

        }

        public List particionateExausticVectorComplete(ArrayList <ArrayList<Integer>> ListInputVectors) throws ScriptException, Exception{

                List thread_list = new ArrayList();

                int N = this.sampleSize;

                int partition;
                if(this.threads == 1){
                        partition = N; //final_pos/NThreads ;
                }
                else{
                        double temp;
                        temp = Math.floor(N/this.threads);
                        partition =  (int) temp ;//(int) Math.round(collapsed_faults/NThreads);
                }

                int start = 0;
                int end = partition;

                /* In case logic gates One and Zero
                    //ArrayList <Signal> Signals_CTE_ONE_ZERO = identificate_ONE_ZERO_CTE();  //ONLY USE WHEN ITS NOT CADENCE.GENLIB
                    //System.out.println("LOGIC GATES consider WIRES (CTE) Can't inject fault: " + Signals_CTE_ONE_ZERO);
               */



                int vec = (int) Math.pow(2, this.circuit.getInputs().size());
                long result_computation = 0;
                for (int i = 1; i < this.signals_to_inject_faults.size(); i++) {
                        ///int combination = (int) (factorialUsingRecursion(this.circuit.getSignals().size())/ ((factorialUsingRecursion(this.signals_to_inject_faults.size() - i)) * (factorialUsingRecursion(i))));
                        long comb = combination(this.circuit.getSignals().size(), i);

                        result_computation = result_computation + (comb);
                        System.out.println("conjunto  " + this.circuit.getSignals().size() + "," + i  + " : " + comb + "  testComplexity = " + comb + " = " + (result_computation)) ;
                }
                this.sizeExaustiveCompleteSimulation = (int) result_computation * vec;
        /*
        for (int i = 0; i < this.signals_to_inject_faults.size(); i++) {
            List<int[]> combinations = generate(this.signals_to_inject_faults.size(), i);
            for (int[] combination : combinations) {
               // System.out.println(Arrays.toString(combination));
            }
            //System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), this.signals_to_inject_faults.size(), i);
        }
        */

                //this.sizeExaustiveCompleteSimulation = 0;
                int counter = 0;
                int counterv2 = 0;

                for (int i = 0; i < this.threads; i++) { //Loop of simulations

                        ArrayList <TestVectorInformation> ItemxSimulationList = new ArrayList<>();
                        ArrayList <Integer> inputVector = new ArrayList<>();

                        if((this.threads-1) == (i)){

                                start = end;
                                end = N;
                        }
                        else{
                                if(i == 0){
                                        start = 0;
                                        end = partition;
                                }else{
                                        start = start + partition;
                                        end = start + partition;
                                }

                        }


                        System.out.println(" - starting thread: "+i  + " - simulate fault injection (number): " + partition);


                        System.out.println("SIGNALS LIST: " + this.signals_to_inject_faults);



                        for (int j = start; j < end ; j++){

                                inputVector = this.get_Input_Vectors(ListInputVectors, j);  // Vetores [0000] [00001]
                                for (int p = 1; p < this.signals_to_inject_faults.size(); p++) { // 1 , 2, 3, 4

                                        String nxp = "  p: " + p + "  vec: "+ inputVector + "  vv2: " + counterv2 + "  j: "+ j;


                                        //[20000 100 200 400]

                                        //System.out.println(nxp);
                                        //int SigIndex = p-1; // G1, G2 , G3

                                        List<int[]> combinations = generate(this.signals_to_inject_faults.size(), p); // Combination of 11 and 1 = 11 ~ 11 and 2 = 55 ~ 11and 3

                                        for (int[] combination : combinations){ //
                                                TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(combination[0
                                                        ]), counterv2);  //Inject in G1 first

                                                // this.sizeExaustiveCompleteSimulation++;
                                                //String pivot = this.signals_to_inject_faults.get(combination[0]).toString();

                                                for (int element = 1; element < combination.length; element++) {
                                                        ArrayList<Integer> SigIndexList = new ArrayList<Integer>();
                                                        //SigIndexList.add(combination[element]);
                                                        temp.setMultipleTransientFaultInjection(this.signals_to_inject_faults.get(combination[element]));
                                                        SigIndexList.add(combination[element]);
                                                        //String pivoCerto = this.signals_to_inject_faults.get(combination[0]).toString();

                                /*
                                if(j ==0) {
                                    System.out.println(inputVector +
                                            "  Sig Index List: " + SigIndexList +
                                            "  Comb: " + Arrays.toString(combination) +
                                            "  Pivot Atual:  " + pivot +
                                            "  Pivot Certo: " + pivoCerto
                                            + " combEl: " + combination[element]);
                                }
                                */

                                                }
                                                counterv2++;

                                                counter++;
                                                //                           if(j == 0)
//                               System.out.println(ill + " ill " + "Vec: " + inputVector + " comb: " + Arrays.toString(combination) + " Fault Signal: " +  this.signals_to_inject_faults.get(SigIndex) + " list: "+ "" + temp.get_MTF_FaultSignal_List() + " counter: " + counter);

                                                ItemxSimulationList.add(temp);
                                        }
                                        // counterv2++;
                                        // }
                                }
                /*
                for (int aux = 0; aux < this.signals_to_inject_faults.size(); aux++) {

                    inputVector = this.get_Input_Vectors(ListInputVectors, j); //input Test n

                    int SigIndex = aux;//this.sortRandomFaultInjection(); //int SigIndex = decide_Random_Signals_Contrains(Signals_CTE_ONE_ZERO);

                    TestVectorInformation temp = new TestVectorInformation(inputVector, this.signals_to_inject_faults.get(SigIndex), j+1);
                    ItemxSimulationList.add(temp);

                    System.out.println("Vec: " + inputVector + " Fault Signal: " +  this.signals_to_inject_faults.get(SigIndex));
                }
                */


                        }


                        LogicSimulator threadItem = new LogicSimulator(ItemxSimulationList, this.circuit, this.cellLibrary, this.levelCircuit, start, end, this.genlib , this.circuitNameStr); // Thread contex info
                        threadItem.setMode("Multiple");
                        itemx_list.add(threadItem);

                        Runnable runnable = threadItem;
                        Thread thread = new Thread(runnable);
                        thread.setName(Integer.toString(threadItem.hashCode()));
                        thread_list.add(thread);


                        System.out.println(i + " Thread - Size simulation" + " " + this.sizeExaustiveCompleteSimulation + "    computation: " + result_computation + "   - SimulatlistionSize: "+itemx_list.get(i).getThreadSimulatinArray().size() + "   counter: " +counter);
                }
                this.sizeExaustiveCompleteSimulation = (int) counter;

                return thread_list;

        }

        public ArrayList <Integer> passProportionPercentage(ArrayList<Float> mtf_list, int sample){

                float sum_proportion = sumProportionPercentage(mtf_list);
                ArrayList <Integer> m = new ArrayList<>();
                float sum_up = 0;

                if(sum_proportion == 1.0){
                        for (int pos = 1; pos < mtf_list.size(); pos++) {
                                m.add((int) Math.round(sample * mtf_list.get(pos)));
                        }
                }
                if(sum_proportion < 1){
                        //need complete in this case
                        float dif = 1 - sum_proportion;
                        //int dif = 1 - Math.round(sum_proportion);

                        for (int pos = 1; pos < mtf_list.size(); pos++) {
                                m.add(Math.round(sample * mtf_list.get(pos)));
                                sum_up = sum_up + (sample * mtf_list.get(pos));
                        }

                        //while (sum_up < mtf_list.get(0)){  // In case disparity in sum up rounding
                        //    sum_up++;
                        //}

                        int sum = Math.round(sum_up);
                        int least_to_complete = sample - sum;
                        float temp_sample = Math.round(mtf_list.get(0));
                        mtf_list.remove(0);

                        System.out.println("sum up: " + sum_up);

                        if(sum_up <= temp_sample) { // 20k == 20k

                                System.err.println("- Warning:" + " based on your inputs: " + mtf_list + " the sum should be 1 (" + sum_proportion + "), although " +
                                        " in this case the procedure will complete this number of tests (" + least_to_complete + ") because the diference was (1 - " + sum_proportion + " ) = " + dif + " * " + temp_sample + " = " + least_to_complete);

                                System.out.println("- temp arraylist mtf orriginal " + m);
                                //Insert in simple faults
                                m.set(0, m.get(0) + least_to_complete);
                                System.out.println("- temp arraylist mtf " + m);

                                //Insert in medium faults
                                //m.set(m.size()/2, m.get(0) + least_to_complete);
                                //System.out.println("m " + m);

                                //Insert in Higher order faults
                                //m.set(m.size(), m.get(0) + least_to_complete);
                                //System.out.println("m " + m);
                        }
                }else{
                        System.out.println("Proportion sum up is : " + sum_proportion);
                }

                System.out.println("- MTF LIST: " + m);

                return m;
        }

        /**
         * Generate input vectors according with sampleSize and signalsOption defition
         * @param sampleSize eg: 20000 SET faults (Particle generating SET)
         * @param signalsOption
         * @return
         * @throws Exception
         */
        public List createVectorsAndParticionate(int sampleSize, String signalsOption, String option) throws Exception {

                List thread_list = new ArrayList();
                ArrayList <String> random_input_vectors;
                ArrayList <ArrayList<Integer>> ListInputVectors;
                this.sampleSize = sampleSize; //(int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());
                this.signals_to_inject_faults = this.signalsToInjectFault(signalsOption); // Consider all signals to fault inject


                switch (option) {
                        case "RANDOM":
                                System.out.println("STF - RANDOM");
                                random_input_vectors = this.generateInputVector(option); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors =  this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                thread_list = this.particionateVectorPerThread(ListInputVectors); // x - vectors per thread
                                break;

                        case "TRUE_TABLE_SINGLE":
                                System.out.println("STF - Exhaustive for STF");
                                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors =  this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                thread_list = particionateExausticVector(ListInputVectors); // x - vectors per thread
                                break;

                        case "TRUE_TABLE_COMPLETE":
                                System.out.println("STF - Exhaustive for STF");
                                random_input_vectors = this.generateInputVector("TRUE_TABLE"); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors =  this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                thread_list = particionateExausticVectorComplete(ListInputVectors);  // TESTE ALL GATES ///particionateVectorPerThread(ListInputVectors); // x - vectors per thread

                                break;

                        case "MTF-RANDOM":
                                System.out.println("MTF - RANDOM");
                                random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                thread_list = this.particionateMultipletransientFaultInjectionVectorPerThreadProportion(ListInputVectors, this.mtf_list); // x - vectors per thread
                                break;

                        case "MTF-Generate_Netlist":
                                System.out.println("MTF - RANDOM");
                                random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                // System.out.println(ListInputVectors.size());
                                thread_list = this.particionateMultipletransientFaultInjectionVectorPerThreadProportionForElectricalSimulation(ListInputVectors, mtf_list); // x - vectors per thread
                                break;

                        case "MTF-Sensitive_Area-Generate_Netlist":
                                System.out.println("MTF-Sensitive_Area-Generate_Netlist");
                                random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                // System.out.println(ListInputVectors.size());
                                thread_list = particionateExausticVectorForSensitiveAreas(ListInputVectors, this.sensitive_cells, "MTF-Generate_Netlist");//thread_list = this.particionateMultipletransientFaultInjectionVectorPerThreadProportionForElectricalSimulation(ListInputVectors, mtf_list); // x - vectors per thread
                                break;


                        case "STF-Generate_Netlist":
                                System.out.println("STF-Generate_Netlist");
                                random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable
                                ListInputVectors =  this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());
                                thread_list = this.particionateVectorPerThread(ListInputVectors); // x - vectors per thread
                                break;


                }

                return (thread_list);
        }

        public void printResults(String specific, String formattedDate, String formattedDate2, int bitfipCcounter, long timeElapsed_loadTime, long timeElapsed_PrepareTime, long timeElapsed_ThreadingTime, long timeElapsed_logGeneration, long timeElapsed_Instant){
                System.out.println("    -   " + specific + " -     ");
                System.out.println("- Simulation started at: " + formattedDate + " and finished at: "+ formattedDate2);
                System.out.println("- Circuit: " + this.circuit.getName());
                System.out.println("- Sample Size (N): " + this.sampleSize );
                System.out.println("- Fault Mask Rate (FMR): " + " 1 - Ne/N = (1-(" + this.unmasked_faults + "/" + this.sampleSize + ")) = " + this.circuitReliaibility);
                System.out.println("- Bitflip Counter: " + bitfipCcounter );
                System.out.println("- Load Time : " + timeElapsed_loadTime + "(s) - Setup Time: " + timeElapsed_PrepareTime  + "(s) - Threading Execution Time: " + timeElapsed_ThreadingTime
                        + "(s) - Log Generation: " + timeElapsed_logGeneration
                        + "(s) - Simulation Instant TimeElapsed: " + timeElapsed_Instant +" (s)" );
        }

        /**
         * This method orchestrates the settup enviroment for run Multithreading SET evalaution (LOGICAL SIMULATOR)
         * @param sampleSize
         * @param option
         * @throws IOException
         * @throws Exception
         */
        public void runMultithreadingMonteCarlo(int sampleSize, String option) throws IOException, Exception{

                Instant start = Instant.now();

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                this.setupEnviroment("\n ----- Monte Carlo version Single Transient Fault (STF) -------");

                System.out.println("    - Simulation start in : " + formattedDate);
                System.out.println("    - Threads in execution: " + this.threads);

                Instant loadTimeElapsed = Instant.now();

                Instant startPreparingSimulationTimeElapsed = Instant.now();

                int N = this.sampleSize; // random_input_vectors.size();//testNumber;

                System.out.println("-  (input) Sample size = " + this.sampleSize);

                List thread_list =  this.createVectorsAndParticionate(sampleSize, option, "RANDOM");

                Instant endPreparingSimulationTimeElapsed = Instant.now();

                Instant startThreadingTimeElapsed = Instant.now();

                this.executeThreadsSimulation(thread_list);  // Prepare and run the thread simulation

                Instant endThreadingTimeElapsed = Instant.now();

                int bitfipCcounter = this.parseResultsAndCalculateFMR();  // FMR

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

                this.writeLogs(option + "_STF_MonteCarlo_Simple_Log_" +this.circuit.getName()+"_Threads-"+ this.threads +  "_sampleSize-" + this.sampleSize, formattedDate,  formattedDate2, timeElapsed_Instant, itemx_list, "STF");

                System.out.println("----------------------------------------------------------------------");

                        this.printResults("", formattedDate, formattedDate2, bitfipCcounter, timeElapsed_loadTime, timeElapsed_PrepareTime, timeElapsed_ThreadingTime, timeElapsed_logGeneration, timeElapsed_Instant);
                        //String specific, String formattedDate, String formattedDate2,
                        // int bitfipCcounter, long timeElapsed_loadTime, long timeElapsed_PrepareTime,
                        // long timeElapsed_ThreadingTime, long timeElapsed_logGeneration, long timeElapsed_Instant){

                System.out.println("-----------------------END SIMULATION---------------------------------");

                this.Performance_Time = "Simulation started at: " + formattedDate + " and finished at: " + formattedDate2;


        }

        /**
         * Exhaustic Single STF (SET) Simulation
         * @param option
         * @throws IOException
         * @throws Exception
         */
        public void runMultithreadingExausticSimulation(String option) throws IOException, Exception{ //Test All possibilities

                Instant start = Instant.now();

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                this.setupEnviroment("\n ----- Exaustive Simulation Version For SET (SF's) ------");

                System.out.println("    - Simulation start in : " + formattedDate);
                System.out.println("    - Threads in execution: " + this.threads);

                Instant loadTimeElapsed = Instant.now();

                Instant startPreparingSimulationTimeElapsed = Instant.now();

                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());

                int N = this.sampleSize; // random_input_vectors.size();//testNumber;

                int sizeExasuticTest; //= (this.sampleSize * this.signals_to_inject_faults.size());;

                List thread_list =  this.createVectorsAndParticionate(sampleSize, option, "TRUE_TABLE_SINGLE");

                System.out.println("-   Sample size (N = 2^ENTRADAS): " + "2^"+ this.circuit.getInputs().size() + " = " + this.sampleSize + "   Sigs: " + this.signals_to_inject_faults.size());

                sizeExasuticTest = (this.sampleSize * this.signals_to_inject_faults.size());

                Instant endPreparingSimulationTimeElapsed = Instant.now();

                Instant startThreadingTimeElapsed = Instant.now();

                this.executeThreadsSimulation(thread_list);  // Prepare and run the thread simulation

                Instant endThreadingTimeElapsed = Instant.now();

                this.sampleSize = sizeExasuticTest;

                int bitfipCcounter = this.parseResultsAndCalculateFMR();  // FMR

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



                        this.writeLogs(option + "_ExausticSTFSimulation_" +this.circuit.getName()+"_Threads-"+ this.threads +  "_sampleSize-" + this.sampleSize, formattedDate,  formattedDate2, timeElapsed_Instant, itemx_list, "STF");

                System.out.println("----------------------------------------------------------------------");

                this.printResults("Exhaustive", formattedDate, formattedDate2, bitfipCcounter, timeElapsed_loadTime, timeElapsed_PrepareTime, timeElapsed_ThreadingTime, timeElapsed_logGeneration, timeElapsed_Instant);
                //String specific, String formattedDate, String formattedDate2,
                // int bitfipCcounter, long timeElapsed_loadTime, long timeElapsed_PrepareTime,
                // long timeElapsed_ThreadingTime, long timeElapsed_logGeneration, long timeElapsed_Instant){

                System.out.println("-----------------------END SIMULATION---------------------------------");

                this.Performance_Time = "Simulation started at: " + formattedDate + " and finished at: " + formattedDate2;



        }

        /**
         * Exhaustic Complete MTF (SET) Simulation
         * @param option
         * @throws IOException
         * @throws Exception
         */
        public void runMultithreadingExausticSimulationComplete(String option) throws IOException, Exception{ //Test All possibilities


                Instant start = Instant.now();

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                this.setupEnviroment("\n ----- Exaustive Complete (All combinations) Simulation Version -------");

                System.out.println("    - Simulation start in : " + formattedDate);

                System.out.println("    - Threads in execution: " + this.threads);

                Instant loadTimeElapsed = Instant.now();

                Instant startPreparingSimulationTimeElapsed = Instant.now();

                int sizeExasuticTest;

                System.out.println("-   Sample size (N = 2^ENTRADAS): " + "2^"+ this.circuit.getInputs().size() + " = " + this.sampleSize);
                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());

                int N = this.sampleSize; // random_input_vectors.size();//testNumber;

                List thread_list =  this.createVectorsAndParticionate(this.sampleSize, option, "TRUE_TABLE_COMPLETE");

                N = sizeExasuticTest = this.sizeExaustiveCompleteSimulation;//(this.sampleSize * this.signals_to_inject_faults.size());

                this.sampleSize = N;

                Instant endPreparingSimulationTimeElapsed = Instant.now();

                Instant startThreadingTimeElapsed = Instant.now();

                this.executeThreadsSimulation(thread_list);  // Prepare and run the thread simulation

                Instant endThreadingTimeElapsed = Instant.now();

                int bitfipCcounter = this.parseResultsAndCalculateFMR();  // FMR

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

                this.sampleSize = sizeExasuticTest;

                this.writeLogs(option + "_ExausticCompleteSimulation_" +this.circuit.getName()+"_Threads-"+ this.threads +  "_sampleSize-" + this.sampleSize, formattedDate,  formattedDate2, timeElapsed_Instant, itemx_list, "STF");

                System.out.println("----------------------------------------------------------------------");

                this.printResults("ExausticCompleteSimulation_", formattedDate, formattedDate2, bitfipCcounter, timeElapsed_loadTime, timeElapsed_PrepareTime, timeElapsed_ThreadingTime, timeElapsed_logGeneration, timeElapsed_Instant);
                //String specific, String formattedDate, String formattedDate2,
                // int bitfipCcounter, long timeElapsed_loadTime, long timeElapsed_PrepareTime,
                // long timeElapsed_ThreadingTime, long timeElapsed_logGeneration, long timeElapsed_Instant){

                System.out.println("-----------------------END SIMULATION---------------------------------");

                this.Performance_Time = "Simulation started at: " + formattedDate + " and finished at: " + formattedDate2;
                this.sampleSize = N;

        }

        /**
         * This method run Multiple Transient Faults (MTF's)
         * @param sample
         * @param mtf_list
         * @param option
         * @throws IOException
         * @throws Exception
         */
        public void runMultipleFaultInjectionMultithreadingMonteCarloSimulationProportion(int sample, ArrayList <Float> mtf_list, String option) throws IOException, Exception{

                System.out.println("- SUM PROPORTION: " + sumProportionPercentage(mtf_list) + " -------- OP: " + option);

                if (sumProportionPercentage(mtf_list) == 1.0) {  // 100%


                        Instant start = Instant.now();

                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String formattedDate = myDateObj.format(myFormatObj);

                        int sampleSize = sample;//mtf_list.get(0);

                        this.setupEnviroment(" ----- Monte Carlo version  for Multiple Transient Fault Injection -------");

                        Instant loadTimeElapsed = Instant.now();

                        Instant startPreparingSimulationTimeElapsed = Instant.now();

                        this.sampleSize = sampleSize; //(int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());
                        int N = this.sampleSize; // random_input_vectors.size();//testNumber;

                        System.out.println("\n-  (input) Sample size = " + this.sampleSize);
                        this.mtf_list = mtf_list;

                        this.signals_to_inject_faults = this.signalsToInjectFault("ALL_SIGNALS"); // Consider all signals to fault inject

                        System.out.println("Signal to inject fault: " + this.signals_to_inject_faults.size());

                                List thread_list =  this.createVectorsAndParticionate(this.sampleSize, option, "MTF-RANDOM");

                        System.out.println("THREAD LIST: " + thread_list);

                        //ArrayList<Float> tt = new ArrayList<>(mtf_list);
                        //tt.remove(0); // 20k

                        Instant endPreparingSimulationTimeElapsed = Instant.now();

                        Instant startThreadingTimeElapsed = Instant.now();

                        this.executeThreadsSimulation(thread_list);

                        Instant endThreadingTimeElapsed = Instant.now();

                        int bitfipCcounter = this.parseResultsAndCalculateFMR();  // FMR

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

                        this.writeLogs(option + "_MTF_MonteCarlo_Simple_Log_" +this.circuit.getName()+"_Threads-"+ this.threads +  "_sampleSize-" + this.sampleSize, formattedDate,  formattedDate2, timeElapsed_Instant, itemx_list, "MTF");

                        long timeElapsed_logGeneration = Duration.between(startTimelogGeneration, endTimelogGeneration).toSeconds();

                        System.out.println("----------------------------------------------------------------------");

                        System.out.println("- Simulation started at: " + formattedDate + " and finished at: "+ formattedDate2);
                        System.out.println("- Circuit: " + this.circuit.getName());
                        System.out.println("- Sample Size (N): " + this.sampleSize );
                        System.out.println("- Fault Mask Rate (FMR): " + " 1 - Ne/N = (1-(" + this.unmasked_faults + "/" + this.sampleSize + ")) = " + this.circuitReliaibility);
                        System.out.println("- Bitflip Counter: " + bitfipCcounter );
                        System.out.println("- Load Time : " + timeElapsed_loadTime + "(s) - Setup Time: " + timeElapsed_PrepareTime  + "(s) - Threading Execution Time: " + timeElapsed_ThreadingTime
                                + "(s) - Log Generation: " + timeElapsed_logGeneration
                                + "(s) - Simulation Instant TimeElapsed: " + timeElapsed_Instant +" (s)" );

                        System.out.println("-----------------------END SIMULATION---------------------------------");

                        this.Performance_Time = "Simulation started at: " + formattedDate + " and finished at: " + formattedDate2;
                        this.sampleSize = N;
                        System.out.println(" ----------------------------------------------------------------------------------------------------------------------\n\n...");
                }
                else{
                        System.err.println("- Inputs inserted sum up ("+sumProportionPercentage(mtf_list)+") above 1 (100%), these were the inserted commands: " + mtf_list);
                }

        }

        public void runMultipleFaultInjectionMultithreadingMonteCarloSimulationProportionOLD(int sample, ArrayList <Float> mtf_list, String option) throws IOException, Exception{

                System.out.println("SUM PROPORTION: " + sumProportionPercentage(mtf_list));

                if (sumProportionPercentage(mtf_list) == 1.0) {  // 100%

                        System.out.println(" ----- Monte Carlo version  for Multiple Transient Fault Injection -------");

                        Instant start = Instant.now();

                        int sampleSize = sample;//mtf_list.get(0);

                        System.out.println("        - SampleSize: " + sampleSize);

                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String formattedDate = myDateObj.format(myFormatObj);
                        System.out.println("    - Simulation start in : " + formattedDate);
                        System.out.println("    - Threads in execution: " + this.threads);

                        /*Reading CellLibrary*/
                        //System.out.println("1");
                        CellLibrary cellLib = new CellLibrary();
                        //System.out.println("2");
                        this.cellLibrary = cellLib;
                        //System.out.println("3");
                        this.cellLibrary.initLibrary(this.genlib);
                        //System.out.println("4");

                        System.out.println("    ... Reading Genlib " + " at -> " + this.genlib + " ... ok");
                        //System.out.println("  - Avaliable logic gatesin this library: "+cellLib.getCells());

                        System.out.println("    ... Reading verilog " + " at -> " + this.circuitNameStr + " ... ok");
                        /*Reading verilog*/
                        MappedVerilogReader verilog_circuit = new MappedVerilogReader(this.circuitNameStr, this.cellLibrary);
                        this.verilog_circuit = verilog_circuit;
                        /*Circuit linked to verilog_circuit - init circuit*/
                        this.circuit = verilog_circuit.getCircuit();

                        //System.out.println("Patterns : " + this.verilog_circuit.getGatePattern());


                        /*Circuit Probabilities */
                        this.initLevelCircuit();

                        /*Init ProbCircuits*/
                        this.initProbCircuit();

                        /*Init PTMs Const*/
                        cellLib.setPTMCells2(Float.valueOf(this.reliabilityConst));
                        cellLib.setPTMCells(new BigDecimal(this.reliabilityConst));

                        Instant loadTimeElapsed = Instant.now();

                        System.out.println("\n        ------ Printing Circuit Specs: --------");
                        //this.PrintSpecs();
                        System.out.println("          ---------------------------------------\n");
                        /*----------------------*/

                        Instant startPreparingSimulationTimeElapsed = Instant.now();

                        this.sampleSize = sampleSize; //(int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());
                        int N = this.sampleSize; // random_input_vectors.size();//testNumber;
                        //int period =  (int) Math.pow(base, order);
                        System.out.println("-  (input) Sample size = " + this.sampleSize);

                        this.signals_to_inject_faults = this.signalsToInjectFault(option); // Consider all signals to fault inject

                        ArrayList<String> random_input_vectors = this.generateInputVector("RANDOM"); // Generate Random Input Vectors or InputTrueTable

                        //Collections.sort(random_input_vectors);

                        ///
                        //System.out.println(" ....... dev input vectors size: " + random_input_vectors.size());

                        ArrayList<ArrayList<Integer>> ListInputVectors = this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());

                        ArrayList<Float> tt = new ArrayList<>(mtf_list);
                        tt.remove(0); // 20k

                        final ArrayList<Float> arrayList_mtf_original = new ArrayList<>(tt); // Original ArrayList

                        //List thread_list = this.particionateMultipletransientFaultInjectionVectorPerThreadMODE(ListInputVectors, mtf_list); // x - vectors per thread
                        List thread_list = this.particionateMultipletransientFaultInjectionVectorPerThreadProportion(ListInputVectors, mtf_list); // x - vectors per thread

                        Instant endPreparingSimulationTimeElapsed = Instant.now();

                        Instant startThreadingTimeElapsed = Instant.now();

                        /*Execução das threads*/
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

                        Instant endThreadingTimeElapsed = Instant.now();

                        /* Compilando os resultados - Falhas detectadas Ne*/
                        int bitfipCcounter = 0;

                        for (int i = 0; i < this.itemx_list.size(); i++) {
                                System.out.println(" itemx_list: " + itemx_list.get(i) + " prop: " + itemx_list.get(i).getPropagatedFaults());
                                this.unmasked_faults = this.unmasked_faults + itemx_list.get(i).getPropagatedFaults();
                                bitfipCcounter = bitfipCcounter + itemx_list.get(i).bitflipcounter;
                        }


                        this.circuitReliaibility = (float) (1.0 - ((float) this.unmasked_faults / (float) this.sampleSize));

                        /*circuit reliability SER (Soft Error Rate)*/
                        //this.circuitReliaibility = (1 - (this.unmasked_faults/this.sampleSize));


                        Instant finish = Instant.now();
                        long timeElapsed_Instant = Duration.between(start, finish).toSeconds();

                        LocalDateTime myDateObj2 = LocalDateTime.now();
                        DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String formattedDate2 = myDateObj2.format(myFormatObj2);

                        Instant startTimelogGeneration = Instant.now();

                        long timeElapsed_loadTime = Duration.between(start, loadTimeElapsed).toSeconds();
                        long timeElapsed_PrepareTime = Duration.between(startPreparingSimulationTimeElapsed, endPreparingSimulationTimeElapsed).toSeconds();
                        long timeElapsed_ThreadingTime = Duration.between(startThreadingTimeElapsed, endThreadingTimeElapsed).toSeconds();

                        //this.writeSimpleLogMultipleTransientFault(option + "_MULTIPLE_MonteCarlo_Simple_Log_" +this.circuit.getName()+"_Threads-"+ this.threads +  "_sampleSize-" + this.sampleSize, formattedDate,  formattedDate2, timeElapsed_Instant, arrayList_mtf_original);
                        //this.writeSimpleLogMultipleTransientFaultProportion(option + "_MULTIPLE_MonteCarlo_Simple_Log_" + this.circuit.getName() + "_Threads-" + this.threads + "_sampleSize-" + this.sampleSize, formattedDate, formattedDate2, timeElapsed_Instant, arrayList_mtf_original);
                        //this.writeLogs(option + "_MTF_MonteCarlo_Simple_Log_" +this.circuit.getName()+"_Threads-"+ this.threads +  "_sampleSize-" + this.sampleSize, formattedDate,  formattedDate2, timeElapsed_Instant, itemx_list, "MTF-PROP");
                        WriteLog log_MTF_PROP = new WriteLog(this.sampleSize, this.threads,
                                this.unmasked_faults, this.circuitReliaibility, this.circuit,
                                this.verilog_circuit, this.signals_to_inject_faults, this.mtf_list);
                        log_MTF_PROP.writeSimpleLogMultipleTransientFaultProportion(option + "_MULTIPLE_MonteCarlo_Simple_Log_" + this.circuit.getName() + "_Threads-" + this.threads + "_sampleSize-" + this.sampleSize, formattedDate, formattedDate2, timeElapsed_Instant, arrayList_mtf_original);

                        log_MTF_PROP.writeCsvFileCompleteThMTF(option + "_MULTIPLE_MonteCarlo_Complete_Log_" + this.circuit.getName() + "_Theads-" + this.threads + "_sampleSize" + this.sampleSize, itemx_list);

                        //this.writeCsvFileCompleteThMTF(option + "_MULTIPLE_MonteCarlo_Complete_Log_" + this.circuit.getName() + "_Theads-" + this.threads + "_sampleSize" + this.sampleSize, itemx_list);

                        Instant endTimelogGeneration = Instant.now();


                        long timeElapsed_logGeneration = Duration.between(startTimelogGeneration, endTimelogGeneration).toSeconds();

                        System.out.println("\n\n----------------- Results ------------------");
                        System.out.println("Circuit: " + this.circuit.getName());
                        System.out.println("- Simulation started at: " + formattedDate + " and finished at: " + formattedDate2); //formattedDate

                        // System.out.println("- PropagatedTime (s): " + propagateTime);
                        System.out.println("- Sample Size (N): " + N);
                        System.out.println("- Propagated fault(s) (Ne): " + this.unmasked_faults);
                        System.out.println("- Fault Mask Rate (FMR): " + " 1 - Ne/N = (1-(" + this.unmasked_faults + "/" + N + ")) = " + this.circuitReliaibility);
                        //System.out.println("- MTBF (Mean Time Between failure) : " + this.MTBF);
                        // System.out.println("- Simulation TimeElapsed: " + propagateTimems + "(ms)");

                        String time = "- Load Time : " + timeElapsed_loadTime + "(s) - Setup Time: " + timeElapsed_PrepareTime + "(s) - Threading Execution Time: " + timeElapsed_ThreadingTime
                                + "(s) - Log Generation: " + timeElapsed_logGeneration
                                + "(s) - Simulation Instant TimeElapsed: " + timeElapsed_Instant + " (s)";

                        // ArrayList <Integer> new_MTF = passProportionPercentage(arrayList_mtf_original, sample);
                        System.out.println("- MTF order list: " + mtf_list);

                        System.out.println("- Bitflip Counter: " + bitfipCcounter);
                        System.out.println(time);

                        System.out.println("--------------------------------------------");
                        this.Performance_Time = "Simulation started at: " + formattedDate
                                + " and finished at: " + formattedDate2;
                        this.sampleSize = N;
                        System.out.println(" ----------------------------------------------------------------------------------------------------------------------\n\n...");
                }
                else{
                        System.err.println("- Inputs inserted sum up ("+sumProportionPercentage(mtf_list)+") above 1 (100%), these were the inserted commands: " + mtf_list);
                }

        }


        /**
         * This method orchestrates the settup enviroment for run Multithreading SET evalaution (LOGICAL SIMULATOR)
         * @param sample
         * @param option
         * @throws IOException
         * @throws Exception
         */
        public void runMTFMonteCarlo_calulateSensitiveArea(int sample, ArrayList <Float> mtf_list, String option, String file) throws IOException, Exception{

                System.out.println("- SUM PROPORTION: " + sumProportionPercentage(mtf_list));
                //List thread_list =  this.createVectorsAndParticionate(sampleSize, option, "MTF-Generate_Netlist");
                //this.runElectricalSimulator(this.relativePath, this.relativePath + "netlist_files/" +"netlist_"+this.circuit.getName() + ".txt");
                //this.sampleSize = N;

                if (sumProportionPercentage(mtf_list) == 1.0 && (sample > 0)) {  // 100%

                        Map <String, SensitiveCell> sensitive_cells = readCsvFileAndMapSensitiveCellsArea(file, ",");
                        System.out.println("Sensitive Cells: " + sensitive_cells.size());
                        this.setSensitiveCells(sensitive_cells);

                        Instant start = Instant.now();

                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String formattedDate = myDateObj.format(myFormatObj);



                        this.setupEnviroment(" ----- Monte Carlo version  for Multiple Transient Fault Injection -------");

                        Instant loadTimeElapsed = Instant.now();

                        Instant startPreparingSimulationTimeElapsed = Instant.now();

                        this.sampleSize = sample; //(int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());

                        int N = this.sampleSize; // random_input_vectors.size();//testNumber;

                        //System.out.println("-  (input) Sample size = " + this.sampleSize);

                        this.signals_to_inject_faults = this.signalsToInjectFault(option); // Consider all signals to fault inject

                        this.mtf_list = mtf_list;

                        System.out.println("SAMPLE SIZE: " + this.sampleSize);


                        this.signals_to_inject_faults = this.signalsToInjectFault(option); // Consider all signals to fault inject

                        this.mtf_list = mtf_list;

                        //List thread_list =  this.createVectorsAndParticionate(sampleSize, option, "MTF-RANDOM");
                        List thread_list =  this.createVectorsAndParticionate(this.sampleSize, option, "MTF-Sensitive_Area-Generate_Netlist");

                        //System.out.println("THREAD LIST: " + thread_list);

                        ArrayList<Float> tt = new ArrayList<>(mtf_list);
                        tt.remove(0); // 20k

                        Instant endPreparingSimulationTimeElapsed = Instant.now();

                        Instant startThreadingTimeElapsed = Instant.now();

                        this.executeThreadsSimulation(thread_list);

                        Instant endThreadingTimeElapsed = Instant.now();

                        int bitfipCcounter = this.parseResultsAndCalculateFMR();  // FMR

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

                        this.writeLogs(option + "_MTF_MonteCarlo_Simple_Log_" +this.circuit.getName()+"_Threads-"+ this.threads +  "_sampleSize-" + this.sampleSize, formattedDate,  formattedDate2, timeElapsed_Instant, itemx_list, "MTF");

                        long timeElapsed_logGeneration = Duration.between(startTimelogGeneration, endTimelogGeneration).toSeconds();

                        System.out.println("----------------------------------------------------------------------");

                                this.printResults("MTF" , formattedDate, formattedDate2, bitfipCcounter, timeElapsed_loadTime, timeElapsed_PrepareTime, timeElapsed_ThreadingTime, timeElapsed_logGeneration, timeElapsed_Instant);
                        //String specific, String formattedDate, String formattedDate2,
                        // int bitfipCcounter, long timeElapsed_loadTime, long timeElapsed_PrepareTime,
                        // long timeElapsed_ThreadingTime, long timeElapsed_logGeneration, long timeElapsed_Instant){);

                        System.out.println("-----------------------END SIMULATION---------------------------------");



                        System.out.println(" ----------------------------------------------------------------------------------------------------------------------\n\n...");
                }
                else{
                        System.err.println("- Inputs inserted sum up ("+sumProportionPercentage(mtf_list)+") above 1 (100%), these were the inserted commands: " + mtf_list);
                }



        }

        public void generateSensitiveNodesForSETSpiceFile(String spiceScriptsFolder, String PTMLibrary, String SpiceNetListLibrary) throws IOException {

                System.out.println("--------  Electrical Simulation Analysis ---------");
                System.out.println("- Moving files....");
                //String electricalFolderSimulation = this.relativePath + "netlist_files/";
                String electricalFolderSimulation = this.relativePath + spiceScriptsFolder;

                //String folder = "netlist_files/";
                //System.out.println("\n---- > RElative Path: " + this.relativePath + "     R: " + spiceScriptsFolder);
                ///this.moveFiles(this.relativePath,  "45nm_HP.pm", electricalFolderSimulation);
                this.moveFiles(this.relativePath,  PTMLibrary, electricalFolderSimulation);
                //System.out.println("---- > 2RElative Path: " + this.relativePath + "     R: " + spiceScriptsFolder);
                //this.moveFiles(this.relativePath,"Library.txt", electricalFolderSimulation);
                this.moveFiles(this.relativePath, SpiceNetListLibrary, electricalFolderSimulation);
                //System.out.println("---- > 3 RElative Path: " + this.relativePath + "     R: " + spiceScriptsFolder);

                System.out.println(" SIZE: " + this.itemx_list.size());
                for (int i = 0; i < this.itemx_list.size(); i++) {
                        if(!this.itemx_list.get(i).getParsedNetlistContent().equals("") && (!this.itemx_list.get(i).getParsedNetlistContent().contains("ERROR"))) {
                                String circuitSpiceName = this.circuit.getName() + "_vec_" + i + ".txt";
                                this.writeInformationInFileLog(this.relativePath + spiceScriptsFolder, "", this.itemx_list.get(i).getParsedNetlistContent(), circuitSpiceName);
                                        //System.out.println("- Created parsed netlist file: " + electricalFolderSimulation + circuitSpiceName + "  size: " + this.itemx_list.get(i).getParsedNetlistContent().isBlank());
                                this.runElectricalSimulator(this.relativePath , electricalFolderSimulation + circuitSpiceName);
                        }
                }
                System.out.println("--------  Electrical Simulation Analysis ---------");

        }

        public void runElectricalSimulator(String path, String spiceCircuito){
                try {
                        Runtime runTime = Runtime.getRuntime();

                        File f = new File(spiceCircuito);

                        // Checking if the specified file exists or not
                        if (f.exists()) {

                                String executablePath = path + "ngspice.exe " + spiceCircuito;//"C:\\Users\\sdkca\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe";

                                Process process = runTime.exec(executablePath);
                        }else{
                                System.out.println("File dont exist: " + spiceCircuito);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public void setSensitiveCells(Map <String, SensitiveCell> sensitive_cells){
                this.sensitive_cells = sensitive_cells;
        }

        public float sumProportionPercentage(ArrayList<Float> mtf_list){

                float sum_proportion = 0;


                for (int percentage = 1; percentage < mtf_list.size(); percentage++) { // Check if it higher then 100% (1.0)
                        sum_proportion = sum_proportion + mtf_list.get(percentage);
                }
                return sum_proportion;
        }

        public void moveFiles(String source, String fileName, String destinationFolder) throws IOException {
                //"netlist_files/"

                try {

                        Path path = Paths.get(destinationFolder);
                        System.out.println("Path: " + path);
                        System.out.println(" Source: " + source + "   filename: " + fileName + "   dstFOlder: " +destinationFolder);
                        //java.nio.file.Files;
                        Files.createDirectories(path);

                        System.out.println("Directory is created : " + destinationFolder);
                }catch (Exception e){
                        System.out.println("Error Folder already exists: " + destinationFolder);
                }

                //System.out.println("- Moving file: " + destinationFolder + fileName);
                //System.out.println("Source: " + source + fileName);
                //System.out.println("Destination: " + destinationFolder + fileName);

                List<File> files = new ArrayList<>();
                files.add(new File(source + fileName));

                for(File file : files) {
                        Files.copy(file.toPath(),
                                (new File(destinationFolder + file.getName())).toPath(),
                                StandardCopyOption.REPLACE_EXISTING);
                }
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
                        System.out.println("Error al leer .csv");
                        e.printStackTrace();
                }
                return sensitive_cells;
        }

        public void runCalculationSensitiveAreas(String option, String file) throws IOException, Exception{ //Test All possibilities
                System.out.println(" ----- Calculate Sensitive Areas -------");
                System.out.println("File: " + file);
                //file = "teste\\lookup_table.csv";
                //System.out.println("File: " + file);

                Map <String, SensitiveCell> sensitive_cells = readCsvFileAndMapSensitiveCellsArea(file, ",");

                System.out.println("Sensitive Cells: " + sensitive_cells);

                long loadTimeStart = System.nanoTime();//System.currentTimeMillis();

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);
                System.out.println("    - Simulation start in : " + formattedDate);
                System.out.println("    - Threads in execution: " + this.threads);

                /*Reading CellLibrary*/
                CellLibrary cellLib = new CellLibrary();

                // System.out.println("1");
                this.cellLibrary = cellLib;
                // System.out.println("2");
                this.cellLibrary.initLibrary(this.genlib);
                System.out.println("3"
                        + "");
                System.out.println("    ... Reading Genlib " + " at -> " + this.genlib  + " ... ok");
                //System.out.println("  - Avaliable logic gatesin this library: "+cellLib.getCells());


                /*Reading verilog*/
                MappedVerilogReader verilog_circuit = new MappedVerilogReader(this.circuitNameStr, this.cellLibrary);
                this.verilog_circuit = verilog_circuit;
                /*Circuit linked to verilog_circuit - init circuit*/
                this.circuit = verilog_circuit.getCircuit();
                System.out.println("    ... Reading verilog "+ " at -> " + this.circuitNameStr  + " ... ok");
                //System.out.println("Patterns : " + this.verilog_circuit.getGatePattern());



                /* Print circuit Specs*/
                System.out.println("\n        ------ Printing Circuit Specs: --------");
                //this.PrintSpecsThesis();
                System.out.println("          ---------------------------------------\n");
                /*----------------------*/


                /*Circuit Probabilities */
                this.initLevelCircuit();

                /*Init ProbCircuits*/
                this.initProbCircuit();

                /*Init PTMs Const*/
                cellLib.setPTMCells2(Float.valueOf(this.reliabilityConst));
                cellLib.setPTMCells(new BigDecimal(this.reliabilityConst));

                long loadTimeEnd = System.nanoTime();//System.currentTimeMillis();
                long loadTime =   TimeUnit.NANOSECONDS.toMillis(loadTimeEnd - loadTimeStart);
                //System.out.println("- Load Time m(s): " + loadTime);

                this.sampleSize = (int) Math.pow(2, this.probCircuit.getInputs().size());  //(int) Math.pow(2, this.probCircuit.getInputs().size());
                int N = this.sampleSize; // random_input_vectors.size();//testNumber;

                int sizeExasuticTest;

                System.out.println("-   Sample size (N = 2^ENTRADAS): " + "2^"+ this.circuit.getInputs().size() + " = " + this.sampleSize);

                this.signals_to_inject_faults = this.signalsToInjectFault(option); // Consider all signals to fault inject

                sizeExasuticTest = this.sampleSize;//(this.sampleSize * this.signals_to_inject_faults.size());

                ArrayList <String> random_input_vectors =  this.generateInputVector("TRUE_TABLE"); //this.calcInputTableVector(this.probCircuit.getInputs().size(), this.sampleSize);

                ArrayList <ArrayList<Integer>> ListInputVectors =  this.splitInputPatternsInInt(random_input_vectors, this.probCircuit.getInputs().size());

                System.out.println("LIST:::::: "+ ListInputVectors.size());

                List thread_list = particionateExausticVectorForSensitiveAreas(ListInputVectors, sensitive_cells, "Sensitive_Area");  // TESTE ALL GATES ///particionateVectorPerThread(ListInputVectors); // x - vectors per thread

                long propagateTimeStart = System.nanoTime();

                /*Execução das threads*/
                Thread thread_temp = null;
                for (int i=0; i < thread_list.size() ; i++) {
                        thread_temp = (Thread) thread_list.get(i);
                        thread_temp.start();

                }
                /*Esperando termino das threads*/
                for (int i=0; i < thread_list.size() ; i++) {
                        thread_temp = (Thread) thread_list.get(i);
                        thread_temp.join();
                }

                /* Compilando os resultados - Falhas detectadas Ne*/
                //for (int i=0; i < this.itemx_list.size() ; i++) {
                //    this.unmasked_faults = this.unmasked_faults +  itemx_list.get(i).getPropagatedFaults();
                //}
                for (int i = 0; i < this.itemx_list.size(); i++) {
                        List <TestVectorInformation> x =  this.itemx_list.get(i).get_threadSimulationList();
                        for (int j = 0; j < x.size(); j++) {
                                System.out.println(" index: " + x.get(j).getSimulationIndex() + " vec: " + x.get(j).getinputVector() + " sensitive area sum: " + x.get(j).getSum_sensitive_cells_area() );
                        }
                }

                //System.out.println("SIZE: " + this.itemx_list.size());

                /*circuit reliability SER (Soft Error Rate)*/
                // this.circuitReliaibility = (float) (1.0 - ((float) this.unmasked_faults / (float) sizeExasuticTest));

                //System.out.println("-> Umasked Faults: " + this.unmasked_faults);
                //System.out.println("-> Sample: " + sizeExasuticTest);
                //System.out.println("-> SER : " + this.circuitReliaibility);


                long propagateTimeEnd = System.nanoTime();
                //long propagateTime =    TimeUnit.NANOSECONDS.toSeconds(propagateTimeEnd - propagateTimeStart);
                long propagateTime =  TimeUnit.NANOSECONDS.toMillis(propagateTimeEnd - propagateTimeStart);


                LocalDateTime myDateObj2 = LocalDateTime.now();
                DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate2 = myDateObj2.format(myFormatObj2);

                this.sampleSize = sizeExasuticTest;

                //this.writeSimpleLog("ExausticSimulation_" +this.circuit.getName()+"_Threads-"+ this.threads + "_sampleSize-" + this.sampleSize, formattedDate,  formattedDate2, propagateTime);

                //this.writeCsvFileCompleteTh("ExausticSimulation_"+this.circuit.getName()+"_Theads-"+ this.threads + "_sampleSize-" + this.sampleSize, itemx_list);


                System.out.println("\n\n----------------- Sensitive Area ------------------");
                System.out.println("Circuit: " + this.circuit.getName());
                System.out.println("- Simulation finished at: " + formattedDate2);
                //System.out.println("- PropagatedTime (s): " + propagateTime);
                System.out.println("- Sample (N): " + this.sampleSize);
                //System.out.println("- Detected faults (Ne): " + this.unmasked_faults);
                //System.out.println("- Fault Masking Rate (FMR): " + "(1-(" + this.unmasked_faults + "/" + this.sampleSize + ")) = " + this.circuitReliaibility);
                // System.out.println("- MTBF (Mean Time Between failure) : " + this.MTBF);
                System.out.println("- Simulation TimeElapsed: " + propagateTime + "(s)");
                System.out.println("--------------------------------------------");

                this.Performance_Time = "Simulation started at: " + formattedDate + " and finished at: " + formattedDate2;

                System.out.println(" ----------------------------------------------------------------------------------------------------------------------------\n\n");
                /*
                 */
        }

        public void writeInformationInFileLog(String relativePath,  String header, String content, String outputFilename) throws IOException {
                try {
                        String content_file = header + "\n" + content;

                        //relativePath = relativePath + "/netlist_files";
                        Path path = Paths.get(relativePath);

                        //java.nio.file.Files;
                        Files.createDirectories(path);


                        if (!content_file.isBlank()) {
                                System.out.println("--> File : " + outputFilename + " was created...");
                                try (FileWriter file = new FileWriter(relativePath + "/" + outputFilename)) {
                                        file.write(content_file);
                                }catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }else{
                                System.out.println("- Could not create file " + outputFilename + " because is not propagate SET in logical level");
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
