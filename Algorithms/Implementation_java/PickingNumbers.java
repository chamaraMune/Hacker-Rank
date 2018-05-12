import java.util.Scanner;
import java.util.Arrays;

public class PickingNumbers {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = scanner.nextInt();
        int[] inputArray = new int[size];
        
        for(int idx = 0; idx < inputArray.length; idx++) {
            inputArray[idx] = scanner.nextInt();
        }
        
        int answer = processAnswer(inputArray);
    }

    private static int processAnswer(int[] input) {
        int answer = 0;
        Arrays.sort(input);
        printArray(input);
        return answer;
    }
    
    private static void printArray(int[] input) {
        for(int element : input) {
            System.out.print(element + " ");
        }
    } 
} 