package S5_2693;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int [] tmp = new int[10];
			for(int j = 0; j < 10; j++) {
				tmp[j] = sc.nextInt();
			}
			Arrays.sort(tmp);
			System.out.println(tmp[7]);
		}
	}
}
