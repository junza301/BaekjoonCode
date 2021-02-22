package S2_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int [] check;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		check = new int[n+1];
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());
		
		for(int i = 0; i < m ; i++) {
			str = bf.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}
		
		
		DFS(v, graph);
		System.out.println();
		
		
		Arrays.fill(check, 0);
		
		Queue<Integer> q = new LinkedList<>();
		check[v] = 1;
		System.out.print(v + " ");
		
		for(int i = 0; i < graph.get(v).size(); i++) {
			q.add(graph.get(v).get(i));
		}
		
		while(!q.isEmpty()) {
			int num = q.size();
			for(int i = 0; i < num; i++) {
				int tmp = q.poll();
				if(check[tmp] == 0) {
					System.out.print(tmp + " ");
					check[tmp] = 1;
					for(int j = 0; j < graph.get(tmp).size(); j++) {
						q.add(graph.get(tmp).get(j));
					}
				}
			}
		}
		System.out.println();
	}

	private static void DFS(int v, ArrayList<ArrayList<Integer>> graph) {
		check[v] = 1;
		System.out.print(v + " ");
		for(int i = 0; i < graph.get(v).size(); i++) {
			int next = graph.get(v).get(i);
			if(check[next] == 0) {
				DFS(next, graph);
			}
		}
	}

}
