package com.pratice.amazon;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DuplicateIPv4 {


    public int findDuplicate(int[] nums) {

        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;


        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
            }

            if(max<nums[i])
            {
                max=nums[i];
            }
        }


        int xor=0,xor1=0;

        for(int i=min;i<=max;i++)
        {
            xor^=i;
        }


        for(int i=0;i<nums.length;i++)
        {
            xor1^=nums[i];
        }

        System.out.println("The min is "+min);
        System.out.println("The max is "+max);
        System.out.println("The xor is "+xor);
        System.out.println("The xor1 is "+xor1);


        return xor^xor1;




    }

}
