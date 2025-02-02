package simulation;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class SimulationInLotParser {

        private String  circuitfilesPath;
        private ArrayList<String> circuitList = new ArrayList<>();
        private ArrayList<SimulationCircuit> simulationCircuitsList = new ArrayList<>();

        public SimulationInLotParser(String circuitfilesPath){
                this.circuitfilesPath = circuitfilesPath;
        }

        public ArrayList<String> getCircuitList() {
                /*
                ArrayList <String> temp = new ArrayList<>(this.circuitList);

                ArrayList <String> backup = new ArrayList<>();

                System.out.println("----OLD >>>> " + temp);
                for (int i = 0; i < temp.size() ; i++) {
                        temp.set(i, temp.get(i).replace("_lib_min_no_cost.v", ""));
                        //System.out.println("file: " + temp.get(i) + "  - size" +  temp.get(i).length());
                        if(temp.get(i).length() <= 4){
                                backup.add(temp.get(i));
                        }
                        //temp.set(i, temp.get(i).replace("s", ""));
                }

                //System.out.println("Before Sorting:");

                Collections.sort(temp);



                System.out.println("\nAfter Sorting: " + backup);
                */

                return this.circuitList;
        }

        public ArrayList<SimulationCircuit> getSimulationCircuitsList() {
                return simulationCircuitsList;
        }

        public void getVerilogCircuitFilesPath(){
                String[] circuitFiles;
                File f = new File(this.circuitfilesPath);

                circuitFiles = f.list();

                for (String pathname : circuitFiles) {
                        if(pathname.endsWith(".v")){ // test type for verilogs .v
                                this.circuitList.add(pathname);
                        }
                }
                //System.out.println("Circuits in List: " +  this.circuitList);
                System.out.println("- Were founded " + this.circuitList.size() + " circuit (.v) in path folder: " + this.circuitfilesPath);
                //return this.circuitList;
        }

        public void getSpiceCircuitFilesPath(){
                String[] circuitFiles;
                File f = new File(this.circuitfilesPath);

                circuitFiles = f.list();

                for (String pathname : circuitFiles) {
                        if(pathname.endsWith(".txt")){ // test type for verilogs .v
                                this.circuitList.add(pathname);
                        }
                }
                //System.out.println("Circuits in List: " +  this.circuitList);
                System.out.println("- Were founded " + this.circuitList.size() + " Spice circuit (.txt) in path folder: " + this.circuitfilesPath);
                //return this.circuitList;
        }

        public void circuitListParser(String genlib, String signalsToinjectFault, int threads, String reliabilityConst, int sampleSize){

                if ( sampleSize > 0 ) {
                        for (String file : this.circuitList) {
                                SimulationCircuit circuit = new SimulationCircuit(file, this.circuitfilesPath, genlib, signalsToinjectFault, threads, reliabilityConst, sampleSize); //String circuit, String relativePath, String genlib, String signalsToinjectFault, int threads, String reliabilityConst, int sampleSize
                                //System.out.println("   ~~~~~ sample: " + circuit.getSample());
                                this.simulationCircuitsList.add(circuit);
                        }
                }else{
                        System.err.println("Sample Size <= 0 !!!!");
                }
        }

        public void circuitListParser(String genlib, String signalsToinjectFault, int threads, String reliabilityConst,  ArrayList <Float> mtf_sizes){
                if ( mtf_sizes.size() >= 0 ) {
                        for (String file : this.circuitList) {
                                SimulationCircuit circuit = new SimulationCircuit(file, this.circuitfilesPath, genlib, signalsToinjectFault, threads, reliabilityConst, mtf_sizes); //String circuit, String relativePath, String genlib, String signalsToinjectFault, int threads, String reliabilityConst, int sampleSize
                                this.simulationCircuitsList.add(circuit);
                        }
                }
                else{
                        System.err.println(" MTF_LIST <= 0 !!!!");
                }
        }

        public void printCircuitsSpecs(){
                System.out.println("\n");
                int id = 0;
                for (SimulationCircuit circ: this.simulationCircuitsList){
                        System.out.println("(" +id + ") - Circuit: " + circ.getCircuit() + " genlib: " + circ.getGenlib() + "  threads: " + circ.getThreads() + " STF or MTF: " + circ.getSample()+ " " + circ.getMtf_sizes());
                        id++;
                }
        }
}
