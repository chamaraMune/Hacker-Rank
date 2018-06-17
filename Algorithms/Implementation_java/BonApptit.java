import java.util.Scanner;

public class BonAppetit {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int noOfItems = scanner.nextInt();
        int itemNotEat = scanner.nextInt();
        int[] items = new int[noOfItems];
        
        for (int idx = 0; idx < noOfItems; idx++) {
            items[idx] = scanner.nextInt();
        }
        int chargeForAnna = scanner.nextInt();
        scanner.close();
        processAnswer(items, noOfItems, chargeForAnna, itemNotEat);
    }
    
    private static void processAnswer(int[] items, int noOfItems, int charge, int itemNotEat) {
        int actualCharge = 0;
        for (int idx = 0; idx < noOfItems; idx++) {
            if (idx != itemNotEat) {
                actualCharge += items[idx];
            }
        }
        int fairCharge = actualCharge / 2;
        
        if (fairCharge == charge) {
            System.out.println("Bon Appetit");
        } else {
            int refundAmount = Math.abs(fairCharge - charge);
            System.out.println(refundAmount);
        }
    }
}
