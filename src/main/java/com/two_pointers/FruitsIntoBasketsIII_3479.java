package com.two_pointers;

import java.util.TreeSet;

public class FruitsIntoBasketsIII_3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree tree = new SegmentTree(baskets);
        int unplaced = fruits.length;

        for (int fruit: fruits){
            int availableBasket = tree.leftmostIndexWithCapacityAtLeast(fruit);
            if (availableBasket != -1){
                unplaced--;
                tree.markUsed(1, 0, tree.n - 1, availableBasket);
            }
        }

        return unplaced;
    }

    class SegmentTree{
        private int n;
        private int[] max;
        private final int USED = -1;

        SegmentTree(int[] capacities){
            this.n = capacities.length;
            this.max = new int[this.n * 4];
            build(1, 0, n - 1, capacities);
        }

        private void build(int curNodeIdx, int l, int r, int[] cap){
            if (l == r) {max[curNodeIdx] = cap[l];return;}

            int mid = (l + r) / 2, leftChildIdx = curNodeIdx * 2, rightChildIdx = leftChildIdx + 1;
            build(leftChildIdx, l, mid, cap);
            build(rightChildIdx, mid + 1, r, cap);
            max[curNodeIdx] = Math.max(max[leftChildIdx], max[rightChildIdx]);
        }

        private void markUsed(int curNodeInd, int l, int r, int idxToUpdate){
            if (l == r) {max[curNodeInd] = USED;return;}

            int mid = (l + r) / 2, leftChildIdx = curNodeInd * 2, rightChildIdx = leftChildIdx + 1;
            if (idxToUpdate <=  mid) markUsed(leftChildIdx, l, mid, idxToUpdate);
            else markUsed(rightChildIdx, mid + 1, r, idxToUpdate);

            max[curNodeInd] = Math.max(max[leftChildIdx], max[rightChildIdx]);
        }

        public int leftmost(int curNodeIdx, int l, int r, int need){
            if (l == r) return l;
            int mid = (l + r) / 2, leftChildIdx = curNodeIdx * 2, rightChildIdx = leftChildIdx + 1;

            if (max[leftChildIdx] >= need) return leftmost(leftChildIdx, l, mid, need);
            return leftmost(rightChildIdx, mid + 1, r, need);
        }

        int leftmostIndexWithCapacityAtLeast(int need) {
            if (n == 0 || max[1] < need) return -1;
            return leftmost(1, 0, n - 1, need);
        }
    }
}
