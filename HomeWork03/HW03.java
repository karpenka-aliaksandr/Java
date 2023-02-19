package HomeWork03;

import java.util.Arrays;
import java.util.Random;

/**
 * HW03 Сортировка слиянием
 */
public class HW03 {

    public static void main(String[] args) {
        int SIZE = 10;
        int ORIGIN = 0;
        int BOUND = 1000;
        int[] array = new int[SIZE];
        fillArray(array,ORIGIN,BOUND);
        System.out.println(Arrays.toString(array));
        array = sortMerge(array);
        System.out.println(Arrays.toString(array));

    }
    static void fillArray(int[] array,int origin,int bound){
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(origin,bound);
        }
    }
    static int [] sortMerge(int[] array){ 
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array; 
        }
        int [] halfArrayA = new int[array.length / 2];
        System.arraycopy(array, 0, halfArrayA, 0, array.length / 2);
        int [] halfArrayB = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, halfArrayB, 0, array.length - array.length / 2);
        halfArrayA = sortMerge(halfArrayA); 
        halfArrayB = sortMerge(halfArrayB); 
        return mergeArray(halfArrayA, halfArrayB);
    }
    static int [] mergeArray(int [] halfArrayA, int [] halfArrayB) {

        int [] arrayDest = new int[halfArrayA.length + halfArrayB.length];
        int posA = 0, posB = 0;
        
        for (int i = 0; i < arrayDest.length; i++) {
            if (posA == halfArrayA.length){
            arrayDest[i] = halfArrayB[posB];
            posB++;
            } else if (posB == halfArrayB.length) {
            arrayDest[i] = halfArrayA[posA];
            posA++;
            } else if (halfArrayA[posA] < halfArrayB[posB]) {
            arrayDest[i] = halfArrayA[posA];
            posA++;
            } else {
            arrayDest[i] = halfArrayB[posB];
            posB++;
            }
        }
        return arrayDest;
    }
}