public class reverseno {
    public static void main(String args[]){
        int n = 318005;
        while(n > 0){
            int digit = n % 10;
            System.out.print(digit + " ");
            n /=10; 
        }
        System.out.println();
    }
}
