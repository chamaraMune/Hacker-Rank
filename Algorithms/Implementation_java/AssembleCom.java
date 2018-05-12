/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chamara Munasinghe
 */
import java.util.Scanner;
public class AssembleCom {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] arr = new int[6];
        for(int i=0;i<input.length();i++){
            switch (input.charAt(i)) {
                case 'A':
                    arr[0]++;
                    break;
                case 'D':
                    arr[1]++;
                    break;
                case 'X':
                    arr[2]++;
                    break;
                case 'Y':
                    arr[3]++;
                    break;
                case 'P':
                    arr[4]++;
                    break;
                case 'R':
                    arr[5]++;
                    break;
                default:
                    break;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min)
                min = arr[i];
        }
        System.out.println(min);
    }
}
