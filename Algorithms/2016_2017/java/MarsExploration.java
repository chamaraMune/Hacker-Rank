import java.util.Scanner;
public class MarExploration {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int answer = processAnswer(input);
        System.out.println(answer);
    }

    private static int processAnswer(String input) {
        int answer = 0, idx = 0, needle = 0;
        char[] arr = input.toCharArray();
        char[] word = {'S', 'O', 'S'};

        while (idx < arr.length) {
            if(arr[idx] != word[needle]) {
                answer++;
            }
            idx++;
            needle++;

            if (needle == word.length) {
                needle = 0;
            }
        }
        return answer;
    }
}
