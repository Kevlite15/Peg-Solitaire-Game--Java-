public class Board {
 private static final int SIDE = 10;
 private static final int SIDE2 = 1;
 
 private Peg[][] board;
 
 public Board(int row, int col) {
  board = new Peg[SIDE2][SIDE];
  for(int r = 0; r < SIDE; r++) {
   for(int c = 0; c < SIDE; c++) {
    if(r == row && c == col) {
     //DO NOTHING
    } else {
     board[r][c] = new Peg("" + r + (char)('A' + c));
    }
   }
  }
 }
 
 public void display() {
  for(int r = 0; r < SIDE; r++) {
   for(int c = 0; c < SIDE; c++) {
    if(board[r][c] != null) {
     System.out.print(board[r][c]);
    } else
    {
     System.out.print("__");
    }
   }
   System.out.println();
  }
 }
 
 private Integer getRow(String name) {
  for(int r = 0; r < SIDE; r++) {
   for(int c = 0; c < SIDE; c++) {
    if(board[r][c] != null && board[r][c].getName().equals(name)) {
     return r;
    }
   }
  }
  return null;
 }
 
 private Integer getColumn(String name) {
  for(int r = 0; r < SIDE; r++) {
   for(int c = 0; c < SIDE; c++) {
    if(board[r][c] != null && board[r][c].getName().equals(name)) {
     return c;
    }
   }
  }
  return null;
 }
 
 public boolean canJump(String name1, String name2) {
  
  if(name1.equals(name2)) return false; //a peg can't jump itself.
  
  Integer n1r = getRow(name1);
  Integer n1c = getColumn(name1);
  Integer n2r = getRow(name2);
  Integer n2c = getColumn(name2);
  
  if(n1r == null || n2r == null) {
   return false;
  }
  
  if(n1r == n2r) { //same row.
   int delta = n2c - n1c;
   if(Math.abs(delta) > 1) return false; //must be adjacent columns.
   int dest = n2c + delta; //this will be the destination column.
   if(dest < 0 || dest >= SIDE) {
    return false; //dest is out of bounds.
   }
   return board[n1r][dest] == null;
  }
  
  if(n1c == n2c) { //same column.
   int delta = n2r - n1r;
   if(Math.abs(delta) > 1) return false;
   int dest = n2r + delta;
   if(dest < 0 || dest >= SIDE) {
    return false;
   }
   return board[dest][n1c] == null;
  }
  
  return false; //no other conditions are jump conditions.
 }
 

 
 public boolean jump(String name1, String name2) {
  Integer n1r = getRow(name1);
  Integer n1c = getColumn(name1);
  Integer n2r = getRow(name2);
  Integer n2c = getColumn(name2);
  
  if(! canJump(name1, name2)) return false;
  Peg jumper = board[n1r][n1c];
  Peg jumpee = board[n2r][n2c];
  
  if(n1r == n2r) { //same row.
   int delta = n2c - n1c;
   int dest = n2c + delta; //this will be the destination column.
   
   board[n1r][n1c] = null;
   board[n2r][n2c] = null;
   board[n1r][dest] = jumper;
   
   return true;
  } else { //same column.
   int delta = n2r - n1r;
   int dest = n2r + delta;

   
   board[n1r][n1c] = null;
   board[n2r][n2c] = null;
   board[dest][n1c] = jumper;
   
   return true;
  }
 }
 
 public boolean hasNextMove() {
  for(int r = 0; r < SIDE; r++) {
   for(int c = 0; c < SIDE; c++) {
    for(int r2 = 0; r2 < SIDE; r2++) {
     for(int c2 = 0; c2 < SIDE; c2++) {
      String name1 = board[r][c] != null ? board[r][c].getName() : "";
      String name2 = board[r2][c2] != null ? board[r2][c2].getName() : "";
      if(canJump(name1, name2)) return true;
     }
    }
   }
  }
  return false;
 }
 
}