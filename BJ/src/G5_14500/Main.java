package G5_14500;

import java.util.Scanner;

public class Main {
	static int [][] dir = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
	static int [][] grid;
	static int [][] check;
	static int n, m;
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		check = new int [n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j<m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				DFS(i, j, 0, 0);
				Fxxx(i, j);
			}
		}
		System.out.println(max);
	}

	private static void Fxxx(int a, int b) {
		for(int j = 0; j < 4; j++) {
			int sum = grid[a][b];
			for(int i = 0; i < 3; i++) {
				int tmpa = a + dir[(j+i)%4][0];
				int tmpb = b + dir[(j+i)%4][1];
				if(tmpa < 0 || tmpa >= n || tmpb < 0 || tmpb >=m)
					break;
				sum += grid[tmpa][tmpb];
			}
			if(sum > max)
				max = sum;
		}	
	}

	private static void DFS(int a, int b, int count, int sum) {
		sum += grid[a][b];
		check[a][b] = 1;
		count++;
		if(count == 4) {
			if(sum > max)
				max = sum;
			check[a][b] = 0;
			return;
		}
		
		for(int i = 0; i<4; i++) {
			int tmpa = a + dir[i][0];
			int tmpb = b + dir[i][1];
			if(tmpa >= 0 && tmpa <n && tmpb >= 0 && tmpb < m && check[tmpa][tmpb] == 0) {
				DFS(tmpa, tmpb, count, sum);
			}
		}
		check[a][b] = 0;
	}
}
