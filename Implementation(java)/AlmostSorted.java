/**
 *
 * @author Chamara Munasinghe
 */
import java.util.Arrays;
import java.util.Scanner;
public class AlmostSorted {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] arr = new int[n];
       int[] temp = new int[n];
       
       
       //putting integers into array.
       for(int i=0;i<n;i++){
           arr[i] = sc.nextInt();
           temp[i] = arr[i];
       }
       int[] temp2 = arr.clone();
       Arrays.sort(temp);
       //if array is already sorted
       boolean initialySorted = isSorted(arr);
       //if array is already sorted.
       if(initialySorted){
           System.out.println("yes");
       }
       //if array is not already sort initialy
       if(!initialySorted){
           //find index where array is made unsorted array in first place
           int idx1 = unsortedIndex(arr,temp,0);
           int idx2 = unsortedIndex(arr,temp,idx1+1);
           
           boolean flag = swapOperation(arr, temp, idx1, idx2);
           if(flag){
               System.out.printf("yes\nswap %d %d",idx1+1,idx2+1);
           }
           else{
               idx2 = unsortedIdex2(arr, temp, idx1);
               boolean flag1 =reverseOperation(temp2, temp, idx1, idx2);
               if(flag1){
                   System.out.printf("yes\nreverse %d %d",idx1+1,idx2+1);
               }
               else
                   System.out.println("no");
           }
       }
       
    }
       
    static boolean isSorted(int[] arr){
        int[] temp = arr.clone();
        Arrays.sort(temp);
        //comparing input array with sorted copy of input array
        return (Arrays.equals(arr,temp));
    }
    
    static boolean swapOperation(int[] arr,int[] temp,int idx1,int idx2){
        
        //find index where arr is made unsorted from the start.
        swap(arr,idx1,idx2);
        boolean test = Arrays.equals(arr,temp);
        return test;
    }
    static boolean reverseOperation(int [] arr,int[] temp,int idx1,int idx2){
        int i = idx1;
        int j = idx2;
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
        boolean test = Arrays.equals(arr,temp);
        
        return test;
    }
    
    static void swap(int[] arr,int idx1,int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        
    }
    static int unsortedIndex(int arr[],int[] temp,int fromIdx){
        //checking input array from next index of unsortedIdex1
        int idx = fromIdx;
        while(arr[idx] == temp[idx] && idx <arr.length){
            idx++;
        }
        return idx;
        
    }
    static int unsortedIdex2(int[] arr,int[] temp,int endIdx){
        int idx = arr.length-1;
        while(temp[idx] == arr[idx] && idx>endIdx)
            idx--;
        return idx;
    }
}
