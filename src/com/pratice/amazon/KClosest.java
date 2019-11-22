//package com.pratice.amazon;
//
//import java.util.*;
//
//class KClosest {
//    public int[][] kClosest(int[][] points, int K) {
//
//        Map<int[][],Double> map=new HashMap<>();
//
//        for(int i=0;i<points.length;i++)
//        {
//            Double distance=getEuclideanDistance(points[i][0],points[i][1],0,0);
//            if(map.size()<K)
//            {
//                map.put(new int[][]{{points[i][0],points[i][1]}},distance);
//            }
//            else
//            {
//                for(Map.Entry<int[][],Double> entry:map.entrySet())
//                {
//                    if(distance<entry.getValue())
//                    {
//                        map.remove(entry.getKey());
//                        map.put(new int[][]{{points[i][0],points[i][1]}},distance);
//                        break;
//                    }
//                }
//            }
//
//        }
//        int[][] resArray=new int[K][2];
//        int i=0;
//        for(int[][] res:map.keySet())
//        {
//            resArray[i][0]=res[0][0];
//            resArray[i][1]=res[0][1];
//            i++;
//        }
//
//        return resArray;
//    }
//
//
//    public static double getEuclideanDistance(int p, int q,int m,int n)
//    {
//        //you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q))
//        return Math.sqrt((m - p) * (m - p) + (n - q) * (n - q));
//    }
//}
