public class invertedPyramid {
    public static void inverted_Half_Pyramid(int n){
        for(int i = 1; i<=n;i++){
            for(int j = 1 ; j <= n-i;j++){
                System.out.print(" ");
            }
            for(int k = 1;k <=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
           inverted_Half_Pyramid(5);
    }
}
