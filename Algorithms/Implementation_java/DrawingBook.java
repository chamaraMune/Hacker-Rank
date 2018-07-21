import java.util.Scanner;

public class DrawingBook {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[]) {
        int noOfpages = scanner.nextInt();
        int page = scanner.nextInt();
        int answer = processSolution(noOfpages, page);
        System.out.println(answer);
    }
    
    private static int processSolution(int noOfPages, int page) {
        int answer = 0;
        boolean isFirstPage = (page == 1);
        boolean isLastPage = (page == noOfPages) || (!isEvenNumber(noOfPages) && page == noOfPages - 1);
        
        if (isLastPage || isFirstPage) {
            return answer;
        }
        
        int totalFlips = isEvenNumber(noOfPages) ? (noOfPages - 2) / 2 : (noOfPages - 3) / 2;
        
        for (int currentFlip = 1; currentFlip <= totalFlips; currentFlip++) {
            // forward flip
            int forwardLeftPage = currentFlip * 2;
            int forwardRightPage = forwardLeftPage + 1;
            
            if (forwardLeftPage == page || forwardRightPage == page) {
                return currentFlip;
            }
            
            //Backword flip
            int backwordLeftPage = isEvenNumber(noOfPages) ?  (noOfPages - currentFlip * 2) : ((noOfPages - 1) - (currentFlip * 2));
            int backwordRightPage = backwordLeftPage + 1;
            
            if (backwordLeftPage == page || backwordRightPage == page) {
                return currentFlip;
            }
        }
        return answer;
    }
    
    private static boolean isEvenNumber(int number) {
        return (number % 2 == 0);
    } 
}
