package S3_2606;

import java.util.Scanner;

public class Main {

	static int n;
	static int [] check = new int[101];
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int [][] data = new int[n+1][n+1];
		
		int m = sc.nextInt();
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			data[a][b] = 1;
			data[b][a] = 1;
		}
		sc.close();
		
		DFS(data, 1);
		System.out.println(count);
	}
	
	public static void DFS(int [][] graph, int a) {
		check[a] = 1;
		for(int i = 1; i <= n; i++) {
			if(graph[a][i] == 1 && check[i] == 0) {
				count++;
				DFS(graph, i);
			}
		}
	}
}
