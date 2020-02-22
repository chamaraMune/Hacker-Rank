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
public class BoneTrousle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i=0;i<cases;i++){
            long n = sc.nextLong(); // number of sticks to buy
            long k = sc.nextLong(); // number of boxes available
            long b = sc.nextLong(); // number of boxes to buy
            
            long temp = n - (b*(b+1))/2;
            if(temp%b == 0){
                temp = temp/b;
            }
            else{
                temp = temp/b +1;
            }
            long overbuy = temp*b +(b)*(b+1)/2 - n;
            long[] answers = new long[(int) b];
            for(int a=0;a<b;a++){
                answers[a] = temp + a + 1;
            }
            for(int a=1;a<=b;a++){
                if(overbuy > 0){
                    if(overbuy > answers[a-1]-a){
                        overbuy -= answers[a-1] - a;
                        answers[a-1] = a;
                    }
                    else{
                        answers[a-1] -= overbuy;
                        overbuy = 0;
                    }
                }
            }
            long sum = 0;
            boolean isdone = true;
            for(int a =0;a<b;a++){
                sum += answers[a];
                if(answers[a] <=0){
                    isdone = false;
                }
                if(answers[a] > k){
                    isdone = false;
                }
            }
            if(sum != n){
                isdone = false;
            }
            if(!isdone){
                System.out.println("-1");
            }
            else{
                StringBuilder sb = new StringBuilder();
                for(int a =0;a<b;a++){
                    sb.append(answers[a]);
                    if(a!=b-1){
                        sb.append(" ");
                    }
                }
                System.out.println(sb);
            }
            
            
        }
    }
}
    

