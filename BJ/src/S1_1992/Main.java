package S1_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int [][] grid;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		grid = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = bf.readLine();
			for(int j = 0; j < n; j++) {
				grid[i][j] = str.charAt(j) - '0';
			}
		}
		
		recursion(n, 0, n, 0, n);
	}

	private static void recursion(int now, int rs, int re, int cs, int ce) {
		int num = grid[rs][cs];
		boolean check = true;
		
		if(now == 1) {
			System.out.print(num);
			return;
		}
		

		for(int i = rs; i < re; i++) {
			for(int j = cs; j < ce; j++) {
				if(num != grid[i][j]) {
					check = false;
					break;
				}
			}
			if(!check)
				break;
		}
		
		if(check)
			System.out.print(num);
		else {
			int halfR = re - ((re-rs)/2);
			int halfC = ce - ((ce-cs)/2);
			
			System.out.print("(");
			recursion(now/2, rs, halfR, cs, halfC);
			recursion(now/2, rs, halfR, halfC, ce);
			recursion(now/2, halfR, re, cs, halfC);
			recursion(now/2, halfR, re, halfC, ce);
			System.out.print(")");
		}	
	}
}
