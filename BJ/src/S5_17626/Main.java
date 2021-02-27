package S5_17626;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] data = new int[n+1];
		data[0] = 0;
		data[1] = 1;
		for(int i = 2; i <= n; i++) {
			int min = 5;
			for(int j = 1; j*j <= i; j++) {
				if(min > data[i-j*j])
					min = data[i-j*j];
			}
			data[i] = min+1;
		}
		System.out.println(data[n]);
	}
}
