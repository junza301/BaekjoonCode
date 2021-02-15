package B1_1357;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		String y = sc.next();
		System.out.println(Rev(Integer.toString(Rev(x)+Rev(y))));
	}
	
	public static int Rev(String a) {
		int n = a.length();
		int tmp = Integer.parseInt(a);
		String result = "";
		for(int i = 0; i < n; i++) {
			result = result + Integer.toString(tmp%10);
			tmp /= 10;
		}
		return Integer.parseInt(result);
	}
}
