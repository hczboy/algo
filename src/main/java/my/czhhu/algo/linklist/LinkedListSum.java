package my.czhhu.algo.linklist;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

//1->3->6->5
//   8->7->5
//2->2->4->0
public class LinkedListSum
{
    static class PartialSum
    {
        Node n = null;
        int carry = 0;
    }

    static Node calc(Node n1, Node n2)
    {
        if (n1 == null && n2 == null)
        {
            return new Node(0);
        }
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;

        int len1 = CommonOp.length(n1);
        int len2 = CommonOp.length(n2);
        int diff = Math.abs(len2 - len1);

        if (len2 > len1)
        {
            n1 = padDiffNode(n1, diff);

        }
        else if (len1 > len2)
        {
            n2 = padDiffNode(n2, diff);
        }

        PartialSum sum = calcR(n1, n2);
        if (sum.carry != 0)
        {
            return new Node(sum.carry, sum.n);

        }
        return sum.n;

    }

    private static PartialSum calcR(Node n1, Node n2)
    {
        PartialSum res = new PartialSum();
        if (n1 == null && n2 == null)
        {
            return res;
        }
        PartialSum next = calcR(n1.getNext(), n2.getNext());
        Node cur = new Node();
        int v = (n1.getData() + n2.getData() + next.carry) % 10;
        int ca = (n1.getData() + n2.getData() + next.carry) / 10;
        cur.setData(v);
        cur.setNext(next.n);
        res.n = cur;
        res.carry = ca;
        return res;

    }

    private static Node padDiffNode(Node n, int diff)
    {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < diff; i++)
        {
            Node tmp = new Node(0);
            if (head == null)
            {
                head = tmp;
                tail = tmp;
            }
            else
            {
                tail.setNext(tmp);
                tail = tmp;
            }

        }
        tail.setNext(n);
        return head;

    }

    public static void main(String[] args)
    {
        // Node n1 = new Node(1, new Node(3, new Node(6, new Node(5))));
        /*Node n1 = new Node(9, new Node(3, new Node(6, new Node(5))));
        Node n2 = new Node(8, new Node(7, new Node(5)));*/

        Node n1 = new Node(6);
        Node n2 = new Node(7);

        Node res = calc(n1, n2);
        CommonOp.printLinkedList(res);
    }

}
