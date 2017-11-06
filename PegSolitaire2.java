import java.util.Scanner;


public class PegSolitaire {
 public static void main(String[] args) {
  Board b = new Board(2, 2);
  b.display();
  
  Scanner input = new Scanner(System.in);
  
  System.out.print("Enter choice: ");
  String line = input.nextLine();
  while(b.hasNextMove())
  {
   if(line.equals("exit")) {
    return;  //quit the program.
   } else if(line.equals("jump")) {
    System.out.print("Enter jumper's name: ");
    String name1 = input.nextLine().trim();
    System.out.print("Enter jumpee's name: ");
    String name2 = input.nextLine().trim();
    boolean success = b.jump(name1, name2);
    if(! success) {
     System.out.println("***Illegal jump: " + name1 + " can't jump " + name2);
    }
   } else if(line.equals("testjump")) {
    System.out.print("Enter jumper's name: ");
    String name1 = input.nextLine().trim();
    System.out.print("Enter jumpee's name: ");
    String name2 = input.nextLine().trim();
    boolean success = b.canJump(name1, name2);
    if(! success) {
     System.out.println(name1 + " can't jump " + name2);
    } else {
     System.out.println(name1 + " can jump " + name2);
    }
   }
   b.display();
   System.out.print("Enter choice: ");
   line = input.nextLine();
  }
  
 }
}