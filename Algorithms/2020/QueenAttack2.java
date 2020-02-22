import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chamara
 */

/**
 * Hacker Rank Problem statement url
 *  https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueenAttack2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boardSize = scanner.nextInt();
        int noOfObstacles = scanner.nextInt();
        int queenRow = scanner.nextInt();
        int queenColumn = scanner.nextInt();
        
        Map<String, Integer> blockerMap = new HashMap<>();
        
        for (int obstacle = 0; obstacle < noOfObstacles; obstacle++) {
            int obstacleRow = scanner.nextInt();
            int obstacleColumn = scanner.nextInt();
            
            boolean isPathBlocker = isQueenPathBlocker(queenRow, queenColumn, obstacleRow, obstacleColumn);
            if (!isPathBlocker) continue;
            
            String direction = null;
            int difference = 0;

            if ( queenRow == obstacleRow) {
                difference = obstacleColumn - queenColumn;
                direction = difference > 0 ? "RIGHT" : "LEFT";
            } else if (queenColumn == obstacleColumn) {
                difference = obstacleRow - queenRow;
                direction = difference > 0 ? "TOP" : "BOTTOM";
            } else {
                difference = (obstacleColumn - queenColumn);
                if (obstacleRow > queenRow) {
                    direction = difference > 0 ? "TOP_RIGHT" : "TOP_LEFT";
                } else {
                    direction = difference > 0 ? "BOTTOM_RIGHT" : "BOTTOM_LEFT";
                }
            }
            
            int absoluteDifference = Math.abs(difference);
            
            if (blockerMap.containsKey(direction)) {
                int currentValue = blockerMap.get(direction);    
                if (absoluteDifference < currentValue) {
                    blockerMap.put(direction, absoluteDifference);
                }
            } else {
                blockerMap.put(direction, absoluteDifference);
            }
        }
        
        int totalMovements = calculateMovements(boardSize, queenRow, queenColumn, blockerMap);
        System.out.println(totalMovements);
    }
    
    
    private static boolean isQueenPathBlocker(int queenRow, int queenColumn, int obstacleRow, int obstacleColumn) {
        return (queenRow == obstacleRow) 
                || (queenColumn == obstacleColumn) 
                || (Math.abs(queenRow - obstacleRow) == Math.abs(queenColumn - obstacleColumn));
    }
    
    // if there is not any obstacles, calculate the total movements
    public static int calculateMovements(int boardSize, int queenRow, int queenColumn, Map<String, Integer> blockerMap) {
        
        int totalMovements = 0;
        
        // TOP_LEFT DIRECTION
        if (blockerMap.containsKey("TOP_LEFT")) {
            int blockerPosition = blockerMap.get("TOP_LEFT");
            totalMovements += (blockerPosition - 1);
        } else {
            int rowMovements = boardSize - queenRow;
            int columnMovements = queenColumn - 1;
            totalMovements += Math.min(rowMovements, columnMovements);
        }
        
        // TOP DIRECTION
        if (blockerMap.containsKey("TOP")) {
            int blockerPosition = blockerMap.get("TOP");
            totalMovements += (blockerPosition - 1);
        } else {
            int rowMovements = boardSize - queenRow;
            totalMovements += rowMovements;
        }
        
        // TOP_RIGHT DIRECTION
        if (blockerMap.containsKey("TOP_RIGHT")) {
            int blockerPosition = blockerMap.get("TOP_RIGHT");
            totalMovements += (blockerPosition - 1);
        } else {
            int rowMovements = boardSize -queenRow;
            int columnMovements = boardSize - queenColumn;
            totalMovements += Math.min(rowMovements, columnMovements);
        }
        
        // RIGHT DIRECTION
        if (blockerMap.containsKey("RIGHT")) {
            int blockerPosition = blockerMap.get("RIGHT");
            totalMovements += (blockerPosition -1);
        } else {
            int columnMovements = boardSize - queenColumn;
            totalMovements += columnMovements;
        }
        
        // BOTTOM_RIGHT DIRECTION
        if (blockerMap.containsKey("BOTTOM_RIGHT")) {
            int blockerPosition = blockerMap.get("BOTTOM_RIGHT");
            totalMovements += (blockerPosition - 1);
        } else {
            int rowMovements = queenRow - 1;
            int columnMovements = boardSize - queenColumn;
            totalMovements += Math.min(rowMovements, columnMovements);
        }
        
        // BOTTOM DIRECTION
        if (blockerMap.containsKey("BOTTOM")) {
            int blockerPosition = blockerMap.get("BOTTOM");
            totalMovements += (blockerPosition - 1);
        } else {
            int rowMovements = queenRow - 1;
            totalMovements += rowMovements; 
        }
        
        // BOTTOM_LEFT DIRECTION
        if (blockerMap.containsKey("BOTTOM_LEFT")) {
            int blockerPosition = blockerMap.get("BOTTOM_LEFT");
            totalMovements += (blockerPosition - 1);
        } else {
            int rowMovements = queenRow - 1;
            int columnMovements = queenColumn - 1;
            totalMovements += Math.min(rowMovements, columnMovements);
        }
        
        // LEFT DIRECTION
        if (blockerMap.containsKey("LEFT")) {
            int blockerPosition = blockerMap.get("LEFT");
            totalMovements += (blockerPosition - 1);
        } else {
            int columnMovements = queenColumn - 1;
            totalMovements += columnMovements;
        }
        
        return totalMovements;    
    }
}