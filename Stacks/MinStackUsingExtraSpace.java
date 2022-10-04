import java.util.Stack;

public class MinStackUsingExtraSpace {

     Stack<Integer> st = new Stack<>();
     Stack<Integer> ss = new Stack<>();

     public MinStackUsingExtraSpace() {

     }

     public void push(int val) {
          if (st.isEmpty() || (!ss.isEmpty() && val < ss.peek())) {
               ss.push(val);
          }
          st.push(val);
     }

     public void pop() {
          if (!ss.isEmpty() && st.pop().intValue() == ss.peek().intValue()) {
               ss.pop();
          }
     }

     public int top() {
          return st.peek();
     }

     public int getMin() {
          return ss.peek();
     }

     public static void main(String[] args) {
          MinStackUsingExtraSpace st = new MinStackUsingExtraSpace();
          st.push(5);
          st.push(2);
          st.pop();
          System.out.println(st.getMin());
     }
}
