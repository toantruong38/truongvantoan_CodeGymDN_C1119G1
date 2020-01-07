public class MyLinkedList
{
    Node head;

    public static void main(String[] args)
    {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.push(20);
        myLinkedList.push(30);
        myLinkedList.push(40);
        myLinkedList.push(50);
        System.out.println(myLinkedList.insertByIndex(2, 123));
        System.out.println(myLinkedList.printList());
    }

    public int unshift(Object data)
    {
        Node current = new Node(data);
        current.next = head;
        head = current;

        return length();
    }

    public Object shift()
    {
        if (head == null) return null;
        Object removed_object = head.data;
        head = head.next;
        return removed_object;
    }

    public int push(Object data)
    {
        Node newNode = new Node(data);
        Node current = head;
        if (current == null)
        {
            head = newNode;
            return length();
        }
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = newNode;
        return length();
    }

    public Object pop()
    {
        Node current = head;
        if (current == null) return null;
        while (current.next.next != null)
        {
            current = current.next;
        }
        Object backUp = current.next.data;
        current.next = null;
        return backUp;
    }

    public int insertByData(Object data, Object data_search)
    {
        try
        {
            Node current = head;
            Node newNode = new Node(data);
            while (current.data != data_search)
            {
                current = current.next;
            }
            Node tail = current.next;
            current.next = newNode;
            newNode.next = tail;
            return length();
        } catch (Exception e)
        {
            return -1;
        }
    }

    public int insertByIndex(int index, Object data)
    {
        Node current = head;
        Node newNode = new Node(data);
        int current_index = 0;
        if (head == null) {return -1;}
        while (current != null)
        {
            if (current_index == index)
            {
                Node tail = current;
                current = newNode;
                newNode.next = tail;
                return length();
            }
            current_index++;
            current = current.next;
        }
        return -1;
    }

    public int length()
    {
        int length = 0;
        Node current = head;
        while (current != null)
        {
            current = current.next;
            length++;
        }
        return length;
    }

    public String printList()
    {
        String output = "";
        Node current = head;
        if (head == null)
        {
            return null;
        }
        while (current != null)
        {
            output += current.data + "\t";
            current = current.next;
        }

        return output;
    }

    public class Node
    {
        Object data;
        Node next;

        public Node(Object data)
        {
            this.data = data;
        }
    }
}
