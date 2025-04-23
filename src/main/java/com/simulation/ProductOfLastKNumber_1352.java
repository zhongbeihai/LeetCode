package com.simulation;

import java.util.ArrayList;
import java.util.List;

// [1 2 3 4 5]
// [1 2 6 24 120]
// prefixSum -> prefix product
// A data structure store the product of first k element
// presume that there are 5 elem, pre_pro[5] / pre_prd[3]
public class ProductOfLastKNumber_1352 {
    private List<Long> pp;
    private int lastZeroPos = 0;
    public ProductOfLastKNumber_1352() {
        this.pp = new ArrayList<>();
        // 1 ele in pp,
        pp.add(1L);
    }

    public void add(int num) {
        if (num == 0){
            this.pp.add(0L);
            this.lastZeroPos = this.pp.size();
        }else {
            long last = this.pp.get(this.pp.size() - 1);
            if(last == 0L){
                this.pp.add((long)num);
            }else {
                pp.add(last * num);
            }
        }
    }

    public int getProduct(int k) {
        int size = this.pp.size() - 1;
        if (size - k + 1 == this.lastZeroPos) {
            return this.pp.get(size).intValue();
        }else if (size - k + 1 < this.lastZeroPos){
            return 0;
        }else{
            return (int) (this.pp.get(size) / this.pp.get(size - k));
        }
    }

    public static void main(String[] args) {
        ProductOfLastKNumber_1352 l = new ProductOfLastKNumber_1352();
        l.add(3);
        l.add(0);
        l.add(2);
        l.add(5);
        l.add(4);
        l.add(4);
        l.getProduct(2);
    }
}
