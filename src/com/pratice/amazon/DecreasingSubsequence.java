package com.pratice.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DecreasingSubsequence
{

    public int getMinNumberOfSubArrays(int[] array)
    {
        Map<Integer,Boolean> map=new HashMap<>();

        int count=0;


        for(int i=0;i<array.length;i++)
        {
            if(map.get(i)==null)
            {
                int temp=i;
                System.out.print(array[i]+" ");
                for(int j=i+1;j<array.length;j++)
                {

                    if(map.get(j)==null && array[j]<array[temp])
                    {
                        map.put(j,true);
                        temp=j;
                        System.out.print(array[j]+"  ");
                    }

                }
                count++;
                System.out.println();
            }
        }


//        Comparator<Map.Entry<Integer,Boolean>> comparator=(o1,o2)->{
//            if(o1.getKey()<o2.getKey())
//            {
//                return 1;
//            }
//            else
//            {
//                return -1;
//            }
//        };
//
//       Iterator<Map.Entry<Integer,Boolean>> iterator= map.entrySet().stream().sorted(comparator).iterator();
//
//       while(iterator.hasNext())
//       {
//           System.out.println(iterator.next().getKey());
//       }

        return count;
    }
}
