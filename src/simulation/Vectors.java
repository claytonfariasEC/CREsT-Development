package simulation;

import datastructures.CellLibrary;
import datastructures.Circuit;
import datastructures.Signal;
import levelDatastructures.LevelCircuit;
import logicSimulator.LogicSimulator;
import logicSimulator.TestVectorInformation;
import signalProbability.ProbCircuit;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vectors extends Manager{

    private int sampleSize;

    private CellLibrary cellLibrary;

    private ArrayList<Signal> signals_to_inject_faults = new ArrayList<Signal>();

    private LevelCircuit levelCircuit;

    private String circuitNameStr;

    private ArrayList<LogicSimulator> itemx_list = new ArrayList<>();

    /**
     * @param threads
     * @param reliabilityConst
     * @param relativePath
     * @param genlib
     * @param circuitName
     * @param probCircuit
     * @param circuit
     * @throws IOException
     */
    public Vectors(int threads, String reliabilityConst, String relativePath, String genlib, String circuitName, ProbCircuit probCircuit, Circuit circuit, int sampleSize) throws IOException {
        super(threads, reliabilityConst, relativePath, genlib, circuitName, probCircuit, circuit);

        this.sampleSize = getSampleSize();
        this.cellLibrary = getCellLibrary();
        this.levelCircuit = getLevelCircuit();
        this.circuitNameStr = getCircuitNameStr();
        this.itemx_list = getItemx_list();
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

    // FALTA COISAS AINDA


}
