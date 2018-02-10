import java.util.Scanner;
public class BirthDayChocolate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfSquares = sc.nextInt();
        int[] chocolateBar = new int[noOfSquares];

        for (int idx = 0; idx < chocolateBar.length; idx++) {
            chocolateBar[idx] = sc.nextInt();
        }

        int day = sc.nextInt();
        int month = sc.nextInt();
        int answer = processAnswer(chocolateBar, noOfSquares, day, month);
        System.out.println(answer);
    }

    public static int processAnswer(int[] arr, int length, int day, int month) {
        int count = 0;

        if (month > length) {
            return 0;
        }

        int firstSquaresSum = 0;

        for (int idx = 0; idx < month; idx++) {
            firstSquaresSum += arr[idx];
        }

        if (firstSquaresSum == day) {
            count++;
        }

        for (int idx = month; idx < length; idx++) {
            firstSquaresSum = firstSquaresSum - arr[idx - month] + arr[idx];

            if (firstSquaresSum == day) {
                count++;
            }
        }

        return count;
    }
}
