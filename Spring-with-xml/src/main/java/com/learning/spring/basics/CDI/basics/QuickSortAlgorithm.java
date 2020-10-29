package com.learning.spring.basics.CDI.basics;

import javax.inject.Named;

@Named
public class QuickSortAlgorithm implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
	// logic for bubble sort
	return arr;
    }
}
