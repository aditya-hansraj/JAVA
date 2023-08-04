
import java.util.*;
public class DoubleCircularLinkedList<T> {
	static Scanner sc = new Scanner(System.in);

    private class Node {
        T data;
        Node next,pre;
        
        Node(T data){
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }

    private Node head,tail;
    int size;

    public DoubleCircularLinkedList(){

    }

    public void insertB(T d) {
    	Node n = new Node(d);
    	if(head == null) {
    		n.next = n;
    		n.pre = n;
    		head = n;
    		tail = n;
    	}else {
    		n.next = head;
    		n.pre = tail;
    		head.pre = n;
    		tail.next = n;
    		head = n;
    	}
    	size ++;
    }
    

    public void insertE(T d) {
    	Node n = new Node(d);
    	if(tail == null) {
    		n.next = n;
    		n.pre = n;
    		head = n;
    		tail = n;
    	}else {
    		n.next = head;
    		n.pre = tail;
    		head.pre = n;
    		tail.next = n;
    		tail = n;
    	}
    	size ++;
    }
    
    public void deleteB() {
    	if(head == null)
    		System.out.println("Empty List !");
    	else {
    		System.out.println("Deleted "+head.data);
    		if(head == tail) {
    			head = null;
    			tail = null;
    		}else {
    			tail.next = head.next;
        		head.next.pre = tail;
        		head = head.next;
    		}
    		size --;
    	}
    }
    
    public void deleteE() {
    	if(tail == null)
    		System.out.println("Empty List !");
    	else {
    		System.out.println("Deleted "+tail.data);
    		if(tail == head) {
    			tail = null;
    			head = null;
    		}else {
    			head.pre = tail.pre;
    			tail.pre.next = head;
    			tail = tail.pre;
    		}
    		size --;
    	}
    }
    
    public void insertA(T d) {
    	System.out.println("Enter position: ");
    	int p =sc.nextInt();
    	if(p < 1 || p > size + 1)
    		System.out.println("Invalid Position !");
    	else {
    		if(p == 1)
    			insertB(d);
    		else if(p == size + 1)
    			insertE(d);
    		else {
    			Node n = new Node(d);
    			int c = 1;
    			Node t = head;
    			while(c++ < p-1)
    				t = t.next;
    			n.next = t.next;
    			n.pre = t;
    			n.next.pre = n;
    			t.next = n; 
    			size++;
    		}
    	}
    }
    
    public void deleteA() {
    	System.out.println("Enter position: ");
    	int p =sc.nextInt();
    	if(p < 1 || p > size)
    		System.out.println("Invalid Position !");
    	else {
    		if(p == 1)
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
    }
    
    public void displayF(){
        System.out.print("[");
        if(head == null)
            System.out.println("E M P T Y   L I S T  !]");
        else{
            Node t = head;
            do{
                System.out.print(t.data);
                if(t.next != head)
                	System.out.print(", ");
                t = t.next;           
            }
            while(t != head);
            System.out.println("]");
        }
    }

     public void displayB(){
        System.out.print("[");
        if(tail == null)
            System.out.println("E M P T Y   L I S T  !]");
        else{
            Node t = tail;
            do{
                System.out.print(t.data);
                if(t.pre != tail)
                	System.out.print(", ");
                t = t.pre;           
            }
            while(t != tail);
            System.out.println("]");
        }
    }
     
     public static void main(String[] args) {
 		DoubleCircularLinkedList<Integer> dcl = new DoubleCircularLinkedList();
 		
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
 				case 1->
 					dcl.displayF();
 				case 2->
 					dcl.displayB();
 				case 3->{
					System.out.println("Enter data: ");
					dcl.insertB(sc.nextInt());
				}
 				case 4->{
					System.out.println("Enter data: ");
					dcl.insertE(sc.nextInt());
				}
 				case 5->
 					dcl.deleteB();
 				case 6->
 					dcl.deleteE();
 				case 7->{
					System.out.println("Enter data: ");
 					dcl.insertA(sc.nextInt());
				}
 				case 8->
 					dcl.deleteA();
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
