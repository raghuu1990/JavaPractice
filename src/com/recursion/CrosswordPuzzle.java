package com.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/crossword-puzzle

public class CrosswordPuzzle {
	private static String EMPTY = "-";
	private static String FILLED = "+";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[][] matrix = new char[10][10];

		int t = 0;
		while (t < 10) {
			String str = in.nextLine();
			matrix[t++] = str.toCharArray();
		}

		String str = in.nextLine();
		ArrayList<String> words = new ArrayList<String>();
		
		String[] wordsArray = str.split(";");
		for (int i = 0; i < wordsArray.length; i++) {
			words.add(wordsArray[i]);
		}
		solve(matrix, words, 0, -1);
		print(matrix);
		in.close();
	}

    private static void print(char[][] matrix) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
    
	private static void solve(char[][] matrix, ArrayList<String> words, int row, int collumn) {
		collumn++;
		if(collumn==matrix[0].length) {
			row++;
			collumn =0;
		}
		for (int i = row; i < matrix.length; i++) {
			if(i>row) {
				collumn = 0;
			}
			for (int j = collumn; j < matrix[0].length; j++) {
				if (isEmpty(matrix, i, j) || isUserFilled(matrix, i, j)) {
                    if(isUserFilled(matrix, i, j) && !isHorizontalEmpty(matrix, i, j) && !isVerticalEmpty(matrix, i, j)) {
						solve(matrix, words, i, j);
						if(isSolved(matrix)) {
							return;
						}
					}
					int h = getHorizontalSize(matrix, i,j);
					int v = getVerticalSize(matrix, i,j);
					if(h>0) {
						HashMap<Integer, Character> hm = getHorizontalFilled(matrix, i,j);
						ArrayList<String> wrds;
						if(hm.size()!=0) {
							wrds = getWords(words, h, j, hm);
						}else {
							wrds = getWords(words, h);
						}
						for(String wrd : wrds) {
							char[][] newMatrix = new char[matrix.length][matrix[0].length];
							makeCopy(newMatrix, matrix);
							fillHorizontal(matrix, wrd, i, j);
							words.remove(wrd);
                            if(isSolved(matrix)) {
								return;
							}
							solve(matrix, words, i, j);
							if(!isSolved(matrix)) {
								makeCopy(matrix, newMatrix);
								words.add(wrd);
							}else {
								return;
							}
						}
					}
                    if(v>0) {
						HashMap<Integer, Character> hm = getVerticalFilled(matrix, i,j);
						ArrayList<String> wrds;
						if(hm.size()!=0) {
							wrds = getWords(words, v, i, hm);
						}else {
							wrds = getWords(words, v);
						}
						for(String wrd : wrds) {
							char[][] newMatrix = new char[matrix.length][matrix[0].length];
							makeCopy(newMatrix, matrix);
							fillVertical(matrix, wrd, i, j);
							words.remove(wrd);
                            if(isSolved(matrix)) {
								return;
							}
							solve(matrix, words, i, j);
							if(!isSolved(matrix)) {
								makeCopy(matrix, newMatrix);
								words.add(wrd);
							}else {
								return;
							}
						}
					}
				}
				if(isEmpty(matrix, i, j)) {
					return;
				}
			}
		}
	}

	private static boolean isSolved(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(isEmpty(matrix, i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	private static char[][] makeCopy(char[][] newMatrix, char[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				newMatrix[i][j] = newMatrix[i][j];
			}
		}
		return newMatrix;
	}
	
	private static void fillHorizontal(char[][] matrix, String word, int row, int collumn) {
		for (int i = 0; i < word.length(); i++) {
			matrix[row][collumn++] = word.charAt(i);
		}
	}
	
	private static void fillVertical(char[][] matrix, String word, int row, int collumn) {
		for (int i = 0; i < word.length(); i++) {
			matrix[row++][collumn] = word.charAt(i);
		}
	}

	private static ArrayList<String> getWords(ArrayList<String> words, int length) {
		ArrayList<String> result = new ArrayList<String>();
		for(String word : words) {
			if(word.length()==length) {
				result.add(word);
			}
		}
		return result;
	}
	
	private static ArrayList<String> getWords(ArrayList<String> words, int length, int startPoint, HashMap<Integer, Character> hm) {
		ArrayList<String> result = new ArrayList<String>();
		for(String word : words) {
			if(word.length()==length) {
				boolean isPass = true;
				for(Integer index : hm.keySet()) {
					if(!(word.charAt(index-startPoint)+"").equals(hm.get(index).toString())) {
						isPass = false;
						break;
					}
					if(isPass) {
						result.add(word);
					}
				}
			}
		}
		return result;
	}

    private static boolean isUserFilled(char[][] matrix, int row, int collumn) {
		if (!isEmpty(matrix, row, collumn) && !isFilled(matrix, row, collumn)) {
			return true;
		}
		return false;
	}
    
	private static boolean isEmpty(char[][] matrix, int row, int collumn) {
		if ((matrix[row][collumn]+"").equals(EMPTY)) {
			return true;
		}
		return false;
	}
	
	private static boolean isFilled(char[][] matrix, int row, int collumn) {
		if ((matrix[row][collumn]+"").equals(FILLED)) {
			return true;
		}
		return false;
	}
	
	private static int getVerticalSize(char[][] matrix, int row, int collumn) {
		int j = 0;
		for (int i = row; i < matrix.length; i++) {
			if (isFilled(matrix, i, collumn)) {
				break;
			}
			j++;
		}
		return j;
	}

	private static int getHorizontalSize(char[][] matrix, int row, int collumn) {
		int j = 0;
		for (int i = collumn; i < matrix[row].length; i++) {
			if (isFilled(matrix, row, i)) {
				break;
			}
			j++;
		}
		return j;
	}
	
	private static boolean isVerticalEmpty(char[][] matrix, int row, int collumn) {
		for (int i = row; i < matrix.length; i++) {
			if(isEmpty(matrix, i, collumn)){
				return true;
			}
			if(isFilled(matrix, i, collumn)) {
				return false;
			}
		}
		return false;
	}

	private static boolean isHorizontalEmpty(char[][] matrix, int row, int collumn) {
		for (int i = collumn; i < matrix[row].length; i++) {
			if (isEmpty(matrix, row, i)) {
				return true;
			}
			if(isFilled(matrix, row, i)) {
				return false;
			}
		}
		return false;
	}

	private static HashMap<Integer, Character> getVerticalFilled(char[][] matrix, int row, int collumn) {
		HashMap<Integer, Character> result = new HashMap<Integer, Character>();
		for (int i = row; i < matrix.length; i++) {
			if (isUserFilled(matrix, i, collumn)) {
				result.put(i, matrix[i][collumn]);
			}
			if (isFilled(matrix, i, collumn)) {
				break;
			}
		}
		return result;
	}
	
	private static HashMap<Integer, Character> getHorizontalFilled(char[][] matrix, int row, int collumn) {
		HashMap<Integer, Character> result = new HashMap<Integer, Character>();
		for (int i = collumn; i < matrix[row].length; i++) {
			if (isUserFilled(matrix, row, i)) {
				result.put(i, matrix[row][i]);
			}
			if (isFilled(matrix, row, i)) {
				break;
			}
		}
		return result;
	}
}