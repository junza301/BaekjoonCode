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
		
		culc(n, 0, (int)Math.pow(2, n), 0, (int)Math.pow(2, n));
		System.out.println(count-1);
	}

	private static void culc(int now, int x1, int x2, int y1, int y2) {
			while(now != 1) {
				int length = (x2-x1)/2;
				int halfx = x2 - ((x2-x1)/2);
				int halfy = y2 - ((y2-y1)/2);
				if(a >= x1 && a < halfx && b >= y1 && b < halfy) {
					x2 = halfx;
					y2 = halfy;
				}
				else if(a >= x1 && a < halfx && b >= halfy && b < y2) {
					count += length * length;
					x2 = halfx;
					y1 = halfy;
				}
				else if(a >= halfx && a < x2 && b >= y1 && b < halfy) {
					count += length * length * 2;
					x1 = halfx;
					y2 = halfy;
				}
				else if(a >= halfx && a < x2 && b >= halfy && b < y2) {
					count += length * length * 3;
					x1 = halfx;
					y1 = halfy;
				}
				now--;
			}
			
			if(a == x1) {
				if(b == y1)
					count++;
				else
					count+=2;
			}
			else {
				if(b == y1)
					count+=3;
				else
					count+=4;
			}
	}
}
