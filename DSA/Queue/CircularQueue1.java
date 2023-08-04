import java.util.Scanner;

class Queue<T>{
	T[] ar;
	private int front;
    private int rear;
    private int size;

	Queue(int size){
		 ar = (T[]) new Object[size];
		 front = 0;
		 rear = -1;
		 size = 0;
	}

	boolean isFull(){
		return size == ar.length;
	}

	boolean isEmpty(){
		return size == 0;
	}

	void enQueue(T data){
		if(isFull()){
			System.out.println("Queue is Full !");
			return;
		}
		rear = (rear + 1) % ar.length; //  used for circular Queue
		ar[rear] = data;
		size++;
	}

	T deQueue(){
		if(isEmpty()){
			System.out.println("Queue is Empty !");
			return null;
		}
		T i = ar[front];
		front = (front + 1) % ar.length;
		size --;
		return i;
	}

	T peek(){
		if(isEmpty()){
			System.out.println("Queue is Empty !");
			return null;
		}
		return ar[front];
	}

	void display(){
		if(isEmpty()){
			System.out.println("Queue is Empty !");
		}
		else{
			int count = 0;
			int i = front;
			while(count < size){
				System.out.print(ar[i]+" ");
				i = (i + 1) % size;
				count++;
			}
			System.out.println();
		}
	}

}

class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Queue size: ");
		Queue<Integer> queue = new Queue<>(sc.nextInt());
		System.out.println("1.EnQueue\n2.deQueue\3.Peek\n4.Display\n5.Exit");
		while(true){
			System.out.print("Enter Choice: ");
			switch(sc.nextInt()){
				case 1:
					System.out.println("Enter Element to EnQueue: ");
					queue.enQueue(sc.nextInt());
					break;
				case 2:
					System.out.println("DeQueued "+queue.deQueue());
					break;
				case 3: 
					System.out.println("Front: "+queue.peek());
					break;
				case 4:
					queue.display();
					break;
				case 5:
					System.out.println("Program End !");
					System.exit(0);
			}
		}
	}
}
