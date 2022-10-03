public class MaximumAreaOfRectangleInBinaryMatrix {

     public static void main(String[] args) {
          int[][] arr = {
                    { 0, 1, 1, 0 },
                    { 1, 1, 1, 1 },
                    { 1, 1, 1, 1 },
                    { 1, 1, 0, 0 }
          };

          System.out.println(maximumAreaOfRectangleInBinaryMatrix(arr));
     }

     private static int maximumAreaOfRectangleInBinaryMatrix(int[][] arr) {
          int n = arr.length;
          int m = arr[0].length;
          int[] height = new int[m];

          // Copying the first row of the array
          for (int j = 0; j < m; j++) {
               height[j] = arr[0][j];
          }

          // initializing the max with maximum area that can be obtained from 1st row
          // histogram
          int max = MaximumAreaOfHistogram.maximumAreaOfHistogram(height);

          // finding the maximum area of histogram if all the rows are included

          for (int i = 0; i < n; i++) {
               for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) {
                         height[j] = 0;
                    } else {
                         height[j] = height[j] + arr[i][j];
                    }
               }
               max = Math.max(max, MaximumAreaOfHistogram.maximumAreaOfHistogram(height));
          }

          return max;
     }

}