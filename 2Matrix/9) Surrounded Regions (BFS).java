/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'. 
A region is captured by flipping all 'O's into 'X's in that surrounded region.
For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
*/


//This solution causes java.lang.StackOverflowError, because for a large board, 
//too many method calls are pushed to the stack and causes the overflow.
//使用了太多内存
class Solution {
    public void solve(char[][] board) {
        int count=0, h=board.length;
        if(h==0) return;
        int w=board[0].length;
        if(w==0) return;
        boolean[][] visited=new boolean[h][w];
    
        for (int j=0; j<board[0].length; j++){
            int i=0;
            if ( !visited[i][j] && board[i][j]=='O') markRegion (i, j, board, visited);
            else visited[i][j]=true;
            i=board.length-1;
            if ( !visited[i][j] && board[i][j]=='O') markRegion (i, j, board, visited);
            else visited[i][j]=true;
        }
        
        for (int i=0; i<board.length; i++){
            int j=0;
            if ( !visited[i][j] && board[i][j]=='O') markRegion (i, j, board, visited);
            else visited[i][j]=true;
            j=board[0].length-1;
            if ( !visited[i][j] && board[i][j]=='O') markRegion (i, j, board, visited);
            else visited[i][j]=true;
        }
        
        for (int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if ( board[i][j]=='O') board[i][j]='X';
                else if ( board[i][j]=='#') board[i][j]='O';
            }
        }
    }
    
    public void markRegion(int i, int j, char[][] board, boolean[][] visited){
        if(i<0||i==board.length||j<0||j==board[0].length||visited[i][j]) return;
        visited[i][j]=true;
        if (board[i][j]=='X') return;
        board[i][j]='#';
        markRegion (i-1, j, board, visited);
        markRegion (i+1, j, board, visited);
        markRegion (i, j-1, board, visited);
        markRegion (i, j+1, board, visited);
    }
}


//bfs 方法来弄
class Solution {
    LinkedList<Integer> queue =new LinkedList();
    public void solve(char[][] board) {
        int count=0, h=board.length;
        if(h==0) return;
        int w=board[0].length;
        if(w==0) return;
        boolean[][] visited=new boolean[h][w];
        for (int j=0; j<board[0].length; j++){
            int i=0;
            if ( !visited[i][j] && board[i][j]=='O') bfs (i, j, board, visited);
            else visited[i][j]=true;
            i=board.length-1;
            if ( !visited[i][j] && board[i][j]=='O') bfs (i, j, board, visited);
            else visited[i][j]=true;
        }
        
        for (int i=0; i<board.length; i++){
            int j=0;
            if ( !visited[i][j] && board[i][j]=='O') bfs (i, j, board, visited);
            else visited[i][j]=true;
            j=board[0].length-1;
            if ( !visited[i][j] && board[i][j]=='O') bfs (i, j, board, visited);
            else visited[i][j]=true;
        }
        for (int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if ( board[i][j]=='O') board[i][j]='X';
                else if ( board[i][j]=='#') board[i][j]='O';
            }
        }
    }

    public void bfs (int i, int j, char[][] board, boolean[][] visited){
        markRegion(i, j, board, visited);
        while(!queue.isEmpty()){
            int tmp=queue.remove();
            i=tmp/board[0].length;
            j=tmp-i*board[0].length;
            markRegion(i-1, j, board, visited);
            markRegion(i+1, j, board, visited);
            markRegion(i, j-1, board, visited);
            markRegion(i, j+1, board, visited);
        }
    }
    public void markRegion(int i, int j, char[][] board, boolean[][] visited){
        if(i<0||i==board.length||j<0||j==board[0].length||visited[i][j]) return;
        visited[i][j]=true;
        if (board[i][j]=='X') return;
        board[i][j]='#';
        queue.add(i*board[0].length+j);
    }
}







