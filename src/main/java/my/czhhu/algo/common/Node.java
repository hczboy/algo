package my.czhhu.algo.common;

public class Node
{
    private int data = 0;
    private Node next = null;

    public int getData()
    {
        return data;
    }

    public Node()
    {
        super();
    }

    public Node(int data, Node next)
    {
        super();
        this.data = data;
        this.next = next;
    }

    public Node(int i)
    {
        this.data = i;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

}
