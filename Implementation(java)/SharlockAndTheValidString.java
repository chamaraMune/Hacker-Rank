/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

/**
 *
 * @author Chamara Munasinghe
 */
import java.util.Scanner;
import java.util.ArrayList;
public class SharlockAndTheValidString {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] charArr = str.toCharArray();
        int[] tempArr = letterCounting(charArr);
        boolean boo1 = process1(tempArr);
        if(boo1){
            System.out.println("YES");
        }
        else
            System.out.println("NO");
        
    }
    
    public static int[] letterCounting(char[] inputArr){
        int[] arr = new int[26];
        for(char i : inputArr){
            int idx = i -'a';
            arr[idx]++;
        }
        return arr;
    }
    
    public static boolean process1(int[] arr){
        ArrayList list = new ArrayList();
        
        
        int minCount = Integer.MAX_VALUE;
        for(int i : arr){
            if(i<minCount && i!=0){
                minCount=i;
            }
        }
        if(minCount == 1){
            for(int i : arr){
                if(i == minCount)
                    list.add(i);
            }
            if(list.size()==1)
                return true;
            else
                return false;
        }
            
        else{
            for(int i : arr){
                if(i>minCount)
                    list.add(i);
            }

            if(list.size()==0){
                return true;
            }
            else if(list.size()==1){
                int temp = (int) list.get(0);

                if(temp-1 == minCount)
                    return true;

                else
                    return false;
            }
            else
                return false;
        }
        
    }
    
    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}