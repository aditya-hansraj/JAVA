import java.util.*;

class Stack<T> {
    Scanner sc = new Scanner(System.in);
    int top;
    T[] ar;

    public Stack(int n) {
        top = -1;
        this.ar = (T[]) new Object[n];
    }

    public void push(T o) {
        if (isFull())
            return;
        else {
            ar[++top] = o;
            System.out.println("Pushed " + o);
        }
    }

    public void pop() {
        if (isEmpty())
            return;
        else {
            System.out.println("Popped " + ar[top]);
            ar[top--] = null;
        }
    }

    public void peek() {
        if (isEmpty())
            System.out.println("Stack is Empty !");
        else
            System.out.println(ar[top]);
    }

    public void display() {
        if (isEmpty())
            System.out.println("Stack is Empty !");
        else {
            int i = top;
            while (i >= 0) {
                System.out.println("|" + ar[i] + "|");
                i--;
            }
        }
    }

    public boolean isFull() {
        return top == ar.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void start() {
        while (true) {
            System.out.print("Enter your choice: ");
            char c = sc.next().charAt(0);
            switch (c) {
                case '1':
                    System.out.println("Enter element you want to push: ");
                    this.push(sc.next());
                    break;
                case '2':
                    this.pop();
                    break;
                case '3':
                    this.peek();
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

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the stack: ");
        int n = sc.nextInt();
        Stack<String> myStack = new Stack<>(n); // You can replace String with any other data type you want to use in the stack
        System.out.println("1->PUSH\n2->POP\n3->PEEK\n4->DISPLAY\n5->EXIT");
        myStack.start();
    }
}
