package com.pratice.LinkedList;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class DoubleLinkedList {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean insertNode(Node node)
    {
        if(this.root==null)
        {
            this.root=node;
            return true;
        }
        else if(root.getNext()==null)
        {

            if(root.getValue()<node.getValue())
            {
                root.setNext(node);
                node.setPrevious(root);
                return true;
            }
            else
            {
                swapElements(root,node);
                this.root=node;
                return true;

            }

        }

        else
        {
            if(root.getValue()>node.getValue())
            {
                swapElements(root,node);
                this.root=node;
                return true;
            }
            else {
                Node temp = this.root.getNext();
                boolean flag=true;
                while (temp!= null&&flag) {

                    if(temp.getValue()>node.getValue())
                    {
                        temp.getPrevious().setNext(node);
                        node.setNext(temp);
                        node.setPrevious(temp.getPrevious());
                        temp.setPrevious(node);
                        return true;

                    }

                    if(temp.getNext()!=null) {
                        temp = temp.getNext();
                    }
                    else
                    {
                        flag=false;
                    }

                }

                temp.setNext(node);
                node.setPrevious(temp);
                return true;
            }
        }

    }


    private void swapElements(Node root,Node node)
    {
        node.setNext(root);
        root.setPrevious(node);
    }


    public void traverse(Node root,boolean flag)
    {
        if(root==null)
        {
            System.out.println("The linked list is empty");
        }

        else if(flag)
        {
            Node temp=root;
            System.out.println("The root is "+temp.getValue());
            int count=0;
            while(temp!=null)
            {
                System.out.println(temp.getValue());
                temp=temp.getNext();
                //count++;
            }

        }

        else
        {
            Node temp=root;
            while(temp.getNext()!=null)
            {
                temp=temp.getNext();
            }

            while(temp!=null)
            {
                System.out.println(temp.getValue());
                temp=temp.getPrevious();
            }
        }
    }


    public Node reverseLinkedList(Node head)
    {
        Node temp=head;

        while(head!=null)
        {
            Node temp1=temp;//1->2
            temp=head.getNext();
            temp.setNext(temp1);   // 2->1
            temp1.setPrevious(temp);
            temp.setPrevious(temp1.getPrevious());
            head=head.getNext();
        }

        return temp;
    }

}
