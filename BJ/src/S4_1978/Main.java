package S4_1978;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] data = new int[n];
		for(int i = 0; i<n; i++)
			data[i] = sc.nextInt();
		
		int [] prime = new int[1001];
		prime[0] = 0;
		prime[1] = 0;
		for(int i = 2; i <= 1000; i++)
			prime[i] = i;
		for(int i = 2; i <= 1000; i++) {
			if(prime[i] == 0)
				continue;
			for(int j = i+i; j<=1000; j+=i)
				prime[j] = 0;
		}
		
		int count = 0;
		for(int i = 0; i<n; i++) {
			if(data[i] == prime[data[i]])
				count++;
		}
		System.out.println(count);
	}

}
