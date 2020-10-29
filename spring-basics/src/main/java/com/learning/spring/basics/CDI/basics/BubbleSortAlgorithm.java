package com.learning.spring.basics.CDI.basics;

import javax.inject.Named;

import org.springframework.context.annotation.Primary;

@Named
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
	// logic for bubble sort
	return arr;
    }
}
