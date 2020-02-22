/***
 * problem : Counting valleys
 * domain : Algorithms -> Implementation
 * problem link: https://www.hackerrank.com/challenges/counting-valleys/problem
 */
import java.util.*;

public class CountingValleys {
    
    public static final Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
        int inputSize = Integer.parseInt(SCANNER.nextLine());
        String inputString = SCANNER.nextLine();
        int answer = processAnswer(inputString);
        System.out.println(answer);
    }
    
    public static int processAnswer(String input) {
        int valleyCount = 0;
        int currentLevelState = 0;
        
        for (int index = 0; index < input.length(); index++) {
            char currentStep = input.charAt(index);
            switch (currentStep) {
                case 'U':
                    currentLevelState++;
                    break;
                case 'D':
                    currentLevelState--;
                    break;
            }
            
            if (currentLevelState == -1 && currentStep == 'D') {
                valleyCount++;
            }
        }
        return valleyCount;
    }
}
