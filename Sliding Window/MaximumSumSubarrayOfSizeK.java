// Fixed Size Window

// Time Complexity : O(n)
// Space Complexity : O(1)
public class MaximumSumSubarrayOfSizeK {

     public static void main(String[] args) {
          int[] arr = { 2, 5, 1, 8, 2, 9, 1 };
          int k = 3;
          System.out.println(maximumSumSubarrayOfSizeK(arr, k));
     }

     public static int maximumSumSubarrayOfSizeK(int[] arr, int k) {
          // initializing both the pointer with 0
          int i = 0; // Start of the window
          int j = 0; // End of the window
          int sum = 0; // sum always contains the sum of the window
          int max = -1; // Maximum sum of windows uptil now
          while (j < arr.length) {
               // Till now there is sum of the only first two element of current window
               // Adding the new element that has just came in the window
               sum = sum + arr[j];
               // Only runs till the window is not formed
               if (j - i + 1 < k) {
                    j++; // increasing the size of the window till window is formed
               } else if (j - i + 1 == k) { // exucutes when the window is already fromed
                    // comparing the previous sum with the max sum uptil now and assigning the max
                    // out of two
                    max = Math.max(max, sum);
                    // Removing the first element of the window from the sum
                    // Before moving the pointer removing the first element of the previous window
                    sum = sum - arr[i];
                    // Moving the window by one place
                    i++;
                    j++;
               }
          }
          // returning the max of all the window sums
          return max;
     }

}