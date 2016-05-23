import java.util.*;
class StringCompare{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int k = sc.nextInt();
        String firstSub = input.substring(0,k);
        String min = firstSub ,max = firstSub;
        for(int i=1;i<=input.length()-k; i++){
			String newString = input.substring(i,i+k);
			if(min.compareTo(newString)>0){
				min = newString;
			}
			if(max.compareTo(newString)<0){
				max = newString;
			}
			
        }
        System.out.println(min);
		System.out.println(max);
    }
}
