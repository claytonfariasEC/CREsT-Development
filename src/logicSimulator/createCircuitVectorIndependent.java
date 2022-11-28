package logicSimulator;

import datastructures.CellLibrary;
import datastructures.Circuit;
import levelDatastructures.LevelCircuit;

import java.util.ArrayList;

public class createCircuitVectorIndependent {

    private Circuit circuit;
    //private ArrayList<Circuit> circuitAccordingVector = new ArrayList<>();
    private CellLibrary cellLibrary;
    private LevelCircuit levelCircuit;

    private int threadSimulationIndex;
    String vector;
    String faultSig;
    public createCircuitVectorIndependent(Circuit circuit, CellLibrary cellLibrary, LevelCircuit levelCircuit, int threadSimulationIndex){
        this.circuit = circuit;
        this.levelCircuit = levelCircuit;
        this.cellLibrary = cellLibrary;
        this.vector = "";
        this.faultSig = "";
        this.threadSimulationIndex = threadSimulationIndex;
    }

    public Circuit getCircuit() {
        return this.circuit;
    }

    public CellLibrary getCellLibrary() {
        return this.cellLibrary;
    }

    public LevelCircuit getLevelCircuit() {
        return this.levelCircuit;
    }

    public int getThreadSimulationIndex() {
        return this.threadSimulationIndex;
    }

    @Override
    public int hashCode() {
        return this.levelCircuit.hashCode();
    }
}
