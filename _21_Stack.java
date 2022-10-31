class stack {
    private int arr[];
    private int top = -1;
    private int capacity = 0;

    stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack OverFlow!");
        } else {
            arr[++top] = x;
            System.out.println("Inserted : " + x);
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("No element in array to push !");
        } else {
            System.out.println("Pushed : " + arr[top]);
            top--;
        }
    }

    public void peek(int inx) {
        if (inx <= (-1) && inx >= top) {
            System.out.println("No element at given index!");
        } else {
            System.out.println("Peeking " + inx + " position : " + arr[top - inx + 1]);
        }
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

public class _21_Stack {
    public static void main(String[] args) {
        stack s = new stack(15);
        s.push(0);
        s.push(105);
        s.push(205);
        s.push(-9);
        s.push(6);
        s.printStack();
        s.pop();
        s.pop();
        s.printStack();
        s.peek(2);
        s.printStack();

    }
}
