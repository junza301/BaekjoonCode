package S2_2644;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> [] graph;
	static boolean [] check;
	static int result = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int m = sc.nextInt();
		
		check = new boolean[n+1];
		graph = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		int count = 0;
		check[a] = true;
		DFS(a, b, count);
		System.out.println(result);
	}

	private static void DFS(int a, int end, int count) {
		if(a==end)
			result = count;
		
		int size = graph[a].size();
		for(int i = 0; i < size; i++) {
			int now = graph[a].get(i);
			if(check[now] == false) {
				check[now] = true;
				DFS(now, end, count+1);
			}
		}
	}
}
