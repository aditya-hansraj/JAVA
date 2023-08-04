import java.util.Scanner;

class Stack<T> {
    static Scanner sc = new Scanner(System.in);
    Node top;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    Stack() {
        top = null;
    }

    void push(T data) {
        Node newNode = new Node(data);
        if (newNode == null)
            System.out.println("Stack Overflow !");
        else if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    T pop() {
        if (top == null) {
            System.out.println("Stack Underflow !");
            return null;
        } else {
            T x = top.data;
            top = top.next;
            return x;
        }
    }

    T peek() {
        if (top == null) {
            System.out.println("Stack Underflow !");
            return null;
        } else
            return top.data;
    }

    void display() {
        if (top == null) {
            System.out.println("Stack Underflow !");
            return;
        }
        Node i = top;
        while (i != null) {
            System.out.println("|" + i.data + "|");
            i = i.next;
        }
    }

    public void start() {
        while (true) {
            System.out.print("Enter your choice: ");
            char c = sc.next().charAt(0);
            switch (c) {
                case '1':
                    System.out.println("Enter element you want to push: ");
                    this.push(sc.nextInt());
                    break;
                case '2':
                    System.out.println("Popped " + this.pop());
                    break;
                case '3':
                    System.out.println(this.peek());
                    break;
                case '4':
                    this.display();
                    break;
                case '5':
                    System.out.println("Process End !");
                    return;
                default:
                    System.out.println("Invalid Input !");
                    this.start();
            }
        }
    }
}

public class StackByLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> myStack = new Stack<>();
        System.out.println("1->PUSH\n2->POP\n3->PEEK\n4->DISPLAY\n5->EXIT");
        myStack.start();
    }
}
