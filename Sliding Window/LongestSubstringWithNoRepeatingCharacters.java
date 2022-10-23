import java.util.HashMap;

public class LongestSubstringWithNoRepeatingCharacters {

     public static void main(String[] args) {
          String str = "pwwkew";
          System.out.println(longestSubstringWithNoRepeatingCharacters(str));
     }

     private static int longestSubstringWithNoRepeatingCharacters(String str) {

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

               /*
                * This condition would be never executed because there can never be more unique
                * characters than the hashmap size
                * for example : if window size is 3 then there can't be more than 3 characters
                * which are unique
                * it is never possible that there are 4 unique charcter in window size of 3
                * so discarding this condition
                */
               // if (map.size() > j - i + 1) {
               // j++;
               // }

               /*
                * If hashmap size is equal to window size (substring) then all the elemets
                * present in the window would be unique
                */
               if (map.size() == j - i + 1) {
                    longest = Math.max(longest, j - i + 1);
                    j++;
               }
               /*
                * If map size is less than window size then it means there is one of
                * the character which is reapeated so removing those repeated characters
                */
               else if (map.size() < j - i + 1) {
                    // Remove the Calculation for i
                    while (map.size() < j - i + 1) {

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
