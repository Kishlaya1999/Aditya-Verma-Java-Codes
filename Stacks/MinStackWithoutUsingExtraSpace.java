import java.util.Stack;

public class MinStackWithoutUsingExtraSpace {

     Stack<Integer> st = new Stack<>();
     int minElement = Integer.MIN_VALUE;

     public MinStackWithoutUsingExtraSpace() {
     }

     public void push(int val) {
          // if stack is empty then pushing the value in stack and updating the minElement
          // to val
          if (st.size() == 0) {
               st.push(val);
               minElement = val;
          } else { // otherwise
                   // if val >= minElement then pushing the val in stack and not updating the
                   // minElement
               if (val >= minElement) {
                    st.push(val);
               }
               // if val < minElement then pushing (2 x valueToBePushed - minElement) and
               // updating the minElement as value
               else if (val < minElement) {
                    st.push(2 * val - minElement);
                    minElement = val;
               }
          }
     }

     public int pop() {
          // storing minElement for further use
          int ans = minElement;
          if (st.size() == 0) {
               return -1;
          } else {
               // if top of stack is greater or equal to minElement then popping the top of
               // stack and returning it
               if (st.peek() >= minElement) {
                    return st.pop();
               }
               // if topOfStack is smaller than minElement then updaing the minElement to
               // previous minElement and popping the top of the stack
               else if (st.peek() < minElement) {
                    minElement = 2 * minElement - st.peek();
                    st.pop();
               }
          }
          return ans;
     }

     public int top() {
          if (st.size() == 0) {
               return -1;
          } else {
               // if topOfStack is greater or equal to minElement then return topOfStack
               if (st.peek() >= minElement) {
                    return st.peek();
               }
               // else returning the minElement
               else { // st.peek() < minElement
                    return minElement;
               }
          }
     }

     public int getMin() {
          if (st.size() == 0) {
               return -1;
          }
          return minElement;
     }

     public static void main(String[] args) {
          MinStackWithoutUsingExtraSpace st = new MinStackWithoutUsingExtraSpace();

          st.push(10);
          st.push(15);
          // st.push(7);
          // st.push(3);
          System.out.println(st.top());
          System.out.println(st.getMin());
     }

}
