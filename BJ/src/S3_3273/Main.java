package S3_3273;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] data = new int[n];
		
		for(int i =0; i< n; i++) {
			data[i] = sc.nextInt();
		}

		Arrays.sort(data);
		
		int x = sc.nextInt();
		
		int count = 0;
		
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				int now = data[i] + data[j];
				if(now == x)
					count++;
				
				if(now >= x)
					break;
			}
		}
		
		System.out.println(count);
	}

}
