//Kevin Singh
//Homework 1
//PegSolitaire.java
//Array List

import java.util.Scanner;

public class PegSolitaire{
  public static void main(String[] args) {
    int pos = 0;
    int count = 0;
    int[] pegBoard = new int[100];
    Scanner sc =  new Scanner(System.in);
    System.out.println("Please enter atmost 10 User Positions bewtween 0 - 99.");
    do{
      if(count == 10){
        System.out.println("You have entered the maximum number of Positions/Users.");
        break;
      }
      else{
        System.out.println("Please enter a Users position bewtween 0 - 99.(Enter -1 to exit)");
        pos = sc.nextInt();
        if(pos > 0){
          pegBoard[pos] = 1;
          count++;
        }
        else 
          System.out.println("Please do not enter Positions out side the given bounds.");
      }
    }
    while(pos != -1);  
  }
}

