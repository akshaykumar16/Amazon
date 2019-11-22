package com.pratice.amazon;


import java.util.*;
public class FavouriteGenres {


    public  void findFavouriteGeneres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap)
    {

        Map<String,String> songWithGeneres=getSongWithGeneres(genreMap);

        Map<String,Integer> countMap=new HashMap<>();

        Map<String,List<String>> res=new HashMap<>();

        for(Map.Entry<String,List<String>> entry:userMap.entrySet())
        {

            String user=entry.getKey();
            int max=-1;
            List<String> genere=entry.getValue();
            if(genere.size()>0)
            {
                 max=1;
                 for(String s:genere) {
                     String key = songWithGeneres.get(s);

                     if(!countMap.containsKey(key))
                     {
                         countMap.put(key,1);
                     }
                     else
                     {
                         countMap.put(key,countMap.get(key)+1);
                         max=Math.max(max,countMap.get(key));
                     }


                 }
            }
            List<String> values=new ArrayList<>();
            for(Map.Entry<String,Integer> entry1:countMap.entrySet())
            {
                String genere1=entry1.getKey();
                if(max==entry1.getValue())
                {
                       values.add(genere1);
                }

            }
            res.put(user,values);
           countMap.clear();

        }


        System.out.println(res);




    }

    private Map<String, String> getSongWithGeneres(Map<String, List<String>> genreMap) {

        Map<String,String> songsListWithGenere=new HashMap<>();

          for(Map.Entry<String,List<String>> entry:genreMap.entrySet())
          {

              String key=entry.getKey();

              for(String value:entry.getValue())
              {
                     songsListWithGenere.put(value,key);
              }


          }

          return songsListWithGenere;


    }
}
