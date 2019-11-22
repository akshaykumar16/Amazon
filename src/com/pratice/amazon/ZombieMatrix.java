package com.pratice.amazon;

import java.util.HashMap;
import java.util.Map;

public class ZombieMatrix {


    private int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int getHours(int[][] zombie)
    {
        Map<String,Integer> map=new HashMap<>();
        int hours=0;
        int count=0;
        while(count<zombie[0].length*zombie.length)
        {

             count=0;
             map.clear();
            for(int i=0;i<zombie.length;i++)
            {
                for(int j=0;j<zombie[0].length;j++)
                {
                    if(zombie[i][j]!=0 && map.get(i+""+j)==null)
                    {
                        count++;
                        int dx,dy;
                        for(int k=0;k<directions.length;k++)
                        {
                            dx=i+directions[k][0];
                            dy=j+directions[k][1];

                            if(dx>=0&& dy>=0 && dx<zombie.length && dy<zombie[0].length && zombie[dx][dy]==0)
                            {
                                map.put(dx+""+dy,0);
                                zombie[dx][dy]=1;
                                count++;
                            }
                        }
                    }
                }
            }
            hours++;


            for(int i=0;i<zombie.length;i++)
            {
                for(int j=0;j<zombie[0].length;j++)
                {
                    System.out.print(zombie[i][j]+"  ");
                }
                System.out.println();
            }

            System.out.println("+++++++++++++++++++");
            //System.out.println(count+""+zombie[0].length*zombie.length);

        }

        return hours;


    }

//    public int checkZombies(int[][] zombie,Map<String,Integer> map)
//    {
//        int count=0;
//        map=new HashMap<>();
//
//        for(int i=0;i<zombie.length;i++)
//        {
//            for(int j=0;j<zombie.length;j++)
//            {
//                if(zombie[i][j]!=0 && map.get(i+""+j)!=null)
//                {
//                    count++;
//                    int dx,dy;
//                    for(int k=0;k<directions.length;k++)
//                    {
//                        dx=k+directions[k][0];
//                        dy=k+directions[k][1];
//
//                        if(dx>=0&& dy>=0 && dx<zombie.length && dy<zombie[0].length && zombie[dx][dy]==0)
//                        {
//                             map.put(dx+""+dy,0);
//                             zombie[dx][dy]=1;
//                             count++;
//                        }
//                    }
//                }
//            }
//        }
//
//        return count;
//
//    }


}
