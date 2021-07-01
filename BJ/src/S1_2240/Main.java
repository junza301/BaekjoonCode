package S1_2240;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int w = sc.nextInt();
		
		int [][] dp = new int[t+1][w+1];
		int max = 0;
		int first = sc.nextInt();

		if(first==1) {
			dp[1][0] = 1;
			dp[1][1] = 0;
		}
		else {
			dp[1][0] = 0;
			dp[1][1] = 1;
		}
		
		if(dp[1][0]>max)
			max=dp[1][0];
		if(dp[1][1]>max)
			max=dp[1][1];
		
		for(int i = 2; i <= t; i++) {
			int now = sc.nextInt();
			for(int j = 0; j <= w; j++) {
				if(j>i)
					break;
				
				if(now == 1) {
					if(j%2==0) {
						if(j==0)
							dp[i][j] = dp[i-1][j]+1;
						else 
							dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+1;
					}
					else {
						dp[i][j] = dp[i-1][j];
					}
				}
				
				else {
					if(j%2==0) {
						dp[i][j] = dp[i-1][j];
					}
					else {
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+1;
					}
				}
				
				if(dp[i][j] > max)
					max = dp[i][j];
			}
		}	
		System.out.println(max);
	}
}
