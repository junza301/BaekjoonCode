package S2_1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		long n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		boolean check = false;
		boolean stop = false;
		
		if(n == 1 && l == 1) {
			System.out.println("1");
			System.exit(0);
		}
		
		for(int i = l; i <= 100; i++) {
			if(i >= n)
				break;
			
			long now = n / i;
			long [] prev = new long[i/2];
			long [] next = new long[i/2];
			prev[0] = now-1;
			next[0] = now+1;
			
			int count = i;
			int previndex = 0;
			int nextindex = 0;
			
			long result = now;
			count--;
			
			if(i % 2 == 0) {
				result += next[0];
				count--;
				nextindex++;
			}
			
			while(count != 0) {
				result += next[nextindex++];
				result += prev[previndex++];
				count -= 2;
				
				if(count != 0) {
					next[nextindex] = next[nextindex-1] + 1;
					prev[previndex] = prev[previndex-1] - 1;
					
					if(prev[previndex] < 0) {
						stop = true;
						break;
					}
				}	
			}
			
			if(stop)
				break;
			
			if(result == n) {
				check = true;
				for(int a = 0; a < previndex; a++)
					System.out.print(prev[a] + " ");
				System.out.print(now + " ");
				for(int a = 0; a < nextindex; a++)
					System.out.print(next[a] + " ");
				break;
			}
		}
		
		if(!check)
			System.out.println(-1);
	}

}
