import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumTwoPointer {
  private ThreeSumTwoPointer() { }

  public static int count(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = 0; i< nums.length && nums[i] <= 0; i++) {
      if (i == 0 || nums[i - 1] != nums[i]) {
        int low = i + 1, high = nums.length - 1;
        while (low < high) {
          int sum = nums[i] + nums[low] + nums[high];
          if (sum < 0 || (nums[low] == nums[low - 1] && low > i + 1)) {
            low++;
          } else if (sum > 0 || (high < nums.length - 1 && nums[high] == nums[high + 1])) {
            high--;
          } else {
            count++;
          }
        }
      }
    }
    return count;
  }

  private static boolean containsDuplicates(int[] a) {
    for (int i = 1; i < a.length; i++)
      if (a[i] == a[i-1]) return true;
    return false;
  }

  public static void printAll(int[] a) {
    int n = a.length;
    Arrays.sort(a);
    if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        int k = Arrays.binarySearch(a, -(a[i] + a[j]));
        if (k > j) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
      }
    }
  }

  public static void main(String[] args)  {
//    In in = new In(args[0]);
    int[] a = {-10, -7, -1, -2, 0, 2, 1, 4, 6, 9, 10};
    Stopwatch timer = new Stopwatch();
    int count = count(a);
    StdOut.println("elapsed time = " + timer.elapsedTime());
    System.out.println(count);
  }
}

