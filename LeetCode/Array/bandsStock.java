// lc -> 121
import java.util.*;

class bandsStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            } else {
                buyPrice = prices[i];
            }
        }

        System.out.println(maxProfit);
    }
}
