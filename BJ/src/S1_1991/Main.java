package S1_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] grid;
	static boolean [][] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		grid = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			String str = bf.readLine();
			st = new StringTokenizer(str);
			
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			
			int now = a - 'A';
			
			grid[now][0] = a;
			grid[now][1] = b;
			grid[now][2] = c;
		}
		
		pre(0);
		System.out.println();
		in(0);
		System.out.println();
		post(0);
	}

	private static void pre(int now) {
		System.out.print((char)grid[now][0]);
		if(grid[now][1] != '.') {
			pre(grid[now][1] - 'A');
		}
		if(grid[now][2] != '.') {
			pre(grid[now][2] - 'A');
		}
	}
	
	private static void in(int now) {
		if(grid[now][1] != '.') {
			in(grid[now][1] - 'A');
		}
		
		System.out.print((char)grid[now][0]);
		
		if(grid[now][2] != '.') {
			in(grid[now][2] - 'A');
		}
	}
	
	private static void post(int now) {
		if(grid[now][1] != '.') {
			post(grid[now][1] - 'A');
		}
		
		if(grid[now][2] != '.') {
			post(grid[now][2] - 'A');
		}
		
		System.out.print((char)grid[now][0]);
	}
}
