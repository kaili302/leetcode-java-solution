/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally 
or vertically neighboring. The same letter cell may not be used more than once.
For example, given board =
[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
//dfs 核心经典是在是在board[i][j]='#' 用来防止二次使用 跟islan里面很像 学会使用雷士方法！！！！给力
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length()==0) return true;
        if (board.length==0 || board[0].length==0) return false;
        boolean[][] used;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++) {
                if (word.charAt(0)!=board[i][j]) continue;
                if (dfs(i, j, board, word)) return true;
            }        
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word) {
        if(i<0||i==board.length||j<0||j==board[0].length) return false;
        if (word.charAt(0)==board[i][j]){
            if(word.length()==1) return true;
            char tmp=board[i][j];
            board[i][j]='#';
            String sub=word.substring(1);
            if (dfs(i-1, j, board, sub)||dfs(i+1, j, board, sub) || dfs(i, j-1, board, sub) || dfs(i, j+1, board, sub)) return true;
            board[i][j]=tmp;
        }
        return false;   
    }     
}