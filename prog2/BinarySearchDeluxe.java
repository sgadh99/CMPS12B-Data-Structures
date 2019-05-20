

import java.util.*;

public class BinarySearchDeluxe {	
 public static <Key> int firstIndexOf(Key[] i, Key k, Comparator<Key> comparator){
	 if (i == null || k == null || comparator == null) 
		 throw new IllegalArgumentException("arguments cannot be null");
 	int beginning = 0;
 	int end = i.length - 1;
 	if (comparator.compare(i[0], k) == 0) 
 		return 0;
 	while (beginning <= end) {
 		int middle = beginning + (end - beginning) / 2;
 		if (comparator.compare(k, i[middle]) < 0) 
 			end = middle - 1;
 		else if (comparator.compare(k, i[middle]) > 0) 
 			beginning = middle + 1;
 		else if (comparator.compare(i[middle - 1], i[middle]) == 0)
 			end = middle - 1;
 		else return middle;
 	}
		return -1;
 }
 public static <Key> int lastIndexOf(Key[] i, Key k, Comparator<Key> comparator){
	 if (i == null || k == null || comparator == null)
		 throw new IllegalArgumentException("arguments cannot be null");
 	int beginning = 0;
 	int end = i.length - 1;
 	if (comparator.compare(i[end], k) == 0) return end;
 	while (beginning <= end) {
 		int middle = beginning + (end - beginning) / 2;
 		if (comparator.compare(k, i[middle]) < 0)
 			end = middle - 1;
 		else if (comparator.compare(k, i[middle]) > 0) 
 			beginning = middle + 1;
 		else if (comparator.compare(i[middle + 1], i[middle]) == 0)
 			beginning = middle + 1;
 		else return middle;
 	}
		return -1;
 }

public static void main(String[] args) throws Exception{
	Term[] numbers = {new Term("Bob", 20), new Term("Dylan", 20), new Term("Mike", 17), new Term("Swan",19), new Term("Toad", 19), new Term("Leaf", 20), new Term("Marie", 21)};
	System.out.print(BinarySearchDeluxe.firstIndexOf(numbers, new Term("i",20), Term.byReverseWeightOrder()) + "\t");
	System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, new Term("j", 20), Term.byReverseWeightOrder()));
 }
}



