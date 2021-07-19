package S1_1790;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		
		long sum = 0;
		long nstandard = 9;
		int ndigital = 1;
		while(n > nstandard) {
			n -= nstandard;
			sum+=nstandard*ndigital;
			ndigital++;
			nstandard*=10;
		}
		sum += n*ndigital;
		
		if(sum < k) {
			System.out.println(-1);
			System.exit(0);
		}

		long standard = 9;
		int digital = 1;
		
		while(k > standard*digital) {
			k -= (standard*digital);
			digital++;
			standard*=10;

		}
		k--;
		
		String now = ((long)Math.pow(10, digital-1)+(long)(k/digital))+"";
		int x = (int) (k%digital);
		System.out.println(now.charAt(x));
	}
}
