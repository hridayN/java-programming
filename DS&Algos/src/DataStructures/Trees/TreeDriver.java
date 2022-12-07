package DataStructures.Trees;

public class TreeDriver {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        TreeNode<Integer> rootNode = tree.GetTreeInput_DepthWise(-1, 1);
        tree.PrintTree(rootNode);
    }
}
