public class LC993 {
    int levelX = -1, levelY = -1;
    TreeNode parentX = null, parentY = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, null, 0, x, y);
        return levelX == levelY && parentX != parentY;
    }

    void dfs(TreeNode node, TreeNode parent, int level, int x, int y) {
        if (node == null) return;
        if (node.val == x) {
            levelX = level;
            parentX = parent;
        }
        if (node.val == y) {
            levelY = level;
            parentY = parent;
        }
        dfs(node.left, node, level + 1, x, y);
        dfs(node.right, node, level + 1, x, y);
    }
}

