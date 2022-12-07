package DataStructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private TreeNode_Old root;
    public BinaryTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree();
        //tree.InOrderTraversal(tree.root);
        //tree.InOrderTraversal(tree.root);
        //tree.PostOrderTraversal(tree.root);
        //tree.LevelOrderTraversal(tree.root);
        System.out.println(String.format("Tree's max: %d", tree.GetMaxInBinaryTree(tree.root)));
    }

    public void createTree() {
        TreeNode_Old first = new TreeNode_Old(1);
        TreeNode_Old second = new TreeNode_Old(2);
        TreeNode_Old third = new TreeNode_Old(3);
        TreeNode_Old fourth = new TreeNode_Old(4);
        TreeNode_Old fifth = new TreeNode_Old(5);
        TreeNode_Old sixth = new TreeNode_Old(6);
        TreeNode_Old seventh = new TreeNode_Old(7);

        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;

        root = first;
    }

    public void PreOrderTraversal(TreeNode_Old root) {
        if (root == null) {
            return;
        }
        System.out.print(String.format("%d --> ", root.data));
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }

    public void InOrderTraversal(TreeNode_Old root) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(String.format("%d --> ", root.data));
        InOrderTraversal(root.right);
    }

    public void PostOrderTraversal(TreeNode_Old root) {
        if (root == null) {
            return;
        }
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(String.format("%d --> ", root.data));
    }

    public void LevelOrderTraversal(TreeNode_Old root) {
        if (root == null) return;
        Queue<TreeNode_Old> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode_Old tempNode = queue.poll();
            System.out.print(tempNode.data + " --> ");
            if (tempNode.left != null) queue.offer(tempNode.left);
            if (tempNode.right != null) queue.offer(tempNode.right);
            System.out.println();
        }
    }

    public int GetMaxInBinaryTree(TreeNode_Old root) {
        if (root == null) return -1;
        int max = (int)root.data;
        Queue<TreeNode_Old> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode_Old tempNode = queue.poll();
            if (max < (int)tempNode.data) max = (int)tempNode.data;
            if (tempNode.left != null) queue.offer(tempNode.left);
            if (tempNode.right != null) queue.offer(tempNode.right);
        }
        return max;
    }
}
