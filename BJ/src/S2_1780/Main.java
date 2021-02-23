package S2_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int [][] grid;
	static int minus = 0;
	static int plus = 0;
	static int zero = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		grid = new int[n][n];
		for(int i = 0; i < n; i++) {
			String str = bf.readLine();
			st = new StringTokenizer(str);
			for(int j = 0; j<n; j++)
				grid[i][j] = Integer.parseInt(st.nextToken());
		}
		
		recursion(0, n, 0, n);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	private static void recursion(int a, int b, int c, int d) {
		int tmp = grid[a][c];
		boolean check = true;
		
		for(int i = a; i < b; i++) {
			for(int j = c; j < d; j++) {
				if(grid[i][j] != tmp) {
					check = false;
					break;
				}
			}
			if(!check)
				break;
		}
		
		if(check) {
			switch (tmp) {
			case -1 : minus++; break;
			case 0 : zero++; break;
			case 1 : plus++; break;
			}
		}
		else {
			int x = (b-a)/3;
			int y = (d-c)/3;
			
			recursion(a, a+x, c, c+y);
			recursion(a, a+x, c+y, c+2*y);
			recursion(a, a+x, c+2*y, c+3*y);
			recursion(a+x, a+2*x, c, c+y);
			recursion(a+x, a+2*x, c+y, c+2*y);
			recursion(a+x, a+2*x, c+2*y, c+3*y);
			recursion(a+2*x, a+3*x, c, c+y);
			recursion(a+2*x, a+3*x, c+y, c+2*y);
			recursion(a+2*x, a+3*x, c+2*y, c+3*y);
		}
	}
}
