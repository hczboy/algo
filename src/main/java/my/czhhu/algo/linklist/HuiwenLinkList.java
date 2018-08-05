package my.czhhu.algo.linklist;

public class HuiwenLinkList
{
    static Node findMidNode(Node head)
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

    static Node reverseLinkedList(Node head)
    {
        if (head == null || head.getNext() == null)
            return head;
        return rld(head, head.getNext());
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

    static boolean isHuiwen(Node head)
    {
        if (head == null || head.getNext() == null)
        {
            return true;
        }

        Node mid = findMidNode(head);

        Node nextStart = mid.getNext();
        mid.setNext(null);
        Node reverseHead = reverseLinkedList(nextStart);
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
                mid.setNext(reverseLinkedList(reverseHead));
                return false;
            }
        }
        mid.setNext(reverseLinkedList(reverseHead));
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
        System.out.println(reverseLinkedList(empty));
        System.out.println(reverseLinkedList(one).getData());
        System.out.println(reverseLinkedList(two).getData());
        System.out.println(reverseLinkedList(three).getData());
    }

}
