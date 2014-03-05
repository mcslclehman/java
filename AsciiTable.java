/*
Java Programming for Engineers
Julio Sanchez
Maria P. Canton


ISBN: 0849308100
Publisher: CRC Press
*/


// File name: AsciiTable.java
//Reference: Chapter 11
//
//Java program to demonstrate looping
//Topics:
// 1. Using several loop constructs simultaneously
// 2. Nested loops
//
public class AsciiTable {
  public static void main(String[] args) {
    // Local variables
    char hexLetter; // For table header
    char ascCode = 0x20; // First ASCII code
    // Counters for rows and columns
    int row = 2;
    int column;

    System.out.print("\n\n");
    System.out.print("                             ");
    System.out.println("ASCII CHARACTER TABLE");
    System.out.print("                            ");
    System.out.println("characters 0x20 to 0xff");
    System.out.print("\n    ");

    // Loops 1 and 2
    // Display column heads for numbers 0 to F hexadecimal
    for (hexLetter = '0'; hexLetter <= '9'; hexLetter++)
      System.out.print("   " + hexLetter);
    for (hexLetter = 'A'; hexLetter <= 'F'; hexLetter++)
      System.out.print("   " + hexLetter);

    // Blank line to separate table head from data
    System.out.println("\n");

    // Loop 3
    // While ASCII codes smaller than 0x80 display row head
    // and leading spaces
    // Loop 4 (nested in loop 3)
    // Display row of ASCII codes for columns 0 to 0x0F.
    // Add a new line at end of each row
    while (ascCode < 0x80) {
      System.out.print("   " + row);
      for (column = 0; column < 16; column++) {
        System.out.print("   " + ascCode);
        ascCode++;
      }
      System.out.print("\n\n");
      row++;
    }
  }
}


           
