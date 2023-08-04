package traf;
import java.util.*;
//Output Restricted Circular Queue Using Array
public class ORC_QueueA {
	static Scanner sc = new Scanner(System.in);
	private int[] ar;
	int f,r;
	
	public ORC_QueueA(int size) {
		ar = new int[size];
		f = r = -1;
	}
	
	public boolean isFull() {
		return f == r+1%ar.length;
	}
	
	public boolean isEmpty() {
		return f == -1 && r == -1;
	}
	
	public void display() {
		System.out.print("[");
		if(isEmpty())
			System.out.println("E M P T Y   L I S T  !]");
		else {
			int i = f;
			while(true) {
				System.out.print(ar[i]);
				if(i != r)
					System.out.print(", ");
				else {
					System.out.println("]");
					return;
				}
				i = (i + 1) % ar.length;
			}
		}
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
				f = (f == 0) ?ar.length-1 :f-1;
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
			else 
				f = (f + 1) % ar.length;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Enter Queue size: ");
		ORC_QueueA q = new ORC_QueueA(sc.nextInt());
		
		while(true) {
			System.out.println("Enter your choice: ");
			switch(sc.nextInt()) {
			case 1->{
				q.inputF();
				q.display();
			}case 2->{
				q.inputR();
				q.display();
			}case 3->{
				q.deleteF();
				q.display();
			}case 0->System.exit(0);
			}
		}
	}
}
