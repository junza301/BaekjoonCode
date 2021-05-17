package S2_1735;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		int a2 = sc.nextInt();
		int b2 = sc.nextInt();
		
		int lcm = LCM(b1,b2);
		a1 *= (lcm/b1);
		a2 *= (lcm/b2);
		
		int a = a1+a2;
		int b = lcm;
		
		int gcd = GCD(a,b);
		
		a /= gcd;
		b /= gcd;
		
		System.out.println(a + " " + b);
	}
	
	public static int GCD(int x, int y) {
		if(y==0)
			return x;
		else
			return GCD(y, x%y);
	}
	
	public static int LCM(int x, int y) {
		return (x*y) / GCD(x,y);
	}

}
