import java.util.HashMap;

public class LongestSubstringWithkUniqueCharacters {

     public static void main(String[] args) {
          String str = "aabacbebebe";
          int k = 3;
          System.out.println(longestSubstringWithkUniqueCharacters(str, k));
     }

     private static int longestSubstringWithkUniqueCharacters(String str, int k) {

          HashMap<Character, Integer> map = new HashMap<>();
          int longest = 0;
          int i = 0;
          int j = 0;
          while (j < str.length()) {
               // Calculation for jth element
               char ch = str.charAt(j);
               if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
               } else {
                    map.put(ch, 1);
               }

               if (map.size() < k) {
                    j++;
               }

               else if (map.size() == k) {
                    longest = Math.max(longest, j - i + 1);
                    j++;
               }

               else if (map.size() > k) {
                    // Remove the Calculation for i
                    while (map.size() > k) {

                         ch = str.charAt(i);
                         if (map.containsKey(ch)) {
                              map.put(ch, map.get(ch) - 1);
                         }
                         if (map.get(ch) == 0) {
                              map.remove(ch);
                         }
                         i++;
                    }
                    j++;
               }
          }

          return longest;
     }

}
