package DataStructures.Trees;

public class TreeNode_Old<T> {
    T data;
    TreeNode_Old left;
    TreeNode_Old right;
    public TreeNode_Old(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static void DisplayTreePreOrder(TreeNode_Old root) {
        if (root == null) return;

        System.out.print(root.data + " --> ");
        DisplayTreePreOrder(root.left);
        DisplayTreePreOrder(root.right);
    }

    public static void DisplayTreeInOrder(TreeNode_Old root) {
        if (root == null) {
            return;
        }

        DisplayTreeInOrder(root.left);
        System.out.print(root.data + " --> ");
        DisplayTreeInOrder(root.right);
    }
}
