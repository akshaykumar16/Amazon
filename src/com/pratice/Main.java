package com.pratice;

import com.pratice.LinkedList.SingleLinkedList;
import com.pratice.LinkedList.Node;

import java.util.ArrayList;
import java.util.*;
import java.util.regex.Pattern;


public class Main {


    enum Directions
    {
        Left,
        Right,
        Top,
        Bottom
    }
    public static void main(String[] args) {

        int[] array=new int[]{2,4,6,8,10};
        int gcd=getGcd(array[0],array[1]);
        for(int i=2;i<array.length;i++)
        {
            gcd=getGcd(array[i],gcd);
        }

        System.out.println(gcd);
    }

    private static int getGcd(int num1, int num2) {

        while(num2!=0)
        {
            int temp=num2;
            num2=num1%num2;
            num1=temp;
        }
        return num1;
    }


    static void movieFlight(int[] movieDuration, int flightDuration) {


        int a = 0, b = 0, res = 0;
        int longDuration = flightDuration - 30;

        for (int i = 0; i < movieDuration.length; i++) {

            for (int j = i + 1; j < movieDuration.length; j++) {

                if (res <= movieDuration[i] + movieDuration[j] && movieDuration[i] + movieDuration[j] <= longDuration) {
                    if (res == (movieDuration[i] + movieDuration[j])) {
                        if (b < movieDuration[j]|| b< movieDuration[i]) {
                            a=Math.min(movieDuration[i],movieDuration[j]);
                            b=Math.max(movieDuration[i],movieDuration[j]);
                        }
                    } else {
                        a=Math.min(movieDuration[i],movieDuration[j]);
                        b=Math.max(movieDuration[i],movieDuration[j]);
                    }

                    res = a + b;
                }


            }

        }

        System.out.println(a + "," + b);


    }


    static void treasureHunt(char[][] treasure) {



        int location_x = 0, location_y = 0;

        System.out.println(treasure.length);
        System.out.println(treasure[1].length);

        for (int i = 0; i < treasure.length; i++) {
            for (int j = 0; j < treasure[1].length; j++) {

                if (treasure[i][j] == 'X') {
                    location_x = i;
                    location_y = j;
                }


            }
        }


       // System.out.println(location_x + ""+location_y);
        int i=0,j=0;
        Map<String,List<String>> map=new HashMap<>();
        while(treasure[i][j]!='X')
        {
             if(i<=location_x)
             {
                  if(i<location_x && treasure[i+1][j]!='D' && checkCycle(map,i+""+j,(i+1)+""+j))
                  {
                       insertIntoMap(map,i+""+j,(i+1)+""+j);
                       i=i+1;
                       System.out.println(i+""+j);
                  }
                  else
                  {
                      if(j<=location_y)
                      {

                          int[] array=checkTreasure(treasure,i,j,1);
                          insertIntoMap(map,i+""+j,array[0]+""+array[1]);
                          i=array[0];
                          j=array[1];

                      }
                      else if(j>location_y)

                      {
                          int[] array=checkTreasure(treasure,i,j,-1);
                          insertIntoMap(map,i+""+j,array[0]+""+array[1]);
                          i=array[0];
                          j=array[1];
                      }

                  }
             }
        }

    }

    private static void insertIntoMap(Map<String, List<String>> map, String key, String value) {

        if(map.containsKey(key))
        {
            map.get(key).add(value);
        }
        else
        {
            List<String> destLocations=new ArrayList<>();
            destLocations.add(value);
            map.put(key,destLocations);
        }
    }

    private static boolean checkCycle(Map<String, List<String>> map,String currentLocation,String destLoc) {

        if(map.containsKey(currentLocation))
        {

            List<String> locations=map.get(currentLocation);

            for(String loc:locations)
            {
                if(loc.contains(destLoc))
                {
                    return false;
                }
            }

            return true;
        }

        return true;


    }


    private static int[] checkTreasure(char[][] treasure,int i,int j,int constant)
     {

         int[] array=new int[2];

         if(((j+constant)<treasure[1].length)&&(treasure[i][j+constant]!='D'))
         {
             j=j+constant;
             System.out.println(i+""+j);
            // return j;
         }

         else if(((j-constant)>0)&&(treasure[i][j-constant]!='D'))
         {
             j=j+constant;
             System.out.println(i+""+j);
            // return j;
         }
         else if((i-1)>0)
         {
             i=i-1;
             System.out.println(i+""+j);
             //return i;
         }
         else
         {
             i=i+1;
         }



         array[0]=i;
         array[1]=j;


        return array;

     }


     public static int diceProblem(int[] array)
     {
         int min=Integer.MAX_VALUE;

         for(int i=0;i<array.length;i++)
         {
             int temp=0;
             for(int j=0;j<array.length;j++)
             {
                 if(i!=j && array[i]!=array[j])
                 {
                     if(7-array[j]==array[i])
                     {
                         temp+=2;
                     }
                     else
                     {
                         temp++;
                     }
                 }

             }

             if(min>temp)
             {
                 min=temp;
             }


         }

      return min;

     }




}


