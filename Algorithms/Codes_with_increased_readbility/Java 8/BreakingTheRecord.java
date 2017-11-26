import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfGames = sc.nextInt();
        int[] stat = new int[noOfGames];
        
        for (int idx = 0; idx < noOfGames; idx++) {
            stat[idx] = sc.nextInt();
        }
        processStat(stat);
    }
    
    private static void processStat(int[] arr) {
        int minValue = arr[0], maxValue = arr[0];
        int minCount = 0, maxCount = 0;
        
        for (int idx = 1; idx < arr.length; idx++) {
            if (minValue > arr[idx]) {
                minCount ++;
                minValue = arr[idx];
            }
            
            if (maxValue < arr[idx]) {
                maxCount++;
                maxValue = arr[idx];
            }
        }
        System.out.print(maxCount + " " + minCount );
    }
}
