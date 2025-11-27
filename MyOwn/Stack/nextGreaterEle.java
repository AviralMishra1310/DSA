import java.util.*;

public class nextGreaterEle {
    public static void main(String args[]){
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];
        
        for(int i= arr.length - 1; i>=0; i--){
            //step 1 while loop chalana
            while(!s.empty() && arr[s.peek()] <= arr[i]) {
                 s.pop();
            }

            //2 if-else
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            } else {
               nxtGreater[i] = arr[s.peek()];
            }

            //push ele in stack
            s.push(i);
        }

        //to print
        for(int i = 0; i < nxtGreater.length; i++){
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();
    }
}
