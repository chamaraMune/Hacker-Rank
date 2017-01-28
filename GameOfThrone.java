/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author Chamara Munasinghe
 */
import java.util.*;
public class GameOfThrone {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet myset = new HashSet();
        boolean flag = true;
        char[] input = sc.nextLine().toCharArray();
        int[] arr = new int[26];
        for(int i=0; i<input.length; i++){
            int idx = (int) input[i] - (int) 'a';
            myset.add(input[i]);
            arr[idx]++;
        }
        
        if(myset.size() == input.length){
            flag = false;
        }
        else{
            ArrayList list = new ArrayList();
            Arrays.sort(arr);
            int idx = arr.length -1;
            while(idx>=0 && arr[idx]!=0){
                list.add(arr[idx]);
                idx--;
            }
            for(int i=0; i< list.size(); i++){
                list.set(i,(boolean) isEven((int)list.get(i)));
            }
            //System.out.println(list);
            if(isEven(input.length)){
                if(list.contains(false)){
                    flag = false;
                }
            }
            else{
                int count = Collections.frequency(list, false);
                if(count >1){
                    flag = false;
                }
            }
            
        }
        if(flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    
    public static boolean isEven(int number){
        return (number % 2 ==0);
    }
    
    public static void printArray(int[] arr){
        for(int each : arr){
            System.out.print(each+" ");
        }
        System.out.println();
    }
}
