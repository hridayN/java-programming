package DataStructures.Trees;

public class BinarySearchTree {
    private TreeNode root;
    public BinarySearchTree() {
        this.root = null;
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.InsertNode(bst.root, 4);
        bst.root = bst.InsertNode(bst.root, 5);
        //System.out.println(String.format("%d inserted", bst.InsertNode(bst.root,3).data));
        // TreeNode.DisplayTreePreOrder(bst.root);
        //TreeNode.DisplayTreeInOrder(bst.root);
        //System.out.println();

        bst.root = bst.InsertNode(bst.root, 3);
        TreeNode.DisplayTreeInOrder(bst.root);
        System.out.println();
        int searchValue = 7;
        bst.root = bst.SearchNode(bst.root, searchValue);
        String str = "";
        if (bst.root == null) str = "not";
        System.out.println(String.format("%d %s found", searchValue, str));
    }

    public TreeNode InsertNode(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < (int)root.data) root.left = InsertNode(root.left, value);
        else root.right = InsertNode(root.right, value);

        return root;
    }

    public TreeNode SearchNode(TreeNode root, int value) {
        if (root == null || (int)root.data == value) return root;

        if (value < (int)root.data) return SearchNode(root.left, value);
        else return SearchNode(root.right, value);
    }
}
