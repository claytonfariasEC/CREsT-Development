package datastructures;

/**
 * Circuit DataStructura, contains signals and gates that composing a circuit
 * represented.
 * @author Matheus Ferreira Pontes
 */

import java.util.*;

public class Circuit {
        
    private String name;
    private ArrayList<Signal> signals;
    private ArrayList<Gate> gates;
    private Map<String, Signal> hashSignals;
    
    /**
     * Simple Circuit constructor.
     *
     */
    public Circuit() {
        signals = new ArrayList<>();
        gates = new ArrayList<>();
        hashSignals = new HashMap<String, Signal>();
    }
    
    /**
     * Circuit constructor with defined "name".
     *
     * @param name String - Circuit name
     */
    public Circuit(String name) {
        this.name = name;
        signals = new ArrayList<>();
        gates = new ArrayList<>();
    }
    
    /**
     * Circuit constructor with defined "name".
     *
     * @param name String - Circuit name
     * @param signals ArrayList - Signal Circuit List
     * @param gates ArrayList - Gates Circuit List
     */
    public Circuit(String name, ArrayList<Signal> signals, 
                   ArrayList<Gate> gates) {
        this.name = name;
        this.signals = signals;
        this.gates = gates;
    }

    /**
     * This method return the Circuit name.
     *
     * @return String - Circuit name
     */
    public String getName() {
        return name;
    }
    
    /**
     * This method set the Circuit name.
     *
     * @param name String - Gate ID
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method return the Circuit Signals list.
     *
     * @return Arraylist - Signal list
     */
    public ArrayList<Signal> getSignals() {
        return signals;
    }

    /**
     * This method set the Circuit Signals list.
     *
     * @param signals ArrayList - Signal list
     */
    public void setSignals(ArrayList<Signal> signals) {
        this.signals = signals;
    }
    
    /**
     * This method add a Signal to the Circuit Signals list.
     *
     * @param signal Signal - Signal it'll be added
     */
    public void addSignal(Signal signal) {
        signals.add(signal);
    }

    /**
     * This method remove a Signal from the Circuit Signals List
     *
     * @param signal Signal - Signal it'll be removed
     */
    public void removeSignal(Signal signal) {
        signals.remove(signal);
    }

    /**
     * This method return the Circuit Gates list.
     *
     * @return Arraylist - Gates list
     */
    public ArrayList<Gate> getGates() {
        return gates;
    }

    /**
     * This method set the Circuit Gates list.
     *
     * @param gates ArrayList - Gates list
     */
    public void setGates(ArrayList<Gate> gates) {
        this.gates = gates;
    }
    
    /**
     * This method add a Gate to the Circuit Gates list.
     *
     * @param gate Gate - Gate it'll be added
     */
    public void addGate(Gate gate) {
        gates.add(gate);
    }

    /**
     * This method remove a Gate from the Circuit Gates List
     *
     * @param gate Gate - Gate it'll be removed
     */
    public void removeGate(Gate gate) {
        gates.remove(gate);
    }
    
    /**
     * This method return the Circuit Inputs ArrayList.
     *
     * @return ArrayList - Inputs ArrayList
     */
    public ArrayList<Signal> getInputs() {
        ArrayList<Signal> temp = new ArrayList<>();
        for (Signal input1 : signals) {
            if (input1.getOrigin() == null && !input1.getDestiny().isEmpty()) {
                temp.add(input1);
            }
        }
        return temp;
    }

    /**
     * This method return the Circuit Outputs ArrayList.
     *
     * @return ArrayList - Outputs ArrayList
     */
    public ArrayList<Signal> getOutputs() {
        ArrayList<Signal> temp = new ArrayList<>();
        for (Signal input1 : signals) {
            for(Gate fooGate: input1.getDestiny()) {
                if(fooGate == null) {
                    temp.add(input1);
                    break;
                }
            }            
        }
        return temp;
    }

    /**
     * Hashmap test performance
     */
    public void setHashSignals(ArrayList<Signal> signals) {
        for (Signal signal : signals) {
            this.hashSignals.put(signal.getId(), signal);
        }
    }

    public Signal getHashSignalById(String key) {
        return this.hashSignals.get(key);
    }

    public void addHashSignal(String key, Signal signal) {
        this.hashSignals.put(key, signal);
    }



}
