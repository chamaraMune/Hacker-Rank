import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumLoss {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[]) {
        int inputSize = scanner.nextInt();
        long[] housePrices = new long[inputSize];
        
        for (int i = 0; i < inputSize; i++) {
            housePrices[i] = scanner.nextLong();
        }
        
        long answer = processAnswer(housePrices);
        System.out.println(answer);
    }
    
    public static long processAnswer(long[] inputArr) {
        long minimumLoss = Long.MAX_VALUE;
        ArrayList comparaList = new ArrayList();
        
        for (int i = 0; i < inputArr.length; i ++) {
            comparaList.add(inputArr[i]);
        }
        
        long[] sortedArray = inputArr.clone();
        Arrays.sort(sortedArray);
        int steps = inputArr.length;
        
        for (int idx = steps - 1; idx > 0; idx--) {
            long valueA = sortedArray[idx];
            long valueB = sortedArray[idx - 1];
            long currentLoss = Math.abs(valueA - valueB);
            
            if (currentLoss < minimumLoss && comparaList.indexOf(valueA) < comparaList.indexOf(valueB)) {
                minimumLoss = currentLoss;
            }
        }      
        return minimumLoss;
    }
}