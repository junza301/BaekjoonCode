package G5_10026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char [][] grid;
	static int [][] check;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new char[n][n];
		check = new int[n][n];
		for(int i = 0; i<n;i++) {
			String tmp = sc.next();
			for(int j = 0; j<n; j++) {
				grid[i][j] = tmp.charAt(j);
			}
		}
		
		int count_non = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(check[i][j] == 0) {
					DFS_non(i, j);
					count_non++;
				}
			}
		}
		
		for(int i = 0; i < n; i ++) 
			Arrays.fill(check[i], 0);
		
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(check[i][j] == 0) {
					DFS(i, j);
					count++;
				}
			}
		}
		
		System.out.println(count_non + " " + count);
	}
	
	static void DFS_non(int a, int b) {
		check[a][b] = 1;
		char result = grid[a][b];
		int[][] delim = {{-1,0}, {0,1}, {1,0}, {0,-1}};
		for(int dir = 0; dir < 4; dir++) {
			int tmpa = a, tmpb = b;
			tmpa += delim[dir][0];
			tmpb += delim[dir][1];
			if(tmpa>=0 && tmpa<n && tmpb>=0 && tmpb<n) {
				if(grid[tmpa][tmpb] == result && check[tmpa][tmpb] == 0)
					DFS_non(tmpa,tmpb);
			}
		}
	}
	
	static void DFS(int a, int b) {
		check[a][b] = 1;
		char result = grid[a][b];
		int[][] delim = {{-1,0}, {0,1}, {1,0}, {0,-1}};
		for(int dir = 0; dir < 4; dir++) {
			int tmpa = a, tmpb = b;
			tmpa += delim[dir][0];
			tmpb += delim[dir][1];
			if(tmpa>=0 && tmpa<n && tmpb>=0 && tmpb<n && check[tmpa][tmpb] == 0) {
				if(result == 'B') {
					if(grid[tmpa][tmpb] == 'B')
						DFS(tmpa,tmpb);
				}
				else {
					if(grid[tmpa][tmpb] == 'R' || grid[tmpa][tmpb] == 'G')
						DFS(tmpa,tmpb);
				}
					
			}
		}
	}
}
