import java.util.*;

class LC706 {

    int[] arr;

    public LC706() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }

    public void put(int k, int v) {
        arr[k] = v;
    }

    public int get(int k) {
        return arr[k];
    }

    public void remove(int k) {
        arr[k] = -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LC706 map = new LC706();

        int n = sc.nextInt();   // number of operations

        for(int i = 0; i < n; i++) {

            String op = sc.next();

            if(op.equals("put")) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                map.put(k, v);
            }

            else if(op.equals("get")) {
                int k = sc.nextInt();
                System.out.println(map.get(k));
            }

            else if(op.equals("remove")) {
                int k = sc.nextInt();
                map.remove(k);
            }
        }
    }
}