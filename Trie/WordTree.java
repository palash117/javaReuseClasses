public class WordTree{
    Node root;
    public WordTree(){}
    public void init(String[] words){
        root = new Node().startNode();
        for(int i=0;i<words.length;i++){
            addWord(words[i]);
        }
    }
    public void addWord(String word){
        if(word==null){
            return;
        }
        if(word.length()==0){
            root.isEnd = true;
            return;
        }
        Node curr = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            if(!curr.child.containsKey(c)){
                curr.child.put(c, new Node());
            }
            if(i==word.length()-1){
                curr.child.get(c).isEnd=true;
            }
            curr= curr.child.get(c);
        }
    }
    public boolean isWordPresent(String word){
        boolean present = true;
        Node curr = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            if(!curr.child.containsKey(c)){
                present = false;
                break;
            }
            if(i==word.length()-1){
                present = curr.child.get(c).isEnd==true;
            }
            curr= curr.child.get(c);
        }
        return present;
    }
}
class Node{
    boolean isStart;
    Map<Character,Node> child;
    boolean isEnd;
    public Node(){
        isStart = false;
        isEnd = false;
        child = new HashMap<>();
    }
    public Node startNode(){
        this.isStart = true;
        return this;
    }
    public Node endNode (){
        this.isEnd = true;
        return this;
    }
}
