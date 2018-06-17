import java.util.Scanner;
import java.util.ArrayList;

public class TwoSetOptimize {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[] A = new int[m];
    int[] B = new int[n];

    for (int idx = 0; idx < m; idx++) {
      A[idx] = sc.nextInt();
    }

    for (int idx = 0; idx < n; idx++) {
      B[idx] = sc.nextInt();
    }

    int answer = processAnswer(A, B);
    System.out.println(answer);
  }

  private static int processAnswer(int[] A, int[] B) {
    int lcm = lcmOfArrayOfNumbers(A);
    int gcd = gcdOfArrayOfNumbers(B);
    ArrayList answers = new ArrayList();
    int count = 0;

    for (int i = lcm, j = 2; i <= gcd; i = lcm*j, j++) {
      if (gcd % i == 0) {
        answers.add(i);
        count++;
      }
    }
    return count;

  }

  private static int gcd(int number1, int number2) {
    while (number2 > 0) {
      int temp = number2;
      number2 = number1 % number2;
      number1 = temp;
    }
    return number1;
  }

  private static int lcm(int number1, int number2) {
    return (number1 * number2) / gcd(number1, number2);
  }

  private static int gcdOfArrayOfNumbers(int[] numbers) {
    int result = numbers[0];

    for (int idx = 1; idx < numbers.length; idx++) {
      result = gcd(result, numbers[idx]);
    }
    return result;
  }

  private static int lcmOfArrayOfNumbers(int[] numbers) {
    int result = numbers[0];

    for (int idx = 0; idx < numbers.length; idx++) {
      result = lcm(result, numbers[idx]);
    }
    return result;
  }
}
