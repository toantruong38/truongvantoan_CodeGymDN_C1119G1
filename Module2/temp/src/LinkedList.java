class LinkedList
{
    Node head;

    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        llist.head.next = second;
        second.next = third;
        Node slow = llist.head;
        Node fast = llist.head;
        Node newNode = new Node(4);
        newNode.next = llist.head;
        llist.head = newNode;
        llist.push(10);
        llist.add(99);
        //llist.printList();
        llist.add(199, 2);
        llist.printList();
        //llist.printList();
    }

    public void printList()
    {
        Node n = head;
        int count = 0;
        while (n != null)
        {
            System.out.print("[" + count + "]" + n.data + " ");
            n = n.next;
            count++;
        }
    }

    public void push(Object x)
    {
        Node node = head;
        while (node.next != null)
        {
            node = node.next;
        }
        node.next = new Node(x);
    }

    public void add(Object x)
    {
        Node newHead = new Node(x);
        newHead.next = head;
        head = newHead;
    }

    public void add(Object x, int index)
    {
        int count = 0;
        Node node = head;
        Node newNode = new Node(x);
        while (node.next != null)
        {
            if (count == index)
            {
                Node temp = node.next;
                node.next = newNode;
                newNode.next = temp;
                //System.out.println(node.data);
                break;
            }
            count++;
            node = node.next;
        }
    }

    static class Node
    {
        Object data;
        Node next;

        Node(Object d)
        {
            data = d;
            next = null;
        }
    }
}