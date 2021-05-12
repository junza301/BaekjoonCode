package S2_4963;

import java.util.Scanner;

public class Main {
	static int m,n;
	static int [][] grid;
	static int [][] check;
	static int [][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			m = sc.nextInt();
			n = sc.nextInt();
			if(n == 0 && m == 0)
				System.exit(0);
			
			grid = new int[n][m];
			check = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(check[i][j] == 0 && grid[i][j] == 1) {
						DFS(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}

	}

	private static void DFS(int i, int j) {
		check[i][j] = 1;
		
		for(int k = 0; k < 8; k++) {
			int tmpi = i + dir[k][0];
			int tmpj = j + dir[k][1];
			if(tmpi >= 0 && tmpi < n && tmpj >= 0 && tmpj < m && check[tmpi][tmpj] == 0 && grid[tmpi][tmpj] == 1) {
				DFS(tmpi, tmpj);
			}
		}
	}

}
