package com.pratice.amazon;

import java.util.*;

public class Main {

    public static void main(String[] args) {



        int[][]  array=new int[][]{{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,2},{0,1}};
        Pratice<int[][]> pratice=new Pratice<>();

//[[1,9],[2,5],[19,20],[10,11],[12,20],[0,3],[0,1],[0,2]]

//
//        //Arrays.sort();
//
//        Arrays.sort(array,(a,b)->{
//            if(a[0]>b[0]|| (a[0]==b[0] && a[1]>b[1]))
//            {
//                return 1;
//            }
//            return -1;
//        });
//
//
//        for(int i=0;i<array.length;i++)
//        {
//            System.out.println(array[i][0]+"  "+array[i][1]);
//        }


////           DuplicateIPv4 duplicateIPv4=new DuplicateIPv4();
////        System.out.println(duplicateIPv4.findDuplicate(new int[]{1,3,4,2,2}));
//
//        MergeIntervals mergeIntervals=new MergeIntervals();
//       int[][] res= mergeIntervals.merge(new int[][]{{1,3},{2,6}});
//
//       for(int i=0;i<res.length;i++)
//       {
//           System.out.println(res[i][0]+" "+res[i][1]);
//       }
//


//
//        DecreasingSubsequence subsequence=new DecreasingSubsequence();
//        System.out.println(subsequence.getMinNumberOfSubArrays(new int[]{2,9,12,13,4,7,6,5,10}));

//
//        IncreasingSubsequence subsequence1=new IncreasingSubsequence();
//        System.out.println(subsequence1.findSubsequences(new int[]{4,6,7,7}));
//
//        ZombieMatrix zombieMatrix=new ZombieMatrix();
//        int[][] zombie={ { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1 } };
//        System.out.println(zombieMatrix.getHours(zombie));


//      Competitior competitior=new Competitior();
//      List<String> compeitors=new ArrayList<>();
//      compeitors.add("newshop");
//      compeitors.add("shopnow");
//      compeitors.add("afshion");
//      compeitors.add("fashionbeats");
//      compeitors.add("mymarket");
//      compeitors.add("tcellular");
//
//
//      List<String> reviews=new ArrayList<>();
//      reviews.add("newshop is providing good servies in the cuty use newshop");
//      reviews.add("best servies by newshop");
//      reviews.add("fashionbeats has  in the cty");
//      reviews.add("i am proud to be fashionbeats");
//      reviews.add("i am afshion to have mymarket");
//      reviews.add("thanks newshop shopnow awesomre services");
//      competitior.competitors(compeitors,reviews);

    }



    public static int[][] kClosest(int[][] points, int K) {

       Map<int[][],Double> map=new HashMap<>();

       for(int i=0;i<points.length;i++)
       {
           Double distance=getEuclideanDistance(points[i][0],points[i][1],0,0);
           if(map.size()<K)
           {
               map.put(new int[][]{{points[i][0],points[i][1]}},distance);
           }
           else
           {
               for(Map.Entry<int[][],Double> entry:map.entrySet())
               {
                   if(distance<entry.getValue())
                   {
                       map.remove(entry.getKey());
                       map.put(new int[][]{{points[i][0],points[i][1]}},distance);
                       break;
                   }
               }
           }

       }
       int[][] resArray=new int[K][2];
       int i=0;
       for(int[][] res:map.keySet())
       {
           System.out.print(res[0][0]+" "+res[0][1]);
           System.out.println();
       }
        System.out.println("=================================");
       for(int[][] res:map.keySet())
       {
           resArray[i][0]=res[0][0];
           resArray[i][1]=res[0][1];
           i++;
       }

       return resArray;

    }


    public static double getEuclideanDistance(int p, int q,int m,int n)
    {
        //you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q))

        return Math.sqrt((m - p) * (m - p) + (n - q) * (n - q));
    }


    public static List<List<Integer>> getMaxPairs(int[] backTask, int[] foreTask,int k)
    {

        int maxPairSum=Integer.MIN_VALUE;
        List<List<Integer>> maxPairs=new ArrayList<>();

           for(int i=0;i<backTask.length;i++)
           {

               if(backTask[i]<k)
               {

                   for(int j=0;j<foreTask.length;j++)
                   {
                       if(backTask[i]+foreTask[j]<=k)
                       {
                           if(maxPairSum<backTask[i]+foreTask[j])
                           {
                               maxPairSum=backTask[i]+foreTask[j];
                              if(maxPairs.size()>0)
                              {
                                  maxPairs.clear();
                              }

                                  List<Integer> maxPair=new ArrayList<>();
                                  maxPair.add(i);
                                  maxPair.add(j);
                                  maxPairs.add(maxPair);

                           }
                           else if(maxPairSum==backTask[i]+foreTask[j])
                           {
                               List<Integer> maxPair=new ArrayList<>();
                               maxPair.add(i);
                               maxPair.add(j);

                               maxPairs.add(maxPair);

                           }
                       }
                   }


               }

           }


      return maxPairs;



    }
}
