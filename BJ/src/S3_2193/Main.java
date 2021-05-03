package S3_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		long [] dp = new long[91];
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= 90; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		int n = Integer.parseInt(bf.readLine());
		System.out.println(dp[n]);
	}
}
