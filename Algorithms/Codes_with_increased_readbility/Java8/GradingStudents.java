import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfStudents = sc.nextInt();
        int[] marks = new int[numOfStudents];
        
        for (int idx = 0; idx < marks.length; idx++) {
            marks[idx] = sc.nextInt();
        }
        processResults(marks);
    }
    private static void processResults(int[] arr) {
        
        for(int idx=0; idx < arr.length; idx++) {
            int nextMulitple = ((arr[idx] / 5) + 1) * 5;
            boolean isCanProcess = (nextMulitple <= 35) ? false : (nextMulitple - arr[idx] > 2) ? false : true;
            
            if (!isCanProcess) {
                continue;
            }
            arr[idx] = nextMulitple;
        }
        printArray(arr);
    }
    
    private static void printArray(int[] arr) {
        for (int each : arr) {
            System.out.println(each);
        }
        
    }
}
