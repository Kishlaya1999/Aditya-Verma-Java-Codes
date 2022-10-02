import java.util.Stack;
// import javafx.util.Pair;

public class StockSpan {

     public static void main(String[] args) {
          int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
          int[] stockSpanArray = stockSpan(arr);

          for (int i : stockSpanArray) {
               System.out.print(i + " ");
          }
     }

     // Based on the next greater to left (NGL)
     private static int[] stockSpan(int[] arr) {
          // Creating a stack which will contain array
          // and the array will contain the NGL and its index [100,0],[80,1]......
          Stack<int[]> st = new Stack<>();
          // Creating the array answer which will contain index of the next greter to left
          // and we will create our own answer using next greater to left index and
          // current index
          int[] ans = new int[arr.length];
          int k = 0;
          for (int i = 0; i < arr.length; i++) {
               // if stack is empty it means NGL doesn't exist so inserting -1 for that index
               if (st.size() == 0) {
                    ans[k++] = -1;
               }
               // if stack is not empty and top of stack [0] i.e NGL is greater than arr[i]
               // then inserting NGL's index
               else if (st.size() > 0 && st.peek()[0] > arr[i]) {
                    ans[k++] = st.peek()[1];
               }
               // other wise popping the elements from the stack till we get the NGL and
               // repeting the above two operation (if , else if)
               else if (st.size() > 0 && st.peek()[0] <= arr[i]) {
                    while (st.size() > 0 && st.peek()[0] <= arr[i]) {
                         st.pop();
                    }
                    if (st.size() == 0) {
                         ans[k++] = -1;
                    } else {
                         ans[k++] = st.peek()[1];
                    }
               }
               // Before moving forward we insert the current value and its index for further
               // checking
               st.push(new int[] { arr[i], i });
          }
          // Creating the answer on the basis of the NGL index i.e finding the difference
          // of current index and NGL's index
          for (int i = 0; i < ans.length; i++) {
               ans[i] = i - ans[i];
          }
          return ans;
     }
}
