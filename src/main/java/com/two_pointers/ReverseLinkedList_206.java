package com.two_pointers;

import structure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList_206 {



     public ListNode reverseList(ListNode head) {
          ListNode pre, cur, tem;
          pre = null;
          cur = head;

          while (cur != null){
               tem = cur.next;
               cur.next = pre;
               pre = cur;
               cur = tem;
          }
          return pre;
     }

     public static void main(String[] args) {
          List<ListNode> ll = new ArrayList<>();
          for(int i = 1; i <=5 ;i++){
               ListNode l1 = new ListNode();
               l1.val = i;
               ll.add(l1);
          }
          for(int i = 0; i <=3; i++){
               ll.get(i).next = ll.get(i + 1);
          }

          ListNode l1 = ll.get(0);
          ReverseLinkedList_206 r = new ReverseLinkedList_206();
          r.reverseList(l1);
          while(l1 != null){
               System.out.println(l1.val);
          }
     }
}
