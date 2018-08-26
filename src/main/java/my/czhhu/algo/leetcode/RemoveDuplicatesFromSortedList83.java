package my.czhhu.algo.leetcode;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

public class RemoveDuplicatesFromSortedList83
{

    static Node removeDups(Node head)
    {

        Node cur = head;
        Node n = cur;

        while (cur != null && cur.next != null)
        {
            while (cur.next != null && cur.data == cur.next.data)
            {
                cur = cur.next;
            }

            n.next = cur.next;
            n = n.next;
            cur = n;
        }

        return head;
    }

    public static void main(String[] args)
    {
        Node head = new Node(1, new Node(2, new Node(3, new Node(3, new Node(4, new Node(4, new Node(5)))))));
        Node h1 = new Node(1, new Node(1, new Node(1, new Node(2, new Node(3, new Node(3))))));
        Node h2 = new Node(1, new Node(1, new Node(2, new Node(2, new Node(3, new Node(3))))));
        CommonOp.printLinkedList(removeDups(head));
        CommonOp.printLinkedList(removeDups(h1));
        CommonOp.printLinkedList(removeDups(h2));
    }

}
