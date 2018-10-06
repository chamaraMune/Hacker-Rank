/**
 *
 * @author chamara
 */
import java.util.Scanner;

public class AppendAndDelete {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String initialString = scanner.nextLine();
        String desiredString = scanner.nextLine();
        int noOfMoves = Integer.parseInt(scanner.nextLine());
        boolean isPossible = processAnswer(initialString, desiredString, noOfMoves);
        String answer = (isPossible) ? "Yes" : "No";
        System.out.println(answer);
    }
    
    private static boolean processAnswer(String initialString, String desiredString, int movesGiven) {
        StringBuilder sb = new StringBuilder();
        
        // check intialString == desiredString
        if (initialString.equals(desiredString)) {
            int stringSize = initialString.length();
            int movesRequired = (stringSize * 2);
            
            if (movesRequired <= movesGiven) {
                return true;
            }
        }
        
        int commonSequenceEnd = 0;
        int initialStringLength = initialString.length();
        int desiredStringLength = desiredString.length();
        int loopSteps = (initialStringLength <= desiredStringLength) ? initialStringLength : desiredStringLength;
        
        for (int idx = 0; idx < loopSteps; idx++) {
            if (initialString.charAt(idx) == desiredString.charAt(idx)) {
                commonSequenceEnd++;
                continue;
            }
            break;
        }
        
        if (commonSequenceEnd == 0) {
            int movesRequired = initialStringLength + desiredStringLength;
            return (movesRequired <= movesGiven);
        }
        
        int movesRequired = initialStringLength + desiredStringLength - 2 * commonSequenceEnd;
        
        if (movesRequired > movesGiven) {
            return false;
        }
        
        return (movesRequired % 2 <= movesGiven % 2);
    }
}
