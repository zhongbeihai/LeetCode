package com.binary_tree;

public class LowestCommonAncestorOfBinaryTreeIII_1650 {
     class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public  Node lowestCommonAncestor(Node p, Node q) {
         Node p1 = p, p2 = q;

         while (p1 != p2){
             p1 = (p1 == null) ? q : p1.parent;
             p2 = (p2 == null) ? p : p2.parent;
         }

         return p1;
    }
}
