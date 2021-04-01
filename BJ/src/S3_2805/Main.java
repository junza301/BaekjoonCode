package S3_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String [] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long max = 0;
		long [] tree = new long[n];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			long now = Long.parseLong(st.nextToken());
			tree[i] = now;
			if(now > max)
				max = now;
		}
		
		long left = 0;
		long right = max;
		long mid = 0;
		long heightMax = 0;
		
		while (left <= right) {
			mid = (left+right) / 2;
			long sum = 0;
			for(int i = 0; i < n; i++) {
				long tmp = tree[i] - mid;
				if(tmp > 0)
					sum+=tmp;
			}
			
			if(sum >= m) {
				if(mid > heightMax)
					heightMax = mid;
				left = mid+1;
			}
			
			else {
				right = mid-1;
			}
		}
		
		System.out.println(heightMax);
	}
}
