package S2_1929;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean [] prime = new boolean[m+1];
		for(int i = 0; i <= m; i++)
			prime[i] = true;
		prime[0] = false;
		prime[1] = false;
		
		for(int i = 2; i*i <= m; i++) {
			for(int j = i*i; j <= m; j+=i) {
				prime[j] = false;
			}
		}
		
		for(int i = n; i <= m; i++) {
			if(prime[i])
				System.out.println(i);
		}
	}
}
