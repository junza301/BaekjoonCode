package S5_2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> data = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			data.add(Integer.parseInt(bf.readLine()));
		}
		
		Collections.sort(data);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < n; i++) {
			bw.write(data.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
