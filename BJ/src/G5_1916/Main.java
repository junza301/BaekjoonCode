package G5_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public class Edge {
		public int v;
		public int W;
		
		public Edge(int x, int weight) {
			this.v = x;
			this.W = weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
		}
	}

}
