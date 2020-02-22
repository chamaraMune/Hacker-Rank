import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author chamara
 */
public class TheGridSearch {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String readLine = scanner.nextLine();
        int testCases = Integer.parseInt(readLine);
        
        for (int i = 0; i < testCases; i++) {
            readLine = scanner.nextLine();
            String[] stringParticles = readLine.split(" ");
            int heystackRows = Integer.parseInt(stringParticles[0]);
            
            String[] heyStack = new String[heystackRows];
            
            for (int j = 0; j < heystackRows; j++) {
                heyStack[j] = scanner.nextLine();
            }
            
            readLine = scanner.nextLine();
            stringParticles = readLine.split(" ");
            int needleRows = Integer.parseInt(stringParticles[0]);
            
            String[] needle = new String[needleRows];
            
            for (int j = 0; j < needleRows; j++) {
                needle[j] = scanner.nextLine();
            }
            
            boolean hasNeedleInHeystack = findNeedleInHeystack(heyStack, needle);
            String output = hasNeedleInHeystack ? "YES" : "NO";
            System.out.println(output);
        }
    }
    
    private static boolean findNeedleInHeystack(String[] heystack, String[] needle) {
        
        int heystackSize = heystack.length;
        int needleSize = needle.length;
        int heystackLine = 0;
        int needleLine = 0;
        int noOfVerticalShifts = heystackSize - needleSize;
        
        while (heystackLine <= noOfVerticalShifts) {
            String curHeystackString = heystack[heystackLine];
            String curNeedleString = needle[needleLine];
            
            boolean didFirstLineOccurred = curHeystackString.contains(curNeedleString);
            
            if (!didFirstLineOccurred) {
                heystackLine++;
                continue;
            }
            
            boolean didNeedleMatched = didMatchEntireNeedle(heystack, needle, heystackLine);
            
            if (didNeedleMatched) {
                return true;
            }
            
            heystackLine++;
        }
        return false;
    }
    
    private static boolean didMatchEntireNeedle(String[] heystack, String needle[], int heystackLine) {

        ArrayList<Integer> occuranceIndices = new ArrayList<>();
        int needleLine = 0;
        
        String currentHeystackLine = heystack[heystackLine];
        String currentNeedleLine = needle[needleLine];
        
        int heystackLength = currentHeystackLine.length();
        int needleLength = currentNeedleLine.length();
        
        int currentOccurance = currentHeystackLine.indexOf(currentNeedleLine);
        occuranceIndices.add(currentOccurance);
        
        while (currentOccurance != -1) {
            currentOccurance = currentHeystackLine.indexOf(currentNeedleLine, currentOccurance + 1);
            
            if (currentOccurance != -1) {
                occuranceIndices.add(currentOccurance);
            }
            
            if ((currentOccurance + needleLength) > heystackLength) break;
        }
        
        for (int i = 0; i < occuranceIndices.size(); i++) {
            int recordedIdx = occuranceIndices.get(i);
            int offset = i == 0 ? 0 : occuranceIndices.get(i - 1) + 1;
            
            for (int j = 1; j < needle.length; j++) {
                String heystackString = heystack[heystackLine + j];
                String needleString = needle[j];
                int currentMatchedIdx = heystackString.indexOf(needleString, offset);
                
                if (currentMatchedIdx != recordedIdx) {
                    break;
                }
                
                if (j == needle.length - 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}