public class LC2523 {
    public boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public int[] closestPrimes(int left, int right){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i  = left; i <= right; i++){
            if(isPrime(i)) list.add(i);
        }

        if(list.size() < 2) return new int[]{-1, -1};
        int min = Integer.MAX_VALUE;
        int a = -1, b = -1;

        for(int i = 0; i < list.size() - 1; i++){
            int diff = list.get(i+1) - list.get(i);

            if(diff < min){
                min = diff;
                a = list.get(i);
                b = list.get(i+1);
            }
        }

        return new int[]{a, b};
    }
}
