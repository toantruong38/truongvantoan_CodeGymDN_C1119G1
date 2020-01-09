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
        System.out.println(myLinkedList.insertByIndex(2, 99));
//        System.out.println(myLinkedList.insertByIndex(0, 88));
//        System.out.println(myLinkedList.insertByData(123, 20));
        System.out.println(myLinkedList.printList());
        MyLinkedList llist2 = myLinkedList.slice(0, 2);
        myLinkedList.remove(40);
        System.out.println(myLinkedList.printList());
        System.out.println(llist2.printList());
    }

    public Object remove(Object data)
    {
        Node current = head;

        while (current.next.data != data)
        {
            current = current.next;
        }
        Object removed_object = current.next.data;
        current.next = current.next.next;
        return removed_object;
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
            if (current.data == data_search)
            {
                unshift(data);
                return length();
            }
            while (current.next.data != data_search)
            {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
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
        if (index < 0 || index >= this.length()) return -1;
        if (index == 0)
        {
            unshift(data);
            return length();
        }

        while (index - 1 > 0)
        {
            current = current.next;
            index--;
        }
        newNode.next = current.next;
        current.next = newNode;
        return length();

//        int current_index = 0;
//        if (head == null) {return -1;}
//        while (current != null)
//        {
//            if (current_index == index)
//            {
//                Node tail = current;
//                current = newNode;
//                newNode.next = tail;
//                return length();
//            }
//            current_index++;
//            current = current.next;
//        }
//        return -1;
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

    public MyLinkedList slice(int start, int end)
    {
        MyLinkedList return_llist = new MyLinkedList();
//        if(start<0||end<0||start>=this.length()||end)
        try
        {
            Node current = head;
            int i = 0;
            while (current != null)
            {
                if (i >= start && i < end)
                {
                    return_llist.push(current.data);
                }


                current = current.next;
                i++;
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return return_llist;
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
