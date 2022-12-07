package DataStructures.Trees;

import java.util.ArrayList;

public class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    public TreeNode(T _data) {
        this.data = _data;
        this.children = new ArrayList<>();
    }
}
