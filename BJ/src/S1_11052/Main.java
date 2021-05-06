package S1_11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int [] data = new int[n+1];
		int [] dp = new int[n+1];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i <= n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = data[1];
		
		for(int i = 2; i <= n; i++) {
			dp[i] = data[i];
			for(int j = 0; j <= i; j++) {
				int tmp = i-j;
				dp[i] = Math.max(dp[tmp] + dp[j], dp[i]);
			}
 		}	
		System.out.println(dp[n]);
	}
}
