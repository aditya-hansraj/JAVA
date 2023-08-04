package traf;
import java.util.*;
//Double Ended Queue using Array
public class DE_QueueA {
	private static Scanner sc = new Scanner(System.in);
	private int[] ar;
	private int f,r;

	public DE_QueueA(int size) {
		ar = new int[size];
		f = r = -1;
	}
	
	boolean isFull() {
		return f == (r + 1) % ar.length;
	}
	
	boolean isEmpty() {
		return f == -1 && r == -1;
	}
	
	public void inputF() {
		if(isFull())
			System.out.println("Queue Full !");
		else {
			System.out.println("Enter input data: ");
			int data = sc.nextInt();
			if(isEmpty())
				f = r = 0;
			else
				f = (f == 0)? ar.length-1 : f-1;
			ar[f] = data;
		}
	}
	
	public void inputR() {
		if(isFull())
			System.out.println("Queue Full !");
		else {
			System.out.println("Enter input data: ");
			int data = sc.nextInt();
			r = (r == -1 && f++ == -1)?0:(r+1) % ar.length;
			ar[r] = data;
		}
	}
	
	public void deleteF() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else {
			System.out.println("Deleted: "+ar[f]);
			if(f == r)
				f = r = -1;
			else {
				f = (f + 1) % ar.length;
			}
		}
	}
	
	public void deleteR() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else {
			System.out.println("Deleted: "+ar[r]);
			if(f == r)
				f = r = -1;
			else {
				if(r == 0)
					r = ar.length-1;
				else
					r--;
			}
		}
	}
	
	public void display() {
		System.out.print("[");
		if(isEmpty())
			System.out.println("E M P T Y   Q U E U E  !]");
		else {
			if(f == r) 
				System.out.println(ar[f]+"]");
			else {
				int t = f;
				while(true) {
					System.out.print(ar[t]);
					if(t != r) 
						System.out.print(", ");
					t = (t + 1) % ar.length;
					if(t == r){
						System.out.println(ar[t]+"]");	
						return;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("Enter size of the Queue: ");
		DE_QueueA q = new DE_QueueA(sc.nextInt());
		while(true) {
			System.out.println("Enter your choice: ");
			switch (sc.nextInt()) {
				case 1->{
					q.inputF();
					q.display();
				}case 2->{
					q.inputR();
					q.display();
				}case 3->{
					q.deleteF();
					q.display();
				}case 4->{
					q.deleteR();
					q.display();
				}case 0->System.exit(0);
			}
		}
	}
}
