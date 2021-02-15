package S2_11724;

import java.util.Scanner;

public class Main {
	static int [][] grid;
	static int [] check = new int[1001];
	static int n;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		grid = new int[n+1][n+1];
		for(int i = 0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			grid[a][b] = 1;
			grid[b][a] = 1;
		}
		
		int count = 0;
		
		for(int i = 1; i <= n; i++) {
			if(check[i] == 0) {
				DFS(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	static void DFS(int index) {
		if(check[index] == 1)
			return;
		else {
			check[index] = 1;
			for(int i = 1; i<=n; i++) {
				if(grid[index][i] == 1)
					DFS(i);
			}
		}
	}
}
