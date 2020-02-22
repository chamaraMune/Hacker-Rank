import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] setA = new int[m];
        int[] setB = new int[n];

        for (int idx = 0; idx < m; idx++) {
            setA[idx] = sc.nextInt();
        }

        for (int idx = 0; idx < n; idx++) {
            setB[idx] = sc.nextInt();
        }

        int answer = processSolution(setA, setB);
        System.out.println(answer);

    }

    private static int processSolution(int[] setA, int[] setB) {
        Arrays.sort(setA);
        Arrays.sort(setB);
        int minimumPossibleAnswer = setA[setA.length-1];
        int maximumPossibleAnswer = setB[0];
        ArrayList factors = findingFactors(maximumPossibleAnswer, minimumPossibleAnswer);
        ArrayList possibleAnswers = generateNumbersByFactors(factors, minimumPossibleAnswer);
        ArrayList answers = getActualAnswers(setB, possibleAnswers);
        int numberOfAnswers = answers.size();
        return numberOfAnswers;
    }

    private static ArrayList findingFactors(int maximumNumber, int minimumNumber) {
        ArrayList factorList = new ArrayList();

        if (minimumNumber == 1) {
            factorList.add(minimumNumber);
        }

        int factor = 2;

        while (maximumNumber > 1) {
            if (isDivisible(maximumNumber, factor) ) {
                factorList.add(factor);
                maximumNumber /= factor;
                continue;
            }
            factor++;
        }

        return factorList;
    }

    private static boolean isDivisible(int number, int divisor) {
        return (number % divisor == 0);
    }

    private static ArrayList generateNumbersByFactors(ArrayList factors, int fromNumber) {
        ArrayList generatedNumbers = new ArrayList();

        for (int idx1 = 0; idx1 < factors.size(); idx1++) {
            int number = (int) factors.get(idx1);

            if (number >= fromNumber && generatedNumbers.indexOf(number) == -1) {
                generatedNumbers.add(number);
            }

            for (int idx2 = 0; idx2 < factors.size(); idx2++) {

                if (idx1 != idx2) {
                    number *= (int) factors.get(idx2);
                }

                if (number >= fromNumber && generatedNumbers.indexOf(number) == -1) {
                    generatedNumbers.add(number);
                }

            }
        }

        return generatedNumbers;
    }

    private static ArrayList getActualAnswers(int[] numbers, ArrayList divisors) {
        ArrayList answers = new ArrayList();

        for (Object divisor : divisors ) {
            boolean isAnswer = true;

            for (int number : numbers) {

                if (!isDivisible(number, (int) divisor)) {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer) {
                answers.add(divisor);
            }
        }

        return answers;
    }
}
