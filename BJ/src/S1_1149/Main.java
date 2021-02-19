package S1_1149;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] house = new int[n][3];
		for(int i = 0; i < n; i++) {
			house[i][0] = sc.nextInt();
			house[i][1] = sc.nextInt();
			house[i][2] = sc.nextInt();
		}
		
		int [][] DP = new int[n][3];
		DP[0][0] = house[0][0];
		DP[0][1] = house[0][1];
		DP[0][2] = house[0][2];
		
		for(int i = 1; i < n; i++) {
			DP[i][0] = Math.min(house[i][0] + DP[i-1][1], house[i][0] + DP[i-1][2]);
			DP[i][1] = Math.min(house[i][1] + DP[i-1][0], house[i][1] + DP[i-1][2]);
			DP[i][2] = Math.min(house[i][2] + DP[i-1][0], house[i][2] + DP[i-1][1]);
		}
		
		int min = DP[n-1][0];
		if(min > DP[n-1][1])
			min = DP[n-1][1];
		if(min > DP[n-1][2])
			min = DP[n-1][2];
		
		System.out.println(min);
	}

}
