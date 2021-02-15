package S3_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] data = new int[n];
		for(int i = 0; i<n;i++)
			data[i] = sc.nextInt();
		Arrays.sort(data);
		int result = 0;
		int j = 0;
		for(int i = n; i>0; i--) {
			result += (i *data[j++]);
		}
		System.out.println(result);
	}

}
