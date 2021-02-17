package G5_1107_fail;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	
	static String [] result;
	static int [] error;
	static boolean small = false;
	static boolean big = false;
	static boolean check = false;
	static boolean up = false;
	static boolean down = false;
	static boolean first = true;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int m = sc.nextInt();
		error = new int[m];
		for(int i = 0; i<m; i++)
			error[i] = sc.nextInt();
		Arrays.sort(error);
		
		int result = 0;
		for(int i = 0; i<n.length(); i++) {
			int tmp = find(n.charAt(i)-'0');
			if(tmp != -1) {
				if(check && up) {
					result += (int) (Math.pow(10, n.length()-i-1) * tmp);
				}
				else if(check) {
					result += Math.pow(10, n.length()-i);
					check = false;
					up = true;
				}
				else {
					result += (int) (Math.pow(10, n.length()-i-1) * tmp);
				}
			}
		}
		
		System.out.println(result);
	}

	private static int find(int k) {
		if(!BS(k)) {
			small = false;
			big = false;
			return k;
		}
		for(int i = 1; i <= 9; i++) {
			boolean plus = true;
			boolean minus = true;
			if(k+i <= 9)
				plus = BS(k+i);
			else {
				check = true;
				plus = BS((k+i)%10);
			}
			
			if(k-i == 0 && first) {
				first = false;
				down = true;
				return 0;
			}
			
			if(k-i >= 0)
				minus = BS(k-i);
			// first ¿¹¿Ü
			
			if(!plus && !minus) {
				if(small) {
					if(!check && up)
						up = false;
					return (k+i)%10;
				}
				else if(big)
					if(down)
						return k+i;
					else
						return k-i;
				else {
					big = true;
					if(!check && up)
						up = false;
					return (k+i)%10; 
				}
					
			}
			else if(!plus) {
				if(!small && !big)
					big = true;
				if(!check && up)
					up = false;
				return (k+i) % 10;
			}
			else if(!minus) {
				if(!small && !big)
					small = true;
				return k-i;
			}
		}
		return -1;
	}

	private static boolean BS(int i) {
		int mid;
		int left = 0;
		int right = error.length-1;
		
		while(left<=right) {
			mid = (left + right) / 2;
			if(i==error[mid]) {
				return true;
			}
			else if(i>error[mid])
				left = mid+1;
			else
				right = mid-1;
		}
		return false;
	}
	
	

}
