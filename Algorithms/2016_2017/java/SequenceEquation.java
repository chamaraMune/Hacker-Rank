import java.util.Scanner;
import java.util.ArrayList;

public class SequenceEquation {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[]) {
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        
        for (int idx = 0; idx < n; idx++) {
            inputs[idx] = scanner.nextInt();
        }
        scanner.close();
        processAnswers(inputs);
    }
    
    private static void processAnswers(int[] inputArr) {
        ArrayList inputList = new ArrayList();
        
        for (int nmuber : inputArr) {
            inputList.add(nmuber);
        }
        
        for (int idx = 0; idx < inputList.size(); idx++) {
            int actuvalValue = idx + 1;
            int pValue1 = inputList.indexOf(actuvalValue);
            int pValue2 = inputList.indexOf(pValue1 + 1) + 1;
            System.out.println(pValue2);
        }
    }
}
