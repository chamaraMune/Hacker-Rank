/***
 * Problem statement
 *   website : www.hackerrank.com
 *   domain : algorithems practice
 *   category : string
 *   problem : Weighted Uniform Strings
 *   url : https://www.hackerrank.com/challenges/weighted-uniform-string/problem
 *
 * problem statement:
 *   look it from given url
 ***/
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class WeightedUniformStrings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int noOfQueries = Integer.parseInt(sc.nextLine());
        Set<Integer> uniformStringValues = formulateUnifromStringValues(input);

          for (int idx = 0; idx < noOfQueries; idx++) {
            int queryValue = Integer.parseInt(sc.next());
            String hasQueryValue = (uniformStringValues.contains(queryValue)) ? "Yes" : "No";
              System.out.println(hasQueryValue);
        }
    }

    public static Set<Integer> formulateUnifromStringValues(String input) {

        Set<Integer> uniformValues = new HashSet<>();
        int index = 0, pointer = 0, factor = (int) input.charAt(0) - (int)'a' + 1;
        char comparitor = input.charAt(index);
        String subString;

        while(index < input.length()) {
            if (input.charAt(index) != comparitor) {
                pointer = index;
                comparitor = input.charAt(index);
                factor = (int) input.charAt(index) - (int) 'a' + 1;
            }

            subString = input.substring(pointer, index+1);
            int value = subString.length() * factor;
            uniformValues.add(value);
            index++;

        }

        return uniformValues;
    }
}
