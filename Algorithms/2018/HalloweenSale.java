/***
 *
 *  problem: Halloween Sale
 * 	domain: Algorithms -> Implementation 
 *  porblem statement: https://www.hackerrank.com/challenges/halloween-sale/problem
 *
 */


import java.util.Scanner;

public class HalloweenSale {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[]) {
        int standardPrice = scanner.nextInt();
        int discount = scanner.nextInt();
        int minimumPrice = scanner.nextInt();
        int amount = scanner.nextInt();
        
        int answer = processAnswer(standardPrice, discount, minimumPrice, amount);
        System.out.println(answer);
    }
    
    private static int processAnswer(int standardPrice, int discount, int minimumPrice, int amount) {
        int count = 0;
        
        if (standardPrice > amount) {
            return count;
        }
        
        int totalCost = 0;
        int currentBookPrice = standardPrice;
        boolean shouldTerminate = false;
        
        while (totalCost <= amount && !shouldTerminate) {
            count++;
            totalCost = totalCost + currentBookPrice;
            int nextBookPrice = standardPrice - (count * discount);
            currentBookPrice = (nextBookPrice > minimumPrice) ? nextBookPrice : minimumPrice; 
            int nextTotalCost = totalCost + currentBookPrice;
            
            if (nextTotalCost > amount) {
                break;
            }
        }
        return count;
    }
}