package S3_11726;

import java.util.Scanner;

public class Main {
	static int [] fibo = new int[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fb(n));
	}
	
	public static int fb(int n) {
		fibo[0] = 0;
		fibo[1] = 1;
		fibo[2] = 2;
		for(int i = 3; i<=n; i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2]) % 10007;
		}
		return fibo[n];
	}
}
