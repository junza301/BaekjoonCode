package S3_7795;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z = 0; z < t; z++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int [] dataA = new int[a];
			int [] dataB = new int[b];
			int count = 0;
			
			for(int i = 0; i < a; i++) {
				dataA[i] = sc.nextInt();
			}
			for(int i = 0; i < b; i++) {
				dataB[i] = sc.nextInt();
			}
			Arrays.sort(dataB);
			
			for(int i = 0; i < a; i++) {
				int k = BinarySearch(dataB, dataA[i]);
				System.out.println(dataA[i] + " " + k);
				//count += BinarySearch(dataB, dataA[i]);
			}
			//System.out.println(count);
		}

	}

	private static int BinarySearch(int[] dataB, int i) {
		int first = 0;
		int last = dataB.length-1;
		int mid = 0;
		
		boolean f_change = false, l_change = false;
		
		while(first <= last) {
			mid = (first+last)/2;
			f_change = false;
			l_change = false;
			
			if(dataB[mid] > i) {
				last = mid-1;
				l_change = true;
			} else if(dataB[mid] < i) {
				first = mid+1;
				f_change = true;
			} else {
				return mid;
			}
		}
		if(l_change) 
			return last;
		else
			return first+1;
	}

}
