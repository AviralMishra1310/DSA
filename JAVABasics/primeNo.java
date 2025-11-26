import java.util.*;
public class primeNo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int n = sc.nextInt();

        if(n == 2){
            System.out.println("n is a prime no");
        }
        else{
            boolean isPrime = true;
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                   isPrime = false; //n is a multiple of  i ( i not equal to 1  or n)
                }
            }
            if(isPrime == true){
                 System.out.println("n is a prime no");
            }
            else{
                System.out.println("n is not prime no");
            }
        }
        sc.close();
    }
}
