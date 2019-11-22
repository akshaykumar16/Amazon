package com.pratice.LinkedList.pratice;


import java.util.*;



enum Directions
{
    Left,
    Right,
    Top,
    Bottom
}
public class Node1
{

      private String data;
      private Map<Directions,ArrayList<Object>> map;


      public Node1(String data)
      {
          this.data=data;
          map.put(Directions.Left,new ArrayList<>());
          map.put(Directions.Right,new ArrayList<>());
          map.put(Directions.Top,new ArrayList<>());
          map.put(Directions.Bottom,new ArrayList<>());
      }






}

