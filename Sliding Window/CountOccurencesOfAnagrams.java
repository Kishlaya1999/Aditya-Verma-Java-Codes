import java.util.HashMap;

public class CountOccurencesOfAnagrams {

     public static void main(String[] args) {
          String str1 = "forxxorfxdofr";
          String ptr1 = "for";
          String str2 = "aabaabaa";
          String ptr2 = "aaba";
          System.out.println(countOccurencesOfAnagrams(str1, ptr1));
     }

     public static int countOccurencesOfAnagrams(String str, String ptr) {

          // Map containing the count of every character in "ptr" string
          HashMap<Character, Integer> map = new HashMap<>();
          // creating the frequency map of "ptr" string
          for (int i = 0; i < ptr.length(); i++) {
               char ch = ptr.charAt(i);
               if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
               } else {
                    map.put(ch, 1);
               }
          }
          // Initializing count as the size of the map i.e number of distinct element
          int count = map.size();

          int ans = 0;
          int i = 0, j = 0;
          int k = ptr.length(); // window size as we have to search the substring of length k in "str"
          while (j < str.length()) {
               /* Calculations realated to j */
               // INCLUDING THE CALCULATIONS FOR jth term
               char ch = str.charAt(j);
               /* If map contains jth character in map */
               if (map.containsKey(str.charAt(j))) {
                    // then decreasing the count of jth element in the map
                    map.put(ch, map.get(ch) - 1);
                    /*
                     * checking if the jth element count in the map has become 0 if it has become 0
                     * the jth element is present in sufficient frequency in current window
                     * i.e equal to partter frequency
                     */
                    if (map.get(ch) == 0) {
                         count--;
                    }
               }

               // If the window is not crated then creting it by increasing the j till window
               // is maintained
               if (j - i + 1 < k) {
                    j++;
               }
               // if window is already created
               else if (j - i + 1 == k) {
                    /*
                     * If the count has become zero it means that all the elements in map has zero
                     * frequency and it is only possible when this window is the anagram of pattern
                     * Hence we count in the aswer
                     */
                    if (count == 0) {
                         ans++;
                    }
                    ch = str.charAt(i);
                    /*
                     * Excluding ith element it on the basis of condition
                     * so that we can move the window
                     * reversing the tasks which we did earlier while including jth element
                     */
                    if (map.containsKey(ch)) {
                         map.put(ch, map.get(ch) + 1);
                         if (map.get(ch) == 1) {
                              count++;
                         }
                    }
                    // Moving the window
                    i++;
                    j++;
               }
          }

          return ans;
     }

}
