/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.ArrayList;

/**
 *
 * @author Matheus Ferreira Pontes
 */
public class Signal {
    
    private String id;
    private Gate origin;
    private ArrayList<Gate> destiny = new ArrayList<>();
    private int logicValue;
    private boolean logicValueBoolean;
    private int originalSignalValue;

    /*Marcio*/
    //valor lógico incorreto
    private boolean fol;
    //valor lógico esperado
    private boolean logicValue2;

    /*clayton*/
    private boolean signalVisited;
    private ArrayList <Object> signalOutputPath = new ArrayList<>();
    
    /**
     * Simple Signal constructor.
     *
     */
    
    /*Clayton*/
    public Signal() {
        
            this.logicValue = -2;
            this.originalSignalValue = -2;
            this.signalVisited = false;
        
    }
    /*Clayton*/
    public Signal(int logicvalue, int originalValue, boolean signalVisited) {
            this.logicValue = -2;
            this.originalSignalValue = -2;
            this.signalVisited = false;
    }
    
    /**
     * Signal constructor with defined "id".
     *
     * @param id - Signal identification
     */
    public Signal(String id) {
        this.id = id;
    }
    /*Clayton*/
    public void setOutputPath(ArrayList gate) {
       this.signalOutputPath.add(gate);
    }
    /*Clayton*/
     public Object getOutputPath() {
       return this.signalOutputPath;
    }
    /**
     * Signal constructor with defined "id", "origin" and "destiny".
     *
     * @param id - Signal identification
     * @param origin - Signal origin
     * @param destiny - Signal destinies
     */
    public Signal(String id, Gate origin, ArrayList<Gate> destiny) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
    }
    
    /**
     * This method return the Signal identification.
     *
     * @return String - Signal ID
     */
    public synchronized String getId() {
        return id;
    }

    public synchronized String getSignalOriginalAndNewValue() {

        return "O(" + this.originalSignalValue + ") - N(" + this.getLogicValue() + ") - Boolean: " + this.getLogicValueBoolean();
        //return id;
    }
    public synchronized String getSignalBitflip() {

        return "(" + this.originalSignalValue + " to " + this.logicValue + ") ";
        //return id;
    }

    public synchronized void setVisited(){
        this.signalVisited = true;
    }

    public synchronized boolean getVisited(){
        return this.signalVisited;
    }
    
    /**
     * This method set the Signal identification.
     *
     * @param id String - Signal ID
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /*Clayton Farias - Setting Logic value */
    public synchronized void setLogicValueBoolean(Boolean logicValue){
        this.logicValueBoolean = logicValue;
    }

    public synchronized void setLogicValue(int logicValue){
        this.logicValue = logicValue;

        //this.setVisited();
    }

    public synchronized void setOriginalLogicValue(int logicValue){
        this.originalSignalValue = logicValue;


    }

    public synchronized int getOriginalLogicValue(){
        return this.originalSignalValue;
    }

    public synchronized int getLogicValue(){
        return this.logicValue;
    }
    
    public Character getLogicValueChar(){
        Character r = (Character.highSurrogate(this.logicValue));// this.logicValue;
        return r;
    }
    
    public boolean getLogicValueBoolean(){
        return this.logicValueBoolean;
    }
    
    /**
     * This method return the Signal Origin (Gate's Output).
     *
     * @return Gate - Origin Gate
     */
    public Gate getOrigin() {
        return origin;
    }

    /**
     *
     * This method set the Signal origin
     * @param origin - Gate (output)
     */
    public void setOrigin(Gate origin) {
        this.origin = origin;
    }
    
    /**
     * This method return the Signal Destination (One or more Gates).
     *
     * @return ArrayList - Gates ArrayList
     */
    public ArrayList<Gate> getDestiny() {
        return destiny;
    }
    
    /**
     * This method set the Signal identification.
     *
     * @param destiny - Gates ArrayList
     */
    public void setDestiny(ArrayList<Gate> destiny) {
        this.destiny = destiny;
    }
    
    /**
     * This method add a Destination Gate to the Signal Destination Gate list.
     *
     * @param gate Gate - Destination Gate
     */
    public void addDestiny(Gate gate) {
        destiny.add(gate);
    }

    /**
     * This method remove a Destination Gate from the Signal Destination Gate
 list.
     *
     * @param gate Gate - Destination signal
     */
    public void removeDestiny(Gate gate) {
        destiny.remove(gate);
    }
    
    public String toString() {
        return this.id;
    }

    /*Marcio*/
    public boolean getLogicValue2() {
        return logicValue2;
    }

    public void setLogicValue2(boolean logicValue2) {
        this.logicValue2 = logicValue2;
    }

    public boolean getFol() {
        return fol;
    }

    public void setFol(boolean fol) {
        this.fol = fol;
    }
}
