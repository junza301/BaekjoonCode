package S4_2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(bf.readLine()));
		}
		Collections.sort(list, Collections.reverseOrder());
		
		int max = 0;
		int count = 0;
		
		for(int i : list) {
			count++;
			max = (max > i*count) ? max : (i*count);
		}
		System.out.println(max);
	}
}
