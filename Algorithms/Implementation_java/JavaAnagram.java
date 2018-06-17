import java.util.*;
public class JavaAnaram {
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String A = sc.nextLine().toLowerCase();
    String B = sc.nextLine().toLowerCase();
    int[] alist = new int[26];
    int[] blist = new int[26];
    boolean isAnagram = true;
    if(A.length()!=B.length())
        isAnagram = false;
    else{
        for(int i=0;i<A.length();i++){
            int idxA = (int) A.charAt(i)-(int) 'a';
            alist[idxA] ++;
            int idxB =(int) B.charAt(i)-(int) 'a';
            blist[idxB]++;
        }
        for(int i=0;i<26;i++){
            if(alist[i]!= blist[i]){
                isAnagram = false;
                break;
            }
            
        }
    }
        if(isAnagram == true)
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }
    
        
    
        
    
    
    
    
    
}
