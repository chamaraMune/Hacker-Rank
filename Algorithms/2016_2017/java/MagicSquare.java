/**
 *
 * @auther : Chamara Munasinghe
 * 
 * Domain : Algorithms
 * Sub-domain : Implementation
 * Question : Forming a magic square
 * Problem Link: https://www.hackerrank.com/challenges/magic-square-forming/problem
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {
	private static final int MAGIC_CONSTANT = 15;
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		int[] input = new int[9];

		for (int i = 0; i < input.length; i++) {
			input[i] = SCANNER.nextInt();
		}
		int answer = processAnswer(input);
		System.out.println(answer);
	}

	private static int processAnswer(int[] input) {
		int minimumCost = Integer.MAX_VALUE;
		ArrayList<int[]> magicSquares = generateMagicSquares();

		for (int[] magicSquare : magicSquares) {
			int currentMatrixCost = calculateCost(input, magicSquare);

			if (minimumCost > currentMatrixCost) {
				minimumCost = currentMatrixCost;
			}
		}
		return minimumCost; 
	}

	private static ArrayList<int[]> generateMagicSquares() {
		ArrayList<int[]> magicSquares = new ArrayList<int[]>();
		int middleValue = 5;
		ArrayList<Integer> upperRows = generateUpperRows();
		int totalElements = upperRows.size();
		int current = 0;

		while (current < totalElements) {
			int rowLeft = upperRows.get(current);
			int rowMiddle = upperRows.get(current + 1);
			int rowRight = upperRows.get(current + 2);
			int[] matrix = generateMagicSquareScalar(rowLeft, rowMiddle, rowRight);
			magicSquares.add(matrix);
			// generate mirror shadow
			matrix = generateMagicSquareScalar(rowRight, rowMiddle, rowLeft);
			magicSquares.add(matrix);			
			current = current + 3;
		}
		return magicSquares; 
	}

	private static ArrayList<Integer> generateUpperRows() {
		ArrayList<Integer> upperRows = new ArrayList<Integer>();
		int[] squareCorners = {2,4,6,8};
		int middleValue = 5;
		int steps = squareCorners.length;

		for(int i = 1; i < steps; i++) {
			int rowLeftValue = squareCorners[i - 1];

			for (int j = i; j < steps; j++) {
				int rowRigthValue = squareCorners[j];
				int rowMiddleValue = Math.abs(MAGIC_CONSTANT - (rowLeftValue + rowRigthValue));
				
				if ( rowMiddleValue == 5) {
					continue;
				}
				upperRows.add(rowLeftValue);
				upperRows.add(rowMiddleValue);
				upperRows.add(rowRigthValue);
			}
		}
		return upperRows;
	}

	private static int[] generateMagicSquareScalar(int rowLeft, int rowMiddle, int rowRight) {
		int middleValue = 5;
		int[] matrix = new int[9];
		matrix[0] = rowLeft;
		matrix[1] = rowMiddle;
		matrix[2] = rowRight;
		matrix[4] = middleValue;
		matrix[6] = Math.abs(MAGIC_CONSTANT - (matrix[2] + matrix[4]));
		matrix[8] = Math.abs(MAGIC_CONSTANT - (matrix[0] + matrix[4]));
		matrix[3] = Math.abs(MAGIC_CONSTANT - (matrix[0] + matrix[6]));
		matrix[5] = Math.abs(MAGIC_CONSTANT - (matrix[2] + matrix[8]));
		matrix[7] = Math.abs(MAGIC_CONSTANT - (matrix[1] + matrix[4]));
		return matrix;	
	}

	private static int calculateCost(int[] inputMatrix, int[] magicSquare) {
		int cost = 0;

		for (int i = 0; i < inputMatrix.length; i++) {
			int currentCost = Math.abs(inputMatrix[i] - magicSquare[i]);
			cost += currentCost;
		}
		return cost;
	}
}
