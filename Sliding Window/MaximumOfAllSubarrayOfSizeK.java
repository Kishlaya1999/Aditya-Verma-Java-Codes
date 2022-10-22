import java.util.ArrayList;

public class MaximumOfAllSubarrayOfSizeK {

     public static void main(String[] args) {

          int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
          int k = 3;
          ArrayList<Integer> ans = maximumOfAllSubarrayOfSizeK(arr, k);
          for (int i : ans) {
               System.out.print(i + " ");
          }

     }

     public static ArrayList<Integer> maximumOfAllSubarrayOfSizeK(int[] arr, int k) {

          ArrayList<Integer> ans = new ArrayList<>();
          ArrayList<Integer> list = new ArrayList<>();
          int i = 0;
          int j = 0;

          while (j < arr.length) {

               /*
                * Removing all the elements from the list which are smaller than arr[j]
                * since they won't be used later anytime becuase greater element than that has
                * came
                */
               while (list.size() > 0 && list.get(0) < arr[j]) {
                    list.remove(0);
               }
               // Now adding arr[j]
               list.add(arr[j]);

               if (j - i + 1 < k) {
                    j++;
               }
               // window size has reached
               else if (j - i + 1 == k) {
                    // always greatest element in the current window will be present in the front of
                    // the list
                    ans.add(list.get(0));

                    /*
                     * Before moving the ith pointer forward we move removing the calculations of i
                     */
                    /*
                     * if front element of the list is equal to ith element then removing it since
                     * now ith won't be presnt in the list after moving the pointer so removing it
                     */
                    if (list.get(0) == arr[i]) {
                         list.remove(0);
                    }

                    // moving the window forward
                    i++;
                    j++;

               }

          }

          return ans;
     }

}
