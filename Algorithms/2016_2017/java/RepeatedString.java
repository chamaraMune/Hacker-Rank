import java.util.Scanner;
public class ReapeatedString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        char[] pattern = sc.nextLine().toCharArray();
        long n = Long.parseLong(sc.nextLine());
        
        //number of a's in pattern
        int letterCount = 0;
        for(char letter:pattern)
            if(letter == 'a')
                letterCount ++;
        //There are no a's in pattern
        if(letterCount==0){
            System.out.println(letterCount);
        }
        //pattern only consist of a's
        else if(letterCount==pattern.length)
            System.out.println(n);
        //pattern consist of a and other occurances
        else{
            //number of pattern in test that size is n.
            long chunks = n/pattern.length;
            long result =chunks*letterCount;
            //checking remainder section
            long remainder = n-(chunks*pattern.length);
            for(int i=0;i<remainder;i++){
                if(pattern[i]=='a')
                    result++;
            }
            System.out.println(result);
            
        }
    }
}
