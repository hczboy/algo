package my.czhhu.algo.linklist;

import my.czhhu.algo.common.CommonOp;
import my.czhhu.algo.common.Node;

public class HuiwenLinkList
{
    static class Result
    {
        Node node;
        boolean rb;

        public Result(Node node, boolean rb)
        {
            super();
            this.node = node;
            this.rb = rb;
        }

        public Result()
        {
            super();
        }

    }

    static boolean isHuiwen(Node head)
    {
        if (head == null || head.getNext() == null)
        {
            return true;
        }

        Node mid = CommonOp.findMidNode(head);

        Node nextStart = mid.getNext();
        mid.setNext(null);
        Node reverseHead = CommonOp.reverseLinkedList(nextStart);
        Node p = head, q = reverseHead;

        while (p != null && q != null)
        {
            if (p.getData() == q.getData())
            {
                p = p.getNext();
                q = q.getNext();
            }
            else
            {
                mid.setNext(CommonOp.reverseLinkedList(reverseHead));
                return false;
            }
        }
        mid.setNext(CommonOp.reverseLinkedList(reverseHead));
        return true;

    }

    static boolean isHuiwenRecursive(Node head)
    {
        if (head == null || head.getNext() == null)
            return true;

        int length = CommonOp.length(head);
        Result r = isHuiwenRecur(head, length);
        return r.rb;
    }

    private static Result isHuiwenRecur(Node head, int length)
    {
        if (length == 1)
        {
            return new Result(head.getNext(), true);
        }
        if (length == 0)
        {
            return new Result(head, true);
        }

        Result rightRes = isHuiwenRecur(head.getNext(), length - 2);
        Result cur = new Result(rightRes.node.getNext(), false);

        if (head.getData() == rightRes.node.getData())
        {
            cur.rb = true;

        }
        return cur;
    }

    public static void main(String[] args)
    {
        Node empty = null;
        Node one = new Node(1, null);
        Node two = new Node(1, new Node(1, null));
        Node three = new Node(1, new Node(2, new Node(1, null)));

        System.out.println(isHuiwen(empty));
        System.out.println(isHuiwen(one));
        System.out.println(isHuiwen(two));
        System.out.println(isHuiwen(three));
        System.out.println("=======================");
        System.out.println(isHuiwenRecursive(empty));
        System.out.println(isHuiwenRecursive(one));
        System.out.println(isHuiwenRecursive(two));
        System.out.println(isHuiwenRecursive(three));

        System.out.println("==============================");
        System.out.println(CommonOp.reverseLinkedList(empty));
        System.out.println(CommonOp.reverseLinkedList(one).getData());
        System.out.println(CommonOp.reverseLinkedList(two).getData());
        System.out.println(CommonOp.reverseLinkedList(three).getData());
    }

}
