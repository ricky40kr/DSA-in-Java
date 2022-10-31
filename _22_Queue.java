class queue {
    int arr[];
    int front, rear;

    queue(int size) {
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return (front == 0 && rear == arr.length - 1);
    }

    boolean isEmpty() {
        return (front == -1);
    }

    public void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is Full !");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            arr[rear] = element;
            System.out.println(element + " is inserted !");
        }
    }

    public void deQueue() {
        int element = 0;
        if (isEmpty()) {
            System.out.println("Queue is Empty !");
        } else {
            element = arr[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
        }
        System.out.println("Deleted : " + element);
    }

    public void display() {
        if (front != -1) {
            for (int i = rear; i >= front; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Empty Queue !");
        }
    }

}

public class _22_Queue {
    public static void main(String[] args) {
        queue q = new queue(8);
        q.display();
        q.enQueue(5);
        q.enQueue(-100);
        q.enQueue(0);
        q.display();
        q.deQueue();
        q.display();
    }

}
