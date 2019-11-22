package com.pratice.amazon;

import java.util.ArrayList;
import java.util.List;

public class ProductSuggestions {

  private static Trie root;

    public static void main(String[] args) {

        List<String> repository = new ArrayList<>();
        repository.add("mobile");
        repository.add("mouse");
        repository.add("moneypot");
        repository.add("monitor");
        repository.add("mousepad");

        System.out.println(suggestions(5,repository,"mouse"));


    }

    public static List<List<String>> suggestions(int numProducts, List<String> repository, String customerQuery) {

        List<List<String>> res=new ArrayList<>();

                root=new Trie();


        for(String s:repository)
        {
            root.insert(s);
        }


        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(customerQuery.charAt(0));

        for(int i=1;i<customerQuery.length();i++)
        {
            res.add(root.autoComplete(stringBuilder.append(customerQuery.charAt(i)).toString()));
        }


         return res;

    }



    }



class Trie
{

    private Node root;

    public Trie() {
        char c=0;
        this.root = new Node(c);
    }

    public void insert(String key)
    {
        Node temp=this.root;

        for(int i=0;i<key.length();i++)
        {
              char c=key.charAt(i);
              if(temp.getChild(c)==null)
              {
                 Node node= temp.setChild(c);
                 temp=node;
              }
              else
              {
                temp=temp.getChild(c);
              }

        }
        temp.setLeaf(true);
    }

    public boolean search(String key)
    {
        Node temp=this.root;

        for(int i=0;i<key.length();i++)
        {

            if(temp.getChild(key.charAt(i))==null)
            {
                return false;
            }
            else
            {
                temp=temp.getChild(key.charAt(i));
                System.out.println(temp);

            }


        }


        return true;
    }

    public List<String> autoComplete(String prefix)
    {
        List<String> res=new ArrayList<>();
        Node temp=this.root;
        for(int i=0;i<prefix.length();i++)
        {

              if(temp.getChild(prefix.charAt(i))==null)
              {
                    return res;
              }
              temp=temp.getChild(prefix.charAt(i));

        }

        System.out.println(temp);
        System.out.println(prefix);

        collect(temp,prefix,res);

        return res;
    }

    private void collect(Node temp, String prefix, List<String> res)
    {

          if(temp==null||res.size()>3)
          {

              return;
          }

          if(temp.isLeaf() && res.size()<3)
          {
              res.add(prefix);
          }

          for(Node child:temp.getChildren())
          {
              if(child==null) continue;
              collect(child,prefix+child.getValue(),res);
          }


    }


}


class Node
{
    private char value;
    private Node[] children;
    private boolean isLeaf;

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public Node(char value) {
        this.value = value;
        this.children = new Node[26];
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }


    public Node getChild(char c) {
        int index = c - 'a';
        return children[index];
    }

    public Node setChild(char c)
    {
        int index=c-'a';
        this.children[index]=new Node(c);
        return children[index];
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
