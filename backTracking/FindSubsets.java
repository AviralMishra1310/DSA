public class FindSubsets {
    public static void findSubsets(String str, String ans, int i){
        //base case
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        //Yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        //No choice
        findSubsets(str, ans, i+1);
    }
    public static void main(String aargs[]){
        String str = "abc";
        findSubsets(str, "" , 0);
    }
}

// with string buider 

// public class FindSubsets {
//     public static void findSubsets(String str, StringBuilder ans, int i) {
//         // Base case
//         if (i == str.length()) {
//             System.out.println(ans.toString());
//             return;
//         }

//         // Yes choice - include the current character
//         ans.append(str.charAt(i));
//         findSubsets(str, ans, i + 1);
//         ans.deleteCharAt(ans.length() - 1); // backtrack

//         // No choice - skip the current character
//         findSubsets(str, ans, i + 1);
//     }

//     public static void main(String[] args) {
//         String str = "abc";
//         StringBuilder ans = new StringBuilder();
//         findSubsets(str, ans, 0);
//     }
// }
