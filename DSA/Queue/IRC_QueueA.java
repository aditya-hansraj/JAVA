package traf;
import java.util.*;
//Input Restricted Circular Queue by Array
public class IRC_QueueA {
	static Scanner sc = new Scanner(System.in);
	
	private int[] ar;
	private int front,rear;
	
	public IRC_QueueA(int size) {
		ar = new int[size];
		front = rear = -1;
	}
	
	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}
	
	public boolean isFull() {
		return front == rear + 1 || (front == 0 && rear == ar.length-1);
	}
	
	public void input() {
		if(isFull())
			System.out.println("Queue Full !");
		else {
			System.out.println("Enter data: ");
			int data = sc.nextInt();
			if(isEmpty())
				front = rear = 0;
			else
				rear = (rear + 1) % ar.length;
			ar[rear] = data;
		}
	}
	
	public void deleteF() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else {
			System.out.println("Deleted: "+ar[front]);
			if(front == rear)
				front = rear = -1;
			else {
				front = (front + 1) % ar.length;
			}
		}
	}
	
	public void deleteR() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else {
			System.out.println("Deleted: "+ar[rear]);
			if(front == rear)
				front = rear = -1;
			else {
				if(rear == 0)
					rear = ar.length-1;
				else
					rear--;
			}
		}
	}
	
	public void display() {
		System.out.print("[");
		if(isEmpty())
			System.out.println("E M P T Y   Q U E U E  !]");
		else {
			if(front == rear) 
				System.out.println(ar[front]+"]");
			else {
				int t = front;
				while(true) {
					System.out.print(ar[t]);
					if(t != rear) 
						System.out.print(", ");
					t = (t + 1) % ar.length;
					if(t == rear){
						System.out.println(ar[t]+"]");	
						return;
					}
						
				}
			}
			
		}
	}
	
	public void peekF() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else
			System.out.println(ar[front]);
	}
	
	public void peekR() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else
			System.out.println(ar[rear]);
	}
	
	public static void main(String[] args) {
		System.out.println("Enter size of the Queue: ");
		IRC_QueueA q = new IRC_QueueA(sc.nextInt());
		
		while(true) {
			System.out.println("Enter your choice: ");
			switch (sc.nextInt()) {
			case 1->{
				q.input();
				q.display();
			}case 2->{
				q.deleteF();
				q.display();
			}case 3->{
				q.deleteR();
				q.display();
			}case 4->{
				q.peekF();
				q.peekR();
			}case 0->System.exit(0);
			}
		}
	}
	
}
