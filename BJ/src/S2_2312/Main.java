package S2_2312;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean [] arr = new boolean[100001];
		arr[0] = arr[1] = false;
		for(int i = 2; i <= 100000; i++)
			arr[i] = true;
		
		for(int i = 2; i*i<=100000; i++) {
			if(arr[i] == false)
				continue;
			for(int j = i+i; j<=100000; j+=i) {
				arr[j] = false;
			}
		}
		
		int [] prime = new int[10000];
		int idx = 0;
		for(int i = 2; i<=100000; i++)
			if(arr[i] == true)
				prime[idx++] = i;
		
		for(int t = 0; t < n; t++) {
			int now = sc.nextInt();
			int prime_idx = 0;
			while(now!=1) {
				int div = prime[prime_idx++];
				int count = 0;
				while(now >= div && now%div == 0) {
					now /= div;
					count++;
				}
				if(count != 0)
					System.out.println(div + " " + count);
			}
		}
	}
}
