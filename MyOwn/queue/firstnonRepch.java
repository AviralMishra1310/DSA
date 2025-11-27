import java.util.*;

public class firstnonRepch{
    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i); //ek ek character ch me leke aayenge
            q.add(ch);               //queue me ek ek character add kr denge
            freq[ch - 'a']++;        //index nikale ge char ka aur uss index par ++ krdenge 

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){ //agr que empty nhi hai aur uske pehle char ki freq >1 hai to usse remove krte jayenge jab less than 1 na ho jaye
                q.remove(); 
            }
            if(q.isEmpty()){
                System.out.print(-1+" "); 
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}