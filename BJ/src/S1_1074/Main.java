package S1_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	static int n, a, b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		

		int start = 0;
		int end = (int)Math.pow(2, n);
		
		while(end-start != 1) {
			end/=2;
			int length = end-start;
			if(a < end && b < end) {
				continue;
			}
			else if(a < end && b > end) {
				count += length * length;
				start = end;
				end *= 2;
			}
			else if(a > end && b < end) {
				
			}
			else if(a > end && b > end) {
				
			}
		}
		
		
		
		
		
		
		recursion(n, 0, (int)Math.pow(2, n), 0, (int)Math.pow(2, n));
	}

	private static void recursion(int now, int x1, int x2, int y1, int y2) {
			if(now != 1) {
				recursion(now-1, x1, x2/2, y1, y2/2);
				recursion(now-1, x1, x2/2, y2/2, y2);
				recursion(now-1, x2/2, x2, y1, y2/2);
				recursion(now-1, x2/2, x2, y2/2, y2);
			}
			
			if(x1 == a && y1 == b) {
				System.out.println(count);
				System.exit(0);
			}
			else
				count++;
			
			if(x1 == a && y2-1 == b) {
				System.out.println(count);
				System.exit(0);
			}
			else
				count++;
			
			if(x2-1 == a && y1 == b) {
				System.out.println(count);
				System.exit(0);
			}
			else
				count++;
			
			if(x2-1 == a && y2-1 == b) {
				System.out.println(count);
				System.exit(0);
			}
			else
				count++;
	}
}
