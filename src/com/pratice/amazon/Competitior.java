package com.pratice.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class Competitior {


    public void competitors(List<String> competitors,List<String> reviews) {


        Map<String, Integer> getCompetitorsWithCount = getCompetitorsWithCount(competitors);

        Map<String, Integer> resultMap = getTopNCompetitors(reviews, getCompetitorsWithCount);

        List<String> res = new ArrayList<>();

        Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                if (o1.getKey().compareTo(o2.getKey()) < 0) {
                    return 1;
                } else {
                    return -1;
                }

            } else if (o1.getValue() > o2.getValue()) {
                return -1;
            } else {
                return 1;
            }

        };

        Iterator<Map.Entry<String, Integer>> iterator = resultMap.entrySet().stream().sorted(comparator).iterator();
        int count = 1;
        while (iterator.hasNext() && count < 3) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey());
            count++;
        }


    }




    private Map<String, Integer> getTopNCompetitors(List<String> reviews, Map<String, Integer> map) {


        for(String review:reviews)
        {
            String[] eachReviews=review.toLowerCase().split("\\s+");

            for(String eachReview:eachReviews)
            {
                  if(map.get(eachReview)!=null)
                  {
                      map.put(eachReview,map.get(eachReview)+1);
                  }
            }
        }

        return map;




    }

    private Map<String, Integer> getCompetitorsWithCount(List<String> competitors) {


        Map<String,Integer> map=new HashMap<>();

        for(String s:competitors)
        {
            map.put(s,0);
        }

        return map;

    }
}
