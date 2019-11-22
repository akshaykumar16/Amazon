package com.pratice.amazon;

public class LongestStringOfVowels {


    public int getLongestSubStringWithVowels(String input)
    {

        int start=0,vowelsFromStart=0,end=input.length()-1,vowelsFromEnd=0;

        while(isVowel(input.charAt(start)))
        {
            start++;
            vowelsFromStart++;
        }
        while(isVowel(input.charAt(end)))
        {
            end--;
            vowelsFromEnd++;
        }
        int sum=0,longest=0;
        for(int i=start;i<=end;i++)
        {
            if(isVowel(input.charAt(i)))
            {
                sum++;
            }
            else {
                longest=Math.max(sum,longest);
                sum=0;
            }
        }
        return longest+vowelsFromStart+vowelsFromEnd;
    }

    private boolean isVowel(char ch)
    {
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }





























//    int firstHighest=0;
//    int secondHighest=0;
//    int count=0;

//    public int getLongestStringOfVowels(String input)
//    {
//        for(int i=0;i<input.length();i++)
//        {
//
//            if(input.charAt(i)=='a'|| input.charAt(i)=='e' || input.charAt(i)=='i'|| input.charAt(i)=='o'||input.charAt(i)=='u')
//            {
//                count++;
//                if(i==input.length()-1)
//                {
//                    updateCount();
//                }
//            }
//            else
//            {
//
//                updateCount();
//            }
//        }
//
//        return firstHighest+secondHighest;
//
//
//
//    }
//
//    private void updateCount()
//    {
//        if(count>=firstHighest)
//        {
//            secondHighest=firstHighest;
//            firstHighest=count;
//            count=0;
//        }
//        else if(count<firstHighest && count>secondHighest)
//        {
//            secondHighest=count;
//            count=0;
//        }
//        else
//        {
//            count=0;
//        }
//
//    }




}
