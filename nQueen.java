package Backtracking;

public class nQueen {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }  

    static int queens(boolean[][] board,int row){
        if(row==board.length){
            display(board);
            System.out.println();
            return 1;
        }  
        int count = 0;
        // placing the queen and checking for every row and col
        for(int col = 0;col<board.length;col++){
            // place the queen if it is safe
            if(isSafe(board,row,col)){  // this means u can put queen 
                board[row][col] = true;
                count+= queens(board, row+1);
                board[row][col] = false;  // when u came out from fun call then change it
            }
        }  
        return count;
    } 

    private static void display(boolean[][] board) {
        for(boolean[] row : board){   // row of board 
            for(boolean element : row){   // elements of row
                if(element){
                 System.out.print("Q ");
                }  else{
                    System.out.print("X ");
                } 
        }  System.out.println();
    } 
 }

    private static boolean isSafe(boolean[][] board, int row, int col) {  // if it return true that means safe otherwise not safe
        // check vertical row
        for(int i =0;i<row;i++){
            if(board[i][col]){  // this means queen is there and this place is not safe for put queen in there
                return false;
            }
        }   

        // diagonal left 
        int maxLeft = Math.min(row,col);
        for(int i = 1;i<=maxLeft;i++){
            if(board[row-i][col-i]){  // this means queen is there and this place is not safe for put queen in there
                return false;
            }
        }
         // diagonal right 
        int maxRight = Math.min(row,board.length-col-1);  
        for(int i = 1;i<=maxRight;i++){
            if(board[row-i][col+i]){  // this means queen is there and this place is not safe for put queen in there
                return false;
            }
        } 
        // if none of these check return false this means that ans is true
         return true;
    }
}
