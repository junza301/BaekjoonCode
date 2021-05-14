package S2_1660;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [] data = new int[201];
		int [] data2 = new int[201];
		int [] dp = new int[300001];
		
		data[1] = 1;
		for(int i = 2; i <= 200; i++) {
			data[i] = data[i-1] + i+1;
		}

		data2[0] = 0;
		data2[1] = 1;
		dp[data2[0]] = 1;
		dp[data2[1]] = 1;
		for(int i = 2; i <= 200; i++) {
			data2[i] = data[i] + data2[i-1];
			if(data2[i] <= 300000)
				dp[data2[i]] = 1;
		}
		
		dp[1] = 1;
		for(int i = 2; i<=300000; i++) {
			System.out.println(i);
			if(dp[i] == 1)
				continue;
			
			int pivot = i-1;
			int j = 1;
			
			while(pivot >= j) {
				dp[i] = Math.min(dp[i], dp[pivot]+dp[j]);
				pivot--;
				j++;
			}
		}
		
		System.out.println(dp[n]);
	}
}
