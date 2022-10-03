import java.util.Stack;

public class MaximumAreaOfHistogram {

     public static void main(String[] args) {
          int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
          System.out.println(maximumAreaOfHistogram(arr));
     }

     static int maximumAreaOfHistogram(int[] height) {

          int[] NSLindex = nearestSmallestToLeftIndex(height);
          int[] NSRindex = nearestSmallestToRightIndex(height);
          int[] width = new int[height.length];

          for (int i = 0; i < height.length; i++) {
               width[i] = NSRindex[i] - NSLindex[i] - 1;
          }

          int[] area = new int[height.length];
          for (int i = 0; i < height.length; i++) {
               area[i] = width[i] * height[i];
          }

          int max = -1;
          for (int i = 0; i < width.length; i++) {
               max = Math.max(max, area[i]);
          }
          return max;
     }

     private static int[] nearestSmallestToRightIndex(int[] height) {
          Stack<int[]> st = new Stack<>();
          int[] ans = new int[height.length];
          int k = height.length - 1;
          int psudo_index = height.length;

          for (int i = height.length - 1; i >= 0; i--) {
               if (st.size() == 0) {
                    ans[k--] = psudo_index;
               } else if (st.size() > 0 && st.peek()[0] < height[i]) {
                    ans[k--] = st.peek()[1];
               } else if (st.size() > 0 && st.peek()[0] >= height[i]) {
                    while (st.size() > 0 && st.peek()[0] >= height[i]) {
                         st.pop();
                    }
                    if (st.size() == 0) {
                         ans[k--] = psudo_index;
                    } else {
                         ans[k--] = st.peek()[1];
                    }
               }
               st.push(new int[] { height[i], i });
          }

          return ans;
     }

     private static int[] nearestSmallestToLeftIndex(int[] height) {
          Stack<int[]> st = new Stack<>();
          int[] ans = new int[height.length];
          int k = 0;
          int psudo_index = -1;

          for (int i = 0; i < height.length; i++) {
               if (st.size() == 0) {
                    ans[k++] = psudo_index;
               } else if (st.size() > 0 && st.peek()[0] < height[i]) {
                    ans[k++] = st.peek()[1];
               } else if (st.size() > 0 && st.peek()[0] >= height[i]) {
                    while (st.size() > 0 && st.peek()[0] >= height[i]) {
                         st.pop();
                    }
                    if (st.size() == 0) {
                         ans[k++] = psudo_index;
                    } else {
                         ans[k++] = st.peek()[1];
                    }
               }
               st.push(new int[] { height[i], i });
          }

          return ans;
     }

}
