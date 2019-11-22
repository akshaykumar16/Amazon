package com.pratice.amazon;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWords {


    public  void  getMostCommonWords1(String input,String[] wordsToExclude) {


        String[] array=input.toLowerCase().split("[^a-zA-Z]|\\s+");
        Map<String,Integer> map=new HashMap<>();
        int max=-1;

        for(int i=0;i<array.length;i++)
        {
            if(array[i].length()>0)
            {
                int res=insertIntoMap(array[i],wordsToExclude,map);
                if(max<res)
                {
                    max=res;
                }
            }
        }


        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==max)
            {
                System.out.println(entry.getKey());
            }
        }


    }



    public  void  getMostCommonWords(String input,String[] wordsToExclude)
    {
        StringBuilder  s1=new StringBuilder();
        Map<String,Integer> map=new HashMap<>();
        int max=-1;
        for(int i=0;i<input.length();i++)
        {
             Character ch=input.charAt(i);
            if(Character.isLetter(ch) ||  Character.isDigit(ch))
            {
                s1.append(Character.toLowerCase(ch));
            }
            else
            {
                  int res=insertIntoMap(s1.toString(),wordsToExclude,map);
                  if(max<res)
                  {
                      max=res;
                  }
                  s1.delete(0,s1.length());
            }
        }


        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==max)
            {
                System.out.println(entry.getKey());
            }
        }


        //System.out.println(map);

    }

    private boolean checkInExclude(String s1, String[] wordsToExclude) {

        for(int i=0;i<wordsToExclude.length;i++)
        {
            if(wordsToExclude[i].equalsIgnoreCase(s1))
            {
                return false;
            }
        }

        return true;

    }


    private  int insertIntoMap(String s1,String[] wordsToExclude,Map<String,Integer> map)
    {
        if(checkInExclude(s1,wordsToExclude) && s1.length()>0) {
            if (!map.containsKey(s1)) {
                map.put(s1, 1);
            } else {
                map.put(s1,map.get(s1)+1);
            }
           return map.get(s1);
        }

        return -1;
    }
}
