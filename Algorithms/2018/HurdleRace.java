import java.util.Scanner;

public class HurdleRace {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfHurdles = scanner.nextInt();
        int maxHieghtCanJump = scanner.nextInt();
        int[] hurdlesHeights = new int[numberOfHurdles];
        for (int idx = 0; idx < numberOfHurdles; idx++) {
            hurdlesHeights[idx] = scanner.nextInt();
        }
        int answer = processAnswer(numberOfHurdles, maxHieghtCanJump, hurdlesHeights);
        System.out.println(answer);
    }
    
    private static int processAnswer(int numberOfHurdles, int maxHeightCanJump, int[] hurdlesHeights) {
        int answer = 0;
        
        for (int idx = 0; idx < numberOfHurdles; idx++) {
            int currentHurdleHieght = hurdlesHeights[idx];
            
            if (currentHurdleHieght > maxHeightCanJump) {
                int dosesNeeeded = Math.abs(currentHurdleHieght - maxHeightCanJump);
                answer = answer + dosesNeeeded;
                maxHeightCanJump = currentHurdleHieght;
            }
        }
        return answer;
    }
}
