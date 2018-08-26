package my.czhhu.algo.leetcode;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

public class RemoveDuplicatedFromSortedListII82
{

    static Node removeDup(Node head)
    {
        if (head == null || head.next == null)
            return head;

        Node found = null; // pointer to tail of result
        Node h = null; // pointer to head

        Node n = head; // head of next beginning
        Node cur = n.next; // cur pointer

        while (cur != null)
        {
            while (cur != null && n.data == cur.data)
            {
                cur = cur.next;
            }
            if (cur == null) //in this case, last several elements are same, no need to add
                return h;

            if (n.next == cur) // n.data != cur.data, so cur is not moving
            {
                if (found == null)
                {
                    found = n;
                    h = n;

                }
                else
                {
                    found.next = n;
                    found = n;

                }
                found.next = null;

            }
            n = cur;
            cur = n.next;

        }
        if (found != null)
        {
            found.next = n; // this case is last.data != last-1.data, when n == last and cur ==null (last.next)
            found = n; //should append n to tail
            found.next = null;
        }

        return h;

    }

    public static void main(String[] args)
    {
        Node head = new Node(1, new Node(2, new Node(3, new Node(3, new Node(4, new Node(4, new Node(5)))))));
        Node h1 = new Node(1, new Node(1, new Node(1, new Node(2, new Node(3, new Node(3))))));
        CommonOp.printLinkedList(removeDup(head));
        CommonOp.printLinkedList(removeDup(h1));

    }

}
