import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Integer[] numbers = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };

    List list = Arrays.asList(numbers);

    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
  }
}
