import java.util.*;

public class queueReversa{
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        //queue se nikal ke stack me push kr diya
        while(!q.isEmpty()){
            s.push(q.remove());
        }

        //ab stack se nikal ke queue me push krenge
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String args[]){
       Queue<Integer> q = new LinkedList<>();
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);

       reverse(q);

       while(!q.isEmpty()){
           System.out.print(q.remove() + " ");
       }
       System.out.println();
    }
}