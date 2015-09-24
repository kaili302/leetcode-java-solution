/*
Given a 2-d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
Example:11110
        11010
        00100
        00011 Answer: 3
*/
public class Solution {
    public int numIslands(char[][] grid) {
        int count=0, h=grid.length;
        if(h==0) return 0;
        int w=grid[0].length;
        if(w==0) return 0;
        boolean[][] visited=new boolean[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(visited[i][j]) continue;
                if (grid[i][j]=='1') {
                    count++;
                    visit(i, j, visited, grid);
                }else visited[i][j]=true;
            }
        }
        return count;
    }
    public void visit (int i, int j, boolean[][] visited, char[][] grid){
        if (i<0||i==grid.length||j<0||j==grid[0].length) return;
        if (visited[i][j]) return;
        visited[i][j]=true;
        if (grid[i][j]=='0') return;
        else {
            visit(i-1, j, visited, grid);
            visit(i+1, j, visited, grid);
            visit(i, j-1, visited, grid);
            visit(i, j+1, visited, grid);
        }
    }
}