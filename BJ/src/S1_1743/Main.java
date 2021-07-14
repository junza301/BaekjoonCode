package S1_1743;

import java.util.Scanner;

public class Main {
	static int [][] graph;
	static boolean [][] check;
	static int [][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int n, m;
	static int now;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		int max = 0;

		graph = new int[n][m];
		check = new boolean[n][m];
		
		for(int i = 0; i < k; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			graph[r][c] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(graph[i][j] == 1) {
					DFS(i,j);
					if(now > max)
						max = now;
					now = 0;

				}
			}
		}
		System.out.println(max);
	}

	private static void DFS(int i, int j) {
		check[i][j] = true;
		now++;
		for(int d = 0; d < 4; d++) {
			int tmpi = i+dir[d][0];
			int tmpj = j+dir[d][1];
			if(tmpi>=0 && tmpi<n && tmpj >= 0 && tmpj < m && graph[tmpi][tmpj] == 1 && check[tmpi][tmpj] == false) {
				DFS(tmpi, tmpj);
			}
		}
	}
}
