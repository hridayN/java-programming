package DataStructures.Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree<T> {
    ArrayList<TreeNode<T>> tree;

    public Tree() {
        this.tree = new ArrayList<>();
    }

    // This method will take tree's nodes input from user and return the tree root
    /*Basic idea is to fetch input for all subtrees, one by one, and link them to root node*/
    public TreeNode<Integer> GetTreeInput_DepthWise(int currentsParentNode, int noOfChild) {
        Scanner scn = new Scanner(System.in);
        String text = (currentsParentNode == -1) ? "Enter root node value: " : String.format("Enter %dth child of %d: ", noOfChild, currentsParentNode);
        System.out.println(text);
        int rootNodeData = scn.nextInt();

        // Create root node with provided value
        TreeNode<Integer> rootNode = new TreeNode<>(rootNodeData);

        System.out.println(String.format("Enter no. of children for: %d", rootNodeData));
        int numOfRootNodeChildren = scn.nextInt();

        for(int i = 0; i < numOfRootNodeChildren; i++) {
            // Get sub-tree's root node
            TreeNode<Integer> subTreeNode = GetTreeInput_DepthWise(rootNodeData, i+1);
            // Link this root-node to existing rootNode
            rootNode.children.add(subTreeNode);
        }

        return rootNode;
    }

    public void PrintTree(TreeNode<Integer> root) {
        StringBuilder s = new StringBuilder();
        s.append(String.format("[%d]: ", root.data));

        // Print root node's children
        for(int i =0; i < root.children.size(); i++) {
            s.append(String.format("%d, ", root.children.get(i).data));
        }
        System.out.println(s);

        // Print every node's data
        for(int i =0; i < root.children.size(); i++) {
            PrintTree(root.children.get(i));
        }
    }
}

