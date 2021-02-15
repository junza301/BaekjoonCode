package S2_1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	
	public static class Meeting implements Comparable<Meeting> {
		public int start;
		public int end;
		
		public int compareTo(Meeting m) {
			return this.end - m.end;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int [] result = new int[n];
		Meeting [] m = new Meeting[n];
		for(int i = 0; i<n; i++) {
			m[i] = new Meeting();
			m[i].start = sc.nextInt();
			m[i].end = sc.nextInt();
		}
		sc.close();
		Arrays.sort(m);
		
		int count = 1;
		int index = 0;
		
		for(int i = 1; i < n; i++) {
			if(m[index].end > m[i].start)
				if(m[index].end == m[i].end && m[index].start == m[index].end) {
					count++;
					continue;
				}
				else
					continue;
			count++;
			index = i;
		}
		
		System.out.println(count);
	}
}
