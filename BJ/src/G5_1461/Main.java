package G5_1461;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean dir; // false 음수방향 true 양수방향
		int countMinus = 0;
		int countPlus = 0;
		int result = 0;
		
		int [] tmp = new int[n];
		for(int i = 0; i < n; i++) {
			tmp[i] = sc.nextInt();
			if(tmp[i] > 0)
				countPlus++;
			else
				countMinus++;
		}
		Arrays.sort(tmp);
		
		Integer[] bookPlus = new Integer[countPlus];
		int[] bookMinus = new int[countMinus];
		
		for(int i = 0; i < countMinus; i++)
			bookMinus[i] = tmp[i];
		int x = 0;
		for(int i = countMinus; i < n; i++)
			bookPlus[x++] = tmp[i];

		
		if (countPlus == 0) {
			Arrays.sort(bookMinus);
			dir = false;
		} else if (countMinus == 0) {
			Arrays.sort(bookPlus, Collections.reverseOrder());
			dir = true;
		} else {
			Arrays.sort(bookPlus, Collections.reverseOrder());
			Arrays.sort(bookMinus);
			dir = bookPlus[0] > Math.abs(bookMinus[0]) ? true : false;
		}

		if (dir) {
			int now = 0;
			while (countMinus >= m) {
				result += Math.abs(bookMinus[now]) * 2;
				countMinus -= m;
				now += m;
			}

			if (countMinus > 0) {
				result += Math.abs(bookMinus[now]) * 2;
			}
			
			now = 0;
			while (countPlus >= m) {
				result += bookPlus[now] * 2;
				countPlus -= m;
				now += m;
			}
			
			if(countPlus > 0) {
				result += bookPlus[now] * 2;
			}
			result -= bookPlus[0];

		} else {
			int now = 0;
			while (countPlus >= m) {
				result += bookPlus[now] * 2;
				countPlus -= m;
				now += m;
			}
			
			if(countPlus > 0) {
				result += bookPlus[now] * 2;
			}
			
			now = 0;
			while (countMinus >= m) {
				result += Math.abs(bookMinus[now]) * 2;
				countMinus -= m;
				now += m;
			}

			if (countMinus > 0) {
				result += Math.abs(bookMinus[now]) * 2;	
			}
			result -= Math.abs(bookMinus[0]);
		}

		System.out.println(result);
	}
}
