package S1_2468;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int max_num = 0;
		
		int [][] graph = new int[n][n];
		boolean [][] check = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				graph[i][j] = sc.nextInt();
				if(graph[i][j] > max_num)
					max_num = graph[i][j];
			}
		}

		int max_island = 0;
		for(int t = 0; t < max_num; t++) {	// 강수량
			fill_false(check);
			int count = 0;
			for(int i = 0; i < n; i++) {	// dfs 반복
				for(int j = 0; j < n; j++) {
					if(graph[i][j] > t && !check[i][j]) {
						DFS(graph, check, t, i, j);
						count++;
					}
				}
			}
			max_island = Math.max(max_island, count);		
		}
		
		System.out.println(max_island);
	}

	private static void DFS(int[][] graph, boolean[][] check, int t, int i, int j) {
		check[i][j] = true;
		for(int k = 0; k < 4; k++) {
			int tmpi = i + dy[k];
			int tmpj = j + dx[k];
			if(tmpi >= 0 && tmpi < n &&
				tmpj >= 0 && tmpj < n &&
				graph[tmpi][tmpj] > t &&
				!check[tmpi][tmpj]) {
				DFS(graph, check, t, tmpi, tmpj);
			}
		}
	}
	
	private static void fill_false(boolean[][] check) {
		for(int i = 0; i < check.length; i++) {
			Arrays.fill(check[i], false);
		}	
	}

}
