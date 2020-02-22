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
        System.out.println(answer);
    }

    private static int processAnswer(int[] input) {
        int answer = 0;
        
        if (input.length == 2) {
            return (Math.abs(input[0] - input[1]) <= 1) ? 2 : 0;
        } else {
            Arrays.sort(input);
            int comparitor = input[0];
            int counter = 0;
            
            for (int idx = 0; idx < input.length; idx++) {
                int placeValue = input[idx];
                if (Math.abs(comparitor - placeValue) <= 1) {
                    counter++;
                } else {
                    comparitor = placeValue;
                    counter = 1;
                }
                
                if (counter > answer) {
                    answer = counter;
                }
            }      
        } 
        return answer;
    }
} 