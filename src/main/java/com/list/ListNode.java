package com.list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode copyNode(){
        ListNode node = this;
        ListNode copy = new ListNode();
        ListNode newHead = copy;
        while(node != null){
            copy.val = node.val;
            node = node.next;
            if(node != null){ copy.next = new ListNode(); copy = copy.next; }
        }
        return newHead;
    }

    public void constructLinkedList(int[] input, ListNode node, int i){
        if(i+1 < input.length){
            ListNode next = new ListNode(input[i+1]);
            node.next = next;
            constructLinkedList(input, next, i+1);
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode node = head;
        ListNode reverse = head;
        if(node.next == null){}
        else if(node != null){ reverse = reverseHelper(node, node.next, node); }
        return reverse;
    }

    public static String printLinkedList(ListNode head){
        return printHelper(head, "");
    }

    private static String printHelper(ListNode node, String output){
        if (node != null) {
            output += (node.val);
            if(node.next != null)
                output += (" -> ");
            return printHelper(node.next, output);
        }
        else{ return output; }
    }

    private ListNode reverseHelper(ListNode current, ListNode next, ListNode newHead){
        if(next != null){
            ListNode temp = next.next;
            next.next = current;
            if(current == newHead) { current.next = null; }
            newHead = reverseHelper(next, temp, newHead);
        }
        else{ newHead = current; }
        return newHead;
    }
}