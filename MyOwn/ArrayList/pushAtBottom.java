import java.util.*;

public class pushAtBottom{
    public static void pushatBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
    int top = s.pop();       //Top element hatao taaki neeche ja sako
    pushatBottom(s, data);  //Ab bachi stack mein data ko daalo (recursion)
    s.push(top);  //Jo pop kiya tha usko wapis daalo
    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void main(String args[]) {
        String str = "abc";
        String result = reverseString(str);
        System.out.println("Reverse String is : " + result);
    }
}