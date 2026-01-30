import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class LC124 { 
    static int res;

    public static int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        solve(root);
        return res;
    }

    private static int solve(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(0, solve(root.left));
        int r = Math.max(0, solve(root.right));

        int ans = l + r + root.val;
        res = Math.max(res, ans);

        return Math.max(l, r) + root.val;
    }

    private static TreeNode buildTree(Scanner sc) {
        int val = sc.nextInt();
        if (val == -1) return null;

        TreeNode root = new TreeNode(val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                curr.left = new TreeNode(leftVal);
                q.add(curr.left);
            }

            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                curr.right = new TreeNode(rightVal);
                q.add(curr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        Example input:
        1 2 3 -1 -1 -1 -1
        */

        TreeNode root = buildTree(sc);
        System.out.println(maxPathSum(root));
    }
}
