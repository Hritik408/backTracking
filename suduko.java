package Backtracking;


public class suduko {
    public static void main(String[] args) {
        int[][] board = new int[][]{
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(solve(board)){
            display(board);
        } else{
            System.out.println("sudoko can't solve");
        }
    }
    static boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;  // some empty element is present
        
        // this is how we are replacing r,c with argument
         for(int i=0;i<n;i++){
            for(int j= 0;j<n;j++){
                if(board[i][j]==0){
                    row = i;
                    col = j;
                    emptyLeft = false;   // no empty places are left
                    break;
                }
            }   // if u found some of the element in the row then break  
               if(emptyLeft == false){
                break;
            }
        }   
            if(emptyLeft == true){
                return true;
                // sudoko is solved
            }     
            // backtraking
            for(int number = 1;number<=9;number++){
                if(isSafe(board, row, col, number)){
                    board[row][col] = number;
                    if(solve(board)){
                        // found the answer
                        display(board);
                        return true;
                    } 
                    else{
                        // backtracking
                        board[row][col]=0;
                    }
                }
            }
            return false;  
    }
    private static void display(int[][] board) {
        for(int[] row : board){
            for(int element : row){
                System.out.println(element + " ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][] board,int row,int col,int num){
        // check for rows
        for(int i=0;i<board.length;i++){
            // check if the number is in the row
            if(board[i][col]==num){
                return false;
            }
        }
        // check for cols
          for(int i=0;i<board.length;i++){
            // check if the number is in the col
            if(board[row][i]==num){
                return false;
            }
        }
        // cleck for particular 9 boxes matrix 
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - (row % sqrt);
        int colStart = col- (col % sqrt);

        for(int r = rowStart;r<rowStart+sqrt;r++){
            for(int c = colStart;c<colStart+sqrt;c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }   
        return true;
    }
}
