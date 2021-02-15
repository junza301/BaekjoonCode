package S1_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int [][] grid;
	static int n, m;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		Queue<String> queue = new LinkedList<>();
		grid = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				grid[i][j] = sc.nextInt();
				if(grid[i][j] == 1)
					queue.add(i + "," + j);
			}
		}
		if(queue.size() != 0)
			BFS(queue);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j<m; j++) {
				if(grid[i][j] == 0) {
					System.out.println("-1");
					System.exit(0);
				}
			}
		}
		System.out.println(count-1);
	}
	
	public static void BFS(Queue<String> queue) {
		int size = queue.size();
		for(int i = 0; i < size; i++) {
			String tmp = queue.poll();
			StringTokenizer stk = new StringTokenizer(tmp, ",");
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			for(int dir = 0; dir < 4; dir++) {
				search(a,b,dir, queue);
			}
		}		
		count++;
		if(queue.size() != 0)
			BFS(queue);
	}
	
	public static void search(int a, int b, int dir, Queue<String> queue) {
		int [][] delim = {{-1,0},  {0,1}, {1,0},{0,-1}};
		a += delim[dir][0];
		b += delim[dir][1];
		if(a>=0 && a<n && b>=0 && b<m) {
			if(grid[a][b] == 0) {
				grid[a][b] = 1;
				queue.add(a + "," + b);
			}
		}
	}

}
