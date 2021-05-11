package S3_1057;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean check = false;
		int count = 1;
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x > y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		while(true) {
			if(n==1)
				break;
			if(y-x == 1 && x%2!=0 && y%2==0) {
				check = true;
				break;
			}
			
			if(is_even(x)) {
				x/=2;
			}
			else {
				x= x/2 + 1;
			}
			
			if(is_even(y)) {
				y/=2;
			}
			else
				y=y/2+1;
			
			count++;
			if(is_even(n))
				n/=2;
			else
				n= n/2+1;
		}
		
		if(check)
			System.out.println(count);
		else
			System.out.println("-1");
	}

	private static boolean is_even(int x) {
		if(x%2 == 0)
			return true;
		else
			return false;
	}

}
