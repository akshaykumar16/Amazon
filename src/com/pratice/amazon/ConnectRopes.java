package com.pratice.amazon;

import java.util.Arrays;

public class ConnectRopes {


    public int getMinimumLength(int[] input)
    {

        Arrays.sort(input);
        int minSum=input[0]+input[1];
        int result=minSum;
        for(int i=2;i<input.length;)
        {
             if(i+1<input.length)
             {
                  if(minSum+input[i]< input[i]+input[i+1]) {
                      minSum = minSum + input[i];
                      result += minSum;
                      i++;
                  }
                  else
                  {
                       int temp=input[i]+input[i+1];
                       result+=temp;
                       minSum=minSum+temp;
                       result+=minSum;
                       i+=2;
                  }
             }
             else
             {
                 minSum=minSum+input[i];
                 result+=minSum;
                 i++;

             }

        }
        return result;
    }

    private void sortOfTwo(int[] input) {


          for(int i=0;i<input.length;i+=2) {
              sortOfTwo(input, i, input.length - 1,i);
              sortOfTwo(input,i+1,input.length-1,i+1);
          }
    }

    private void sortOfTwo(int[] input, int low, int high,int k) {

        int pivot=partition(input,low,high);




    }

    private int partition(int[] input, int low, int high) {

        int pivot=(low+high)/2;

          swapTwoNumbers(input,pivot,high);

          int i=low;

          for(int j=low;j<high;j++)
          {
                if(input[j]<input[high])
                {
                     i++;
                     if(j!=i)
                     {
                         swapTwoNumbers(input,i,j);
                     }
                }
          }

          swapTwoNumbers(input,i,high);
          return i;

    }

    private void swapTwoNumbers(int[] input, int pivot, int high) {

        int temp=input[pivot];
        input[pivot]=input[high];
        input[high]=temp;

    }
}
