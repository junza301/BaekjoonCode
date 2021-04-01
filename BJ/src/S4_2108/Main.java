package S4_2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int [] num = new int[n];
		int [] numCount = new int[8001];
		double sum = 0;
		
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(bf.readLine());
			num[i] = tmp;
			sum += tmp;
			numCount[tmp+4000]++;
		}
		Arrays.sort(num);
		
		int max = 0;
		for(int i = 0; i<=8000; i++) {
			if(numCount[i] > max) {
				max = numCount[i];
			}
		}
		
		int index = 10000;
		boolean check = false;
		
		for(int i = 0; i <= 8000; i++) {
			if(numCount[i] == max && check == false) {
				index = i-4000;
				check = true;
			}
			else if(numCount[i] == max && check == true) {
				index = i-4000;
				break;
			}
		}
		
		System.out.printf("%.0f\n", sum/n);
		System.out.println(num[n/2]);
		System.out.println(index);
		System.out.println(num[n-1] - num[0]);
	}

}
