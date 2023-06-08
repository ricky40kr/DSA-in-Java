class Dequex {
    static final int MAX = 100;
    int arr[];
    int front, rear, size;

    public Dequex(int size) {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }

    boolean isFull() {
        return front == (rear + 1) % size;

    }

    boolean isEmpty() {
        return front == -1;
    }

    void insertFront(int key) {
        if (isFull()) {
            System.out.println("OverFlow!");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            front = (front + size - 1) % size;
        }

        arr[front] = key;
    }

    void insertRear(int key) {
        if (isFull()) {
            System.out.println("OverFlow!");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        arr[rear] = key;
    }

    void deleteFront() {
        if (isEmpty()) {
            System.out.println("UnderFlow!");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    void deleteRear() {
        if (isEmpty()) {
            System.out.println("UnderFlow!");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear + size - 1) % size;
        }
    }

    int getFront() {
        if (isEmpty()) {
            System.out.println("Underflow!");
            return -1;
        }
        return arr[front];
    }

    int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Underflow!");
            return -1;
        }
        return arr[rear];
    }
}

public class _51_2_DequeImp {

    public static void main(String[] args) {
        Dequex q = new Dequex(5);

        q.deleteFront();
        q.deleteRear();
        q.insertRear(0);
        q.insertRear(1);
        q.insertRear(2);
        q.insertFront(3);
        System.err.println(q.getFront());
        System.err.println(q.getRear());
        q.deleteFront();
        System.err.println(q.getFront());
        q.deleteRear();
        System.err.println(q.getRear());

    }
}