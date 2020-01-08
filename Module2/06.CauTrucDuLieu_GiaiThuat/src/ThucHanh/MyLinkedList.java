package ThucHanh;

public class MyLinkedList
{
    static int numNodes;
    Node head;

    public static void main(String[] args)
    {
        MyLinkedList llist = new MyLinkedList();
        //llist.add(0,99);
        //llist.addFirst(99);

        llist.add(0, 99);
        llist.add(1, 99);
        System.out.println(llist.get(1));
        llist.printList();
    }

    public void addFirst(Object data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void add(int i, Object data)
    {
        Node current = head;
        if (i < 0 || i > numNodes) return;
        if (i == 0)
        {
            addFirst(data);
            return;
        }
        while (i - 1 > 0)
        {
            current = current.next;

            i--;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        numNodes++;
    }

    public Object get(int i)
    {
        Node current = head;
        if (i < 0 || i > numNodes) return null;
        while (i > 0)
        {
            current = current.next;
            i--;
        }
        return current.data;
    }

    public void printList()
    {
        Node current = head;
        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public class Node
    {
        Node next;
        Object data;

        public Node(Object data)
        {
            this.data = data;
        }
    }
}

class LinkedListTest
{

}
