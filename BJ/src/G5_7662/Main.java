package G5_7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		
		for(int v = 0; v < t; v++) {
			Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Integer> minQueue = new PriorityQueue<>();
			int pushcount = 0;
			int popcount = 0;
			
			int k = Integer.parseInt(bf.readLine());
			for(int b = 0; b < k; b++) {
				String str = bf.readLine();
				st = new StringTokenizer(str);
				if(st.nextToken().equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					maxQueue.add(num);
					minQueue.add(num);
					pushcount++;
				}
				else {
					if(maxQueue.isEmpty())
						continue;
					
					if(st.nextToken().equals("1")) {
						maxQueue.poll();
						popcount++;
					}
					else {
						minQueue.poll();
						popcount++;
					}
				}
				
				if(pushcount == popcount) {
					maxQueue = new PriorityQueue<>(Collections.reverseOrder());
					minQueue = new PriorityQueue<>();
					pushcount = 0;
					popcount = 0;
				}
			}
			
			if(maxQueue.size() == 0 || minQueue.size() == 0) {
				System.out.println("EMPTY");
			}
			else {
				System.out.println(maxQueue.poll() + " " + minQueue.poll());
			}
			
			
		}
	}
}
