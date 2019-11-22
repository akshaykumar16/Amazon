package com.pratice.amazon;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IncreasingSubsequence {

    public List<List<Integer>> findSubsequences(int[] array)
    {
        List<List<Integer>> res=new ArrayList<>();

        List<Integer> list=new ArrayList<>();
        list.add(array[0]);
        res.add(list);
        List<Integer> list1=new ArrayList<>();
        list1.add(array[1]);
        res.add(list1);
        List<Integer> list2=new ArrayList<>();
        list2.add(array[0]);
        list2.add(array[1]);
        res.add(list2);

      for(int i=2;i<array.length;i++)
      {
           increasingSub(array[i],res,i,array.length-1);
      }


        Comparator<List<Integer>> comparator=(o1,o2)->
        {
             if(o1.size()>o2.size())
             {
                 return -1;
             }
             else {
                 return 1;
             }
        };
      res.sort(comparator);
        return res;




    }



         private void increasingSub(int low, List<List<Integer>> res,int index,int lastIndex) {
           {



              List<List<Integer>> temp=new ArrayList<>();

              for(List<Integer> list:res)
              {
                  if(list.size()>0)
                  {
                      List<Integer> tempList=new ArrayList<>();
                      for(int i:list)
                      {
                          tempList.add(i);
                      }
                      temp.add(tempList);
                  }
              }

               for(List<Integer> list:res)

               {

                   if(list.get(list.size()-1)<=low)
                   {
                       list.add(low);
                   }

               }
              for(List<Integer> list:temp)
              {
                 if(!res.contains(list)) {
                     res.add(list);
                 }
              }

              if(index!=lastIndex) {
                  List<Integer> list = new ArrayList<>();
                  list.add(low);
                  res.add(list);
              }



           }



    }
}
