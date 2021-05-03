package S3_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int [] data = new int[n];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		long m = Long.parseLong(bf.readLine());
		
		Arrays.sort(data);
		
		int left = 0;
		int right = data[n-1];
		
		int ans = 0;
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			long result = 0;
			for(int i = 0; i < n; i++) {
				if(data[i] < mid)
					result += data[i];
				else
					result += mid;
			}
			
			if(result <= m) {
				ans = mid;
				left = mid+1;
			}
			else
				right = mid-1;
		}
		
		System.out.println(ans);
	}
}
