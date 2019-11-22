package com.pratice.amazon;

public class AmazonSortCenter {


    public void sortCenter(int truckSpace,int[] packages)
    {

        int a=-1,b=-1,res=0;


        int exactTruckSpace=truckSpace-30;


        for(int i=0;i<packages.length;i++)
        {
            for(int j=i+1;j<packages.length;j++)
            {
                if(res<=packages[i]+packages[j]&& packages[i]+packages[j]<=exactTruckSpace)
                {

                    if(res<packages[i]+packages[j])
                    {
                       if(packages[i]==Math.min(packages[i],packages[j]))
                        {
                            a=i;
                            b=j;
                        }
                        else
                        {
                            a=j;
                            b=i;
                        }

                    }

                    else
                    {
                        if(packages[b]<packages[i]||packages[b]<packages[j])
                        {
                            if(packages[j]==Math.max(packages[i],packages[j]))
                            {
                                 b=j;
                                 a=i;
                            }
                            else
                            {
                                a=j;
                                b=i;
                            }
                        }
                    }

                    res=packages[a]+packages[b];
                }



            }
        }


        System.out.println(a+"  "+b);
    }
}
