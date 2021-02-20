package S1_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		Queue<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] check = new int[n+1];
		int [] num = new int[n+1];
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		int min = n * 7;
		int minNum = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < graph.get(i).size(); j++) {
				q.add(graph.get(i).get(j));
			}
			
			Arrays.fill(check, 0);
			Arrays.fill(num, 0);
			
			int count = 1;
			while(!q.isEmpty()) {
				int s = q.size();
				for(int k = 0; k < s; k++) {
					int tmp = q.poll();
					if(check[tmp] == 0) {
						check[tmp] = 1;
						num[tmp] = count;
						for(int j = 0; j < graph.get(tmp).size(); j++) {
							q.add(graph.get(tmp).get(j));
						}
					}
				}
				count++;
			}
			
			int result = 0;
			for(int j = 0; j < num.length; j++)
				result += num[j];
			result -= num[i];
			
			
			if(min > result) {
				min = result;
				minNum = i;
			}
		}
		
		System.out.println(minNum);
	}
}
