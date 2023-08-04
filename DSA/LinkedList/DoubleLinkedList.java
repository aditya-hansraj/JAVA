

import java.util.Scanner;

public class DoubleLinkedList<T>{
	static Scanner sc = new Scanner(System.in);
	private class Node{
		T data;
		Node pre;
		Node next;

		Node(T data){
			this.data = data;
			this.pre = null;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;
	int size;
	
	public DoubleLinkedList(){
		
	}

	
	
	public void insertB(T data){
		Node n = new Node(data);
		if(head == null){
			head = n;
			tail = n;
		}else{
			head.pre = n;
			n.next = head;
			head = n;
		}
		size++;
	}
	
	
	public void insertE(T data) {
		Node n = new Node(data);
		if(tail == null) {
			head = n;
			tail = n;
		}else {
			tail.next = n;
			n.pre = tail;
			tail = n;
		}
		size++;
	}

	//delete from beginning
	public void deleteB() {
		if(head == null)
			System.out.println("Empty List !");
		else {
			System.out.println("Deleted: "+head.data);
			head = head.next;
			if(head == null)
				tail = null;
			else
				head.pre = null;
		}
		size--;
	}
	
	//delete from end
	public void deleteE() {
		if(tail == null)
			System.out.println("Empty List !");
		else {
			System.out.println("Deleted: "+tail.data);
			tail = tail.pre;
			if(tail == null)
				head = null;
			else
				tail.next = null;
		}
		size--;
	}
	
	//insert at any position
	public void insertA(T data) {
		System.out.print("Enter position you want to inssert at: ");
		int p = sc.nextInt();
		if(p<1 || p > size+1) {
			System.out.println("Invalid Position !");
			return;
		}else {
			if(p == 1)
				insertB(data);
			else if(p == size+1)
				insertE(data);
			else {
				Node n = new Node(data);
				int c = 1;
				Node t = head;
				while(c++ < p-1)
					t = t.next;
				n.next = t.next;
				t.next = n;
				n.next.pre = n;
				n.pre = t;
				size++;
			}
		}
	}
	
	// delete from any position
	public void deleteA() {
		System.out.print("Enter position you want to delete: ");
		int p = sc.nextInt();
		if(p<1 || p>size) {
			System.out.println("Invalid position !");
			return;
		}else if(p == 1) 
			deleteB();
		else if(p == size)
			deleteE();
		else {
			int c = 1;
			Node t = head;
			while(c++ < p-1)
				t = t.next;
			System.out.println("Deleted "+t.next.data);
			t.next.next.pre = t;
			t.next = t.next.next;
			size--;
		}
	}
	
	public int getsize() {
		return size;
	}
	
	// display from forward
	public void displayF(){
		System.out.print("[");
		if(head == null)
			System.out.print("E M P T Y   L I S T  !]\n");
		else{	
			for(Node c = head;c != null;c = c.next) {
				System.out.print(c.data);
				if(c.next != null)
					System.out.print(", ");
			}
			
			System.out.println("]");
		}
	}

	//display from backwards
	public void displayB(){
		System.out.println("[");
		if(tail == null)
			System.out.println("E M P T Y   L I S T  !]\n");
		else{
			for(Node c = tail;c != null; c = c.pre) {
				System.out.print(c.data+" ");
				if(c.pre != null)
					System.out.print(", ");
			} 
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<Integer> dl = new DoubleLinkedList<Integer>();

		while(true){
			System.out.println("1-Display_From_Head");
			System.out.println("2-Display_From_Tail");
			System.out.println("3-Insert_At_Beginning");
			System.out.println("4-Insert_At_End");
			System.out.println("5-Delete_From_Beginning");
			System.out.println("6-Delete_From_End");
			System.out.println("7-Insert_At_Any_Position");
			System.out.println("8-Delete_From_Any_Position");
			System.out.println("0-Exit");
			System.out.print("Enter your choice: ");

			switch(sc.nextInt()){
				case 1:
					dl.displayF();
					break;
				case 2:
					dl.displayB();
					break;
				case 3:
					System.out.println("Enter data: ");
					dl.insertB(sc.nextInt());
					break;
				case 4:
					System.out.println("Enter data: ");
					dl.insertE(sc.nextInt());
					break;
				case 5:
					dl.deleteB();
					break;
				case 6:
					dl.deleteE();
					break;
				case 7:
					System.out.println("Enter data: ");
					dl.insertA(sc.nextInt());
					break;
				case 8:
					dl.deleteA();
					break;
				case 0:
					System.out.println("Program End !");
					System.exit(0);
					break;
				
				default:
					System.out.println("Invalid Input !\nTry Again !");
					
			}
		}
	}
}

