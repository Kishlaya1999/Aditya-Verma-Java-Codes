import java.util.ArrayList;

public class FirstNegativeIntegerInEveryWindowOfSizeK {
     public static void main(String[] args) {
          int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
          firstNegativeIntegerInEveryWindowOfSizeK_Optimized(arr, 3);
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

     public static void firstNegativeIntegerInEveryWindowOfSizeK_Optimized(int[] arr, int k) {

          // containing the -ve integers only
          ArrayList<Integer> list = new ArrayList<>();
          int i = 0;
          int j = 0;

          while (j < arr.length) {
               /*
                * We need to do the calculations realted to j here i.e. in this case if jth
                * index elemetnt is -ve then it can be the first -ve Integer for some window so
                * we add the jth element to the list if it is -ve
                */
               if (arr[j] < 0) {
                    list.add(arr[j]);
               }
               /*
                * Now we have to first create the window of size k so if window size is less
                * then increasing the size of window(by increasing j) till it becomes of size k
                */
               if (j - i + 1 < k) {
                    j++;
               }
               /* If the size of the window is already k tehn */
               else if (j - i + 1 == k) {
                    /*
                     * If list is of size 0 then it means there is no -ve Integer in this window
                     * so printing 0
                     */
                    if (list.size() == 0) {
                         System.out.print(0 + " ");
                    }
                    /* If list has some element */
                    else {
                         /*
                          * then printing the first element of list becuase it is the first -ve integer
                          * of this window
                          */
                         System.out.print(list.get(0) + " ");
                         /*
                          * Before moving the window we have to check that if first element of current
                          * window is equal to the first -ve integer in the list then it means that it
                          * will not be the first -ve integer in the future as well as we have already
                          * calculated for the current window so removing the first element of the list
                          */
                         if (arr[i] == list.get(0)) {
                              list.remove(0);
                         }
                    }
                    /* Moving the window forward */
                    i++;
                    j++;
               }
          }
     }
}