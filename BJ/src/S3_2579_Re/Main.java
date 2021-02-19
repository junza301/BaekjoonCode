package S3_2579_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int [] stair = new int[301];
	static int [] dp = new int[301];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		for(int i = 1; i <= n; i++)
			stair[i] = Integer.parseInt(bf.readLine());
		
		dp[0] = 0;
		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];
		dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
		for(int i = 4; i <= n; i++) {
			dp[i] = Math.max(stair[i] + dp[i-2], stair[i] + stair[i-1] + dp[i-3]);
		}
		System.out.println(dp[n]);
	}
}
