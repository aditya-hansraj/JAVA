package traf;
import java.util.*;
//Output Restricted Circular Queue Using LinkedList
public class ORC_QueueL {
	static Scanner sc = new Scanner(System.in);
	
	private class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	private Node f,r;
	
	public boolean isEmpty() {
		return f == null && r == null;
	}
	
	public void display() {
		System.out.print("[");
		if(isEmpty())
			System.out.println("E M P T Y   Q U E U E  !]");
		else {
			Node t = f;
			while(true) {
				System.out.print(t.data);
				if(t != r)
					System.out.print(", ");
				else {
					System.out.println("]");
					return;
				}
				t = t.next;
			}
		}
	}
	
	public void inputF() {
		System.out.println("Enter input data: ");
		Node n = new Node(sc.nextInt());
		if(isEmpty()) {
			n.next = n;
			f = r = n;
		}else {
			n.next = f;
			r.next = n;
			f = n;
		}		
	}
	
	public void inputR() {
		System.out.println("Enter input data: ");
		Node n = new Node(sc.nextInt());
		if(isEmpty()) {
			n.next = n;
			r = f = n;
		}else {
			n.next = f;
			r.next = n;
			r = n;
		}
	}
	
	public void deleteF() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else {
			System.out.println("Deleted: "+f.data);
			if(f == r)
				f = r = null;
			else
				f = f.next;
		}
	}
	
	
	public static void main(String[] args) {
		ORC_QueueL q = new ORC_QueueL();
		
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





