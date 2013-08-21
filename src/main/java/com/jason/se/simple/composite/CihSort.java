package com.jason.se.simple.composite;

import java.util.Arrays;
import java.util.List;

public class CihSort {

	public static void main(String[] args) {
		int[] arr={2 , 17, 16, 16, 7, 31, 39, 32, 38 , 11};
		List<?> list=bubbleSort(arr);
		System.out.println(list.get(0));
	}
	
	//1.冒泡排序(找出每轮比较的最大的数,往上冒)
	public static List<?> bubbleSort(int[] arr){
       for(int i=0,len=arr.length;i<len;i++)
       {
    	  System.out.print("i:"+arr[i]);
	      for (int j = i+1; j < arr.length; j++) {
	    	  System.out.print("    j:"+arr[j]);
	    	  int temp;
	    	  if (arr[i]>arr[j]) {
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
	      }
	      System.out.println();
       }     
       System.out.println(Arrays.asList( arr) );
       return Arrays.asList(arr);
	}
	
	//2.选择排序(每轮找出最小的对号入座)
	public static List<int[]> selectSort(int[] arr){
	    return Arrays.asList(arr);
	}
}
