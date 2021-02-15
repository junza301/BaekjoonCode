package S4_1764;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String [] hear = new String[n];
		String [] see = new String[m];
		String [] result = new String[Math.max(n,m)];
		int count = 0;
		
		for(int i = 0; i < n; i++)
			hear[i] = sc.next();
		for(int i = 0; i < m; i++)
			see[i] = sc.next();
		
		Arrays.sort(hear);
		Arrays.sort(see);
		
		int i = 0, j = 0;
		
		while(i != n && j != m) {
			if(hear[i].compareTo(see[j]) > 0) {
				j++;
			}
			else if(hear[i].compareTo(see[j]) < 0) {
				i++;
			}
			else {
				result[count++] = hear[i];
				i++;
				j++;
			}
		}
		
		System.out.println(count);
		for(i = 0; i < count; i++)
			System.out.println(result[i]);
	}

}
