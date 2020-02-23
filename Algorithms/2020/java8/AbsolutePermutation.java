import java.util.Scanner;

/**
 *
 * @author chamara
 */
public class AbsolutePermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            findAbosolutePermutation(n, k);
            System.out.print("\n");
        }  
    }
    
    private static void findAbosolutePermutation(int upperBound, int magicOperand) { 
       if (magicOperand == 0) {
           for (int i = 1; i <= upperBound; i++) {
                System.out.print(i + " ");
           }
           return;
       }
       
       if (upperBound % (2 * magicOperand) != 0) {
           System.out.print("-1");
           return;
       }
       
       int temp = magicOperand;
       
       for (int i = 1; i <= upperBound; i++) {
            System.out.print((i + temp) + " ");
           if (i % magicOperand == 0) temp = temp * -1;
       }
    }
}