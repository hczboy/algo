package my.czhhu.algo.common;

import my.czhhu.algo.tree.VisitTreeByLevel;

public class CommonOp
{

    public static Node findMidNode(Node head)
    {
        if (head == null)
        {
            return head;
        }

        Node slow;
        Node fast = slow = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null)
        {
            slow = fast.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static Node reverseLinkedList(Node head)
    {
        if (head == null || head.getNext() == null)
            return head;
        return CommonOp.rld(head, head.getNext());
    }

    public static void printLinkedList(Node head)
    {
        if (head == null)
        {
            System.out.println(head);
            return;
        }
        while (head.getNext() != null)
        {
            System.out.print(head.getData() + "->");
            head = head.getNext();
        }
        System.out.println(head.getData());
    }

    static private Node rld(Node cur, Node n)
    {
        if (n.getNext() == null)
        {
            n.setNext(cur);
            return n;
        }
        Node tmp = n.getNext();
        n.setNext(cur);
        cur = n;
        n = tmp;
        return rld(cur, n);

    }

    static public int length(Node n)
    {
        if (n == null)
            return -1;
        int res = 0;
        while (n != null)
        {
            res++;
            n = n.getNext();
        }
        return res;
    }

    static public void printTreeByLevel(Tnode root)
    {
        VisitTreeByLevel.visit(root, n -> System.out.print(n.data + " "), System.out::println);
    }
}
