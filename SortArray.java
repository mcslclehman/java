
import java.util.Arrays;

public class SortArray {

  public static void main(String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < a.length; i++) {
      a[i] = (int) (Math.random() * 100);
    }
    Arrays.sort(a);
    System.out.println("Sorted array!");
    for (int i = 0; i < a.length; i++)
      System.out.println(a[i]);
  }
}
  
