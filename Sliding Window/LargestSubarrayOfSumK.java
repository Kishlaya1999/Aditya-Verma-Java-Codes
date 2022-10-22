public class LargestSubarrayOfSumK {

     public static void main(String[] args) {
          int[] arr = { 4, 1, 1, 1, 2, 3, 5 };
          int sumK = 5;
          System.out.println(largestSubarrayOfSumK(arr, sumK));
     }

     private static int largestSubarrayOfSumK(int[] arr, int k) {
          int max = Integer.MIN_VALUE;
          int sum = 0;
          int i = 0;
          int j = 0;
          while (j < arr.length) {
               // Calculation for jth element
               // Adding the jth element
               sum = sum + arr[j];

               // if sum is not reached yet then we increase j so that we can get higher value
               // of sum
               if (sum < k) {
                    j++;
               }
               /*
                * if sum is found in the window then we compare the previous and current window
                * size and assign the larger window size in max
                */
               else if (sum == k) {
                    max = Math.max(max, j - i + 1);
                    j++;
               }
               /*
                * If sum is increased then increasing i pointer and subtracting ith element
                * form sum till we get sum lesser of equal to k
                */
               else if (sum > k) {
                    while (sum > k) {
                         sum = sum - arr[i];
                         i++;
                    }
                    j++;
               }

          }

          return max;
     }
}
