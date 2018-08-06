package my.czhhu.algo.leetcode;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

//[2->4->3] + [5->6->4] = [7->0->8]
//from low->high
public class AddTwoNum2
{

    static Node add(Node l1, Node l2)
    {
        Node res = new Node(-1);
        Node tail = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0)
        {
            int x1 = l1 == null ? 0 : l1.getData();
            int x2 = l2 == null ? 0 : l2.getData();
            tail.setNext(new Node((x1 + x2 + carry) % 10));
            carry = (x1 + x2 + carry) / 10;
            tail = tail.getNext();
            if (l1 != null)
                l1 = l1.getNext();
            if (l2 != null)
                l2 = l2.getNext();

        }
        return res.getNext();
    }

    public static void main(String[] args)
    {
        Node l1 = new Node(2, new Node(4, new Node(3)));
        Node l2 = new Node(5, new Node(6, new Node(4)));
        Node res = add(l1, l2);
        CommonOp.printLinkedList(l1);
        CommonOp.printLinkedList(res);
    }

}
