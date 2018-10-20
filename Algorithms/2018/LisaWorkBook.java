import java.util.Scanner;

public class LisaWorkBook {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int chapters = scanner.nextInt();
        int maxProblems = scanner.nextInt();
        int[] problemSet = new int[chapters];
        
        for (int step = 0; step < chapters; step++) {
            problemSet[step] = scanner.nextInt();
        }
        
        int answer = calculateAnswer(chapters, maxProblems, problemSet);
        System.out.println(answer);
    }
    
    private static int calculateAnswer(int chapters, int maxProblems, int[] problemSet) {
        int specialProblems = 0;
        int currentPage = 0;
        
        for (int idx = 0; idx < chapters; idx++) {
            int chapterProblems = problemSet[idx];
            int chapterPages = (int) Math.ceil(new Double(chapterProblems) / maxProblems);
            
            for (int i = 0; i < chapterPages; i++) {
                currentPage = currentPage + 1;
                int pageStartProblem = maxProblems * i + 1;
                int pageEndProblem = maxProblems * (i + 1);
                pageEndProblem = (pageEndProblem > chapterProblems) ? chapterProblems : pageEndProblem;
                
                if (currentPage > pageStartProblem && currentPage < pageEndProblem) {
                    specialProblems++;
                }
                
                if (currentPage == pageStartProblem || currentPage == pageEndProblem) {
                    specialProblems++;
                }
            }
        }
        
        return specialProblems;
    }
}
