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
		
		Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> minQueue = new PriorityQueue<>();
		
		for(int v = 0; v < t; v++) {

			int k = Integer.parseInt(bf.readLine());
			for(int b = 0; b < k; b++) {
				String str = bf.readLine();
				st = new StringTokenizer(str);
				
				if(st.nextToken().equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					maxQueue.add(num);
					minQueue.add(num);
				}
				else {
					if(maxQueue.isEmpty())
						continue;
					
					if(st.nextToken().equals("1")) {
						int num = maxQueue.poll();
						minQueue.remove(num);
					}
					else {
						int num = minQueue.poll();
						maxQueue.remove(num);
					}
				}
			}
			
			if(maxQueue.size() == 0) {
				System.out.println("EMPTY");
			}
			else {
				System.out.println(maxQueue.poll() + " " + minQueue.poll());
			}
			
			maxQueue.clear();
			minQueue.clear();
		}
	}
}
