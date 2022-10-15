package DataStructures.Trees;

public class TreeNode<T> {
    T data;
    TreeNode left;
    TreeNode right;
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static void DisplayTreePreOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " --> ");
        DisplayTreePreOrder(root.left);
        DisplayTreePreOrder(root.right);
    }

    public static void DisplayTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        DisplayTreeInOrder(root.left);
        System.out.print(root.data + " --> ");
        DisplayTreeInOrder(root.right);
    }
}
