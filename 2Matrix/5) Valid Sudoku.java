public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length!=9 ||board[0].length!=9) return false;
        //9*9 size
        HashSet<Character> setRow=new HashSet();
        HashSet<Character> setCol=new HashSet();
        //check row & col
        for (int i=0; i<9; i++){
            setRow=new HashSet();
            setCol=new HashSet();
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'&&!setRow.add(board[i][j])) return false;
                if(board[j][i]!='.'&&!setCol.add(board[j][i])) return false;
            }
        }
        //check cell
        for (int k=0; k<3; k++){
            for(int l=0; l<3; l++){
                HashSet<Character> set =new HashSet();
                for (int i=k*3; i<k*3+3; i++){
                    for(int j=l*3; j<l*3+3; j++){
                        if(board[i][j]!='.'&&!set.add(board[i][j])) return false;
                    }
                }
            }
        }
        return true;
    }
}


/*
Determine if a Sudoku is valid. 
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/