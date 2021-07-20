import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int countPlus = 0;
		Integer[] bookPlus = new Integer[n];
		
		int[] bookMinus = new int[n];
		for (int i = 0; i < n; i++) {
			int now = sc.nextInt();
			if(now > 0) {
				bookPlus[countPlus] = now;
				countPlus++;
			}
		}
		Arrays.sort(bookPlus, Collections.reverseOrder());
		for(int i = 0; i < countPlus; i++)
			System.out.println(bookPlus[i]);
	}

}
