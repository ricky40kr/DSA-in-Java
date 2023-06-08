// Stack Implimentation

public class _45_Stack {
    int arr[];
    int capacity;
    int top;

    _45_Stack(int capacity) {
        this.capacity = capacity;
        top = -1;
        arr = new int[capacity];
    }

    void push(int val) {
        if (capacity <= top - 1) {
            System.out.println("OverFlow!");
            return;
        }
        arr[++top] = val;
        System.out.println("Pushed : " + val);
    }

    void pop() {
        if (top == -1) {
            System.out.println("UnderFlow!");
            return;
        }
        System.out.println("Popped : " + arr[top--]);
    }

    int peek() {
        try {
            return arr[top];
        } catch (Exception e) {
            System.out.println("UnderFlow");
            return top;
        }
    }

    boolean isEmpty() {
        return top == -1 ? true : false;
    }

    boolean isFull() {
        return capacity == top - 1 ? true : false;
    }

    int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        _45_Stack stk = new _45_Stack(10);

        int n = stk.peek();
        System.out.println(n);
        stk.push(10);
        stk.push(0);
        stk.push(50);
        stk.push(-1);
        stk.push(25);
        stk.pop();
        System.out.println(stk.size());
    }
}
