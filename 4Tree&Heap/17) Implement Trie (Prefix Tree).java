class TrieNode {
    public char val;
    public boolean isLeaf=false;
    public HashMap<Character, TrieNode> children;
    public TrieNode(char val) {
        this.val=val;
        children=new HashMap();
    }
    public TrieNode() {
        children=new HashMap();
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node =root;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode child;
            if(node.children.containsKey(c)){
                child=node.children.get(c);
            }else{
                child=new TrieNode(c);
                node.children.put(c, child);
            }
            node=child;
            if (i==word.length()-1) node.isLeaf=true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node =root;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)) return false;
            node=node.children.get(c);
            if (i==word.length()-1 && !node.isLeaf) return false;
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node =root;
        for (int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!node.children.containsKey(c)) return false;
            node=node.children.get(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");