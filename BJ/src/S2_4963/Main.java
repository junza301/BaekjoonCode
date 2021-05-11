package S2_4963;

import java.util.Scanner;

public class Main {
	static int [][] grid;
	static int [][] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if(n == 0 && m == 0)
				System.exit(0);
			
			grid = new int[n][m];
			check = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					DFS(i,j);
				}
			}
			
		}

	}

	private static void DFS(int i, int j) {
		if(check[i][j] == 1)
			return;
		check[i][j] = 1;
		
		
	}

}
