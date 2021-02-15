package S4_2164;

import java.util.Scanner;

public class Main {
	public static class Queue {
		Node head;
		Node tail;
		int count;
		
		public Queue() {
			head = null;
			tail = null;
			count = 0;
		}
		
		public void Enqueue(int data) {
			if(this.head == null) {
				Node now = new Node(data);
				this.head = now;
				this.tail = now;
				this.count++;
			}
			else {
				Node now = new Node(data);
				this.tail.next = now;
				this.tail = now;
				this.count++;
			}
		}
		
		public int Dequeue() {
			if(this.head == null) {
				return 0;
			}
			else {
				Node tmp = this.head;
				this.head = tmp.next;
				this.count--;
				return tmp.data;
			}
		}
	}
	
	public static class Node {
		int data;
		Node next;
		
		public Node(int a) {
			data = a;
			next = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue queue = new Queue();
		
		for(int i = 1; i<=n; i++)
			queue.Enqueue(i);
		
		for(int i = 1; i < n; i++) {
			queue.Dequeue();
			queue.Enqueue(queue.Dequeue());
		}
		
		System.out.println(queue.Dequeue());
	}
}
