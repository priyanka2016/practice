import java.util.*;
import java.util.Stack;

/**
 * Created by priyanka on 25/7/17.
 */
public class MyQueue {

    public static void main(String[] args) {
        java.util.Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(9);
        stack1.push(1);
        stack1.push(0);
        sortStack(stack1);
    }

    private static void sortStack(Stack<Integer> stack1) {
        java.util.Stack<Integer> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            if(stack2.isEmpty()){
                stack2.push(stack1.pop());
            }
            else {
                    if (stack1.peek() > stack2.peek()) {
                        int large = stack1.pop();
                        int count = 0;
                        while (!stack2.isEmpty()&&large>stack2.peek()) {
                            stack1.push(stack2.pop());
                            count++;
                        }
                        stack2.push(large);
                        while (count != 0) {
                            stack2.push(stack1.pop());
                            count--;
                        }
                    }
            }
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop());;
        }
    }
}
