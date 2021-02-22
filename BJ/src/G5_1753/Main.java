package G5_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	public static class Edge implements Comparable<Edge> {
		public int v;
		public int Weight;
		
		public Edge(int x, int y) {
			this.v = x;
			this.Weight = y;
		}

		@Override
		public int compareTo(Edge o) {
			return this.Weight - o.Weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(bf.readLine());
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i = 0; i <= v; i++)
			graph.add(new ArrayList<Edge>());
		
		for(int i = 0; i<e; i++) {
			str = bf.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Edge(b, c));
		}
		
		int [] dist = new int[v+1];
		boolean [] check = new boolean[v+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
			
		PriorityQueue <Edge> pq = new PriorityQueue<Edge>();
		dist[k] = 0;
		pq.add(new Edge(k, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int des = now.v;
			if(check[des])
				continue;
			
			check[des] = true;
			for(int i = 0; i < graph.get(des).size(); i++) {
				if(dist[graph.get(des).get(i).v] >= dist[des] + graph.get(des).get(i).Weight) {
					dist[graph.get(des).get(i).v] = dist[des] + graph.get(des).get(i).Weight;
					pq.add(new Edge(graph.get(des).get(i).v, dist[graph.get(des).get(i).v]));
				}
			}	
		}
		for(int i = 1; i <= v; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
}
