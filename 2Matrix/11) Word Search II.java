/*
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once in a word.

For example, given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
*/
//dfs 这个解法会直接引起time limite 得使用trie 然后把trie当作word放进去遍历
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res=new HashSet();
        Trie trie=new Trie();
        for (String word: words) trie.insert(word);            
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++) {
                dfs (i, j, trie.root.children, board, res);
            }        
        }
        return new ArrayList<String>(res);
    }    
    public void dfs (int i, int j, TrieNode[] children, char[][] board, HashSet<String> res){
        if(i<0||i==board.length||j<0||j==board[0].length) return;
        char c=board[i][j];
        if (c=='#'||children[c-'a']==null) return;
        if (children[c-'a'].word!="") res.add(children[c-'a'].word);
        children=children[c-'a'].children;
        char tmp=board[i][j];
        board[i][j]='#';
        dfs (i-1, j, children, board, res);
        dfs (i+1, j, children, board, res);
        dfs (i, j-1, children, board, res);
        dfs (i, j+1, children, board, res);
        board[i][j]=tmp;
    }
}

class TrieNode{
    char val;
    TrieNode[] children;
    String word="";
    public TrieNode(){
        children=new TrieNode[26];
    }
    public TrieNode(char val){
        this.val=val;
        children=new TrieNode[26];
    }
}

class Trie{
    TrieNode root=new TrieNode();
    public void insert(String word){
        TrieNode node=root;
        TrieNode[] children;
        for(int i=0; i<word.length(); i++){
            children=node.children;
            char c =word.charAt(i);
            if (children[c-'a']==null)  children[c-'a']=new TrieNode(c);
            node=children[c-'a'];
            if(i==word.length()-1) node.word=word;
        }        
    }
}