package traf;
import java.util.*;
//Double Ended Queue using Linked List
public class DE_QueueL {
	private static Scanner sc = new Scanner(System.in);
	private Node f,r;
	
	private class Node{
		int data;
		Node pre,next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	boolean isEmpty() {
		return f == null && r == null;
	}
	
	public void displayF() {
		System.out.print("Forwards:  [");
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
	public void displayR() {
		System.out.print("Backwards: [");
		if(isEmpty())
			System.out.println("E M P T Y   Q U E U E  !]");
		else {
			Node t = r;
			while(true) {
				System.out.print(t.data);
				if(t != f)
					System.out.print(", ");
				else {
					System.out.println("]");
					return;
				}
				t = t.pre;
			}
		}
	}
	
	public void inputF() {
		System.out.print("Enter input data: ");
		Node n = new Node(sc.nextInt());
		
		if(isEmpty()) 
			f = r = n.next = n.pre = n;
		else {
			n.pre = r;
			r.next = n;
			n.next = f;
			f.pre = n;
			f = n;
		}
	}
	
	public void inputR() {
		System.out.print("Enter input data: ");
		Node n = new Node(sc.nextInt());
		
		if(isEmpty())
			f = r = n.next = n.pre;
		else {
			n.pre = r;
			n.next = f;
			r.next = n;
			f.pre = n;
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
				f.pre = r;
				r.next = f;
			}
		}
	}
	
	public void deleteR() {
		if(isEmpty())
			System.out.println("Empty Queue !");
		else {
			System.out.println("Deleted "+r.data);
			if(f == r)
				f = r = null;
			else {
				r = r.pre;
				r.next = f;
				f.pre = r;
			}
		}
	}
	
	public static void main(String[] args) {
		DE_QueueL q = new DE_QueueL();
		
		while(true) {
			System.out.println("Enter your choice: ");
			switch (sc.nextInt()) {
			case 1->{
				q.inputF();
				q.displayF();
				q.displayR();
			}case 2->{
				q.inputR();
				q.displayF();
				q.displayR();
			}case 3->{
				q.deleteF();
				q.displayF();
				q.displayR();
			}case 4->{
				q.deleteR();
				q.displayF();
				q.displayR();
			}case 0->System.exit(0);
			}
		}
	}
}
