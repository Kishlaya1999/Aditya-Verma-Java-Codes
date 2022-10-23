import java.util.HashMap;

public class PickToys {
     public static void main(String[] args) {
          String str = "abaccab";
          System.out.println(pickToys(str));
     }

     private static int pickToys(String str) {
          HashMap<Character, Integer> map = new HashMap<>();
          int longest = 0;
          int i = 0;
          int j = 0;
          while (j < str.length()) {
               /*
                * if current character is in the map then increase its count
                * if not present in map then put it in map and set its count to 1
                */
               map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

               /*
                * If only one type of toy is present then also he will pick all the toys presnt
                */
               if (map.size() <= 2) {
                    longest = Math.max(longest, j - i + 1);
                    j++;
               }
               /*
                * If type of toy is increased then removing the toy from the beginning so that
                * he can take maximum toy and also takes only two types of toy
                */
               else if (map.size() > 2) {
                    while (map.size() > 2) {
                         if (map.containsKey(str.charAt(i))) {
                              map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                         }
                         if (map.get(str.charAt(i)) == 0) {
                              map.remove(str.charAt(i));
                         }
                         i++;
                    }
                    j++;
               }
          }
          return longest;
     }
}
