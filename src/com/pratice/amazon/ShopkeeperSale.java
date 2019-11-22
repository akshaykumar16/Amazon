package com.pratice.amazon;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ShopkeeperSale {


    public int shopKeeperSale(int[] input) {

        int result=0;
        //int smallest=getTheSmallest(input,0);
        for(int i=0;i< input.length;i++)
        {

            if(!checkTheSameNumber(input,i,input[i]))
             {
                   if(input[i]<getTheSmallest(input,i))
                   {
                       result+=input[i];
                       System.out.println(input[i]);
                   }
                   else
                   {
                       result+=input[i]-getTheSmallest(input,i);
                       System.out.println(input[i]-getTheSmallest(input,i));
                   }
             }
        }

        return result;


    }

    private int getTheSmallest(int[] input, int index) {

        if(index<input.length-1)
        {
            int min=input[index+1];

            for(int i=index+2;i<input.length;i++)
            {
                   if(min>input[i])
                   {
                       min=input[i];
                   }
            }

            return min;
        }
        return Integer.MAX_VALUE;

    }

    private boolean checkTheSameNumber(int[] input,int index, int value) {


        for(int i=index+1;i<input.length;i++)
        {
            if(input[i]==value)
            {
                return true;
            }
        }

        return false;

    }

  //   [2, 3, 1, 2, 4, 2].
  public int finalPrice(int[] prices){
      if(prices.length==0) return 0;
      // Next Less Element
      Deque<Integer> NLE = new ArrayDeque<>();//next lesser element
      int res = 0;
      for(int i=prices.length-1;i>=0;i--){
          while (NLE.size()!=0 &&   NLE.peekFirst()>prices[i]){
              NLE.pollFirst();
          }

          res += NLE.isEmpty() ? prices[i] : prices[i] - NLE.peek();
          NLE.offerFirst(prices[i]);
      }

      System.out.println(res);
      return res;
  }



}
