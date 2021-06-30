package S2_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		boolean [] check = new boolean[n+1];
		for(int i = 0; i <= n; i++)
			check[i] = false;
		int [] parent = new int[n+1];
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i = 1; i <= n; i++)
			Collections.sort(graph.get(i));
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < graph.get(1).size(); i++) {
			queue.add(graph.get(1).get(i));
			parent[graph.get(1).get(i)] = 1;
		}
		check[1] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int now = queue.poll();
				check[now] = true;
				for(int j = 0; j < graph.get(now).size(); j++) {
					if(check[graph.get(now).get(j)] == false) {
						queue.add(graph.get(now).get(j));
						parent[graph.get(now).get(j)] = now;
					}
				}
			}	
		}
		
		for(int i = 2; i <= n; i++)
			System.out.println(parent[i]);
	}
}
