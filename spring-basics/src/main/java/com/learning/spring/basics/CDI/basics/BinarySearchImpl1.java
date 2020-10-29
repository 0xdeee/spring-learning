package com.learning.spring.basics.CDI.basics;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class BinarySearchImpl1 {

    @Inject
    public SortAlgorithm sortAlgorithm;

    public BinarySearchImpl1(SortAlgorithm sortAlgorithm) {
	super();
	this.sortAlgorithm = sortAlgorithm;
	System.out.println(this.sortAlgorithm);
    }

    public int binarySearch(int[] arr, int numberToSearch) {

	return 1;
    }
}
