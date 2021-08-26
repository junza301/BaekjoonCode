package S3_1951;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long num_amount = 9;
		int num_now = 1;
		long result = 0;
		
		while(n >= num_amount) {
			n -= num_amount;
			result = (result + (num_amount * num_now)) % 1234567;
			num_amount *= 10;
			num_now++;
		}
		result = (result + (n * num_now)) % 1234567;
		System.out.println(result);
	}
}
