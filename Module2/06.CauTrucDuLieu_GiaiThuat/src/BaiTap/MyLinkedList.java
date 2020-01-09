package BaiTap;

public class MyLinkedList<E>
{
    private Node head;

    private int size = 0;

    public MyLinkedList() {}

    public void add(int index, E element)
    {
        if (index == 0)
        {
            //call the addFirst func
            addFirst(element);
            this.size++;
            return;
        }

        Node current = head;
        while (index - 1 > 0)
        {
            current = current.next;

            index--;
        }
        Node newNode = new Node(element);
        newNode.next = current.next;
        current.next = newNode;
        this.size++;
    }

    public void addFirst(E element)
    {
        Node newHead = new Node(element);

        newHead.next = head;
        head = newHead;
        this.size++;
    }

    public void addLast(E element)
    {
        Node newTail = new Node(element);
        Node current = head;

        while (current.next != null)
        {
            current = current.next;
        }

        current.next = newTail;

        this.size++;
    }

    public E remove(int index)
    {
        Object removed_element;
        Node current = head;
        if (index == 0)
        {
            removed_element = head.data;

            Node newHead = head.next;

            head = newHead;

            this.size--;
            return (E) removed_element;
        }


        while (index - 1 > 0)
        {
            current = current.next;
            index--;
        }
        removed_element = current.next.data;
        current.next = current.next.next;

        this.size--;
        return (E) removed_element;
    }

    public boolean remove(Object e)
    {
        Node current = head;

        try
        {

            while (current.next.data != e)
            {
                current = current.next;
            }
            current.next = current.next.next;

            this.size--;
            return true;
        } catch (Exception err)
        {
            return false;
        }

    }

    public int size()
    {
        return this.size;
    }

    public E clone()
    {
        return (E) this.head;
    }

    public boolean contains(E element)
    {
        Node current = head;

        while (current != null)
        {
            if (current.data == element)
            {
                return true;
            }


            current = current.next;
        }
        return false;
    }

    public int indexOf(E element)
    {
        Node current = head;
        int index = 0;

        while (index < this.size)
        {
            if (current.data == element)
            {
                return index;
            }


            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean add(E element)
    {
        if (this.size == 0)
        {
            addFirst(element);
            this.size++;
            return true;
        }
        this.addLast(element);
        this.size++;
        return true;
    }

    public E get(int index)
    {
        Node current = head;


        while (index > 0)
        {
            current = current.next;
            index--;
        }

        return (E) current.data;
    }

    public E getFirst()
    {
        return (E) this.head.data;
    }

    public E getLast()
    {
        Node current = head;

        while (current.next != null)
        {
            current = current.next;
        }
        return (E) current.data;
    }

    public void clear()
    {
        this.head = null;
    }

    private class Node
    {
        private Object data;
        private Node next;

        public Node(Object data)
        {
            this.data = data;
        }
    }


}
