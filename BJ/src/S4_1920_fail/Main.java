package S4_1920_fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String tmp = bf.readLine();
		int n = Integer.parseInt(tmp);
		int [] a = new int[n];
		tmp = bf.readLine();
		int i = 0;
		StringTokenizer st = new StringTokenizer(tmp);
		while(st.hasMoreTokens()) {
			a[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		quickSort(a, 0, n-1);
		
		tmp = bf.readLine();
		int m = Integer.parseInt(tmp);
		int [] b = new int[m];
		tmp = bf.readLine();
		StringTokenizer st2 = new StringTokenizer(tmp);
		for(i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st2.nextToken());
			BinarySearch(a,n,b,i);
		}
	
		bw.flush();
		bw.close();
	}
	
	public static void BinarySearch(int [] a, int n, int [] b, int i) throws IOException {
		int left = a[0], right = a[n-1], mid;
		while(left<=right && left <= b[i] && right >= b[i]) {
			mid = (left+right)/2;
			if(b[i] > mid) {
				left = mid+1;
			}
			else if(b[i] < mid) {
				right = mid-1;
			}
			else {
				bw.write("1\n");
				return;
			}
		}
		bw.write("0\n");
	}
	
	public static void quickSort(int [] arr, int p, int r) {
		if(p<=r) {
			int q = partition(arr, p, r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
		}
	}
	
	public static int partition(int [] arr, int p, int r) {
		int i = p-1, j, pivot = arr[r], tmp;
		for(j = p; j<r; j++) {
			if(arr[j] <= pivot) {
				tmp = arr[++i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		tmp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = tmp;
		return i+1;
	}
}
