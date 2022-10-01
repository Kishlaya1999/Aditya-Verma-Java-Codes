import java.util.Stack;

public class NearestGreaterToRight {

     public static void main(String[] args) {
          int[] arr = { 1, 3, 2, 4 };
          int[] ngr = NGR(arr);

          for (int i : ngr) {
               System.out.print(i + " ");
          }
     }

     private static int[] NGR(int[] arr) {
          Stack<Integer> st = new Stack<>();
          int[] ans = new int[arr.length];
          int k = arr.length - 1;

          for (int i = arr.length - 1; i >= 0; i--) {
               if (st.size() == 0) {
                    ans[k--] = -1;
               } else if (st.size() > 0 && st.peek() > arr[i]) {
                    ans[k--] = st.peek();
               } else if (st.size() > 0 && st.peek() <= arr[i]) {
                    while (st.size() > 0 && st.peek() <= arr[i]) {
                         st.pop();
                    }
                    if (st.size() == 0) {
                         ans[k--] = -1;
                    } else {
                         ans[k--] = st.peek();
                    }
               }
               st.push(arr[i]);
          }

          return ans;
     }

}