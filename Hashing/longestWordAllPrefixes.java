public class longestWordAllPrefixes {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){ //O(l)
        Node curr = root;
        for(int level = 0; level < word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key) { //O(L)
        Node curr = root;
        for(int level = 0; level < key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i = 0; i < 26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i + 'a'); //(i + 'a') pehle integer aayega a = 97 hai aur agr i = 2 hai to yaha 97+2=99 aayega aur 99 ko (char) me convert kra hai to c hogya wo 
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();  //stringbuilder ki value ko directly string me assign nhi kar skte isi liye toString ka use kra hai                  
                }
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1); //backtrack wala step
            }
        }
    }

    public static void main(String args[]){ 
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
