import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        if (empty()) {
            q1.add(x);
        } else if (q1.isEmpty()) {
            q2.add(x);
        } else  if (q2.isEmpty()) {
            q1.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!empty()) {
            if (q1.isEmpty()) {
                while (q2.size() != 1) {
                    q1.add(q2.poll());
                }

                q2.poll();
                return;
            }

            if (q2.isEmpty()) {
                while (q1.size() != 1) {
                    q2.add(q1.poll());
                }

                q1.poll();
                return;
            }
        }
    }

    // Get the top element.
    public int top() {
        if (!empty()) {

            if (q1.isEmpty()) {
                while (q2.size() != 1) {
                    q1.add(q2.poll());
                }

                int temp = q2.peek();
                q1.add(temp);
                q2.poll();
                return temp;

            }


            if (q2.isEmpty()) {
                while (q1.size() != 1) {
                    q2.add(q1.poll());
                }

                int temp = q1.peek();
                q2.add(temp);
                q1.poll();
                return temp;
            }

        }
        return -1;

    }

    // Return whether the stack is empty.

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        myStack.push(3);
        System.out.println(myStack.top());


    }
}