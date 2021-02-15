package B2_1152;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		String [] split = input.split(" ");
		sc.close();
		if(split.length > 0) {
			if(split[0].equals(""))
				System.out.println("0");
			else
				System.out.println(split.length);
		}
		else
			System.out.println("0");
	}
}
