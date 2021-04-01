package S4_11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		int count = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			count++;
			if(count == k) {
				result.add(now);
				count = 0;
			}
			else
				q.add(now);
		}
		
		System.out.print("<");
		for(int i = 0; i < result.size(); i++) {
			if(i == result.size()-1)
				System.out.print(result.get(i) + ">");
			else
				System.out.print(result.get(i) + ", ");
		}
	}

}
