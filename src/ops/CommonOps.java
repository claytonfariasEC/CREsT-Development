/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ops;

import java.io.File;
import java.lang.Math.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import signalProbability.ProbCircuit;
import signalProbability.ProbSignal;

import static ops.LogarithmOps.lnBig;

/**
 *
 * @author matheus
 */
public class CommonOps {

    public static String getBinaryTruthTable(String hexTruth, int cellInputSize) {
        BigInteger bInt = new BigInteger(hexTruth, 16);
        return String.format("%" + (int)Math.pow(2, cellInputSize) + "s", bInt.toString(2)).replace(' ', '0');
    }

    public static long timenow() {
        return System.currentTimeMillis();
    }

    public static long timestampDiff(Long timenow) {
        return System.currentTimeMillis() - timenow;
    }

    public static void timestamp(Long timenow, String message) {
        final long startTime = System.currentTimeMillis();
        String timeConsup = "## TIME CONSUPTION ## ==> " + Long.toString(timestampDiff(timenow)) + " ms";
        System.out.println(message);
        System.out.println(timeConsup);
    }
    
    public static String getTrueCurrentPath(Object obj) {        
        try {
            //return obj.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            return new File(obj.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        } catch (URISyntaxException ex) {
            Logger.getLogger(CommonOps.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static String getFileName(String path) {
        
        String pathSeparator = File.separator;
        int index = path.lastIndexOf(pathSeparator);
        return path.substring(index + 1);
    }
    
    public static boolean isJar(Object obj) {
     
        String path = getTrueCurrentPath(obj);
        
        String fileName = getFileName(path);
        
        return (fileName.contains(".jar"));
    }
    
    public static String getWorkPath(Object obj) {
        
        if (isJar(obj)) {
            String path = getTrueCurrentPath(obj);
            String filename = getFileName(path);
            
            return path.replace(filename, "");
        } else {
            return System.getProperty("user.dir") + File.separator;
        }
    }
    
    public static BigDecimal[][] getKronecker(BigDecimal[][] matrixA, BigDecimal[][] matrixB) {
        
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        
        int rowsC = rowsA * rowsB;
        int colsC = colsA * colsB;
        
        BigDecimal[][] matrixC = new BigDecimal[rowsC][colsC];
        
        for( int i = 0; i < rowsA; i++ ) {
            
            for( int j = 0; j < colsA; j++ ) {
                
                BigDecimal a = matrixA[i][j];                

                for( int rowB = 0; rowB < rowsB; rowB++ ) {
                    
                    for( int colB = 0; colB < colsB; colB++ ) {
                        
                        BigDecimal val = a.multiply(matrixB[rowB][colB]);

                        matrixC[i*rowsB+rowB][j*colsB+colB] = val.setScale(15, RoundingMode.HALF_UP);
                        //matrixC[i*rowsB+rowB][j*colsB+colB] = val;
                    }
                }
            }
        }
                
        
        return matrixC;
    }
    
    public static BigDecimal[][] getMultipliedMatrix(BigDecimal[][] A, BigDecimal[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        } 
        
        
        BigDecimal[][] C = new BigDecimal[aRows][bColumns];
        
        
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = BigDecimal.ZERO;
            }
        }
        

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] = C[i][j].add(A[i][k].multiply(B[k][j]).setScale(15, RoundingMode.HALF_UP)).setScale(15, RoundingMode.HALF_UP);
                    //C[i][j] = C[i][j].add(A[i][k].multiply(B[k][j]));
                }
            }
        }

        return C;
    }
    
    public static void matrixPrint(BigDecimal[][] matrix) {
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static long powLong(long a, long b) {
        long re = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                re *= a;        
            }
            b >>= 1;
            a *= a; 
        }
        return re;
    }
    
    public static float[][] getKronecker(float[][] matrixA, float[][] matrixB) {
        
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        
        int rowsC = rowsA * rowsB;
        int colsC = colsA * colsB;
        
        float[][] matrixC = new float[rowsC][colsC];
        
        for( int i = 0; i < rowsA; i++ ) {
            
            for( int j = 0; j < colsA; j++ ) {
                
                float a = matrixA[i][j];                

                for( int rowB = 0; rowB < rowsB; rowB++ ) {
                    
                    for( int colB = 0; colB < colsB; colB++ ) {
                        
                        float val = a * matrixB[rowB][colB];

                        matrixC[i*rowsB+rowB][j*colsB+colB] = val;
                    }
                }
            }
        }
                
        
        return matrixC;
    }
    
    public static float[][] getMultipliedMatrix(float[][] A, float[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        } 
        
        
        float[][] C = new float[aRows][bColumns];
        
        
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0f;
            }
        }
        

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }
    
    public static void matrixPrint(float[][] matrix) {
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static ArrayList<ArrayList<Boolean>> getCombVectors(int begin, int end, int vectorSize) {
        
        ArrayList<ArrayList<Boolean>> result = new ArrayList<>();
        
        for (int i = 0; i < vectorSize; i++) {
            result.add(new ArrayList<>(end-begin));
        }

        
        String numBits = "%"+vectorSize+"s";
        
        for (int i = begin; i < end+1; i++) {
            String binary = String.format(numBits, Integer.toBinaryString(i)).replace(' ', '0');
            
            //boolean[] initVector = new boolean[vectorSize];
            //ArrayList<Boolean> initVector = new ArrayList<>();
            
            //System.out.println(binary);

            char[] charArray = binary.toCharArray();
            //System.out.println(charArray);

//            for (int j = 0; j < charArray.length; j++) {
//                initVector[j] = charArray[j] == '1';
//            }
            
            for (int j = 0; j < vectorSize; j++) {
                result.get(j).add(charArray[j] == '1');
            }
            
            //System.out.println(Arrays.toString(initVector));
            
            //result.add(initVector);
            
            //ARRAYLIST ARMAZENA REFERENCIA!!!
        }                
        
        
        
            
            //for (int r : mapping) {
              //  result = result + charArray[r];
            //}
            
            //interArray[i+1] = Integer.parseInt(result, 2);

           // result = "";
        
        return result;
    }
    
    public static int[] getITM(ProbCircuit pCircuit) {
        
        ArrayList<ArrayList<Boolean>> inCombination = getCombVectors(0, PTMOps.PowInt(2, (pCircuit.getProbInputs().size())) - 1, pCircuit.getProbInputs().size());
        pCircuit.propagate(inCombination);
        
        //int[] itm = new int[PTMOps.PowInt(2, pCircuit.getProbInputs().size())];
        int[] itm = new int[pCircuit.getProbInputs().get(0).getSignalValues().size() + 1];
        ArrayList<ProbSignal> outSignals = pCircuit.getProbOutputs();
        
        itm[0] = PTMOps.PowInt(2, outSignals.size());
        
        for (int i = 1; i < itm.length; i++) {
            int column = 0;
            
            int counter = outSignals.size() - 1;
            
            for (int j = 0; j < outSignals.size(); j++) {
                boolean value = outSignals.get(j).getSignalValues().get(i-1);
                if(value) {
                    column = column + PTMOps.PowInt(2, counter);
                }
                counter--;
            }
            
            itm[i] = column;
        }
        return itm;
    }
    
    public static BigDecimal getSignalMatrixDifference(BigDecimal[][] matrix, int scale) {
        BigDecimal counter = BigDecimal.ZERO;
            
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                counter = counter.add(matrix[j][k]);
            }
        }   
        return BigDecimal.ONE.subtract(counter).setScale(scale, RoundingMode.CEILING);
    }
    
    public static BigDecimal[][] getSignalMatrixDistributedError(BigDecimal[][] matrix, BigDecimal error, int scale) {
        
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                BigDecimal matrixValue = matrix[j][k];
                BigDecimal percentageValue = matrixValue.multiply(error.abs()).setScale(scale, RoundingMode.HALF_UP);
                
                //System.out.println("MatrixValue " + matrixValue);
                //System.out.println("PercentageValue: " + percentageValue);
                //System.out.println("Error: " + error);
                                
                matrix[j][k] = matrix[j][k].divide(BigDecimal.ONE.subtract(error).setScale(scale, RoundingMode.HALF_UP), scale, RoundingMode.HALF_UP).setScale(scale, RoundingMode.HALF_UP);
                //System.out.println(matrix[j][k]);
            }
        } 
        //System.out.println("#####################");
        return matrix;
    }   
    /**
     * calculates the inherent reliability in BigDecimal of a circuit, that is, R^N, where
     * R = gates' reliability and N = total gates in circuit
     * @param pCircuit
     * @param reliability
     * @return 
     */
    public static BigDecimal inherentReliability(ProbCircuit pCircuit, String reliability) {
        
        BigDecimal inherent = new BigDecimal(reliability);
        
        return inherent.pow(pCircuit.getProbGates().size());
    }
    
    /**
     * calculates the inherent reliability in float of a circuit, that is, R^N, where
     * R = gates' reliability and N = total gates in circuit
     * @param pCircuit
     * @param reliability
     * @return 
     */
    public static float inherentReliabilityFloat(ProbCircuit pCircuit, String reliability) {

        double inherent = Double.valueOf(reliability);
        
        inherent = Math.pow(inherent, pCircuit.getProbGates().size());
        
        return (float)inherent;
    }
    
    /**
     * Converts the reliability value into Failure Rate using ( R(t) = e^(-y(t)) )
     * @param reliability
     * @return 
     */
    public static BigDecimal getFailureRate(BigDecimal reliability) {
        
        BigDecimal failureRate = new BigDecimal("-1").multiply(lnBig(reliability, 24));
        
        return failureRate;
    }
    
    /**
     * Converts the reliability value into Failure Rate using ( R(t) = e^(-y(t)) )
     * @param reliability
     * @return 
     */
    public static float getFailureRateFloat(float reliability) {
        
        double failureRate = -1.;
        double dReliability = (double)reliability;
        
        failureRate = failureRate * Math.log(dReliability);        
                
        return (float)failureRate;
    }
    
    /**
     * Return the MTBF value based on reliability value passed
     * @param reliability
     * @return 
     */
    public static BigDecimal getMTBF(BigDecimal reliability) {
        
        BigDecimal mtbf = BigDecimal.ONE.divide((getFailureRate(reliability)), 12, RoundingMode.HALF_UP);
        
        return mtbf;
    }
    
    /**
     * Return the MTBF value based on reliability value passed
     * @param reliability
     * @return 
     */
    public static BigInteger getMTBFBigInt(BigDecimal reliability) {
        
        BigDecimal mtbf = BigDecimal.ONE.divide((getFailureRate(reliability)), 12, RoundingMode.HALF_UP);
        
        return mtbf.toBigInteger();
    }
    
    /**
     * Return the MTBF value based on reliability value passed
     * @param reliability
     * @return 
     */
    public static float getMTBFFloat(float reliability) {

        float mtbf = 1 / getFailureRateFloat(reliability);
        
        return mtbf;
    }
    
    /**
     * Return the FIT (Failure in Time) based on reliability value passed
     * @param reliability
     * @return 
     */
    public static BigDecimal getFIT(BigDecimal reliability) {
        
        BigDecimal fit = BigDecimal.TEN.pow(9).divide((getMTBF(reliability)), 12, RoundingMode.HALF_UP);
        
        return fit;
    }
    
    /**
     * Return the FIT (Failure in Time) based on reliability value passed
     * @param reliability
     * @return 
     */
    public static float getFITFloat(float reliability) {
        double fit = Math.pow(10, 9) / getMTBFFloat(reliability);
        
        return (float)fit;
    }
    
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());                

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
            
    
}
