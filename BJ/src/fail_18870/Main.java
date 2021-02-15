package fail_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static class Data {
		int index;
		long num;
		int count;
		public Data(long a, int b) {
			this.num = a;
			this.index = b;
			this.count = 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
		StringTokenizer st = new StringTokenizer(sc.readLine(), " ");
		Data [] d = new Data[n];
		for(int i = 0; i < n; i++) {
			d[i] = new Data(Long.parseLong(st.nextToken()), i);
		}
		
		Arrays.sort(d, new Comparator<Data>() {
			public int compare(Data d1, Data d2) {
				if(d1.num > d2.num)
					return 1;
				else if(d1.num < d2.num)
					return -1;
				else
					return 0;
			}
		});
		
		int [] result = new int[n];
		
		for(int i = 1; i < n; i++) {
			if(d[i-1].num != d[i].num)
				d[i].count = d[i-1].count + 1;
			else
				d[i].count = d[i-1].count;
			result[d[i].index] = d[i].count;
		}
	
		for(int i = 0; i<n; i++) {
			System.out.println(result[i] + " ");
		}
	}
}
