package S3_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long [] Lan = new long[n];
		long max = 0;
		
		for(int i = 0; i < n; i++) {
			Lan[i] = Long.parseLong(bf.readLine());
			if(Lan[i] > max)
				max = Lan[i];
		}
		
		long mid;
		long left = 1;
		long right = max;
		long result = 0;
		
		while(right >= left) {
			mid = (right + left) / 2;		
			int count = 0;
			for(int i = 0; i < n; i++) {
				count += Lan[i] / mid;
			}
			
			if(count >= k) {
				left = mid + 1;
				if(result < mid)
					result = mid;
			}
			else if(count < k) {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}
