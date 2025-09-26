package com.simulation;

import java.security.acl.AclNotFoundException;
import java.util.*;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> oriToClone = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        oriToClone.put(node, new Node(node.val));
        queue.add(node);
        while(!queue.isEmpty()){
            Node origin = queue.poll();
            Node clone = oriToClone.get(origin);

            for (Node nei: origin.neighbors){
                if (!oriToClone.containsKey(nei)){
                    Node newClone = new Node(nei.val);
                    queue.add(nei);
                    oriToClone.put(nei, newClone);
                }
                clone.neighbors.add(oriToClone.get(nei));
            }
        }

        return oriToClone.get(node);
    }
}
