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

    String vector;
    String faultSig;
    public createCircuitVectorIndependent(Circuit circuit, CellLibrary cellLibrary, LevelCircuit levelCircuit){
        this.circuit = circuit;
        this.levelCircuit = levelCircuit;
        this.cellLibrary = cellLibrary;
        this.vector = "";
        this.faultSig = "";
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public CellLibrary getCellLibrary() {
        return cellLibrary;
    }

    public LevelCircuit getLevelCircuit() {
        return levelCircuit;
    }
}
