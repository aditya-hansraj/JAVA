package traf;
import java.util.*;

public class CircularQueueA {
	private int[] ar;private int f,r;
	static Scanner sc = new Scanner(System.in);
	
	public CircularQueueA(int size) {
		ar = new int[size];
		f = -1;r = -1;
	}
	
	private boolean isFull() {
		return r == f-1 || (f == 0 && r == ar.length-1);
	}
	
	private boolean isEmpty() {
		return f == -1 || r == -1;
	}
	
	public void enQueue(int n) {
		if(isFull())
			System.out.println("Queue Full !");
		else {
			if(isEmpty()) {
				f = 0;
				r = 0;
			}else
				r = (r + 1) % ar.length;
			ar[r] = n;
		}
	}
	
	public void deQueue() {
		if(isEmpty()) 
			System.out.println("Queue Empty !");
		else {
			System.out.println("Deleted "+ar[f]);
			if(f == r) {
				f = -1;
				r = -1;
			}else
				f = (f + 1) % ar.length;
		}
	}
	
	public void display() {
		System.out.print("[");
		if(isEmpty())
			System.out.println("E M P T Y   L I S T  !]");
		else {
			if(f == r) {
				System.out.println(ar[f]+"]");
			}else {
				int i = f;
				while(true) {
					if(i == r) {
						System.out.println(ar[r]+"]");
						return;
					}
					System.out.print(ar[i]+", ");
					i = (i + 1) % ar.length;
				}
			}
			
		}
	}
	
	public void peek() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else
			System.out.println(ar[f]);
	}
	
	public static void main(String[] args) {
		System.out.print("Enter size of the Queue: ");
		CircularQueueA cq= new CircularQueueA(sc.nextInt());
		while(true) {
			System.out.println("1-enQueue()");
			System.out.println("2-deQueue()");
			System.out.println("3-peek()");
			System.out.println("0-Exit");
			System.out.print("Enter your choice: ");
			switch(sc.nextInt()) {
				case 1->{
					System.out.println("Enter element to insert: ");
					cq.enQueue(sc.nextInt());
					cq.display();
				}case 2->{
					cq.deQueue();
					cq.display();
				}case 3->
					cq.peek();
				case 0->{
					System.out.println("Program End !");
					System.exit(0);
				}
			}
		}
	}
}
