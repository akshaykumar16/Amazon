package com.pratice.Sorting;

public class QuicKSelect {
    
        public static void main(String[] args) {

            // System.out.println("abc".compareTo(""));
            //QuickSort(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33});

            for(int i=0;i<2;i++)
            {
                for(int j=0;j<2;j++)
                {
                    if(i==1)
                    {
                       break;
                    }

                    System.out.println("j is"+j);
                }

                System.out.println(i);
            }
        }

        public static void QuickSort(int[] array)
        {
            int[] a=new int[array.length/5+1];
            int index=0;

            for(int i=0;i<array.length;) {
                int low=i;
                int high=i+4<array.length?i+4:array.length-1;
                int k=(low+high)/2;
                System.out.println(low+""+high+ "   " +k);
                if(low!=high) {
                    a[index] = sortMyQuick(array, low, high, k);
                    index++;
                    i = high+1;
                }
                else
                {
                    i=high+1;
                }

            }




        }

        private static int sortMyQuick(int[] array, int low,int high,int k) {

            int pivot=parition(array,low,high);
            if(pivot==k)
            {
                //System.out.println(array[pivot]);
                 return array[pivot];
            }
            else if(pivot>k) {
                return sortMyQuick(array, low, pivot - 1, k);
            }
            else {
               return sortMyQuick(array, pivot + 1, high, k);
            }


        }

        private static int parition(int[] array, int low, int high) {

            int pivot=(low+high)/2;


            swap(array,pivot,high);

            int i=low;

            for(int j=low;j<=high;j++)
            {
                if(array[j]<array[high])
                {
                    if(i!=j)
                    {
                        swap(array,i,j);
                    }
                    i++;
                }
            }

            swap(array,i,high);

            return i;



        }

        private static void swap(int[] array, int low, int high) {

            int temp=array[low];
            array[low]=array[high];
            array[high]=temp;
        }
    }

