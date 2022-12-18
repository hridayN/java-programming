package DataStructures.Trees;

import DataStructures.Queue.QueueUsingLinkedList.QueueUsingLL;

import java.util.*;

public class Tree<T> {
    ArrayList<TreeNode<T>> tree;
    private Scanner scanner;
    public Tree() {
        this.tree = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // This method will take tree's nodes input from user and return the tree root
    /*Basic idea is to fetch input for all subtrees, one by one, and link them to root node*/
    public TreeNode<Integer> GetTreeInput_DepthWise(int currentsParentNode, int noOfChild) {
        String text = (currentsParentNode == -1) ? "Enter root node value: " : String.format("Enter %dth child of %d: ", noOfChild, currentsParentNode);
        System.out.println(text);
        int rootNodeData = scanner.nextInt();

        // Create root node with provided value
        TreeNode<Integer> rootNode = new TreeNode<>(rootNodeData);

        System.out.println(String.format("Enter no. of children for: %d", rootNodeData));
        int numOfRootNodeChildren = scanner.nextInt();

        for (int i = 0; i < numOfRootNodeChildren; i++) {
            // Get sub-tree's root node
            TreeNode<Integer> subTreeNode = GetTreeInput_DepthWise(rootNodeData, i + 1);
            scanner.close();
            // Link this root-node to existing rootNode
            rootNode.children.add(subTreeNode);
        }

        return rootNode;
    }

    /*Print tree nodes in Depth wise manner*/
    public void PrintTree_DepthWise(TreeNode<Integer> root) {
        StringBuilder s = new StringBuilder();
        s.append(String.format("[%d]: ", root.data));

        // Print root node's children
        for (int i = 0; i < root.children.size(); i++) {
            s.append(String.format("%d, ", root.children.get(i).data));
        }
        System.out.println(s);

        // Print every node's data, covering the whole depth for the current node
        for (int i = 0; i < root.children.size(); i++) {
            PrintTree_DepthWise(root.children.get(i));
        }
    }

    /*Get tree input Level wise*/
    public TreeNode<Integer> GetTreeInput_LevelWise() {
        System.out.println("Enter root data: ");
        Scanner scanner = new Scanner(System.in);

        int rootData = scanner.nextInt();
        // Create root with provided value
        TreeNode<Integer> rootNode = new TreeNode<>(rootData);

        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        // Add root to queue
        pendingNodes.Enqueue(rootNode);
        while (!pendingNodes.IsEmpty()) {
            // Fetch pending node from queue
            TreeNode<Integer> frontNode = pendingNodes.Dequeue().data;
            System.out.println(String.format("Enter no. of children for %d: ", frontNode.data));
            int numOfChildren = scanner.nextInt();
            // Get children for frontNode
            for (int i = 0; i < numOfChildren; i++) {
                System.out.println(String.format("Enter %dth child of %d", i + 1, frontNode.data));
                int childNodeData = scanner.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(childNodeData);

                // Add child node to its parent(previously fetched node from Queue)
                frontNode.children.add(childNode);
                // Add childNode to queue
                pendingNodes.Enqueue(childNode);
            }
        }
        scanner.close();
        return rootNode;
    }

    /*Print all tree nodes, followed by printing all children*/
    public void PrintTree_LevelWise(TreeNode<Integer> root) {
        System.out.print(String.format("%d, ", root.data));
        for (TreeNode<Integer> child : root.children) {
            System.out.print(String.format("%d, ", child.data));
        }
    }

    /*This method returns the count of nodes in the tree*/
    public int GetNodesCount(TreeNode<Integer> root) {
        // Edge case: if root is NULL
        if (root == null) return 0;

        int count = 1;
        // Here, we need not handle base case, as it'll be handled by For loop
        for (int i = 0; i < root.children.size(); i++) {
            count += GetNodesCount(root.children.get(i));
        }

        return count;
    }

    /*This method returns the largest data in the tree*/
    public int GetMaxNodeData(TreeNode<Integer> root) {
        // Edge case: if root is NULL
        if (root == null) return Integer.MIN_VALUE;

        int maxData = root.data;

        // Here, we need not handle base case, as it'll be handled by For loop
        for (int i = 0; i < root.children.size(); i++) {
            int childLargest = GetMaxNodeData(root.children.get(i));
            maxData = (childLargest > maxData) ? childLargest : maxData;
        }

        return maxData;
    }

    public int GetHeight(TreeNode<Integer> root) {
        int height = 1;
        for (int i = 0; i < root.children.size(); i++) {
            height += GetHeight(root.children.get(i));
        }
        return height;
    }

    /*This method prints all nodes at level K*/
    public void PrintAllNodesAtLevelK(TreeNode<Integer> root, int level) {
        if (level < 0) return;
        if (level == 0) {
            System.out.print(root.data);
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            // Make a Call to next level-1
            PrintAllNodesAtLevelK(root.children.get(i), level - 1);
        }
    }

    /*This method gets count of all Leaf nodes*/
    public int GetLeafNodesCount(TreeNode<Integer> root) {
        if (root == null) return 0;
        if (root.children.size() == 0) return 1;

        int leafNodeCount = 0;
        for (int i = 0; i < root.children.size(); i++) {
            leafNodeCount += GetLeafNodesCount(root.children.get(i));
        }

        return leafNodeCount;
    }
}

