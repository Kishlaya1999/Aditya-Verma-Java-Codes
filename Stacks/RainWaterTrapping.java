public class RainWaterTrapping {

     public static void main(String[] args) {
          int[] arr = { 3, 0, 0, 2, 470, 4 };
          System.out.println(rainWaterTrapping(arr));
     }

     private static int rainWaterTrapping(int[] arr) {

          int[] maxInLeft = new int[arr.length];
          int[] maxInRight = new int[arr.length];

          maxInLeft[0] = arr[0];
          for (int i = 1; i < arr.length; i++) {
               maxInLeft[i] = Math.max(maxInLeft[i - 1], arr[i]);
          }

          maxInRight[arr.length - 1] = arr[arr.length - 1];
          for (int i = arr.length - 2; i >= 0; i--) {
               maxInRight[i] = Math.max(maxInRight[i + 1], arr[i]);
          }

          int[] water = new int[arr.length];
          for (int i = 0; i < water.length; i++) {
               water[i] = Math.min(maxInLeft[i], maxInRight[i]) - arr[i];
          }

          int amoutOfWater = 0;
          for (int i = 0; i < water.length; i++) {
               amoutOfWater += water[i];
          }

          return amoutOfWater;
     }

}
