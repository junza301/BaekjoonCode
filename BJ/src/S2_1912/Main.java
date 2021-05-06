package S2_1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int [] data = new int[n];
		int [] dp = new int[n];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = data[0];
		int max = dp[0];
		for(int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1] + data[i], data[i]);
			if(dp[i] > max)
				max = dp[i];
		}
		System.out.println(max);
	}
}
