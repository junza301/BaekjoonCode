package S3_9095;

import java.util.Scanner;

public class Main {
	static int [] fibo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] data = new int[t];
		int max = 0;
		for(int i = 0; i < t; i++) {
			data[i] = sc.nextInt();
			if(data[i] > max)
				max = data[i];
		}
		fibo = new int[max+1];
		fb(max);
		for(int i = 0; i<t; i++) {
			System.out.println(fibo[data[i]]);
		}
	}
	
	public static void fb(int n) {
		fibo[0] = 0;
		fibo[1] = 1;
		fibo[2] = 2;
		fibo[3] = 4;
		for(int i = 4; i <= n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2] + fibo[i-3];
		}
	}
}
