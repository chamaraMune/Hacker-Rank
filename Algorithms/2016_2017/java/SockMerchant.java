/**
 * 
 * @author chamara
 * 
 * problem : Sock Merchant
 * problem statement: https://www.hackerrank.com/challenges/sock-merchant/problem
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class SockMerchant {

    public static final Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
        int sizeOfSockPile = SCANNER.nextInt();
        int[] sockPile = new int[sizeOfSockPile];
        for (int index = 0; index < sockPile.length; index++) {
            sockPile[index] = SCANNER.nextInt();
        }
        int answer = processAnswer(sockPile);
        System.out.println(answer);
    }
    
    public static int processAnswer(int[] sockPile) {
        int answer = 0;
        HashMap<Integer, Integer> sockDistribution = new HashMap<>();
        
        for (int index = 0; index < sockPile.length; index++) {
            int colorCode = sockPile[index];
            boolean isColorCodeExist = sockDistribution.containsKey(colorCode);
            
            if (!isColorCodeExist) {
                sockDistribution.put(colorCode, 0);
            }
            
            int currentCount = sockDistribution.get(colorCode);
            currentCount++;
            sockDistribution.put(colorCode, currentCount);
        }
        
        Set<Integer> keySet = sockDistribution.keySet();
        for (Integer key : keySet) {
            int socks = sockDistribution.get(key);
            int pairOfSocks = socks / 2;
            answer += pairOfSocks;
        }
        
        return answer;
    }
}
