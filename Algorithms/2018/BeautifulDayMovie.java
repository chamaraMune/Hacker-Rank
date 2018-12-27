import java.util.Scanner;

public class BeautifulDayMovie {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){
        int startDay = scanner.nextInt();
        int endDay = scanner.nextInt();
        int beautifulFactor = scanner.nextInt();
        int answer = processAnswer(startDay, endDay, beautifulFactor);
        System.out.println(answer);
    }
    
    private static int processAnswer(int startDay, int endDay, int factor) {
        int answer = 0;
        
        while (startDay <= endDay) {
            int difference = Math.abs(startDay - reverseInteger(startDay));
            boolean isDivisible = difference % factor == 0;
            
            if (isDivisible)
                answer++;
            
            startDay++;
        }
        return answer;
    }
    
    private static int reverseInteger(int input) {
        String stringifyInput = Integer.toString(input);
        StringBuilder reverseIntegerBuilder = new StringBuilder();
        int index = stringifyInput.length() - 1;
        
        while (index >= 0) {
            char currentChar = stringifyInput.charAt(index);
            reverseIntegerBuilder.append(currentChar);
            index--;
        }
        
        int output = Integer.parseInt(reverseIntegerBuilder.toString());
        return output;
    }
    
}
