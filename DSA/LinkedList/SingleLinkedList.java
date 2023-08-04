
import java.util.Scanner;

class SingleLinkedList<T>{
    Node head=null;
    static Scanner sc = new Scanner(System.in);
    // Node tail=null;
    class Node<T>{    // head.next=tail;
        T data;
        Node next;
    
        Node(){
            
        }
        Node(T data){
            this.data=data;
            next=null;
        }
    }

    void insertAtEnd(T data){
        Node<T> newNode=new Node<>(data);
        Node i=new Node();
        if(head == null){
            head=newNode;
        }else{
            i=head;
            while(i.next != null){
                i=i.next;
            }
        } 
        i.next=newNode;
    }

    void insertAtStart(T data) {
        Node<T> newNode=new Node<>(data);
        newNode.next=head;
        head=newNode;
    }

    void deleteFromStart(){
        if(head==null){
            System.out.println("Empty List !");
        }else{
            System.out.println("Deleted "+head.data);
            head=head.next;
        }
    }

    void deleteFromEnd(){
        if(head==null){
            System.out.println("Empty List !");
        }else if(head.next==null){
            System.out.println("Deleted "+head.data);
            head=null;
        }else{
            Node current = head;
            while(current.next.next != null){
                current=current.next;
            }
            System.out.println("Deleted "+current.next.data);
            current.next=null;
        }
    }

    void display(){       
        if(head==null){
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


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SingleLinkedList<Integer> l1=new SingleLinkedList<>();
        System.out.println("1->InsertAtStart\n2->InsertAtEnd\n3->DeleteFromStart\n4->DeletefromEnd\n5->Display");
        while(true){
            System.out.print("Enter Your Choice: ");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Data To Add At Start: ");
                    l1.insertAtStart(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter Data To Add At End: ");
                    l1.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    l1.deleteFromStart();
                    break;
                case 4:
                    l1.deleteFromEnd();
                    break;
                case 5:
                    l1.display();
                    break;
                default:
                    System.out.println("Exit ! ");
                    System.exit(0);
            }
        }
    }
    

}
