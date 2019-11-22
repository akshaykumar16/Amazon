package com.pratice.LinkedList;


public class SingleLinkedList {


    private Node root;

    private int count=0;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public boolean insertNode(Node node)
    {
        count++;
        if(this.root==null)
        {
            this.root=node;
            return true;
        }

        else

        {
            Node temp=root;
            while(temp.getNext()!=null)
            {

                    temp = temp.getNext();
            }
            temp.setNext(node);
            if(count==5)
            {
                node.setNext(root);
            }
            return true;
        }
    }


    public void traverse(Node node)
    {
        Node temp=node;

        while(temp!=null)
        {
            System.out.println(temp.getValue());
            temp=temp.getNext();
        }
    }

    public Node removeDuplicates(Node head) {

        Node temp=head;
        Node withoutDup=head;

        while(temp.getNext()!=null)
        {

            if((temp.getValue()!=temp.getNext().getValue()))
            {
                if((head.getValue()!=temp.getValue()))
                {
                    withoutDup.setNext(temp);
                    withoutDup=withoutDup.getNext();
                }
            }

            temp=temp.getNext();

        }

        if(withoutDup.getValue()!=temp.getValue())
        {
            withoutDup.setNext(temp);
        }

        return head;





    }

}
