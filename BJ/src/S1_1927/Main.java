package S1_1927;

import java.util.Scanner;

public class Main {
	public static class Heap {
		int [] h;
		int index;
		
		public Heap(int n) {
			h = new int[n+1];
			index = 1;
		}
		
		public void insert(int data) {
			h[index] = data;
			int p = index;
			while(p!=1 && h[p] < h[p/2]) {
				int tmp = h[p];
				h[p] = h[p/2];
				h[p/2] = tmp;
				p /= 2;
			}
			index++;
		}
		
		public int delete() {
			int tmp = h[1];
			h[1] = h[--index];
			
			int now = 1;
			while(now*2<index) {
				int min = h[now*2];
				int minpos = now*2;
				if(now*2+1 < index && min > h[now*2+1]) {
					min = h[now*2+1];
					minpos = now*2+1;
				}
				if(h[now] < min)
					break;
				else {
					int swap = h[now];
					h[now] = h[minpos];
					h[minpos] = swap;
					now=minpos;
				}
			}
			return tmp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Heap heap = new Heap(n);
		
		int [] command = new int[n];
		for(int i = 0; i < n; i++) {
			command[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			if(command[i] == 0) {
				if(heap.index == 1)
					System.out.println("0");
				else 
					System.out.println(heap.delete());
			}
			else
				heap.insert(command[i]);
		}
		
		
	}

}
