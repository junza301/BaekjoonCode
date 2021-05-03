package S2_1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int [] data = new int[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			int idx = 0;
			
			while(tmp!=0 || data[idx] != 0) {
				if(data[idx] == 0) {
					idx++;
					tmp--;
				}
				else
					idx++;
			}
			data[idx] = i+1;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(data[i] + " ");
		}
	}
}

