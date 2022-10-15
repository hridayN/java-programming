package DataStructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private TreeNode root;
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
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);

        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;

        root = first;
    }

    public void PreOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(String.format("%d --> ", root.data));
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }

    public void InOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(String.format("%d --> ", root.data));
        InOrderTraversal(root.right);
    }

    public void PostOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(String.format("%d --> ", root.data));
    }

    public void LevelOrderTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " --> ");
            if (tempNode.left != null) queue.offer(tempNode.left);
            if (tempNode.right != null) queue.offer(tempNode.right);
            System.out.println();
        }
    }

    public int GetMaxInBinaryTree(TreeNode root) {
        if (root == null) return -1;
        int max = (int)root.data;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (max < (int)tempNode.data) max = (int)tempNode.data;
            if (tempNode.left != null) queue.offer(tempNode.left);
            if (tempNode.right != null) queue.offer(tempNode.right);
        }
        return max;
    }
}
