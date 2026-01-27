package com.peng.utils;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public Map<Integer, Integer> inorderMap = new HashMap<>();

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void buildInorderMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
    }

//    public TreeNode buildTreeByInorderAndPreOrder(int[] inorder, int[] preorder, int instart, int inend, int prestart, int preend) {
//        if (prestart > preend) {
//            return null;
//        }
//        int cur = preorder[prestart];
//        TreeNode root = new TreeNode(cur);
//        int pos = inorderMap.get(cur);
//        TreeNode left = buildTreeByInorderAndPreOrder(inorder, preorder, instart, pos - 1, prestart + 1, prestart + pos - instart);
//        TreeNode right = buildTreeByInorderAndPreOrder(inorder, preorder, pos + 1, inend, prestart + pos - instart + 1, preend);
//        root.left = left;
//        root.right = right;
//        return root;
//    }
//
//    public TreeNode buildTreeByInorderAndPostOrder(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
//        if (poststart > postend) {
//            return null;
//        }
//        int cur = postorder[postend];
//        TreeNode root = new TreeNode(cur);
//        int pos = inorderMap.get(cur);
//        TreeNode left = buildTreeByInorderAndPostOrder(inorder, postorder, instart, pos - 1, poststart, poststart + pos - instart - 1);
//        TreeNode right = buildTreeByInorderAndPostOrder(inorder, postorder, pos + 1, inend, poststart + pos - instart, postend - 1);
//        root.left = left;
//        root.right = right;
//        return root;
//    }

    public static class Builder {
        private int val;
        private TreeNode left;
        private TreeNode right;
        private Map<Integer, Integer> inorderMap;
        public Builder() {
        }
        public Builder(int val) {
            this.val = val;
            this.inorderMap = new HashMap<>();
        }

        public Builder left(TreeNode left) {
            this.left = left;
            return this;
        }

        public Builder right(TreeNode right) {
            this.right = right;
            return this;
        }

        public Builder left(int val) {
            this.left = new TreeNode(val);
            return this;
        }

        public Builder right(int val) {
            this.right = new TreeNode(val);
            return this;
        }

        public TreeNode build() {
            return new TreeNode(val, left, right);
        }
        private void buildInorderMap(int[] inorder) {
            inorderMap=new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
        }
        public TreeNode buildTreeFromInorderAndPreOrder(int[] inorder, int[] preorder) {
            buildInorderMap(inorder);
            return buildTreeByInorderAndPreOrder(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
        }
        public TreeNode buildTreeFromInorderAndPostOrder(int[] inorder, int[] postorder) {
            buildInorderMap(inorder);
            return buildTreeByInorderAndPostOrder(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        }
        private TreeNode buildTreeByInorderAndPreOrder(int[] inorder, int[] preorder, int instart, int inend, int prestart, int preend) {
            if (prestart > preend) {
                return null;
            }
            int cur = preorder[prestart];
            TreeNode root = new TreeNode(cur);
            int pos = inorderMap.get(cur);
            TreeNode left = buildTreeByInorderAndPreOrder(inorder, preorder, instart, pos - 1, prestart + 1, prestart + pos - instart);
            TreeNode right = buildTreeByInorderAndPreOrder(inorder, preorder, pos + 1, inend, prestart + pos - instart + 1, preend);
            root.left = left;
            root.right = right;
            return root;
        }

        private TreeNode buildTreeByInorderAndPostOrder(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
            if (poststart > postend) {
                return null;
            }
            int cur = postorder[postend];
            TreeNode root = new TreeNode(cur);
            int pos = inorderMap.get(cur);
            TreeNode left = buildTreeByInorderAndPostOrder(inorder, postorder, instart, pos - 1, poststart, poststart + pos - instart - 1);
            TreeNode right = buildTreeByInorderAndPostOrder(inorder, postorder, pos + 1, inend, poststart + pos - instart, postend - 1);
            root.left = left;
            root.right = right;
            return root;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
