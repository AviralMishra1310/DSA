import java.util.*;

public class LC593 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] p1 = new int[2];
        int[] p2 = new int[2];
        int[] p3 = new int[2];
        int[] p4 = new int[2];

        System.out.println("Enter x y for p1:");
        p1[0] = sc.nextInt();
        p1[1] = sc.nextInt();

        System.out.println("Enter x y for p2:");
        p2[0] = sc.nextInt();
        p2[1] = sc.nextInt();

        System.out.println("Enter x y for p3:");
        p3[0] = sc.nextInt();
        p3[1] = sc.nextInt();

        System.out.println("Enter x y for p4:");
        p4[0] = sc.nextInt();
        p4[1] = sc.nextInt();

        LC593 obj = new LC593();
        System.out.println(obj.validSquare(p1, p2, p3, p4));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();

        set.add(dis(p1, p2));
        set.add(dis(p1, p3));
        set.add(dis(p1, p4));
        set.add(dis(p2, p3));
        set.add(dis(p2, p4));
        set.add(dis(p3, p4));

        return !set.contains(0) && set.size() == 2;
    }

    private int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) +
               (a[1] - b[1]) * (a[1] - b[1]);
    }
}