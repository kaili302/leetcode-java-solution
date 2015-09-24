/*
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
*/
class TrieNode{
    public char val;
    public HashMap<Character, TrieNode> children=new HashMap();
    public boolean isLeaf=false; 
    public TrieNode(){}
    public TrieNode(char val){
        this.val=val;
    }
}
public class WordDictionary{
    TrieNode root;
    public WordDictionary(){
        root=new TrieNode();
    }
    public void addWord(String word){
        TrieNode node=root;
        for (int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            TrieNode child;
            if(node.children.containsKey(c)){
                child=node.children.get(c);
            }else{
                child=new TrieNode(c);
                node.children.put(c, child);
            }
            node=child;
            if (i==word.length()-1) child.isLeaf=true;
        }
    }
    public boolean search(String word){
        return searchHelperDFS(root, word);
    }    
    public boolean searchHelperDFS(TrieNode parent, String word){
        TrieNode node=parent;
        for (int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            if(!node.children.containsKey(c)){
                if(c=='.' && node.children.size()!=0) {
                    for (TrieNode child : node.children.values()){
                        if (searchHelperDFS(child, word.substring(i+1, word.length()))) return true;
                    }
                    return false;
                }
                return false;
            }
            node=node.children.get(c);
        }
        return node.isLeaf;
    }
}

