package com.learning.spring.basics.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// this annotation tell spring that it is responsible for creating and managing beans for this class.
@Component
public class BinarySearchImpl {

	// this annotation tells Spring that it has to create and assign a suitable bean for this depenency 
	// from one of the component classes that is maintains
	@Autowired
	public SortAlgorithm sortAlgorithm;

	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
		System.out.println(this.sortAlgorithm);
	}

	@SuppressWarnings("unused")
	public int binarySearch(int[] arr, int numberToSearch) {
		// for a binary search algo to work we need sorted array
		// so we have to sort this arr array and them use binarySearch algorithm
		// to find the index of the value.

		// Method 1 - Extremely coupled
		// implementing the logic for bubble sort inside BinarySearchImpl.
		// This will make the BinarySearchImpl very tightly coupled with
		// bubbleSort implementation.
		// later due to some requirement if you want to change the sort
		// algorithm used to QuickSort
		// then a whole rewrite is needed.

		// Method 2 - Tightly Coupled
		BubbleSortAlgorithm bubbleSort = new BubbleSortAlgorithm();
		int[] sortedArr = bubbleSort.sort(arr);
		// In this way, If we want to change the sort algorithm used them we can
		// just create a obj for QuickSortAlgorithm and use it here
		// but this is also a tight coupling since we have to do some code
		// change to be able to switch sort algorithm used.

		// Method 3 - loosley Coupled
		int[] sortedArr1 = this.sortAlgorithm.sort(arr);
		// here we are removing the sort type determination out of this class
		// and using a interface insted.
		// both bubbleSort and QuickSort implemnts the interface SortAlgorithm
		// so which ever's obj passed to the constructor of this
		// BinarySearchImpl class that particular sort algorithm will be used.
		// it makes it loosely coupled by giving the option to alter sort type
		// dynamically using constructor.

		// the problem with this method is that we have to manually change the
		// type of sort obj passed in the constructor of BinarySearchImpl and
		// also create and manage instances for sortAlgorithm & BinarySearchImpl

		// we can use SPRING to automate this process using annotations.

		return 1;
	}
}
