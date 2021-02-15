package S2_11279;

import java.util.Scanner;

public class Main {
	static int n;
	public static class Heap {
		int [] h;
		int index;
		
		public Heap(int n) {
			h = new int[n+1];
			index = 1;
		}
		
		public void insert(int data) {
			h[index] = data;
			int now = index++;
			while(now!=1 && h[now/2] < data) {
				int tmp = h[now];
				h[now] = h[now/2];
				h[now/2] = tmp;
				now/=2;
			}
		}
		
		public int delete() {
			int result = h[1];
			h[1] = h[--index];
			int pos = 1;
			while(pos*2 < index) {
				int max = h[pos*2];
				int maxpos = pos*2;
				if(pos*2+1 < index && h[pos*2+1] > max) {
					max = h[pos*2+1];
					maxpos = pos*2+1;
				}
				if(h[pos] < max) {
					int tmp = h[pos];
					h[pos] = h[maxpos];
					h[maxpos] = tmp;
					pos = maxpos;
				}
				else
					break;
			}
			
			return result;
		}
	}
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int [] command = new int[n];
		for(int i = 0; i < n; i++) {
			command[i] = sc.nextInt();
		}
		
		Heap heap = new Heap(n);
		
		for(int i = 0; i < n; i++) {
			if(command[i] == 0) {
				if(heap.index == 1)
					System.out.println("0");
				else 
					System.out.println(heap.delete());				
			}
			else {
				heap.insert(command[i]);
			}
		}
	}

}
