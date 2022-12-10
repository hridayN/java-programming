package DataStructures.Trees;

public class TreeDriver {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        // TreeNode<Integer> rootNode = tree.GetTreeInput_DepthWise(-1, 1);
        TreeNode<Integer> rootNode = tree.GetTreeInput_LevelWise();
        // tree.PrintTree_DepthWise(rootNode);
        // tree.PrintTree_LevelWise(rootNode);
        /*int maxNodeData = tree.GetMaxNodeData(rootNode);
        System.out.println(String.format("MaxNode data: %d", maxNodeData));*/
        int leafNodeCount = tree.GetLeafNodesCount(rootNode);
        System.out.println(String.format("Total leaf nodes: %d", leafNodeCount));
    }
}
