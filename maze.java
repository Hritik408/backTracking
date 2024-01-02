package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class maze {
    public static void main(String[] args) {
     //   System.out.println(count(3, 3));
   //     path(" ",3,3);
    //    System.out.println(pathret(" ",3,3));  
   //     System.out.println(pathdig(" ",3,3));  // here dig is diagonal
        boolean[][]  board = {
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
         boolean[][]  goat = {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };  
        int[][] path = new int[goat.length][goat[0].length];
    //    pathalldirection("", board,0, 0);
   //     pathalldirprint("",goat, 0, 0);
        pathalldirprint("",goat,0,0,path,1);
    }  
    static int count(int l, int r){
        if(l==1||r==1){
            return 1;
        } 
        int left = count(l-1, r);
        int right = count(l,r-1);
        return left + right;
    }   

    static void path(String p,int l, int r){
        if(l==1&&r==1){
            System.out.println(p);
            return;
        }  
        if(r>1){
            path(p+'r', l, r-1);
        }  
        if(l>1){
            path(p+'d', l-1, r);
        }
    }  

    static ArrayList<String> pathret(String p, int l, int r){
        if(l==1 && r==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }  
        ArrayList<String> list = new ArrayList<>();
        if(l>0){
            list.addAll(pathret(p+"d", l-1, r));
        } 
        if(r>0){
            list.addAll(pathret(p+"r", l, r-1));
        }  
        return list;
    }  

      static ArrayList<String> pathdig(String p, int l, int r){  // l=r r=c
        if(l==1 && r==2){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }  
        ArrayList<String> list = new ArrayList<>();
        if(r>0&&l>0){
            list.addAll(pathdig(p+"Digonal", l-1, r-1));
        }
        if(l>0){
            list.addAll(pathdig(p+"Down", l-1, r));
        } 
        if(r>0){
            list.addAll(pathdig(p+"Left", l, r-1));
        }  
        return list;
    }  

    static void pathalldir(String p, boolean[][] maze , int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }  
        if(maze[r][c]==false){
            return;
        }  
        if(r<maze.length-1){
            pathalldirprint(p+"d", maze, r+1, c);
        }  
        if(c<maze[0].length-1){
            pathalldirprint(p+"r", maze, r, c+1);
        }
    }   

        static void pathalldirprint(String p, boolean[][] maze , int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }  
        if(!maze[r][c]){  // if some where any hurdle then not proceed further and just return..
            return;
        }  
        // i am considering this block in my path
        maze[r][c] = false;  // this indicate that current cell is visited and u not reuse this cell
        if(r<maze.length-1){
            pathalldirprint(p+"d", maze, r+1, c);
        }  
        if(c<maze[0].length-1){
            pathalldirprint(p+"r", maze, r, c+1);
        }
        if(r>0){
         pathalldirprint(p+'u', maze, r-1, c);
        }
        if(c>0){
            pathalldirprint(p+'l', maze, r, c-1);
        } 
        // this line is where the function will be over
        // so before the fun get removed, also remove the change the were made by that function
        maze[r][c] = true;   // true typically represents that the cell is accessible or not yet visited.
    }   

   static void  pathalldirprint(String p,boolean[][] maze,int r, int c,int[][] path,int step){
          if(r == maze.length-1 && c == maze[0].length-1){
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }  
        if(!maze[r][c]){  // if some where any hurdle then not proceed further and just return..
            return;
        }  
        // i am considering this block in my path
        maze[r][c] = false;  // this indicate that current cell is visited and u not reuse this cell
        path[r][c] = step;
        if(r<maze.length-1){
            pathalldirprint(p+"d", maze, r+1, c,path,step+1);
        }  
        if(c<maze[0].length-1){
            pathalldirprint(p+"r", maze, r, c+1,path,step+1);
        }
        if(r>0){
         pathalldirprint(p+'u', maze, r-1, c,path,step+1);
        }
        if(c>0){
            pathalldirprint(p+'l', maze, r, c-1,path,step+1);
        } 

        maze[r][c] = true;
        path[r][c] = 0; // for further cell remove the steps for another call
   }
}
