import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LC110 {

    static int solve(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = solve(root.left);
        int rightHeight = solve(root.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static boolean isBalanced(TreeNode root) {
        return solve(root) != -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(true);
            return;
        }

        TreeNode root = new TreeNode(sc.nextInt());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 1;
        while (!queue.isEmpty() && count < n) {
            TreeNode curr = queue.poll();

            int leftVal = sc.nextInt();
            count++;
            if (leftVal != -1) {
                curr.left = new TreeNode(leftVal);
                queue.add(curr.left);
            }

            if (count < n) {
                int rightVal = sc.nextInt();
                count++;
                if (rightVal != -1) {
                    curr.right = new TreeNode(rightVal);
                    queue.add(curr.right);
                }
            }
        }

        System.out.println(isBalanced(root));
    }
}
