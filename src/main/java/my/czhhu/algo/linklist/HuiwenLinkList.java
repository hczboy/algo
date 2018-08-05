package my.czhhu.algo.linklist;

public class HuiwenLinkList
{
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
        System.out.println(CommonOp.reverseLinkedList(empty));
        System.out.println(CommonOp.reverseLinkedList(one).getData());
        System.out.println(CommonOp.reverseLinkedList(two).getData());
        System.out.println(CommonOp.reverseLinkedList(three).getData());
    }

}
