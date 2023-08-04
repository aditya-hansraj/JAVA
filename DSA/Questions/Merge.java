import java.util.Scanner;

class QB {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Node head1 = createList(1,3,5,6);
        Node head2 = createList(2,2,4,6,7);

        display(head1);
        display(head2);

        display(merge(head1, head2));

    }
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }

        Node(){}
    }
    
    static Node createList(int...ar){
        Node head = new Node(ar[0]);
        Node temp = head;
        for(int i=1;i<ar.length;i++){
            temp.next = new Node(ar[i]);
            temp = temp.next;
        }
        return head;
    }

    static Node merge(Node head1,Node head2){
        Node head = new Node();
        head.data = (head1.data<=head2.data)?head1.data:head2.data;
        head.next = new Node();
        head.next.data = (head1.data<=head2.data)?head2.data:head1.data;
        Node temp = head.next;
        head1 = head1.next;
        head2 = head2.next;
        while(head1 != null && head2 != null){
            int data1 = (head1.data<=head2.data)?head1.data:head2.data;
            int data2 = (head1.data<=head2.data)?head2.data:head1.data;

            temp.next = new Node(data1);
            temp = temp.next;
            temp.next = new Node(data2);
            temp = temp.next;

            head1 = head1.next;
            head2 = head2.next;
        }
        temp.next = (head1 == null)?head2:head1;
        
        return head;
    }

    static void display(Node head){
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
}
