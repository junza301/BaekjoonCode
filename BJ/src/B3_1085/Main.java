package B3_1085;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		sc.close();
		
		int wx = w-x;
		int hy = h-y;
		
		if(wx < x)
			x = wx;
		if(hy < y)
			y = hy;
		
		if(x > y)
			System.out.println(y);
		else
			System.out.println(x);
	}

}
