package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree_297 {
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeHelper(root, list);

        StringBuilder sb = new StringBuilder();
        if (!list.isEmpty()) sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++){
            sb.append(",").append(list.get(i));
        }

        return sb.toString();
    }

    public void serializeHelper(TreeNode root, List<String> list){
        if (root == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(root.val));
        serializeHelper(root.left, list);
        serializeHelper(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        return deserializeHelper(datas, 0);
    }

    public TreeNode deserializeHelper(String[] datas, int idx){
        if (datas[idx].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(datas[idx]));

        root.left = deserializeHelper(datas, idx + 1);
        root.right = deserializeHelper(datas, idx + 2);

        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree_297 s = new SerializeAndDeserializeBinaryTree_297();
        s.deserialize("1,2,3,null,null,4,5");
    }
}
