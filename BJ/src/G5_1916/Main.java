package G5_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int [][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		
		graph = new int[n+1][n+1];
		for(int i = 1; i <=n; i++) {
			for(int j = 1; j <= n; j++) {
				graph[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int tmpi = Integer.parseInt(st.nextToken());
			int tmpj = Integer.parseInt(st.nextToken());
			int tmpw = Integer.parseInt(st.nextToken());
			
			graph[tmpi][tmpj] = Math.min(tmpw, graph[tmpi][tmpj]);
		}
		
		
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end));
	}

	private static int dijkstra(int start, int end) {
		int [] distance = new int[n+1];
		boolean [] check = new boolean[n+1];
		
		for(int i = 1; i <= n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
			
		distance[start] = 0;
		check[start] = true;
		
		for(int i = 1; i <= n; i++) {
			if(!check[i] && graph[start][i] != Integer.MAX_VALUE)
				distance[i] = graph[start][i];
		}
		
		for(int i = 0; i < n-1; i++) {
			
			int min = Integer.MAX_VALUE;
			int min_idx = -1;
			
			for(int j = 1; j <= n; j++) {
				if(!check[j] && distance[j] != Integer.MAX_VALUE) {
					if(distance[j] < min) {
						min = distance[j];
						min_idx = j;
					}
				}
			}
			
			if(min_idx == -1)
				continue;

			check[min_idx] = true;
			
			for(int j = 1; j <= n; j++) {
				if(!check[j] && graph[min_idx][j] != Integer.MAX_VALUE) {
					if(distance[j] > distance[min_idx] + graph[min_idx][j])
						distance[j] = distance[min_idx] + graph[min_idx][j];
				}
			}
			

		}

		return distance[end];
	}

}
