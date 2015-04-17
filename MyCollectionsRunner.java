package lab6;

import java.util.Random;

public class MyCollectionsRunner {
public static void main(String[] args) {
	//Random size array value init 
	Random rand = new Random();
	int listIndex = rand.nextInt(50), arrayIndex = rand.nextInt(50);
		
	MyArrayList array = new MyArrayList();
	MyArrayList array2 = new MyArrayList();
	
	//adding random values to array
	for (int i=0; i<arrayIndex; i++)
		array.add(rand.nextInt(100));
	System.out.println(array);
	System.out.println("");	
	
	// MyCollections methods testing for MyArrays
	System.out.println("MyCollections methods testing for MyArrays");
	MyCollections.reverse(array);
	System.out.println(array);
	MyCollections.sort(array);
	System.out.println(array);
	System.out.println(MyCollections.binarySearch(array, 1));
    System.out.println(array);	
	MyCollections.swap(array, 0, 5);
	System.out.println(array);
	MyCollections.copy(array2, array);
	System.out.println(array2);
	System.out.println("");
	
	
	
	////adding random values to list
	MyLinkedList list = new MyLinkedList();
	MyLinkedList list2 = new MyLinkedList();
	
	for (int i=0; i<listIndex; i++)
		list.add(rand.nextInt(100));
	list.print();
	System.out.println("");
	
	// MyCollections methods testing for MyArrays
	System.out.println("MyCollections methods testing for MyArrays");
	MyCollections.reverse(list);
	list.print();	
	MyCollections.sort(list);
	list.print();
	MyCollections.swap(list, 0, 4);
	list.print();
	MyCollections.copy(list2, list);
	list2.print();
	
}
}
