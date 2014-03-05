import java.util.Scanner;

public class MainClass {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int bank = 1000;
    int bet;

    do {
      System.out.print("Enter your bet: ");
      bet = sc.nextInt();
    } while ((bet <= 0) || (bet > bank));
  }
}
