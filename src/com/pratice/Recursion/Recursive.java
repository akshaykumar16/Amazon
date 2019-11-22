package com.pratice.Recursion;

public class Recursive {


    public int getFactorial(int i)
    {
        if(i==0) return 1;
        return i*getFactorial(i-1);
    }


    private int calFactorial(int acc,int i)
    {
        if(i==1) return acc;
        return calFactorial(acc*i,i-1);

    }

    public int gcd(int num1,int num2)
    {
        while(num2!=0)
        {
            int temp=num2;
            num2=num1%num2;
            num1=temp;
        }

        return num1;
    }


}
