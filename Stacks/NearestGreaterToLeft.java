import java.util.Stack;

public class NearestGreaterToLeft {

     public static void main(String[] args) {
          int[] arr = { 1, 3, 2, 4 };
          int[] ngl = NGL(arr);

          for (int i : ngl) {
               System.out.print(i + " ");
          }
     }

     private static int[] NGL(int[] arr) {
          Stack<Integer> st = new Stack<>();
          int[] ans = new int[arr.length];
          int k = 0;

          for (int i = 0; i < arr.length; i++) {
               if (st.size() == 0) {
                    ans[k++] = -1;
               } else if (st.size() > 0 && st.peek() > arr[i]) {
                    ans[k++] = st.peek();
               } else if (st.size() > 0 && st.peek() <= arr[i]) {
                    while (st.size() > 0 && st.peek() <= arr[i]) {
                         st.pop();
                    }
                    if (st.size() == 0) {
                         ans[k++] = -1;
                    } else {
                         ans[k++] = st.peek();
                    }
               }
               st.push(arr[i]);
          }

          return ans;
     }

}