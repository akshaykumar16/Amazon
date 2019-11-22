package com.pratice.amazon;

public class MergeIntervals {

    private int[][] res;// to store the result;

    public int[][] merge(int[][] intervals) {


        res=new int[intervals.length][intervals[0].length];

        int count=0;

        boolean flag=true,flag1=true;
        int newIndex=0;

        while(count<intervals.length-1)
        {

            if(flag)
            {

                if(intervals[count][1]>=intervals[count+1][0])
                {

                    res[newIndex][0]=intervals[count][0];
                    res[newIndex][1]=intervals[count+1][1];
                    flag=false;
                    count+=2;

                }
                else
                {
                    res[newIndex][0]=intervals[count][0];
                    res[newIndex][1]=intervals[count][1];
                    count++;

                }

            }
            else
            {

                if(res[newIndex][1]>=intervals[count][0])
                {
                    newIndex--;
                    System.out.println("hhh"+res[newIndex][1]+" "+intervals[count][0] );
                    res[newIndex][1]=intervals[count][1];
                    flag1=false;
                    newIndex++;

                }

                else
                {
                    newIndex++;
                    System.out.println(newIndex+" "+res[newIndex][0]+"  "+res[newIndex][1]);
                    res[newIndex][0]=intervals[count][0];
                    res[newIndex][1]=intervals[count][1];
                    flag1=true;
                }

                count++;


            }




        }
//
//        if(flag||flag1)
//        {
//            res[newIndex][0]=intervals[intervals.length-1][0];
//            res[newIndex][1]=intervals[intervals.length-1][1];
//
//        }



        return res;
    }


    private void insert(int[][] res,int [][] intervals,boolean flag)
    {




    }


}
