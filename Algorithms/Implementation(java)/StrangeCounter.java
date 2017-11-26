
/**
 *
 * @author Chamara Munasinghe
 */

import java.util.HashMap;
import java.util.Scanner;
public class StrangeCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long inputTime= sc.nextLong();
        long cycleVal = 3;
        long cycleStart = 1;
        long cycles = 1;
        HashMap map = new HashMap();
        
        map.put(cycleStart,cycleVal);
        
        while(cycleVal <= inputTime){
            cycleStart = 2*(cycleStart+1);
            cycleVal = 2*cycleVal;
            map.put(cycleStart,cycleVal);
            cycles++;
        }
        if(cycleStart == inputTime)
            System.out.println(+cycleVal);
        
        if(cycleStart > inputTime){
            long actualStart = (cycleStart/2) - 1;
            long delta = inputTime - actualStart;
            long actualCycleVal = (long) map.get(actualStart);
            long answer = actualCycleVal - delta;
            System.out.println(answer);
        }
    }
}
            
        
        
        
    
