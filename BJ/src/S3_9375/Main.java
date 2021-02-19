package S3_9375;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] res = new int[t];
		
		for(int v = 0; v < t; v++) {		
			int n = sc.nextInt();
			String [] clothes = new String[n];
			int [] num = new int[n];
			
			for(int i = 0 ; i < n; i++) {
				sc.next();
				clothes[i] = sc.next();
			}
			Arrays.sort(clothes);
			
			int count = 1;
			int index = 0;
			for(int i = 1; i < n; i++) {
				if(clothes[i].equals(clothes[i-1])) {
					count++;
				}
				else {
					num[index++] = count;
					count = 1;
				}
			}
			if(n != 0)
				num[index++] = count;
			
			int result = 1;
			
			if(n != 0) {
				for(int i = 0; i < index; i++)
					result *= (num[i]+1);
			}
			result -= 1;
			
			res[v] = result;
		}
		for(int i = 0 ; i < t; i++)
			System.out.println(res[i]);
	}

}
