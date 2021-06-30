package S2_1788;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		
		long [] dp = new long[2000001];
		dp[0] = 0;
		dp[1] = 1;
		dp[1000001] = 1;
		dp[1000002] = -1;
		
		for(int i = 2; i <= 1000000; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 1000000000;
		}
		
		for(int i = 1000003; i <= 2000000; i++) {
			dp[i] = (dp[i-2] - dp[i-1]) % 1000000000;
		}
		
		if(n<0) 
			n = Math.abs(n) + 1000000;
		
		if(dp[n] < 0)
			System.out.println("-1");
		else if(dp[n] > 0)
			System.out.println("1");
		else
			System.out.println("0");
		
		System.out.println(Math.abs(dp[n]));
	}
}
