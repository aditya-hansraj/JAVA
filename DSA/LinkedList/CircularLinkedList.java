
import java.util.*;
public class CircularLinkedList<T> {
	
	static Scanner sc = new Scanner(System.in);
	 
	private class Node{
		T data;
		Node next;

		Node(T data){
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	int size;
	
	public CircularLinkedList() {
		create();
	}
	
	
	
	
	public void insertB(T d) {
		Node n = new Node(d);
		if(head == null) {
			n.next = n;
			head = n;
		}else {
			n.next = head;
			Node c = head;
			while(c.next != head) 
				c = c.next;
			c.next = n;
			head = n;
		}
		size ++;
	}
	
	public void insertE(T d) {
		Node n = new Node(d);
		if(head == null) {
			n.next = n;
			head = n;
		}else {
			Node c = head;
			while(c.next != head)
				c = c.next;
			c.next = n;
			n.next = head;
		}
		size ++;
	}
	
	public void deleteB() {
		if(head == null)
			 System.out.println("Empty List !");
		else {
			System.out.println("Deleted "+head.data);
			if(head.next == head) 
				 head = null;
			else {
				Node t = head;
				while(t.next != head)
					t = t.next;
				t.next = head.next;
				head = head.next;
			}
			size--;
		}
	}
	
	public void deleteE() {
		if(head == null)
			System.out.println("Empty List !");
		else {
			if(head.next == head){
				System.out.println("Deleted: "+head.data);
				head = null;
			}else{
				Node t = head;
				while(t.next.next != head)
					t = t.next;
				System.out.println("Deleted "+t.next.data);
				t.next = head;
				size --;
			}
			
		}
	}
	
	public void insertA(T d) {
		System.out.print("Enter position: ");
		int p = sc.nextInt();
		if(p < 1 || p > size+1) {
			System.out.println("Invalid Input !");
		}else {
			if(p == 1)
				insertB(d);
			else if(p == size+1)
				insertE(d);
			else {
				Node n = new Node(d);
				int c = 1;
				Node t = head;
				while(c++ < p-1)
					t = t.next;
				n.next = t.next;
				t.next = n;
				size++;
			}
		}
	}
	
	public void deleteA() {
		System.out.println("Enter position: ");
		int p = sc.nextInt();
		if(p < 1 || p > size)
			System.out.println("Invalid Input !");
		else {
			if(p == 1)
				deleteB();
			else if(p == size)
				deleteE();
			else {
				Node t = head;
				int c = 1;
				while(c++ < p-1)
					t = t.next;
				System.out.println("Deleted "+t.next.data);
				t.next = t.next.next;
				size--;
			}
		}
	}
	
	public void display() {
		System.out.print("[");
		if(head == null)
			System.out.println("E M P T Y   L I S T  !]\n");
		else {
			Node c = head;
			do {
				System.out.print(c.data);
				if(c.next != head)
					System.out.print(", ");
				c = c.next;
			}while(c != head);
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		CircularLinkedList<Integer> cl = new CircularLinkedList();
		
		while(true){
			System.out.println("1-Display");
			System.out.println("2-Insert_At_Beginning");
			System.out.println("3-Insert_At_End");
			System.out.println("4-Delete_From_Beginning");
			System.out.println("5-Delete_From_End");
			System.out.println("6-Insert_At_Any_Position");
			System.out.println("7-Delete_From_Any_Position");
			System.out.println("0-Exit");
			System.out.print("Enter your choice: ");

			switch(sc.nextInt()){
				case 1->
					cl.display();
				case 2->{
					System.out.println("Enter data: ");
					cl.insertB(sc.nextInt());
				}
					
				case 3->{
					System.out.println("Enter data: ");
					cl.insertE(sc.nextInt());
				}
				case 4->
					cl.deleteB();
				case 5->
					cl.deleteE();
				case 6->{
					System.out.println("Enter data: ");
					cl.insertA(sc.nextInt());
				}
				case 7->
					cl.deleteA();
				case 0->{
					System.out.println("Program End !");
					System.exit(0);
				}
				default->
					System.out.println("Invalid Input !\nTry Again !");
					
			}
		}
	}
}






