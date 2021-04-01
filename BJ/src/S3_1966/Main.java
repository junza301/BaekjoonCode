package S3_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		for(int w = 0; w < t; w++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<Integer>();
			Integer [] Sorted = new Integer[n];
			
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i < n; i++) {
				int now = Integer.parseInt(st.nextToken());
				q.add(now);
				Sorted[i] = now;
			}
			
			Arrays.sort(Sorted, Collections.reverseOrder());
			int Sorted_index = 0;
			
			while(true) {
				int now = q.poll();
				if(now == Sorted[Sorted_index]) {
					Sorted_index++;
					if(m == 0) {
						break;
					}
					m--;
				}
				else {
					q.add(now);
					m--;
					if(m == -1)
						m = q.size()-1;
				}
			}
			System.out.println(Sorted_index);
		}
	}
}
