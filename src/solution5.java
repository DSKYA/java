/**
 * Created by cxj on 17-3-24.
 */
import java.util.Stack;
public class solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while(!stack1.empty()){
            int tmp;
            tmp = stack1.pop();
            stack2.push(tmp);
        }
        stack1.push(node);
        while(!stack2.empty()){
            int tmp = stack2.pop();
            stack1.push(tmp);
        }
    }

    public int pop() {
        return stack1.pop();
    }
}
