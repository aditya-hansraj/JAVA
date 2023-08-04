package traf;
import java.util.*;
//Input Restricted Circular Queue by LinkedList
public class IRC_QueueL {
	static Scanner sc = new Scanner(System.in);
	
	private Node f,r;
	
	private class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	public boolean isEmpty() {
		return f == null && r == null;
	}
	
	public void input() {
		System.out.println("Enter input data: ");
		Node n = new Node(sc.nextInt());
		
		if(isEmpty()) {
			n.next = n;
			f = r = n;
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
			else {
				f = f.next;
				r.next = f;
			}
		}
	}
	
	public void deleteR() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else {
			System.out.println("Deleted: "+r.data);
			if(f == r)
				f = r = null;
			else {
				Node t = f;
				while(t.next != r) {
					t = t.next;
				}
				t.next = f;
				r = t;
			}
		}
	}
	
	public void display() {
		System.out.print("[");
		if(isEmpty())
			System.out.println("E M P T Y   Q U E U E  !]");
		else {
			if(f == r) 
				System.out.println(f.data+"]");
			else {
				Node t = f;
				do {
					if(t != r)
						System.out.print(t.data+", ");
					else
						System.out.println(t.data+"]");
					t = t.next;
				}while(t != f);
			}
			
		}
	}
	
	public static void main(String[] args) {
		IRC_QueueL q = new IRC_QueueL();
		while(true) {
			System.out.println("Enter your choice: ");
			switch(sc.nextInt()){
			case 1->{
				q.input();
				q.display();
			}case 2->{
				q.deleteF();
				q.display();
			}case 3->{
				q.deleteR();
				q.display();
			}case 0-> System.exit(0);
			}
		}
	}
}
