package S5_10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		int [] count = new int[10001];
		
		for(int i = 0; i < n; i++) {
			count[Integer.parseInt(bf.readLine())]++;
		}
		
		for(int i = 0; i < 10001; i++) {
			if(count[i] != 0) {
				for(int j = 0; j < count[i]; j++) {
					bw.write(i + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
