import java.util.*;

public class glbitm{

    static HashMap<Character, String> map = new HashMap<>();

    static{
        map.put('1',"one");
        map.put('2',"two");
        map.put('3',"three");
        map.put('4',"four");
        map.put('5',"five");
        map.put('6',"six");
        map.put('7',"seven");
        map.put('8',"eight");
        map.put('9',"nine");
        map.put('0',"zero");
    }

    public static String tellDig(char ch){
        return map.get(ch);
    }

    public static boolean palindrome(String s){
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int calculate(int n){
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }
        return sum;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        String l = sc.next();

        if(l.equals("A") || l.equals("a")){
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            sb.append(s.charAt(s.length() - 1));
            
            int n = Integer.parseInt(sb.toString());
            
            int sum = calculate(n);
            
            System.out.println("Sum of first and last digit: " + sum);
        }
        else if(l.equals("B") || l.equals("b")){
            if(!palindrome(s)){
                System.out.println("Not palindrome");
            }else{
                System.out.println("Palindrome");
            }
        }
        else if(l.equals("C") || l.equals("c")){
            System.out.println("Number of Digits: " + s.length());
        }
        else if(l.equals("D") || l.equals("d")){
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                System.out.print(tellDig(ch) + " ");
            }
        }
    }
}