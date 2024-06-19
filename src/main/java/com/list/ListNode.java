package com.list;

public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode copyNode(){
        ListNode node = this;
        ListNode copy = new ListNode();
        ListNode newHead = copy;
        while(node != null){
            copy.val = node.val;
            node = node.getNext();
            if(node != null){ copy.next = new ListNode(); copy = copy.next; }
        }
        return newHead;
    }

    public void setNext(ListNode next){ this.next = next; }

    public int getVal(){ return val; }

    public void setVal(int val){ this.val = val; }

    public ListNode getNext(){ return next; }

    public void constructLinkedList(int[] input, ListNode node, int i){
        if(i+1 < input.length){
            ListNode next = new ListNode(input[i+1]);
            node.setNext(next);
            constructLinkedList(input, next, i+1);
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode node = head;
        ListNode reverse = head;
        if(node.getNext() == null){}
        else if(node != null){ reverse = reverseHelper(node, node.getNext(), node); }
        return reverse;
    }

    public static String printLinkedList(ListNode head){
        return printHelper(head, "");
    }

    private static String printHelper(ListNode node, String output){
        if (node != null) {
            output += (node.val);
            if(node.getNext() != null)
                output += (" -> ");
            return printHelper(node.getNext(), output);
        }
        else{ return output; }
    }

    private ListNode reverseHelper(ListNode current, ListNode next, ListNode newHead){
        if(next != null){
            ListNode temp = next.getNext();
            next.setNext(current);
            if(current == newHead) { current.setNext(null); }
            newHead = reverseHelper(next, temp, newHead);
        }
        else{ newHead = current; }
        return newHead;
    }
}