package S1_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int [][] grid;
	static boolean [][] check;
	static int complex = 0;
	static int [] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		grid = new int[n][n];
		check = new boolean[n][n];
		count = new int[n*n];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(check[i], false);
		
		for(int i = 0; i < n; i++) {
			String str = bf.readLine();
			for(int j = 0; j < n; j++) {
				grid[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1 && !check[i][j]) {
					DFS(i, j);
					complex++;
				}
			}
		}
		
		int [] result = new int[complex];
		for(int i = 0; i < complex; i++) {
			result[i] = count[i];
		}
		Arrays.sort(result);
		
		System.out.println(complex);
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

	private static void DFS(int i, int j) {
		check[i][j] = true;
		count[complex]++;
		
		int [][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
		for(int k = 0; k < 4; k++) {
			int tmpi = i + dir[k][0];
			int tmpj = j + dir[k][1];
			
			if(tmpi >= 0 && tmpi < n && tmpj >= 0 && tmpj < n && !check[tmpi][tmpj] && grid[tmpi][tmpj] == 1) {
				DFS(tmpi, tmpj);
			}
		}
	}

}
