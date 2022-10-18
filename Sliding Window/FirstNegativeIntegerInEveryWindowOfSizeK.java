public class FirstNegativeIntegerInEveryWindowOfSizeK {
     public static void main(String[] args) {
          int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
          firstNegativeIntegerInEveryWindowOfSizeK_Brute_Force(arr, 3);
     }

     public static void firstNegativeIntegerInEveryWindowOfSizeK_Brute_Force(int[] arr, int k) {

          // iterating the i form 0 to arr.length - k so that j doesn't get out of index
          // since j is iterating from i to j + k - 1
          for (int i = 0; i <= arr.length - k; i++) {
               for (int j = i; j <= i + k - 1; j++) {
                    // As soon as we get first -ve in window we break the loop
                    if (arr[j] < 0) {
                         System.out.print(arr[j] + " ");
                         break;
                    }
                    // if arr[j] is the last element of the window and still we didn't got any -ve
                    // integer then we print 0
                    if (j - i + 1 == k) {
                         System.out.print(0 + " ");
                    }
               }
          }
     }
}
