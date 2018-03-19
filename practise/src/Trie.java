import java.util.HashMap;
import java.util.Map;

public class Trie {

    public class TrieNode{
        Map<Character,TrieNode> characterTrieNodeMap;
        boolean eow;

        public TrieNode() {
            characterTrieNodeMap = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode currenNode = root;
        for(int i=0;i<word.length();i++){
            TrieNode n = currenNode.characterTrieNodeMap.get(word.charAt(i));

            if(n==null){
                n = new TrieNode();
                currenNode.characterTrieNodeMap.put(word.charAt(i),n);
            }

            currenNode = n;
        }
        currenNode.eow = true;

    }

    public void insertReccur(String word,int i, TrieNode root){
       if(word.length()==i){
           root.eow=true;
           return;
       }

    TrieNode n = root.characterTrieNodeMap.get(word.charAt(i));

    if(n==null){
        n = new TrieNode();
        root.characterTrieNodeMap.put(word.charAt(i),n);
    }
        insertReccur(word, i++, n);

    }

    public boolean search(String word){
        TrieNode c = root;
        int i =0;
        for(i=0;i<=word.length();i++){
            TrieNode n = c.characterTrieNodeMap.get(word.charAt(i));
            if(n==null){
                break;
            }
            c = n;
        }
        if(i==word.length()&&c.eow){
            return true;
        }
        return false;
    }

    public boolean searchRecur(String word,int i,TrieNode c){

        if(i==word.length()){
            return c.eow;
        }
        TrieNode n = c.characterTrieNodeMap.get(word.charAt(i));
        if(n==null){
            return false;
        }
        return searchRecur(word,i++,n);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.eow) {
                return false;
            }
            current.eow = false;
            return current.characterTrieNodeMap.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.characterTrieNodeMap.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.characterTrieNodeMap.remove(ch);
            return current.characterTrieNodeMap.size() == 0;
        }
        return false;
    }
}
