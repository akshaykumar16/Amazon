package com.pratice.Sorting;

import java.util.ArrayList;
import java.util.List;




public class SortingMain {
    public static void main(String[] args) {

        System.out.println("act car".compareTo("act zoo"));
        QuickSort(new String[]{"a1 9 2 3 1","aa act car","zo4 4 7","ab off key dog","ab act car"});

    }


    public static void QuickSort(String[] array)
    {
       List<String> strings=new ArrayList<>();
        List<String> numbers=new ArrayList<>();
        for(int i=0;i<array.length;i++)
        {
            boolean space=true,isNumbers=false;
            for(int j=0;j<array[i].length();j++)
            {

                if(Character.isSpaceChar(array[i].charAt(j))&& space)
                {
                    space=false;
                }
                else if(Character.isDigit(array[i].charAt(j))&& !space )
                {
                    isNumbers=true;
                    numbers.add(array[i]);
                    break;

                }

            }

            if(!isNumbers)
            {
                strings.add(array[i]);
            }



        }


        sortMyQuick(strings,0,strings.size()-1);

        for(int i=0;i<strings.size();i++) {
            System.out.println(strings.get(i));
        }

        for(int i=0;i<numbers.size();i++)
        {
            System.out.println(numbers.get(i));
        }

    }

    private static void sortMyQuick(List<String> array, int low,int high) {

        if(low>high)
        {
            return;
        }

        int pivot=parition(array,low,high);
        sortMyQuick(array,low,pivot-1);
        sortMyQuick(array,pivot+1,high);

    }

    private static int parition(List<String> array, int low, int high) {

        int pivot=(low+high)/2;


        swap(array,pivot,high);

        int i=low;

        for(int j=low;j<high;j++)
        {
            if(getFormattedString(array.get(j),array.get(high))<0)
            {

                swap(array,i,j);
                i++;
            }

        }

        swap(array,i,high);

        return i;



    }

    private static void swap(List<String> array, int low, int high) {

        String temp=array.get(low);
        array.set(low,array.get(high));
        array.set(high,temp);
    }


    public static int getFormattedString(String s1,String s2)
    {

         int index=s1.indexOf(' '),index1=s2.indexOf(' ');


        int comparing=s1.substring(index).compareTo(s2.substring(index1));
        if(comparing<0||comparing>0)
        {

            return comparing;
        }
        else
        {
            return s1.substring(0,index).compareTo(s2.substring(0,index1));
        }


    }




}
