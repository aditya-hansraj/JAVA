import java.util.Scanner;

public class QD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        l.create();
        System.out.print("Enter position from backwards: ");
        System.out.println(l.nthFromLast(sc.nextInt()));
    }
}
class LinkedList{
    static Scanner sc = new Scanner(System.in);
    Node head;
    int size = 0;

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }

        Node(){
            System.out.print("Enter data: ");
            this.data = sc.nextInt();
            next = null;
        }
    }

    void create(){
        System.out.print("Do you want to add Nodes?(1/0): ");
        int c = sc.nextInt();

        if(c == 1){

            Node current = new Node();
            head = current;
            size++;

            System.out.print("Do you want to add more Nodes?(1/0): ");
            c = sc.nextInt();
            current = head;
            while(c != 0){
                current.next = new Node();
                current = current.next;
                size++;
                System.out.print("Do you want to add more Nodes?(1/0): ");
                c = sc.nextInt();
            }

            System.out.print("Do you want to list all Nodes?(1/0): ");
            c = sc.nextInt();
            if(c == 1){
                this.display();
            }
        }
    }

    void display(){
        if(size == 0){
            System.out.println("Empty List !");
            return;
        }
        Node i=head;
        while(i != null){
            System.out.print(i.data+" ");
            i=i.next;
        }
        System.out.println();
    }

    int nthFromLast(int pos){
        if(pos > size){
            System.out.println("Invalid Position !");
            return 0;
        }else{
            int n = size - pos + 1;
            int i = 1;
            Node current = head;

            while(current.next !=null && i<n){
                i++;
                current = current.next;
            }
            if(current == null)
                System.out.println("Number Not found !");
            else 
                return current.data;
        }
        return 0;
    }
}
