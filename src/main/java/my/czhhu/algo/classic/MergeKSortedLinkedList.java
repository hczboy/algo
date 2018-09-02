package my.czhhu.algo.classic;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

public class MergeKSortedLinkedList
{

    static Node mergeK(Node[] sn)
    {
        if (sn == null || sn.length == 0)
            return null;
        int len = 0;
        Node[] nsn = new Node[sn.length];
        for (Node n : sn)
        {
            if (n != null)
            {
                nsn[len++] = n;
            }
        }

        heapfy(nsn, len);
        int l = len;
        Node head = null, tail = null;
        while (l > 0)
        {
            Node n = nsn[0];
            if (n == null)
            {
                nsn[0] = nsn[l - 1];
                l--;

            }
            else
            {
                if (head == null)
                {
                    head = n;
                }
                else
                {
                    tail.next = n;
                }

                tail = n;

                nsn[0] = nsn[0].next;

            }
            goDown(nsn, l, 0);

        }
        return head;

    }

    private static void heapfy(Node[] nsn, int len)
    {
        for (int i = len / 2 - 1; i > -1; i--)
        {
            goDown(nsn, len, i);
        }

    }

    public static void goDown(Node[] nsn, int len, int i)
    {
        if (nsn[i] == null)
            return;
        int j = i;
        while (j < len)
        {
            int left = 2 * j + 1;
            int right = 2 * j + 2;
            int min = j;
            if (left < len && nsn[left].data < nsn[min].data)
            {
                min = left;
            }

            if (right < len && nsn[right].data < nsn[min].data)
            {
                min = right;
            }

            if (min != j)
            {
                Node t = nsn[min];
                nsn[min] = nsn[j];
                nsn[j] = t;
                j = min;
            }
            else
            {
                break;
            }

        }
    }

    public static void main(String[] args)
    {
        Node h1 = new Node(2, new Node(4));
        Node h2 = null;
        Node h3 = new Node(1);

        Node h4 = new Node(4, new Node(6));

        Node[] sn = { h1, h2, h3, h4 };

        Node head = mergeK(sn);

        CommonOp.printLinkedList(head);

    }

}
