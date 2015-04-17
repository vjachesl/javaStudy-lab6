package lab6;

import java.security.InvalidParameterException;
import java.util.Random;
import lab6.MyLinkedList;

public class MyCollections {
	static Random rand;
	
	public static void sort(MyLinkedList list){
		if (list==null || list.size()==0) throw new InvalidParameterException("No valid List in arguments");
		rand= new Random();
		Integer [] tempArr = lListToArray(list);
		quickSort(tempArr, 0, tempArr.length-1);
		list.removeAll();
		for (int value : tempArr)
			list.add(value);
	}
	
	public static void sort(MyArrayList list){
		if (list==null || list.size()==0) throw new InvalidParameterException("No valid Array in arguments");
		rand= new Random();
		Integer [] tempArr = arrListToArray(list);
		quickSort(tempArr, 0, tempArr.length-1);
		for (int i=0; i<tempArr.length; i++)
			list.set(i, tempArr[i]);	
	}
		
	public static void swap(MyLinkedList list, int i, int j){
		if (list==null || list.size()==0) throw new InvalidParameterException("No valid List in arguments");
		if (i>(list.size()-1)||j>(list.size()-1)|| j<0 || i< 0) throw new InvalidParameterException("invalid index in parameters");
		Integer temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public static void swap(MyArrayList list, int i, int j){
		if (list==null || list.size()==0) throw new InvalidParameterException("No valid Array in arguments");
		if (i>(list.size()-1)||j>(list.size()-1)|| j<0 || i< 0) throw new InvalidParameterException("invalid index in parameters");
		Integer temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public static void copy(MyLinkedList dest, MyLinkedList src){
		if (src==null || dest==null) throw new InvalidParameterException("No valid List in arguments");
		dest.removeAll();
		for (int i=0; i<src.size(); i++)
			dest.add(src.get(i));
	}
	
	public static void copy(MyArrayList dest,MyArrayList src){
		if (src==null || dest==null) throw new InvalidParameterException("No valid Array in arguments");
		dest.ensureCapacity(src.size());
		dest.removeAll();
     	for (int i=0; i<src.size(); i++)
     		dest.add(src.get(i));
	}
	
	public static void reverse(MyLinkedList list){
		if (list==null || list.size()==0) throw new InvalidParameterException("No valid List in arguments");
		for (int i=0, j=list.size()-1; i<(list.size()/2); i++, j--){
			Integer temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}	
	}
	public static void reverse(MyArrayList list){
		if (list==null || list.size()==0) throw new InvalidParameterException("No valid Array in arguments");
		for (int i=0, j=list.size()-1; i<(list.size()/2); i++, j--){
			Integer temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
	}
	
	public static int binarySearch(MyArrayList list, Integer key){
		if (list==null || list.size()==0) throw new InvalidParameterException("No valid Array in arguments");	
		Integer [] tempArr=arrListToArray(list);	
			if (key <tempArr[0] || key>tempArr[tempArr.length-1]) return -1;
			  else { 
				  int downBorder = 0;
				  int upBorder = tempArr.length; 
				  while (true){
					 int middle = (downBorder+upBorder)/2;
					  if (key > tempArr[middle]) downBorder = middle;
					  else if (key < tempArr[middle]) upBorder = middle;
					  else return middle;
					  if (downBorder > upBorder||downBorder == upBorder-1) return -1;
				  }
			  }
	}
		
	// additional method for List to array transforming
	private static Integer[] lListToArray(MyLinkedList list){
		Integer [] tempArr = new Integer[list.size()];
		for (int i=0; i<list.size(); i++)
			tempArr[i]=list.get(i);
		return tempArr;
	}
	
	// additional method for ArrayList to array transforming
	private static Integer[] arrListToArray(MyArrayList list){
		Integer [] tempArr = new Integer[list.size()];
		for (int i=0; i<list.size(); i++)
			tempArr[i]=list.get(i);
		return tempArr;
	}
	
	// additional method for array quick sorting 
	private static void quickSort(Integer [] array, int left, int right) {
	    int i = left;
	    int j = right;
	    int x = array[left + rand.nextInt(right - left + 1)];
	    while (i <= j) {
	        while (array[i] < x) {
	            i++;
	        	}
	        while (array[j] > x) {
	            j--;
	        	}
	        if (i <= j) {
	        	Integer temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
	            i++;
	            j--;
	        	}
	    }
	    if (left<j){
	    	quickSort(array, left, j);
	    	}
	    
	    if(i<right){
	    	quickSort(array, i, right);
	    	}
	}		
	
}
