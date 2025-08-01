package com.example.leetCodeProbs;

import java.util.LinkedList;

// Swap the pairs of LinkedList and return the new head of the list
public class SwapLinkedList {

    Node head;

    static class Node{
        int val;
        Node next;

        Node(int data){
            this.val = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public Node add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return node;
        }
        Node tail = head;
        while(tail.next!= null){
            tail = tail.next;
        }
        tail.next = node;
        return tail;

    }

    public void printList(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public Node swapPairs(){
        Node dummy = new Node(0);
        dummy.next = head;
        Node point = dummy;

        while(point.next != null && point.next.next != null){
            Node temp1 = point.next;
            Node temp2 = point.next.next;

            temp1.next = temp2.next;
            temp2.next = temp1;
            point.next = temp2;

            point = temp1;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        SwapLinkedList list = new SwapLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printList();
        list.swapPairs();
        list.printList();

    }
}
