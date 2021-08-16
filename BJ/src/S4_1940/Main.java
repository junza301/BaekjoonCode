package S4_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		int [] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int i = 0, j = n-1, count = 0;
		
		while(i < j) {
			int tmp = arr[i] + arr[j];
			if(tmp == m) {
				count++;
				i++;
				j--;
			} else if(tmp > m ){
				j--;
			} else {
				i++;
			}
		}
		
		System.out.println(count);
	}

}
